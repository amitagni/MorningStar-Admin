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
@Table(name = "abacus_fee")
public class AbacusFee extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = -5952231633736953084L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "months")
	private String months;
	@Column(name = "amount")
	private String amount;
	@Column(name = "status")
	private byte status;
	@Column(name = "regfee")
	private String regfee;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

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

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getMonths() {
		return this.months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getRegfee() {
		return this.regfee;
	}

	public void setRegfee(String regfee) {
		this.regfee = regfee;
	}
}