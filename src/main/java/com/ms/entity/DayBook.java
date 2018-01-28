package com.ms.entity;

import com.ms.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "day_book")
public class DayBook extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "account_Id")
	private Integer accountId;
	@Column(name = "transaction_type")
	private Byte transactionType;
	@Column(name = "payment_type")
	private Byte paymentType;
	@Column(name = "cheque_epay_no")
	private String chequeEpayNo;
	@Column(name = "account_name")
	private String accountName;
	@Column(name = "amount")
	private String amount;
	@Column(name = "comment")
	private String comments;
	@Column(name = "active")
	private Byte active;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Byte getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(Byte transactionType) {
		this.transactionType = transactionType;
	}

	public Byte getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(Byte paymentType) {
		this.paymentType = paymentType;
	}

	public String getChequeEpayNo() {
		return this.chequeEpayNo;
	}

	public void setChequeEpayNo(String chequeEpayNo) {
		this.chequeEpayNo = chequeEpayNo;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Byte getActive() {
		return this.active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}