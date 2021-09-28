package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;

@Repository
public class LoginDAOImp implements LoginDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List getLoginId(String userName){
		List ls = new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q =session.createQuery("from LoginVO where username='"+userName+"'");
		ls = q.list();
		return ls;
	}
	
	public void insertLogin(LoginVO loginVO){
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loginVO);
	}
}
