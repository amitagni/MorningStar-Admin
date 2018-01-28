package com.ms.dto;

public class AbacusReceiptDTO {
	private String name;
	private String fatherName;
	private String date;
	private String months;
	private String regAmount;
	private String amount;
	private String recieptId;
	private String totalAmount;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonths() {
		return this.months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getRegAmount() {
		return this.regAmount;
	}

	public void setRegAmount(String regAmount) {
		this.regAmount = regAmount;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRecieptId() {
		return this.recieptId;
	}

	public void setRecieptId(String recieptId) {
		this.recieptId = recieptId;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
}