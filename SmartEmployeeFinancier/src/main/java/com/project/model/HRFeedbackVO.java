package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class HRFeedbackVO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Feedbackid")
	private int feedbackid;
	
	@Column(name="feedBack")
	private String feedBack;
	
	@Column(name="rating")
	private String rating;
	
	@ManyToOne
	LoginVO loginVO;

	public int getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
}
