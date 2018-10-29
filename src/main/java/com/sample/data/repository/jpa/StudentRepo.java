package com.sample.data.repository.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;

import com.sample.base.daos.jpa.StudentEntity;

public interface StudentRepo extends PagingAndSortingRepository<StudentEntity, Long> {

	// String querytofetchstudentbasicdetails="Select new
	// com.sample.base.daos.jpa.StudentEntity(u.studentId, u.sFirstName,
	// u.applicationId, u.studentRollno, u.fatherName) FROM
	// com.sample.base.daos.jpa.StudentEntity u";
	String querytofetchstudentbasicdetails = "Select u.student_id, u.s_First_Name, u.application_id, u.student_roll_no, u.father_name FROM studentregistration u";
	String AstlQuery = "select studentent0_.student_id as student_1_0_, studentent0_.application_id as applicat2_0_, "
			+ "studentent0_.father_name as father_n3_0_, studentent0_.mother_name as mother_n4_0_, studentent0_.s_first_name as s_first_5_0_, "
			+ "studentent0_.student_roll_no as student_7_0_, " + "studentent0_.student_stadard as student_8_0_, "
			+ "from studentspringboot.studentregistration studentent0";
	String nativequery = "Select u.student_id, u.s_First_Name, u.application_id, u.student_roll_no, u.father_name, "
			+ "u.mother_name, u.s_last_name, u.surname, u.student_stadard  FROM studentregistration u";
	String sqlquery = "select student_id, s_First_Name, application_id, student_roll_no, father_name"
			+ "FROM studentregistration";

	@Query(value = nativequery, nativeQuery = true)
	public List<StudentEntity> fetchStudentsBasicDetails();

}
