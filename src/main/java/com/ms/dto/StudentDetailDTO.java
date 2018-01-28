package com.ms.dto;

import java.io.Serializable;

public class StudentDetailDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String fatherName;
	private String studentClass;
	private String section;
	private String house;
	private String contactNum;
	private String photoPath;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getHouse() {
		return this.house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getContactNum() {
		return this.contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
}