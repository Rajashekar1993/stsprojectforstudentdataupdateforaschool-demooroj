package com.sample.base.daos;

import java.io.Serializable;

public class StudentsData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer studentId;
	private String sFirstName;
	private String sLastName;
	private String surname;
	private String applicationId;
	private int studentStadard;
	private String studentRollno;
	private String fatherName;
	private String motherName;
	private String confirmationmessage;

	private  int pageNumber;
	
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getConfirmationmessage() {
		return confirmationmessage;
	}

	public void setConfirmationmessage(String confirmationmessage) {
		this.confirmationmessage = confirmationmessage;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
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

	@Override
	public String toString() {
		return "StudentsData [studentId=" + studentId + ", sFirstName=" + sFirstName + ", sLastName=" + sLastName
				+ ", surname=" + surname + ", applicationId=" + applicationId + ", studentStadard=" + studentStadard
				+ ", studentRollno=" + studentRollno + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ "]";
	}

	
	
}
