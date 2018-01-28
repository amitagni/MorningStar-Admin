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
@Table(name = "student_info")
public class StudentInfo extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "reg_id")
	private Integer regId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "dob")
	private String dob;
	@Column(name = "father_name")
	private String fatherName;
	@Column(name = "mother_name")
	private String motherName;
	@Column(name = "admission_class")
	private Byte admissionClass;
	@Column(name = "current_class")
	private Byte currentClass;
	@Column(name = "gender")
	private String gender;
	@Column(name = "category")
	private Byte category;
	@Column(name = "section")
	private Byte section;
	@Column(name = "house")
	private Byte house;
	@Column(name = "photo")
	private String photo;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "religion")
	private String religion;
	@Column(name = "caste")
	private String caste;
	@Column(name = "tc_path")
	private String tcPath;
	@Column(name = "dob_proof_path")
	private String dobProofPath;
	@Column(name = "transport_taken")
	private Byte transportTaken;
	@Column(name = "sibling_study")
	private Byte sibling_study;
	@Column(name = "subjects")
	private String subjects;
	@Column(name = "father_occupation")
	private String fatherOccupation;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "discount_id")
	private Integer discountId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegId() {
		return this.regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Byte getAdmissionClass() {
		return this.admissionClass;
	}

	public void setAdmissionClass(Byte admissionClass) {
		this.admissionClass = admissionClass;
	}

	public Byte getCurrentClass() {
		return this.currentClass;
	}

	public void setCurrentClass(Byte currentClass) {
		this.currentClass = currentClass;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Byte getCategory() {
		return this.category;
	}

	public void setCategory(Byte category) {
		this.category = category;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return this.caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getTcPath() {
		return this.tcPath;
	}

	public void setTcPath(String tcPath) {
		this.tcPath = tcPath;
	}

	public String getDobProofPath() {
		return this.dobProofPath;
	}

	public void setDobProofPath(String dobProofPath) {
		this.dobProofPath = dobProofPath;
	}

	public Byte getTransportTaken() {
		return this.transportTaken;
	}

	public void setTransportTaken(Byte transportTaken) {
		this.transportTaken = transportTaken;
	}

	public Byte getSibling_study() {
		return this.sibling_study;
	}

	public void setSibling_study(Byte sibling_study) {
		this.sibling_study = sibling_study;
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

	public Byte getSection() {
		return this.section;
	}

	public void setSection(Byte section) {
		this.section = section;
	}

	public Byte getHouse() {
		return this.house;
	}

	public void setHouse(Byte house) {
		this.house = house;
	}

	public String getSubjects() {
		return this.subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public String getFatherOccupation() {
		return this.fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public Integer getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}
}