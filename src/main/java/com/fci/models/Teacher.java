package com.fci.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 60)
	private String name;

	private String address, phone, description;

	@Column(length = 10)
	private String gender;

	private Date joinDate, graduateDate;

	private byte age, experience;

	private int pay;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Level.class)
	@JoinTable(name = "teacher_level", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "level_id"))
	private List<Level> levels = new ArrayList<>();

	@ManyToMany(targetEntity = Subject.class)
	@JoinTable(name = "teacher_subject", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private List<Subject> subjects = new ArrayList<>();

	public Teacher() {

	}

	public Teacher(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public String getDescription() {
		return description;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public Date getGraduateDate() {
		return graduateDate;
	}

	public byte getAge() {
		return age;
	}

	public byte getExperience() {
		return experience;
	}

	public int getPay() {
		return pay;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Teacher [id=").append(id).append(", name=").append(name).append(", address=").append(address)
				.append(", phone=").append(phone).append(", gender=").append(gender).append(", description=")
				.append(description).append(", joinDate=").append(joinDate).append(", graduateDate=")
				.append(graduateDate).append(", age=").append(age).append(", experience=").append(experience)
				.append(", pay=").append(pay).append("]");
		return builder.toString();
	}

}
