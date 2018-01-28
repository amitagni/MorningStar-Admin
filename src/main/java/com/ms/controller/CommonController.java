package com.ms.controller;

import com.ms.bean.SearchFormBean;
import com.ms.dto.SearchResultDTO;
import com.ms.dto.StudentDetailDTO;
import com.ms.entity.AbacusRegEntity;
import com.ms.entity.StudentInfo;
import com.ms.enums.House;
import com.ms.enums.Section;
import com.ms.enums.StudentClass;
import com.ms.service.SearchService;
import com.ms.util.SessionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class CommonController {
	@Autowired
	private SearchService searchService;

	@RequestMapping(value = {"/search"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView admission(@ModelAttribute("admissionFormBean") SearchFormBean searchFormBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Search");
		return request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())
				? new ModelAndView("search", "searchFormBean", searchFormBean)
				: new ModelAndView("search", "searchFormBean", searchFormBean);
	}

	@RequestMapping({"/fetch-studentlist"})
	@ResponseBody
	public List<SearchResultDTO> getStudentsList(HttpServletRequest request) {
		String studentName = request.getParameter("studentName");
		ArrayList studentList = new ArrayList();
		List studentInfoList = this.searchService.findStudentsByName(studentName);
		if (studentInfoList != null) {
			Iterator arg5 = studentInfoList.iterator();

			while (arg5.hasNext()) {
				StudentInfo studentInfo = (StudentInfo) arg5.next();
				SearchResultDTO searchResultDTO = new SearchResultDTO();
				searchResultDTO.setValue(studentInfo.getId());
				String stClass = StudentClass.findNameByCode(studentInfo.getCurrentClass());
				String stSection = Section.findNameByCode(studentInfo.getSection());
				if (stSection == null) {
					stSection = "N/A";
				}

				searchResultDTO.setLabel(studentInfo.getFirstName() + " : " + stClass + " : " + stSection);
				studentList.add(searchResultDTO);
			}
		}

		return studentList;
	}

	@RequestMapping({"/fetch-studentDetail"})
	@ResponseBody
	public StudentDetailDTO getStudentDetail(HttpServletRequest request) {
		String studentId = request.getParameter("studentId");
		StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
		StudentInfo studentInfo = this.searchService.findStudentsById(Integer.valueOf(Integer.parseInt(studentId)));
		if (studentInfo != null) {
			studentDetailDTO.setId(studentInfo.getId());
			studentDetailDTO.setName(studentInfo.getFirstName() + " " + studentInfo.getLastName());
			studentDetailDTO.setFatherName(studentInfo.getFatherName());
			studentDetailDTO.setStudentClass(StudentClass.findNameByCode(studentInfo.getCurrentClass()));
			studentDetailDTO.setSection(Section.findNameByCode(studentInfo.getSection()));
			studentDetailDTO.setHouse(House.findNameByCode(studentInfo.getHouse()));
			studentDetailDTO.setPhotoPath("http://localhost:8080/upload_doc/" + studentInfo.getPhoto());
		}

		return studentDetailDTO;
	}

	@RequestMapping({"/fetch-abacus-studentlist"})
	@ResponseBody
	public List<SearchResultDTO> getAbacusStudentsList(HttpServletRequest request) {
		String studentName = request.getParameter("studentName");
		ArrayList studentList = new ArrayList();
		List studentInfoList = this.searchService.findAbacusStudentsByName(studentName);
		if (studentInfoList != null) {
			Iterator arg5 = studentInfoList.iterator();

			while (arg5.hasNext()) {
				AbacusRegEntity studentInfo = (AbacusRegEntity) arg5.next();
				SearchResultDTO searchResultDTO = new SearchResultDTO();
				searchResultDTO.setValue(studentInfo.getId());
				searchResultDTO.setLabel(studentInfo.getFirstName());
				studentList.add(searchResultDTO);
			}
		}

		return studentList;
	}

	@RequestMapping({"/fetch-abacus-studentDetail"})
	@ResponseBody
	public StudentDetailDTO getAbacusStudentDetail(HttpServletRequest request) {
		String studentId = request.getParameter("studentId");
		StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
		AbacusRegEntity studentInfo = this.searchService
				.findAbacusStudentsById(Integer.valueOf(Integer.parseInt(studentId)));
		if (studentInfo != null) {
			studentDetailDTO.setId(studentInfo.getId());
			studentDetailDTO.setName(studentInfo.getFirstName() + " " + studentInfo.getLastName());
			studentDetailDTO.setFatherName(studentInfo.getFatherName());
		}

		return studentDetailDTO;
	}

	@RequestMapping({"/finance"})
	public ModelAndView finance() {
		SessionUtil.setPage("Finance");
		return new ModelAndView("finance");
	}
}