package com.sample.bussiness.service.mappings;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.sample.base.daos.StudentsData;
import com.sample.base.daos.jpa.StudentEntity;

@Component
public class StudentDataServiceMappers extends AbstractServiceMapper{
	
	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor 
	 */
	public StudentDataServiceMappers() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	}
	
	/**
	 * Mapping from DTO to Entity
	 * @param StudentsData
	 * @Param StudentEntity
	 */
	public void mapStudentDTOtoStudentEntity(StudentsData studentsdata, StudentEntity studentsentity) {
		
		if(studentsdata==null) {
			return;
		}
		
		//GenericMapping
		map(studentsdata,studentsentity);
	}
	
	/**
	 * 
	 * Mapping from Entiy to DTO
	 * @param Studentsdata
	 */
	public StudentsData mapStudentsEntitytoStudentsData(StudentEntity studententity) {
		
		if(studententity==null) {
			return null;	
		}
		
		//Generic Mapping
		
		StudentsData studentsdata = map(studententity,StudentsData.class);
		
		return studentsdata;
	}
	
	
	
	
	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
}
