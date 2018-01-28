package com.ms.dto;

import java.io.Serializable;

public class DayBookDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String accountName;
	private String transactionType;
	private String paymentType;
	private String amount;
	private String comment;

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
}