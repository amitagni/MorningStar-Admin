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
@Table(name = "user")
public class User extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = -5952231633736953084L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "dept_id")
	private Integer deptId;
	@Column(name = "role_id")
	private Integer roleId;
	@Column(name = "status")
	private byte status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "updated_by")
	private Integer updatedBy;

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
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

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
}