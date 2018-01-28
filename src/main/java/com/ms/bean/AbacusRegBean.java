package com.ms.bean;

import com.ms.bean.FormBean;
import com.ms.enums.State;
import com.ms.enums.StudentClass;
import java.util.List;

public class AbacusRegBean extends FormBean {
	private int id;
	private String formNum;
	private String firstName;
	private String lastName;
	private String nickName;
	private String dateOfBirth;
	private String fatherName;
	private String motherName;
	private String schoolname;
	private String gender;
	private String feeAmount;
	private Byte[] selMonth;
	private String address1;
	private String address2;
	private String area;
	private String city;
	private String state;
	private String pincode;
	private String phone;
	private String mobile;
	private String email;
	private List<State> stateList;
	private String schoolclass;
	private List<StudentClass> studentClassList;

	public List<State> getStateList() {
		return this.stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormNum() {
		return this.formNum;
	}

	public void setFormNum(String formNum) {
		this.formNum = formNum;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getSchoolname() {
		return this.schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFeeAmount() {
		return this.feeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		this.feeAmount = feeAmount;
	}

	public Byte[] getSelMonth() {
		return this.selMonth;
	}

	public void setSelMonth(Byte[] selMonth) {
		this.selMonth = selMonth;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchoolclass() {
		return this.schoolclass;
	}

	public void setSchoolclass(String schoolclass) {
		this.schoolclass = schoolclass;
	}

	public List<StudentClass> getStudentClassList() {
		return this.studentClassList;
	}

	public void setStudentClassList(List<StudentClass> studentClassList) {
		this.studentClassList = studentClassList;
	}
}