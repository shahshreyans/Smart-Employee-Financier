package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.HRComplainVO;

@Repository
public class HRComplainDAOImp implements HRComplainDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertComplain(HRComplainVO complainVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(complainVO);
	}
	@Override
	public List viewComplain() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from HRComplainVO where status = true ");
		List complainList = q.list();
		
		return complainList;	
	}
	@Override
	public List searchComplain (HRComplainVO complainVO) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from HRComplainVO where id = '"+complainVO.getComplainid()+"'");
		List complaintList = q.list();
		return complaintList;
	}
	
	@Override
	public List seeComplain (HRComplainVO complainVO) {
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from HRComplainVO where loginVO.loginId = '"+complainVO.getLoginVO().getLoginId()+"'");
		List complainList = q.list();
		return complainList;
	   }
}