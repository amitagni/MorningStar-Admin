package com.ms.bean;

import com.ms.bean.RegistrationFormBean;
import com.ms.dto.DiscountDTO;
import com.ms.enums.House;
import com.ms.enums.Nationality;
import com.ms.enums.Religion;
import com.ms.enums.Section;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AdmissionFormBean extends RegistrationFormBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer studentId;
	private String applicationDate;
	private String timeOfResiding;
	private CommonsMultipartFile studentPhoto;
	private CommonsMultipartFile studentTc;
	private String studentPhotoPath = "img/u.png";
	private String studentTcPath = "img/u.png";
	private boolean transportReq;
	private boolean siblingStudy;
	private Byte discountId;
	private List<Religion> religionList;
	private List<Nationality> nationalityList;
	private List<Section> sectionList;
	private List<House> houseList;
	private List<DiscountDTO> discountList;

	public String getApplicationDate() {
		return this.applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getTimeOfResiding() {
		return this.timeOfResiding;
	}

	public void setTimeOfResiding(String timeOfResiding) {
		this.timeOfResiding = timeOfResiding;
	}

	public List<Section> getSectionList() {
		return this.sectionList;
	}

	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}

	public List<House> getHouseList() {
		return this.houseList;
	}

	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}

	public CommonsMultipartFile getStudentPhoto() {
		return this.studentPhoto;
	}

	public void setStudentPhoto(CommonsMultipartFile studentPhoto) {
		this.studentPhoto = studentPhoto;
	}

	public CommonsMultipartFile getStudentTc() {
		return this.studentTc;
	}

	public void setStudentTc(CommonsMultipartFile studentTc) {
		this.studentTc = studentTc;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentPhotoPath() {
		return this.studentPhotoPath;
	}

	public void setStudentPhotoPath(String studentPhotoPath) {
		this.studentPhotoPath = studentPhotoPath;
	}

	public String getStudentTcPath() {
		return this.studentTcPath;
	}

	public void setStudentTcPath(String studentTcPath) {
		this.studentTcPath = studentTcPath;
	}

	public boolean isTransportReq() {
		return this.transportReq;
	}

	public void setTransportReq(boolean transportReq) {
		this.transportReq = transportReq;
	}

	public boolean isSiblingStudy() {
		return this.siblingStudy;
	}

	public void setSiblingStudy(boolean siblingStudy) {
		this.siblingStudy = siblingStudy;
	}

	public List<Religion> getReligionList() {
		return this.religionList;
	}

	public void setReligionList(List<Religion> religionList) {
		this.religionList = religionList;
	}

	public List<Nationality> getNationalityList() {
		return this.nationalityList;
	}

	public void setNationalityList(List<Nationality> nationalityList) {
		this.nationalityList = nationalityList;
	}

	public List<DiscountDTO> getDiscountList() {
		return this.discountList;
	}

	public void setDiscountList(List<DiscountDTO> discountList) {
		this.discountList = discountList;
	}

	public Byte getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Byte discountId) {
		this.discountId = discountId;
	}
}