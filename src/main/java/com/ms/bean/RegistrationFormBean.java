package com.ms.bean;

import com.ms.bean.ContactDetails;
import com.ms.bean.FormBean;
import com.ms.bean.StudentDetails;
import com.ms.enums.Category;
import com.ms.enums.Result;
import com.ms.enums.State;
import com.ms.enums.StudentClass;
import java.util.List;

public class RegistrationFormBean extends FormBean {
	private String formNum;
	private String dateOfIssue;
	private Integer regNum;
	private byte lastClass;
	private String lastSchool;
	private String lastClassResult;
	private StudentDetails studentDetails;
	private ContactDetails contactDetails;
	private List<StudentClass> studentClassList;
	private List<Category> categoryList;
	private List<State> stateList;
	private List<Result> resultList;

	public String getFormNum() {
		return this.formNum;
	}

	public void setFormNum(String formNum) {
		this.formNum = formNum;
	}

	public String getDateOfIssue() {
		return this.dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public StudentDetails getStudentDetails() {
		return this.studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public ContactDetails getContactDetails() {
		return this.contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<StudentClass> getStudentClassList() {
		return this.studentClassList;
	}

	public void setStudentClassList(List<StudentClass> studentClassList) {
		this.studentClassList = studentClassList;
	}

	public List<Category> getCategoryList() {
		return this.categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<State> getStateList() {
		return this.stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	public String getLastSchool() {
		return this.lastSchool;
	}

	public void setLastSchool(String lastSchool) {
		this.lastSchool = lastSchool;
	}

	public String getLastClassResult() {
		return this.lastClassResult;
	}

	public void setLastClassResult(String lastClassResult) {
		this.lastClassResult = lastClassResult;
	}

	public byte getLastClass() {
		return this.lastClass;
	}

	public void setLastClass(byte lastClass) {
		this.lastClass = lastClass;
	}

	public Integer getRegNum() {
		return this.regNum;
	}

	public void setRegNum(Integer regNum) {
		this.regNum = regNum;
	}

	public List<Result> getResultList() {
		return this.resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}
}