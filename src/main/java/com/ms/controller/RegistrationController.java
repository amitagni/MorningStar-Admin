package com.ms.controller;

import com.ms.bean.PaymentFormBean;
import com.ms.bean.RegistrationFormBean;
import com.ms.entity.Payment;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.enums.FeeType;
import com.ms.enums.PaymentType;
import com.ms.enums.StudentClass;
import com.ms.service.AdmissionService;
import com.ms.service.PaymentService;
import com.ms.service.RegistrationService;
import com.ms.util.DateUtils;
import com.ms.util.MSException;
import com.ms.util.MSUtil;
import com.ms.util.SessionUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class RegistrationController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private AdmissionService admissionService;

	@RequestMapping(value = {"/registration"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView registration(@ModelAttribute("registrationFormBean") RegistrationFormBean registrationFormBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Registration");
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			this.populateRegistrationFormBean(registrationFormBean);
			return new ModelAndView("registration", "registrationFormBean", registrationFormBean);
		} else {
			try {
				Integer e = this.saveRegistrationFormBean(registrationFormBean);
				return new ModelAndView("redirect:/reg-payment.do?id=" + e);
			} catch (Exception arg5) {
				arg5.printStackTrace();
				return new ModelAndView("registration", "registrationFormBean", registrationFormBean);
			}
		}
	}

	@RequestMapping(value = {"/reg-payment"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView regPayment(@ModelAttribute("paymentFormBean") PaymentFormBean paymentFormBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Registration");
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			String e = request.getParameter("id");
			paymentFormBean.setStudentId(Integer.valueOf(Integer.parseInt(e)));
			this.populatePaymentFormBean(paymentFormBean);
			return new ModelAndView("reg-payment", "paymentFormBean", paymentFormBean);
		} else {
			try {
				this.savePaymentFormBean(paymentFormBean);
				return new ModelAndView("redirect:/reg-receipt.do?id=" + paymentFormBean.getStudentId() + "&amt="
						+ paymentFormBean.getAmount());
			} catch (Exception arg5) {
				arg5.printStackTrace();
				return new ModelAndView("reg-payment", "paymentFormBean", paymentFormBean);
			}
		}
	}

	@RequestMapping({"/reg-receipt"})
	public ModelAndView regReceipt(Model model, HttpServletRequest request) {
		SessionUtil.setPage("Registration");
		String regDate = DateUtils.convertToStringObject(DateUtils.getCurrentDateTime(), "dd/MM/yyyy");
		String studentId = request.getParameter("id");
		StudentInfo studentInfo = this.admissionService.findStudentById(Integer.valueOf(Integer.parseInt(studentId)));
		String amount = request.getParameter("amt");
		model.addAttribute("id", studentInfo.getRegId());
		model.addAttribute("name", studentInfo.getFirstName() + " " + studentInfo.getLastName());
		model.addAttribute("stcls", StudentClass.findNameByCode(studentInfo.getCurrentClass()));
		model.addAttribute("dt", regDate);
		model.addAttribute("amt", amount);
		return new ModelAndView("reg-receipt");
	}

	@RequestMapping({"/fetch-regid"})
	@ResponseBody
	public Integer getRegistrationId(HttpServletRequest request) {
		String regNumber = request.getParameter("regId");
		int id = -1;

		try {
			StudentReg e = this.registrationService.findId(Integer.valueOf(Integer.parseInt(regNumber)));
			if (e != null) {
				id = e.getId().intValue();
			}
		} catch (MSException arg4) {
			arg4.printStackTrace();
		}

		return Integer.valueOf(id);
	}

	public void populateRegistrationFormBean(RegistrationFormBean registrationFormBean) {
		registrationFormBean.setCategoryList(MSUtil.populateCategoryList());
		registrationFormBean.setStateList(MSUtil.populateStateList());
		registrationFormBean.setStudentClassList(MSUtil.populateClassList());
	}

	private Integer saveRegistrationFormBean(RegistrationFormBean registrationFormBean) throws Exception {
		Integer studentId = this.saveStudentInfoAndContact(registrationFormBean);
		registrationFormBean.setCategoryList(MSUtil.populateCategoryList());
		registrationFormBean.setStateList(MSUtil.populateStateList());
		registrationFormBean.setStudentClassList(MSUtil.populateClassList());
		return studentId;
	}

	private Integer saveStudentInfoAndContact(RegistrationFormBean registrationFormBean) throws MSException {
		StudentReg studentReg = new StudentReg();
		studentReg.setFormNumber(registrationFormBean.getFormNum());
		studentReg.setRegDate(registrationFormBean.getDateOfIssue());
		studentReg.setLastClass(Byte.valueOf(registrationFormBean.getLastClass()));
		studentReg.setLastSchool(registrationFormBean.getLastSchool());
		studentReg.setResult(registrationFormBean.getLastClassResult());
		studentReg.setCreatedBy(SessionUtil.getUser().getId());
		StudentInfo studentInfo = MSUtil.populateStudentInfo(registrationFormBean.getStudentDetails());
		StudentContactInfo studentContactInfo = MSUtil.populateContactInfo(registrationFormBean.getContactDetails());
		this.registrationService.save(studentReg, studentInfo, studentContactInfo);
		return studentInfo.getId();
	}

	private void savePaymentFormBean(PaymentFormBean paymentFormBean) {
		Payment payment = new Payment();
		payment.setId(paymentFormBean.getPaymentId());
		payment.setStudentId(paymentFormBean.getStudentId());
		payment.setAmount(paymentFormBean.getAmount());
		payment.setFeeType(FeeType.REGFEES.getCode());
		payment.setPaymentType(PaymentType.CASH.getCode());
		payment.setComment(paymentFormBean.getComment());
		payment.setCreatedBy(SessionUtil.getUser().getId());
		this.paymentService.save(payment);
	}

	private void populatePaymentFormBean(PaymentFormBean paymentFormBean) {
		Payment payment = this.paymentService.findByStudentId(paymentFormBean.getStudentId(),
				FeeType.REGFEES.getCode());
		System.out.println("payment::::" + payment);
		if (payment != null) {
			paymentFormBean.setPaymentId(payment.getId());
			paymentFormBean.setAmount(payment.getAmount());
			paymentFormBean.setComment(payment.getComment());
		}

	}
}