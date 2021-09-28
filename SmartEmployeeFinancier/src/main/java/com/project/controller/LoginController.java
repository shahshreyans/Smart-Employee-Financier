package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;

@Controller
public class LoginController {

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {

		return new ModelAndView("login");
	}

	
	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView loadRegister() {

		return new ModelAndView("Register","register",new RegisterVO());
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView goToHomePage(@ModelAttribute RegisterVO registerVO,LoginVO loginVO) {

		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
		loginVO.setEnabled(1);
		loginVO.setRole("ROLE_USER");
		loginService.insertLogin(loginVO);
		
		registerVO.setLoginVO(loginVO);
		loginService.insertRegister(registerVO);

		return new ModelAndView("Login");
	}*/
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(LoginVO loginVO ) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		/*loginVO.setUsername(userName);
		List ls = this.loginService.searchLoginID(loginVO);
		LoginVO lVO= (LoginVO)ls.get(0);
		int loginId = lVO.getLoginId();
		System.out.println("loginID>>>>>>"+loginId);*/
		
		return new ModelAndView("admin/index");
	}
	
	@RequestMapping(value = "/employee/index", method = RequestMethod.GET)
	public ModelAndView userIndex() {

		return new ModelAndView("employee/index");
	}
	
	@RequestMapping(value = "/HR/index", method = RequestMethod.GET)
	public ModelAndView HRIndex() {

		return new ModelAndView("HR/index");
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	}
	        return "login";
	        }
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}
	
}