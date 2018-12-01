package com.sample.bussiness.service;

import java.util.HashMap;
import java.util.List;

import com.sample.base.daos.StudentsData;

public interface StudentBussinessService {

	public String createStudent(StudentsData studentdata);
	public List<StudentsData> getAllStudentsList(int pagenumber);
	public List<StudentsData> getStudentsBasicList(int pagenumber);
	public List<StudentsData> getStudentsUsingProjections();
	public String deleteStudent(Integer id);
	public Integer getStudentsCount();
	public HashMap<String, Object> getAllStudentsDatabyMap(int pagenumber);
	//public StudentsData editStudentsData(Long studentid);
	//public String deleteStudentData(Long studentid);
	//public Long getStudentsCount();
	
}
