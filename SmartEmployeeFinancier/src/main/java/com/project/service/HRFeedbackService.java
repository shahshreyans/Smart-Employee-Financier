package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.HRFeedbackDAO;
import com.project.model.HRComplainVO;
import com.project.model.HRFeedbackVO;


@Service

public class HRFeedbackService {

	@Autowired
	HRFeedbackDAO feedbackDAO;

	@Transactional
	public void insertFeedback(HRFeedbackVO feedbackVO) {
		
		this.feedbackDAO.insertFeedback(feedbackVO);
	}
	@Transactional
	public List viewFeedback(HRFeedbackVO feedbackVO) {
		
		List feedbackList = this.feedbackDAO.viewFeedback(feedbackVO);
		return feedbackList;
	}
	
	@Transactional
    public List viewHRFeedback(HRFeedbackVO feedbackVO) {
    	
        List complainList =	this.feedbackDAO.viewHRFeedback(feedbackVO);
        return complainList;
    
    }

	
}
