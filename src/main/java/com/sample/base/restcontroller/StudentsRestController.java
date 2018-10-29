package com.sample.base.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.base.daos.StudentsData;
import com.sample.bussiness.service.StudentBussinessService;

@RestController
public class StudentsRestController {
	
	List<StudentsData> studentslist;

	@Autowired
	StudentBussinessService studentBussinessService;

	
	/*
	 * StudentsRest Controllers 
	 * 
	 */
	
	@RequestMapping(value = "/getstudentlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StudentsData> getStudentList() {
		int pagenumber = 0;
		studentslist = new ArrayList<StudentsData>();
		studentslist = studentBussinessService.getAllStudentsList(pagenumber);

		return studentslist;
	}
	
	@RequestMapping(value = "/getstudentBasiclist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StudentsData> getStudentBasicList() {
		int pagenumber = 0;
		studentslist = new ArrayList<StudentsData>();
		studentslist = studentBussinessService.getStudentsBasicList(pagenumber);

		return studentslist;
	}
	
	@RequestMapping(value = "/getpstudentBasiclist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StudentsData> getpStudentBasicList() {
		studentslist = new ArrayList<StudentsData>();
		studentslist = studentBussinessService.getStudentsUsingProjections();

		return studentslist;
	}
	
}
