package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.HRFeedbackVO;
import com.project.model.LoginVO;
import com.project.service.HRFeedbackService;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;

@Controller
public class HRFeedbackController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	HRFeedbackService feedbackService;
	
	@RequestMapping(value="/HR/loadFeedback",method=RequestMethod.GET)
	public ModelAndView loadFeedback(@ModelAttribute HRFeedbackVO feedbackVO)
	{
		return new ModelAndView("/HR/AddFeedback","feedbackVO",new HRFeedbackVO());
	}
	
	@RequestMapping(value="/HR/insertRaiting",method=RequestMethod.POST)
	public ModelAndView insertFeedback(@ModelAttribute HRFeedbackVO feedbackVO,LoginVO loginVO)
	{
		String userName = BaseMethods.getUser();

		List loginList  = loginService.getLoginId(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		feedbackVO.setLoginVO(loginVO2);
		this.feedbackService.insertFeedback(feedbackVO);
		return new ModelAndView("redirect:/HR/loadFeedback");
	}
	
	@RequestMapping(value="admin/viewFeedback",method=RequestMethod.GET)
	public ModelAndView viewFeedback(@ModelAttribute HRFeedbackVO feedbackVO) {
		
		List feedbackList = this.feedbackService.viewFeedback(feedbackVO);
		
		return new ModelAndView("admin/viewFeedback","feedbackList",feedbackList);
	}
	
	@RequestMapping(value="HR/viewHRFeedback",method=RequestMethod.GET)
	public ModelAndView viewHReedback(@ModelAttribute HRFeedbackVO feedbackVO) {
		
		String userName = BaseMethods.getUser();
		List loginList  = loginService.getLoginId(userName); 	
		LoginVO loginVO2 = (LoginVO) loginList.get(0);	
		feedbackVO.setLoginVO(loginVO2);
		
		List feedbackList = this.feedbackService.viewHRFeedback(feedbackVO);
		
		return new ModelAndView("/HR/viewFeedback","feedbackList",feedbackList);
		
	}
	
	
	@RequestMapping(value="/employee/loadFeedback",method=RequestMethod.GET)
	public ModelAndView loadFeedbackToemployee(@ModelAttribute HRFeedbackVO feedbackVO)
	{
		return new ModelAndView("/employee/AddFeedback","feedbackVO",new HRFeedbackVO());
	}
	
	@RequestMapping(value="/employee/insertRaiting",method=RequestMethod.POST)
	public ModelAndView insertFeedbackToemployee(@ModelAttribute HRFeedbackVO feedbackVO,LoginVO loginVO)
	{
		String userName = BaseMethods.getUser();

		List loginList  = loginService.getLoginId(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		feedbackVO.setLoginVO(loginVO2);
		this.feedbackService.insertFeedback(feedbackVO);
		return new ModelAndView("redirect:/employee/loadFeedback");
	}
	
	@RequestMapping(value="employee/viewHRFeedback",method=RequestMethod.GET)
	public ModelAndView viewHRfeedbackTOemployee(@ModelAttribute HRFeedbackVO feedbackVO) {
		
		String userName = BaseMethods.getUser();
		List loginList  = loginService.getLoginId(userName); 	
		LoginVO loginVO2 = (LoginVO) loginList.get(0);	
		feedbackVO.setLoginVO(loginVO2);
		
		List feedbackList = this.feedbackService.viewHRFeedback(feedbackVO);
		
		return new ModelAndView("/employee/viewFeedback","feedbackList",feedbackList);
		
	}

}
