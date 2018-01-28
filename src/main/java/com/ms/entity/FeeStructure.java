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
@Table(name = "fee_structure")
public class FeeStructure extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "fee_freq_type")
	private Byte feeFreqType;
	@Column(name = "abbr_name")
	private String abbrName;
	@Column(name = "class")
	private Byte className;
	@Column(name = "amount")
	private String amount;
	@Column(name = "session")
	private Byte sessionName;
	@Column(name = "is_tutionfee")
	private Byte isTutionFee;
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

	public Byte getFeeFreqType() {
		return this.feeFreqType;
	}

	public void setFeeFreqType(Byte feeFreqType) {
		this.feeFreqType = feeFreqType;
	}

	public String getAbbrName() {
		return this.abbrName;
	}

	public void setAbbrName(String abbrName) {
		this.abbrName = abbrName;
	}

	public Byte getClassName() {
		return this.className;
	}

	public void setClassName(Byte className) {
		this.className = className;
	}

	public Byte getSessionName() {
		return this.sessionName;
	}

	public void setSessionName(Byte sessionName) {
		this.sessionName = sessionName;
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

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Byte getIsTutionFee() {
		return this.isTutionFee;
	}

	public void setIsTutionFee(Byte isTutionFee) {
		this.isTutionFee = isTutionFee;
	}
}