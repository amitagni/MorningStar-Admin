package com.ms.bean;

import com.ms.dto.StudentFeeReportDTO;
import com.ms.enums.StudentClass;
import java.util.List;

public class ReportBean {
	private List<StudentFeeReportDTO> studentDtoList;
	private String totalPaidAmount;
	private String totalDiscAmount;
	private String totalPaidStudent;
	private String totalNotPaidStudent;
	private Byte reportType;
	private Byte currentClass;
	private Integer studentId;
	private Integer recordCount;
	private Integer pageNumber;
	private Integer totalPages;
	private Byte selClass;
	private List<StudentClass> studentClassList;

	public List<StudentFeeReportDTO> getStudentDtoList() {
		return this.studentDtoList;
	}

	public void setStudentDtoList(List<StudentFeeReportDTO> studentDtoList) {
		this.studentDtoList = studentDtoList;
	}

	public String getTotalPaidAmount() {
		return this.totalPaidAmount;
	}

	public void setTotalPaidAmount(String totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}

	public String getTotalDiscAmount() {
		return this.totalDiscAmount;
	}

	public void setTotalDiscAmount(String totalDiscAmount) {
		this.totalDiscAmount = totalDiscAmount;
	}

	public Byte getReportType() {
		return this.reportType;
	}

	public void setReportType(Byte reportType) {
		this.reportType = reportType;
	}

	public Byte getCurrentClass() {
		return this.currentClass;
	}

	public void setCurrentClass(Byte currentClass) {
		this.currentClass = currentClass;
	}

	public List<StudentClass> getStudentClassList() {
		return this.studentClassList;
	}

	public void setStudentClassList(List<StudentClass> studentClassList) {
		this.studentClassList = studentClassList;
	}

	public Byte getSelClass() {
		return this.selClass;
	}

	public void setSelClass(Byte selClass) {
		this.selClass = selClass;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getTotalPaidStudent() {
		return this.totalPaidStudent;
	}

	public void setTotalPaidStudent(String totalPaidStudent) {
		this.totalPaidStudent = totalPaidStudent;
	}

	public String getTotalNotPaidStudent() {
		return this.totalNotPaidStudent;
	}

	public void setTotalNotPaidStudent(String totalNotPaidStudent) {
		this.totalNotPaidStudent = totalNotPaidStudent;
	}

	public Integer getRecordCount() {
		return this.recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getTotalPages() {
		return this.totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
}