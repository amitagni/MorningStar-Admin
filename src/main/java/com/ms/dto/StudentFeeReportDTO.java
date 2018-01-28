package com.ms.dto;

import java.io.Serializable;

public class StudentFeeReportDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String studentName;
	private String phone;
	private String studentFatherName;
	private String paidAmount;
	private String discAmount;
	private String monthlyPaid;
	private String quterlyPaid;
	private String halfyearlyPaid;
	private String anuallyPaid;
	private String studentClass;
	private String section;
	private String admissionClass;
	private String lastSchool;
	private boolean notPaid = false;

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentFatherName() {
		return this.studentFatherName;
	}

	public void setStudentFatherName(String studentFatherName) {
		this.studentFatherName = studentFatherName;
	}

	public String getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getDiscAmount() {
		return this.discAmount;
	}

	public void setDiscAmount(String discAmount) {
		this.discAmount = discAmount;
	}

	public String getMonthlyPaid() {
		return this.monthlyPaid;
	}

	public void setMonthlyPaid(String monthlyPaid) {
		this.monthlyPaid = monthlyPaid;
	}

	public String getQuterlyPaid() {
		return this.quterlyPaid;
	}

	public void setQuterlyPaid(String quterlyPaid) {
		this.quterlyPaid = quterlyPaid;
	}

	public String getHalfyearlyPaid() {
		return this.halfyearlyPaid;
	}

	public void setHalfyearlyPaid(String halfyearlyPaid) {
		this.halfyearlyPaid = halfyearlyPaid;
	}

	public String getAnuallyPaid() {
		return this.anuallyPaid;
	}

	public void setAnuallyPaid(String anuallyPaid) {
		this.anuallyPaid = anuallyPaid;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdmissionClass() {
		return this.admissionClass;
	}

	public void setAdmissionClass(String admissionClass) {
		this.admissionClass = admissionClass;
	}

	public String getLastSchool() {
		return this.lastSchool;
	}

	public void setLastSchool(String lastSchool) {
		this.lastSchool = lastSchool;
	}

	public boolean isNotPaid() {
		return this.notPaid;
	}

	public void setNotPaid(boolean notPaid) {
		this.notPaid = notPaid;
	}
}