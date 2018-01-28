package com.ms.entity;

import com.ms.entity.BaseEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paid_fee_summary")
public class PaidFeeSummary extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "session")
	private Byte sessionName;
	@Column(name = "monthly_freq")
	private String monthlyFreq;
	@Column(name = "quaterly_freq")
	private String quaterlyFreq;
	@Column(name = "halfyearly_freq")
	private String halfyearlyFreq;
	@Column(name = "annually_freq")
	private String annuallyFreq;
	@Column(name = "updated_by")
	private Integer updatedBy;

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

	public Byte getSessionName() {
		return this.sessionName;
	}

	public void setSessionName(Byte sessionName) {
		this.sessionName = sessionName;
	}

	public String getMonthlyFreq() {
		return this.monthlyFreq;
	}

	public void setMonthlyFreq(String monthlyFreq) {
		this.monthlyFreq = monthlyFreq;
	}

	public String getQuaterlyFreq() {
		return this.quaterlyFreq;
	}

	public void setQuaterlyFreq(String quaterlyFreq) {
		this.quaterlyFreq = quaterlyFreq;
	}

	public String getHalfyearlyFreq() {
		return this.halfyearlyFreq;
	}

	public void setHalfyearlyFreq(String halfyearlyFreq) {
		this.halfyearlyFreq = halfyearlyFreq;
	}

	public String getAnnuallyFreq() {
		return this.annuallyFreq;
	}

	public void setAnnuallyFreq(String annuallyFreq) {
		this.annuallyFreq = annuallyFreq;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
}