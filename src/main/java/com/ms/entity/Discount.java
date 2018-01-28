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
@Table(name = "discount")
public class Discount extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "abbriviation")
	private String abbriviation;
	@Column(name = "value")
	private String value;
	@Column(name = "active")
	private Byte active;
	@Column(name = "type")
	private Byte type;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbbriviation() {
		return this.abbriviation;
	}

	public void setAbbriviation(String abbriviation) {
		this.abbriviation = abbriviation;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Byte getActive() {
		return this.active;
	}

	public void setActive(Byte active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Byte getType() {
		return this.type;
	}

	public void setType(Byte type) {
		this.type = type;
	}
}