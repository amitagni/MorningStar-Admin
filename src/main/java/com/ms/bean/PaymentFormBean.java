package com.ms.bean;

import com.ms.bean.FormBean;
import com.ms.dto.DiscountDTO;
import java.util.List;

public class PaymentFormBean extends FormBean {
	private Integer paymentId;
	private String feeSlipIds;
	private Integer studentId;
	private String amount;
	private String disAmount;
	private Byte paymentType;
	private String chkDDNo;
	private String bankName;
	private String issueDate;
	private String challanNum;
	private String depositDate;
	private String comment;
	private Integer feeSummaryId;
	private String monthIds;
	private String quarterlyIds;
	private String halsyrlyIds;
	private String anuallyIds;
	private List<DiscountDTO> addtionalDiscountTypeList;
	private String addDiscountAmt;
	private Byte addDiscountId;
	private Boolean isAddDiscount;

	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDisAmount() {
		return this.disAmount;
	}

	public void setDisAmount(String disAmount) {
		this.disAmount = disAmount;
	}

	public String getFeeSlipIds() {
		return this.feeSlipIds;
	}

	public void setFeeSlipIds(String feeSlipIds) {
		this.feeSlipIds = feeSlipIds;
	}

	public String getChkDDNo() {
		return this.chkDDNo;
	}

	public void setChkDDNo(String chkDDNo) {
		this.chkDDNo = chkDDNo;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getChallanNum() {
		return this.challanNum;
	}

	public void setChallanNum(String challanNum) {
		this.challanNum = challanNum;
	}

	public String getDepositDate() {
		return this.depositDate;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}

	public String getMonthIds() {
		return this.monthIds;
	}

	public void setMonthIds(String monthIds) {
		this.monthIds = monthIds;
	}

	public String getQuarterlyIds() {
		return this.quarterlyIds;
	}

	public void setQuarterlyIds(String quarterlyIds) {
		this.quarterlyIds = quarterlyIds;
	}

	public String getHalsyrlyIds() {
		return this.halsyrlyIds;
	}

	public void setHalsyrlyIds(String halsyrlyIds) {
		this.halsyrlyIds = halsyrlyIds;
	}

	public String getAnuallyIds() {
		return this.anuallyIds;
	}

	public void setAnuallyIds(String anuallyIds) {
		this.anuallyIds = anuallyIds;
	}

	public Integer getFeeSummaryId() {
		return this.feeSummaryId;
	}

	public void setFeeSummaryId(Integer feeSummaryId) {
		this.feeSummaryId = feeSummaryId;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Byte getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(Byte paymentType) {
		this.paymentType = paymentType;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<DiscountDTO> getAddtionalDiscountTypeList() {
		return this.addtionalDiscountTypeList;
	}

	public void setAddtionalDiscountTypeList(List<DiscountDTO> addtionalDiscountTypeList) {
		this.addtionalDiscountTypeList = addtionalDiscountTypeList;
	}

	public String getAddDiscountAmt() {
		return this.addDiscountAmt;
	}

	public void setAddDiscountAmt(String addDiscountAmt) {
		this.addDiscountAmt = addDiscountAmt;
	}

	public Byte getAddDiscountId() {
		return this.addDiscountId;
	}

	public void setAddDiscountId(Byte addDiscountId) {
		this.addDiscountId = addDiscountId;
	}

	public Boolean getIsAddDiscount() {
		return this.isAddDiscount;
	}

	public void setIsAddDiscount(Boolean isAddDiscount) {
		this.isAddDiscount = isAddDiscount;
	}
}