package com.ms.controller;

import com.ms.bean.ReportBean;
import com.ms.enums.ReportType;
import com.ms.service.ReportService;
import com.ms.util.MSUtil;
import com.ms.util.SessionUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class ReportController {
	@Autowired
	private ReportService reportService;

	@RequestMapping(value = {"/report"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView report(@ModelAttribute("reportBean") @Validated ReportBean reportBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Report");
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			reportBean.setReportType(Byte.valueOf(ReportType.STUDENT.getCode().byteValue()));
		} else {
			List objectList = null;
			if (reportBean.getReportType().byteValue() == ReportType.CLASSWISE.getCode().byteValue()) {
				reportBean.setReportType(Byte.valueOf(ReportType.CLASSWISE.getCode().byteValue()));
				if (reportBean.getPageNumber() == null) {
					reportBean.setPageNumber(Integer.valueOf(1));
				}

				if (reportBean.getSelClass().byteValue() == -1) {
					objectList = this.reportService.fetchAllStudentFeeReport(Integer.valueOf(1));
				} else {
					objectList = this.reportService.fetchAllStudentFeeReport(String.valueOf(reportBean.getSelClass()));
				}
			} else if (reportBean.getReportType().byteValue() == ReportType.STUDENT.getCode().byteValue()) {
				objectList = this.reportService.fetchStudentFeeReport(String.valueOf(reportBean.getStudentId()));
				reportBean.setReportType(Byte.valueOf(ReportType.STUDENT.getCode().byteValue()));
			}

			if (objectList != null) {
				reportBean.setStudentDtoList((List) objectList.get(0));
				reportBean.setTotalPaidAmount((String) objectList.get(1));
				reportBean.setTotalDiscAmount((String) objectList.get(2));
				reportBean.setTotalPaidStudent("" + objectList.get(3));
				reportBean.setTotalNotPaidStudent("" + objectList.get(4));
			}
		}

		reportBean.setStudentClassList(MSUtil.populateClassList());
		return new ModelAndView("report", "reportBean", reportBean);
	}

	@RequestMapping(value = {"/registerreport"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView registerreport(@ModelAttribute("reportBean") @Validated ReportBean reportBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			reportBean.setReportType(Byte.valueOf(ReportType.STUDENT.getCode().byteValue()));
		} else {
			List studentList = this.reportService.fetchStudentNotTakenAdmission();
			if (studentList != null) {
				reportBean.setStudentDtoList(studentList);
			}
		}

		return new ModelAndView("report", "reportBean", reportBean);
	}
}