package com.ms.bean;

import com.ms.bean.FormBean;
import com.ms.dto.FeeDTO;
import com.ms.dto.FeeMonthsDTO;
import java.util.List;

public class FeeFormBean extends FormBean {
	private Integer studentId;
	private Integer feeSummaryId;
	private Byte[] selMonth;
	private List<FeeMonthsDTO> monthList;
	private List<FeeDTO> monthlyFeeList;
	private List<FeeDTO> quarterlyFeeList;
	private List<FeeDTO> halfyearlyFeeList;
	private List<FeeDTO> anualFeeList;
	private String totalAmt;
	private String totalDiscAmt;
	private String totalPaidAmt;
	private String studentMSId;
	private String studentName;
	private String studentClass;
	private String months;
	private String recieptDate;

	public List<FeeDTO> getMonthlyFeeList() {
		return this.monthlyFeeList;
	}

	public List<FeeMonthsDTO> getMonthList() {
		return this.monthList;
	}

	public void setMonthList(List<FeeMonthsDTO> monthList) {
		this.monthList = monthList;
	}

	public void setMonthlyFeeList(List<FeeDTO> monthlyFeeList) {
		this.monthlyFeeList = monthlyFeeList;
	}

	public List<FeeDTO> getQuarterlyFeeList() {
		return this.quarterlyFeeList;
	}

	public void setQuarterlyFeeList(List<FeeDTO> quarterlyFeeList) {
		this.quarterlyFeeList = quarterlyFeeList;
	}

	public List<FeeDTO> getHalfyearlyFeeList() {
		return this.halfyearlyFeeList;
	}

	public void setHalfyearlyFeeList(List<FeeDTO> halfyearlyFeeList) {
		this.halfyearlyFeeList = halfyearlyFeeList;
	}

	public List<FeeDTO> getAnualFeeList() {
		return this.anualFeeList;
	}

	public void setAnualFeeList(List<FeeDTO> anualFeeList) {
		this.anualFeeList = anualFeeList;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getFeeSummaryId() {
		return this.feeSummaryId;
	}

	public void setFeeSummaryId(Integer feeSummaryId) {
		this.feeSummaryId = feeSummaryId;
	}

	public String getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getTotalDiscAmt() {
		return this.totalDiscAmt;
	}

	public void setTotalDiscAmt(String totalDiscAmt) {
		this.totalDiscAmt = totalDiscAmt;
	}

	public String getTotalPaidAmt() {
		return this.totalPaidAmt;
	}

	public void setTotalPaidAmt(String totalPaidAmt) {
		this.totalPaidAmt = totalPaidAmt;
	}

	public Byte[] getSelMonth() {
		return this.selMonth;
	}

	public void setSelMonth(Byte[] selMonth) {
		this.selMonth = selMonth;
	}

	public String getStudentMSId() {
		return this.studentMSId;
	}

	public void setStudentMSId(String studentMSId) {
		this.studentMSId = studentMSId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return this.studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getMonths() {
		return this.months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getRecieptDate() {
		return this.recieptDate;
	}

	public void setRecieptDate(String recieptDate) {
		this.recieptDate = recieptDate;
	}
}