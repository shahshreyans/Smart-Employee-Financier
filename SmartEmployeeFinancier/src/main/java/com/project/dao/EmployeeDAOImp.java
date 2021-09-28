package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.DepartmentVO;
import com.project.model.EmployeeVO;
@Repository
public class EmployeeDAOImp implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(EmployeeVO employeeVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
			session.save(employeeVO);
	}
	
	public List Search(EmployeeVO employeeVO){
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from EmployeeVO");
		ls =q.list();
		return ls;
	}
	public void Delete(EmployeeVO employeeVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(employeeVO);	
	}
	public List Edit(EmployeeVO employeeVO){
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from EmployeeVO where employeeId='"+employeeVO.getEmployeeId()+"'");
		ls =q.list();
		return ls;
	}
	
	public void Update(EmployeeVO employeeVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employeeVO);
	}
	
}
