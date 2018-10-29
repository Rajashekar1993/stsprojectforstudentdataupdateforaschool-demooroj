package com.sample.data.repository.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;

import com.sample.base.daos.jpa.StudentEntity;
import com.sample.configs.DataBaseConfig;

public class EntityProjections {

	EntityProjections projection;
	
	public static DataBaseConfig config;

	@SuppressWarnings("unchecked")
	public List<StudentEntity> getBasicStudentsdetails() {

		// projection = new EntityProjections();
		config = new DataBaseConfig();

		Session session = config.getSession();
		/*
		 * SessionFactory sessionFactory = new
		 * Configuration().configure().buildSessionFactory(); Session getsession =
		 * sessionFactory.getCurrentSession();
		 */

		CriteriaBuilder builder = session.getCriteriaBuilder();

		ProjectionList projections = Projections.projectionList().add(Projections.id().as("student_id"))
				.add(Projections.property("firstname").as("s_First_Name"))
				.add(Projections.property("application_id").as("application_id"))
				.add(Projections.property("father_name").as("father_name"));

		CriteriaQuery criteria = (CriteriaQuery) builder.createQuery(StudentEntity.class);
		((Criteria) criteria).setProjection(projections)
				.setResultTransformer(new AliasToBeanResultTransformer(StudentEntity.class));

		return (List<StudentEntity>) ((Criteria) criteria).list();
	}

	/*public static SessionFactory buildSessionFactory() {
		final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}*/

}
