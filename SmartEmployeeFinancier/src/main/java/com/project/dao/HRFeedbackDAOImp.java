package com.project.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Query;

import com.project.model.HRComplainVO;
import com.project.model.HRFeedbackVO;

@Repository
public class HRFeedbackDAOImp implements HRFeedbackDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertFeedback(HRFeedbackVO feedbackVO) {
		
		Session session = sessionFactory.getCurrentSession(); 
		session.saveOrUpdate(feedbackVO);	
	}
	
	@Override
    public List viewFeedback(HRFeedbackVO feedbackVO){
			
		Session session = sessionFactory.getCurrentSession();		
		Query q = session.createQuery("from HRFeedbackVO");		
		List feedbackList = q.list();
		return feedbackList;	
	}
	
	@Override
	public List viewHRFeedback(HRFeedbackVO feedbackVO) {
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from HRFeedbackVO where loginVO.loginId = '"+feedbackVO.getLoginVO().getLoginId()+"'");
		List complainList = q.list();
		return complainList;
	   }

	

}
