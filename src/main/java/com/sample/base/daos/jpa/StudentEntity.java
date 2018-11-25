package com.sample.base.daos.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentregistration", catalog = "studentspringboot")
public class StudentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id", nullable = false)
	private Long studentId;

	@Column(name = "s_First_Name", nullable = false, length = 40)
	private String sFirstName;

	@Column(name = "s_Last_Name", nullable = true, length = 40)
	private String sLastName;

	@Column(name = "surname", nullable = false, length = 20)
	private String surname;

	@Column(name = "application_id", nullable = true, length = 20)
	private String applicationId;

	@Column(name = "student_stadard", nullable = false, length = 4)
	private int studentStadard;

	@Column(name = "student_roll_no", nullable = false, length = 11)
	private String studentRollno;

	@Column(name = "father_name", nullable = false, length = 40)
	private String fatherName;

	@Column(name = "mother_name", nullable = false, length = 40)
	private String motherName;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getsFirstName() {
		return sFirstName;
	}

	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	public String getsLastName() {
		return sLastName;
	}

	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public int getStudentStadard() {
		return studentStadard;
	}

	public void setStudentStadard(int studentStadard) {
		this.studentStadard = studentStadard;
	}

	public String getStudentRollno() {
		return studentRollno;
	}

	public void setStudentRollno(String studentRollno) {
		this.studentRollno = studentRollno;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

}
