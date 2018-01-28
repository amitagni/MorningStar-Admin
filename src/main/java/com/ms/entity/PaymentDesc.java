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
@Table(name = "payment_desc")
public class PaymentDesc extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "details_1")
	private String details1;
	@Column(name = "details_2")
	private String details2;
	@Column(name = "details_3")
	private String details3;
	@Column(name = "created_by")
	private Integer createdBy;
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

	public String getDetails1() {
		return this.details1;
	}

	public void setDetails1(String details1) {
		this.details1 = details1;
	}

	public String getDetails2() {
		return this.details2;
	}

	public void setDetails2(String details2) {
		this.details2 = details2;
	}

	public String getDetails3() {
		return this.details3;
	}

	public void setDetails3(String details3) {
		this.details3 = details3;
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

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}