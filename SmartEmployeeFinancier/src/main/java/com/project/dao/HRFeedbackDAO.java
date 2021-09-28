package com.project.dao;

import java.util.List;

import com.project.model.HRFeedbackVO;

public interface HRFeedbackDAO {

	void insertFeedback(HRFeedbackVO feedbackVO);

	List viewFeedback(HRFeedbackVO feedbackVO);

	List viewHRFeedback(HRFeedbackVO feedbackVO);

}
