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
@Table(name = "payment")
public class Payment extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "fee_type")
	private Byte feeType;
	@Column(name = "amount")
	private String amount;
	@Column(name = "discount_amt")
	private String discountAmt;
	@Column(name = "payment_type")
	private Byte paymentType;
	@Column(name = "comment")
	private String comment;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "add_discount_amt")
	private String addDiscountAmt;
	@Column(name = "add_discount_id")
	private Byte addDiscountId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Byte getFeeType() {
		return this.feeType;
	}

	public void setFeeType(Byte feeType) {
		this.feeType = feeType;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDiscountAmt() {
		return this.discountAmt;
	}

	public void setDiscountAmt(String discountAmt) {
		this.discountAmt = discountAmt;
	}

	public Byte getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(Byte paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
}