package com.ms.controller;

import com.ms.bean.AdmissionFormBean;
import com.ms.bean.ContactDetails;
import com.ms.bean.StudentDetails;
import com.ms.dto.DiscountDTO;
import com.ms.entity.Discount;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.service.AdmissionService;
import com.ms.service.RegistrationService;
import com.ms.util.MSException;
import com.ms.util.MSUtil;
import com.ms.util.SessionUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class AdmissionController {
	@Autowired
	private AdmissionService admissionService;
	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value = {"/admission"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView admission(@ModelAttribute("admissionFormBean") AdmissionFormBean admissionFormBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Admission");
		this.populateAdmissionFormBean(admissionFormBean);
		admissionFormBean.setDiscountList(this.populateDiscounList());
		StudentInfo bytes;
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			String e1 = request.getParameter("regId");
			StudentReg path1 = null;
			if (e1 != null) {
				try {
					path1 = this.registrationService.findId(Integer.valueOf(Integer.parseInt(e1)));
				} catch (MSException arg11) {
					arg11.printStackTrace();
				}

				bytes = this.admissionService.findStudentByRegNum(e1);
				StudentContactInfo bout1 = null;
				if (bytes != null) {
					bout1 = this.admissionService.findStudentContactInfoByStudentId(bytes.getId());
				}

				this.populateAdmissionFormBeanWithStudentData(path1, bytes, bout1, admissionFormBean);
			}

			return new ModelAndView("admission", "admissionFormBean", admissionFormBean);
		} else {
			try {
				StudentInfo e = this.saveAdmissionFormBean(admissionFormBean);
				String path = MSUtil.getStudentDocDirectoryPath();
				System.out.println("Path:::" + path);
				bytes = null;
				BufferedOutputStream bout = null;
				String studentPhotoPath = admissionFormBean.getStudentPhotoPath();
				String studentTcPath = admissionFormBean.getStudentTcPath();
				int studentDir;
				if (studentPhotoPath != null) {
					studentDir = studentPhotoPath.indexOf("upload_doc");
					if (studentDir != -1) {
						studentPhotoPath = studentPhotoPath.substring(studentDir + "upload_doc".length() + 1,
								studentPhotoPath.length());
					}
				}

				if (studentTcPath != null) {
					studentDir = studentTcPath.indexOf("upload_doc");
					if (studentDir != -1) {
						studentTcPath = studentTcPath.substring(studentDir + "upload_doc".length() + 1,
								studentTcPath.length());
					}
				}

				byte[] bytes1;
				if (admissionFormBean.getStudentPhoto().getSize() != 0L) {
					studentPhotoPath = e.getId() + File.separator
							+ admissionFormBean.getStudentPhoto().getOriginalFilename();
					bytes1 = admissionFormBean.getStudentPhoto().getBytes();
					File studentDir1 = new File(path + File.separator + e.getId());
					if (!studentDir1.exists()) {
						studentDir1.mkdir();
					}

					bout = new BufferedOutputStream(new FileOutputStream(path + File.separator + studentPhotoPath));
					bout.write(bytes1);
					bout.flush();
					bout.close();
				}

				if (admissionFormBean.getStudentTc().getSize() != 0L) {
					studentTcPath = e.getId() + File.separator + admissionFormBean.getStudentTc().getOriginalFilename();
					bytes1 = admissionFormBean.getStudentTc().getBytes();
					bout = new BufferedOutputStream(new FileOutputStream(path + File.separator + studentTcPath));
					bout.write(bytes1);
					bout.flush();
					bout.close();
				}

				if (studentPhotoPath.equals("img/u.png")) {
					studentPhotoPath = null;
				}

				if (studentTcPath.equals("img/u.png")) {
					studentTcPath = null;
				}

				e.setPhoto(studentPhotoPath);
				e.setTcPath(studentTcPath);
				e.setSibling_study(Byte.valueOf((byte) (admissionFormBean.isSiblingStudy() ? 1 : 0)));
				e.setTransportTaken(Byte.valueOf((byte) (admissionFormBean.isTransportReq() ? 1 : 0)));
				this.admissionService.save(e);
				return e.getId() != null
						? new ModelAndView("redirect:/fee.do?id=" + e.getId().intValue())
						: new ModelAndView("admission", "admissionFormBean", admissionFormBean);
			} catch (Exception arg12) {
				arg12.printStackTrace();
				return new ModelAndView("admission", "admissionFormBean", admissionFormBean);
			}
		}
	}

	private List<DiscountDTO> populateDiscounList() {
		Map discountMap = SessionUtil.getDiscountMap();
		if (discountMap == null) {
			discountMap = this.populateDiscountMap();
		}

		Set eset = discountMap.entrySet();
		ArrayList discountDTOList = new ArrayList();
		DiscountDTO discountDTO = new DiscountDTO();
		discountDTO.setAbbriviation("None");
		discountDTOList.add(discountDTO);
		Iterator arg5 = eset.iterator();

		while (arg5.hasNext()) {
			Entry entry = (Entry) arg5.next();
			discountDTOList.add((DiscountDTO) entry.getValue());
		}

		return discountDTOList;
	}

	private Map<Integer, DiscountDTO> populateDiscountMap() {
		HashMap discountMap = new HashMap();
		List discountList = this.admissionService.findAllDiscountsByPredefinedType();
		Iterator arg3 = discountList.iterator();

		while (arg3.hasNext()) {
			Discount discount = (Discount) arg3.next();
			DiscountDTO discountDTO = new DiscountDTO();
			discountDTO.setId(discount.getId());
			discountDTO.setAbbriviation(discount.getAbbriviation());
			discountDTO.setValue(discount.getValue());
			discountMap.put(discount.getId(), discountDTO);
			SessionUtil.setDiscountMap(discountMap);
		}

		return discountMap;
	}

	private void populateAdmissionFormBeanWithStudentData(StudentReg studentReg, StudentInfo studentInfo,
			StudentContactInfo studentContactInfo, AdmissionFormBean admissionFormBean) {
		StudentDetails studentDetails = null;
		ContactDetails contactDetails = null;
		if (studentReg != null) {
			admissionFormBean.setApplicationDate(studentReg.getRegDate());
			admissionFormBean.setLastSchool(studentReg.getLastSchool());
			admissionFormBean.setLastClass(studentReg.getLastClass().byteValue());
			admissionFormBean.setLastClassResult(studentReg.getResult());
			admissionFormBean.setRegNum(studentReg.getId());
		}

		if (studentInfo != null) {
			boolean transporttaken = false;
			if (studentInfo.getTransportTaken() != null && studentInfo.getTransportTaken().byteValue() == 1) {
				transporttaken = true;
			}

			boolean siblingStudy = false;
			if (studentInfo.getSibling_study() != null && studentInfo.getSibling_study().byteValue() == 1) {
				siblingStudy = true;
			}

			admissionFormBean.setTransportReq(transporttaken);
			admissionFormBean.setSiblingStudy(siblingStudy);
			studentDetails = new StudentDetails();
			studentDetails.setId(studentInfo.getId());
			studentDetails.setFirstName(studentInfo.getFirstName());
			studentDetails.setRegId(studentInfo.getRegId());
			studentDetails.setLastName(studentInfo.getLastName());
			studentDetails.setDob(studentInfo.getDob());
			studentDetails.setGender(studentInfo.getGender());
			studentDetails.setFatherName(studentInfo.getFatherName());
			studentDetails.setMotherName(studentInfo.getMotherName());
			studentDetails.setStudentClass(
					studentInfo.getCurrentClass() == null ? -1 : studentInfo.getCurrentClass().byteValue());
			studentDetails.setSection(studentInfo.getSection() == null ? -1 : studentInfo.getSection().byteValue());
			studentDetails.setCategory(studentInfo.getCategory().byteValue());
			studentDetails.setReligion(studentInfo.getReligion());
			studentDetails.setCaste(studentInfo.getCaste());
			studentDetails.setHouse(studentInfo.getHouse().byteValue());
			studentDetails.setStudentAdmissionClass(studentInfo.getAdmissionClass().byteValue());
			studentDetails.setFatherOccupation(studentInfo.getFatherOccupation());
			String subjects = studentInfo.getSubjects();
			if (subjects != null && subjects.trim().length() > 0) {
				String[] strArr = subjects.split(",");
				byte[] subjectArr = new byte[strArr.length];

				for (int i = 0; i < strArr.length; ++i) {
					subjectArr[i] = Byte.parseByte(strArr[i]);
				}

				studentDetails.setSubjects(subjectArr);
			}

			if (!MSUtil.isEmpty(studentInfo.getPhoto())) {
				admissionFormBean.setStudentPhotoPath("http://localhost:8080//upload_doc/" + studentInfo.getPhoto());
				System.out.println(admissionFormBean.getStudentPhotoPath());
			}

			if (!MSUtil.isEmpty(studentInfo.getTcPath())) {
				admissionFormBean.setStudentTcPath("http://localhost:8080//upload_doc/" + studentInfo.getTcPath());
				System.out.println(admissionFormBean.getStudentPhotoPath());
			}
		}

		if (studentContactInfo != null) {
			contactDetails = new ContactDetails();
			contactDetails.setId(studentContactInfo.getId());
			contactDetails.setAddress1(studentContactInfo.getAddress1());
			contactDetails.setAddress2(studentContactInfo.getAddress2());
			contactDetails.setArea(studentContactInfo.getArea());
			contactDetails.setCity(studentContactInfo.getCity());
			contactDetails.setPincode(studentContactInfo.getPincode());
			contactDetails.setState(studentContactInfo.getState());
			contactDetails.setPhone(studentContactInfo.getPhone());
			contactDetails.setMobile(studentContactInfo.getMobile());
			contactDetails.setEmail(studentContactInfo.getEmail());
		}

		admissionFormBean.setStudentDetails(studentDetails);
		admissionFormBean.setContactDetails(contactDetails);
	}

	public void populateAdmissionFormBean(AdmissionFormBean admissionFormBean) {
		admissionFormBean.setCategoryList(MSUtil.populateCategoryList());
		admissionFormBean.setStateList(MSUtil.populateStateList());
		admissionFormBean.setStudentClassList(MSUtil.populateClassList());
		admissionFormBean.setResultList(MSUtil.populateResultList());
		admissionFormBean.setReligionList(MSUtil.populateReligionList());
		admissionFormBean.setHouseList(MSUtil.populateHouseList());
		admissionFormBean.setSectionList(MSUtil.populateSectionList());
		admissionFormBean.setNationalityList(MSUtil.populateNationalityList());
	}

	public StudentInfo saveAdmissionFormBean(AdmissionFormBean admissionFormBean) throws MSException {
		StudentReg studentReg = null;
		if (admissionFormBean.getStudentDetails().getRegId() == null) {
			studentReg = new StudentReg();
			studentReg.setRegDate(admissionFormBean.getApplicationDate());
			studentReg.setLastClass(Byte.valueOf(admissionFormBean.getLastClass()));
			studentReg.setLastSchool(admissionFormBean.getLastSchool());
			studentReg.setResult(admissionFormBean.getLastClassResult());
			studentReg.setCreatedBy(SessionUtil.getUser().getId());
		} else {
			studentReg = this.registrationService.findId(admissionFormBean.getStudentDetails().getRegId());
			studentReg.setLastClass(Byte.valueOf(admissionFormBean.getLastClass()));
			studentReg.setLastSchool(admissionFormBean.getLastSchool());
			studentReg.setResult(admissionFormBean.getLastClassResult());
		}

		StudentInfo studentInfo = MSUtil.populateStudentInfo(admissionFormBean.getStudentDetails());
		StudentContactInfo studentContactInfo = MSUtil.populateContactInfo(admissionFormBean.getContactDetails());
		if (admissionFormBean.getDiscountId() != null) {
			studentInfo.setDiscountId(Integer.valueOf(admissionFormBean.getDiscountId().byteValue()));
		}

		this.registrationService.save(studentReg, studentInfo, studentContactInfo);
		return studentInfo;
	}
}