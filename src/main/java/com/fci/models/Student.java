package com.fci.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	private String name;

	@NotNull
	private byte age;

//	@NotNull
	private Date dob, joinDate; // date of birth

	private double paidFees, remainFees;

	private String email, address;

	@Column(length = 10, nullable = false)
	private String status, gender;

	@Column(columnDefinition = "text")
	private String notes;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "guardian_id")
	private Guardian guardian;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "level_id")
	private Level level;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Set<Grade> grades;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public double getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(double paidFees) {
		this.paidFees = paidFees;
	}

	public double getRemainFees() {
		return remainFees;
	}

	public void setRemainFees(double remainFees) {
		this.remainFees = remainFees;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=").append(id).append(", name=").append(name).append(", age=").append(age)
				.append(", dob=").append(dob).append(", joinDate=").append(joinDate).append(", paidFees=")
				.append(paidFees).append(", remainFees=").append(remainFees).append(", email=").append(email)
				.append(", address=").append(address).append(", status=").append(status).append(", gender=")
				.append(gender).append(", notes=").append(notes).append(", guardian=").append(guardian)
				.append(", level=").append(level).append("]");
		return builder.toString();
	}

}
