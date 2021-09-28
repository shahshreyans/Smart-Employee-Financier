package com.project.dao;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.DepartmentVO;

@Repository
public class DepartmentDAOImp implements DepartmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(DepartmentVO departmentVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(departmentVO);
	
	}
	

	public List Search(DepartmentVO departmentVO){
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from DepartmentVO");
		ls =q.list();
		return ls;
	}
	public void Delete(DepartmentVO departmentVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(departmentVO);
		
	}
	

	public List Edit(DepartmentVO departmentVO){
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from DepartmentVO where departmentId='"+departmentVO.getDepartmentId()+"'");
		ls =q.list();
		return ls;
	}
	
	public void Update(DepartmentVO departmentVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(departmentVO);
	}
}