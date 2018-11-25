package com.sample.bussiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sample.base.daos.StudentsData;
import com.sample.base.daos.jpa.StudentEntity;
import com.sample.bussiness.service.StudentBussinessService;
import com.sample.bussiness.service.mappings.StudentDataServiceMappers;
import com.sample.data.repository.jpa.EntityProjections;
import com.sample.data.repository.jpa.StudentRepo;

@Component("StudentBussinessService")
@Transactional
public class StudentBussinessServiceImpl implements StudentBussinessService {

	List<StudentsData> studentslist;
	String CONFIRMATION_MSG;

	@Resource
	StudentRepo studentrepojpa;

	EntityProjections criteriaprojections;

	@Resource
	StudentDataServiceMappers studentdataservicemappers;

	@Override
	public String createStudent(StudentsData studentsdata) {

		
		StudentEntity entity = new StudentEntity();
		studentdataservicemappers.mapStudentDTOtoStudentEntity(studentsdata, entity);
		StudentEntity savedentity = studentrepojpa.save(entity);
		if (savedentity == null) {
			CONFIRMATION_MSG = "Student Registration failed";
		} else {
			CONFIRMATION_MSG = "Student Registered successfully";
		}
		studentsdata.setConfirmationmessage(CONFIRMATION_MSG);
		return studentsdata.getConfirmationmessage();
	}

	@Override
	public List<StudentsData> getAllStudentsList(int pagenumber) {

		studentslist = new ArrayList<StudentsData>();
		Iterable<StudentEntity> studentsEntities;

		if (pagenumber == 0) {
			studentsEntities = studentrepojpa.findAll();
		} else {
			studentsEntities = studentrepojpa.findAll(PageRequest.of(pagenumber - 1, 5));
		}

		for (StudentEntity studentEnetity : studentsEntities) {
			studentslist.add(studentdataservicemappers.mapStudentsEntitytoStudentsData(studentEnetity));
		}

		return studentslist;
	}

	@Override
	public List<StudentsData> getStudentsBasicList(int pagenumber) {

		studentslist = new ArrayList<StudentsData>();
		Iterable<StudentEntity> studentsEntities;

		if (pagenumber == 0) {
			studentsEntities = studentrepojpa.fetchStudentsBasicDetails();
		} else {
			studentsEntities = studentrepojpa.findAll(PageRequest.of(pagenumber - 1, 5));
		}

		for (StudentEntity studentEnitity : studentsEntities) {
			studentslist.add(studentdataservicemappers.mapStudentsEntitytoStudentsData(studentEnitity));
		}

		return studentslist;
	}

	@Override
	public List<StudentsData> getStudentsUsingProjections() {

		int pagenumber = 0;
		criteriaprojections = new EntityProjections();
		Iterable<StudentEntity> studentsentities;
		studentslist = new ArrayList<StudentsData>();
		if(pagenumber==0) {
			studentsentities = criteriaprojections.getBasicStudentsdetails();
		}else {
			studentsentities = criteriaprojections.getBasicStudentsdetails();
		}

		for (StudentEntity studentEnitity : studentsentities) {
			studentslist.add(studentdataservicemappers.mapStudentsEntitytoStudentsData(studentEnitity));
		}

		return studentslist;
	}

	@Override
	public String deleteStudent(Integer studentId) {
		Long l = new Long(studentId);
		if(studentrepojpa.existsById(l)==true) {
			studentrepojpa.deleteById(l);
			CONFIRMATION_MSG = "SUCCESS";
		}else {
			CONFIRMATION_MSG = "Record Not Found";
		}
		/*studentrepojpa.deleteById(l);
		CONFIRMATION_MSG = "SUCCESS";*/
		return CONFIRMATION_MSG;
	}

}
