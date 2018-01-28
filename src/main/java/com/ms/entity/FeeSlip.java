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
@Table(name = "fee_slip")
public class FeeSlip extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "fee_structure_id")
	private Integer feeStructureId;
	@Column(name = "payment_id")
	private Integer paymentId;
	@Column(name = "month")
	private Byte month;
	@Column(name = "amount")
	private String amount;
	@Column(name = "discount")
	private String discount;
	@Column(name = "created_by")
	private Integer createdBy;
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

	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
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

	public Integer getFeeStructureId() {
		return this.feeStructureId;
	}

	public void setFeeStructureId(Integer feeStructureId) {
		this.feeStructureId = feeStructureId;
	}

	public Byte getMonth() {
		return this.month;
	}

	public void setMonth(Byte month) {
		this.month = month;
	}
}