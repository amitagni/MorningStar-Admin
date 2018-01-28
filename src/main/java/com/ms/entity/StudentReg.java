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
@Table(name = "student_reg")
public class StudentReg extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "form_num")
	private String formNumber;
	@Column(name = "reg_date")
	private String regDate;
	@Column(name = "last_class")
	private Byte lastClass;
	@Column(name = "last_school")
	private String lastSchool;
	@Column(name = "result")
	private String result;
	@Column(name = "created_by")
	private Integer createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	public String getFormNumber() {
		return this.formNumber;
	}

	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}

	public String getRegDate() {
		return this.regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Byte getLastClass() {
		return this.lastClass;
	}

	public void setLastClass(Byte lastClass) {
		this.lastClass = lastClass;
	}

	public String getLastSchool() {
		return this.lastSchool;
	}

	public void setLastSchool(String lastSchool) {
		this.lastSchool = lastSchool;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}