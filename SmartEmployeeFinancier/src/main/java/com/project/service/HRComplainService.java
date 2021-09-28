package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.HRComplainDAO;
import com.project.model.HRComplainVO;

@Service
public class HRComplainService {

	@Autowired HRComplainDAO complainDAO;
	
	@Transactional
	public void insertComplain(HRComplainVO complainVO) {
		
		this.complainDAO.insertComplain(complainVO);
	}
	
	@Transactional
	public List viewComplain() {
		
		List complaintList = this.complainDAO.viewComplain();
		
		return complaintList;
	}
	@Transactional
	public List searchComplain(HRComplainVO complainVO) {
		
		List complainList = this.complainDAO.searchComplain(complainVO);
		
		return complainList;	
	}
	
	@Transactional
    public List seeComplain(HRComplainVO complainVO) {
    	
            List complainList =	this.complainDAO.seeComplain(complainVO);
         
            return complainList;
    
    }
}