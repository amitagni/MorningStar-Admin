package com.ms.bean;

public class StudentDetails {
	private Integer id;
	private Integer regId;
	private String firstName;
	private String lastName;
	private String dob;
	private String fatherName;
	private String motherName;
	private byte studentAdmissionClass;
	private byte studentClass;
	private byte section;
	private byte house;
	private byte category;
	private String religion;
	private String caste;
	private String gender;
	private String nationality;
	private byte[] subjects;
	private String fatherOccupation;

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

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public byte getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(byte studentClass) {
		this.studentClass = studentClass;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return this.caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public byte getSection() {
		return this.section;
	}

	public void setSection(byte section) {
		this.section = section;
	}

	public byte getHouse() {
		return this.house;
	}

	public void setHouse(byte house) {
		this.house = house;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public byte getStudentAdmissionClass() {
		return this.studentAdmissionClass;
	}

	public void setStudentAdmissionClass(byte studentAdmissionClass) {
		this.studentAdmissionClass = studentAdmissionClass;
	}

	public byte getCategory() {
		return this.category;
	}

	public void setCategory(byte category) {
		this.category = category;
	}

	public byte[] getSubjects() {
		return this.subjects;
	}

	public void setSubjects(byte[] subjects) {
		this.subjects = subjects;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegId() {
		return this.regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public String getFatherOccupation() {
		return this.fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
}