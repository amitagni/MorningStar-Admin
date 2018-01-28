package com.ms.dto;

public class FeeDTO {
	private Integer id;
	private String name;
	private String amount;
	private String discount;
	private String paidAmount;
	private boolean paid;

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getPaidAmount() {
		return this.paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isPaid() {
		return this.paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}