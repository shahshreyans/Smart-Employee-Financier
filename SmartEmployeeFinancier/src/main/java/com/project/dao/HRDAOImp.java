package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.EmployeeVO;
import com.project.model.HRVO;
@Repository
public class HRDAOImp implements HRDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(HRVO hrVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
			session.save(hrVO);
	}
	public List Search(HRVO hrVO){
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from HRVO");
		ls =q.list();
		return ls;
	}
	
	public void Delete(HRVO hrVO){
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(hrVO);	
	}
	
	public List Edit(HRVO hrVO){
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from HRVO where hrId='"+hrVO.getHrId()+"'");
		ls =q.list();
		return ls;
	}
	
	public void Update(HRVO hrVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hrVO);
	}

}