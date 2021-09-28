package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.DatasetVO;
import com.project.model.DepartmentVO;

@Repository
public class DatasetDAOImp implements DatasetDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(DatasetVO datasetVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(datasetVO);
	
	}
	public List Search(DatasetVO datasetVO){
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from DatasetVO");
		ls =q.list();
		return ls;
	}
}
