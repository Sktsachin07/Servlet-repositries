package com.spring.orm.dao;

import java.util.List;


import javax.transaction.Transactional;


import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	// read all data by Name
	@Transactional
	public List<Student> getStudent(String data) {
		String sql="Select * from student_details where student_name=:data ";
		NativeQuery<Student> query=this.hibernateTemplate.getSessionFactory().getCurrentSession().createNativeQuery(sql,Student.class);
		query.setParameter("data", data);
		
		return query.getResultList();
	}

//save student
	@Transactional
	public int insert(Student student) {
//insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

  // Read only one row
	public Student getStudent(int StudentId)
	{
		Student student = this.hibernateTemplate.get(Student.class, StudentId);
        return student;
	}

//Read All Row
	public List<Student> getStudents() {
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}

// Delete
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);

	}

//Update
	@Transactional
	public void updateStudent(Student student) {
    this.hibernateTemplate.update(student);
	}
      public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
      public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
