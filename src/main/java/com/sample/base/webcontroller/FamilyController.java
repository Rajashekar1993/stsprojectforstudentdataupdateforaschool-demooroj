package com.sample.base.webcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sample.base.daos.StudentsData;
import com.sample.bussiness.service.StudentBussinessService;

@Controller
public class FamilyController {

	@Autowired
	StudentBussinessService studentBussinessService;

	@RequestMapping("/")
	public String landingPage() {

		System.out.println("Hi");
		return "home";
	}

	@RequestMapping("/login")
	public String loginPage() {

		return "";
	}

	@RequestMapping("/agentLandingPage")
	public ModelAndView agentLandingPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentsdata", new StudentsData());
		mv.setViewName("agentlandingpage");
		return mv;
	}

	@RequestMapping("/confirmPage")
	public ModelAndView confirmStudentDetails(StudentsData studentdata, Map<String, Object> modelObject) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("studentsdata", studentdata);
		mv.setViewName("studentdetailschecklist");
		// modelObject.put("studentsdata", studentdata);
		// return "studentdetailschecklist";
		return mv;
	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	public String registerStudent(@ModelAttribute("studentsdata") StudentsData studentdata,
			Map<String, Object> modelObject) {

		studentdata.setConfirmationmessage(studentBussinessService.createStudent(studentdata));
		modelObject.put("studentsdata", studentdata);
		return "studentdetailschecklist";
	}

	/*@RequestMapping(value = "/checkData", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentsData checkData(StudentsData studentdata, Map<String, Object> modelObject) {

		return studentdata;
	}*/

	@RequestMapping(value = "/studentlist", method = RequestMethod.GET)
	public String getStudentList(Map<String, Object> modelobject) {
		int pagenumber = 0;
		List<StudentsData> studentslist = new ArrayList<StudentsData>();
		studentslist = studentBussinessService.getAllStudentsList(pagenumber);
		modelobject.put("studentslist", studentslist);

		return "studentdetailschecklist";
	}

	/*@RequestMapping("/sample")
	public String sampleHeaderPage() {
		return "sample";
	}*/

}
