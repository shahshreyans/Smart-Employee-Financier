package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DepartmentVO;
import com.project.model.EmployeeVO;
import com.project.model.HRVO;
import com.project.model.LoginVO;
import com.project.service.DepartmentService;
import com.project.service.HRService;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;;
@Controller
public class HRController {
	@Autowired 
	HRService hrService;
	@Autowired
	DepartmentService departmentservice;
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="admin/addHR" ,method=RequestMethod.GET)
	public ModelAndView addDepartment(DepartmentVO departmentVO)
	{
		 List departmentList = this.departmentservice.Search(departmentVO);		
		return new ModelAndView("admin/AddHR","hrList",new HRVO()).addObject("departmentList", departmentList);
		
	}
	@RequestMapping(value="admin/insertHR",method=RequestMethod.GET)
	
	public ModelAndView insert(@ModelAttribute HRVO hrVO,LoginVO loginVO)
	{
		String password = BaseMethods.generatePassword();

		BaseMethods.sendMail(hrVO.getLoginVO().getUsername(), password,hrVO.getHrName());
		
		loginVO.setUsername(hrVO.getLoginVO().getUsername());
		loginVO.setPassword(password);
		loginVO.setRole("ROLE_HR");
		loginVO.setEnabled(1);
		
		loginService.insertLogin(loginVO);
		
		hrVO.setLoginVO(loginVO);
		
		
		
		this.hrService.insert(hrVO);
		return new ModelAndView("redirect:/admin/addHR");
		
	}
	
@RequestMapping(value="admin/searchHR",method=RequestMethod.GET)
	
	public ModelAndView dataSearch(@ModelAttribute HRVO hrVO)
	{ 
		 
		List serchhrList = hrService.Search(hrVO);	
		
		return new ModelAndView("admin/viewHR","serchhrList",serchhrList);
			
		}
@RequestMapping(value="employee/searchHR",method=RequestMethod.GET)

public ModelAndView dataSearchToEmployee(@ModelAttribute HRVO hrVO)
{ 
	 
	List serchhrList = hrService.Search(hrVO);	
	
	return new ModelAndView("employee/viewHR","serchhrList",serchhrList);
		
	}
@RequestMapping(value="admin/deleteHR",method=RequestMethod.GET)
public ModelAndView dataDelete(@ModelAttribute HRVO hrVO,HttpServletRequest request)
{		
	int id = Integer.parseInt(request.getParameter("hrId"));
	hrVO.setHrId(id);
	
	hrService.Delete(hrVO);
	
	return new ModelAndView("redirect:/admin/searchHR");
}

@RequestMapping(value="admin/editHR",method=RequestMethod.GET)

public ModelAndView dataUpdate(@ModelAttribute HRVO hrVO,HttpServletRequest request)
{
	
	int hrId = Integer.parseInt(request.getParameter("hrId"));
	hrVO.setHrId(hrId);
	
	List ls=hrService.Edit(hrVO);
	return new ModelAndView("admin/editHR","editList",(HRVO)ls.get(0));
}

@RequestMapping(value="admin/updateHR",method=RequestMethod.GET)

public ModelAndView dataUpdate(@ModelAttribute HRVO hrVO)
{	
	hrService.Update(hrVO);
	return new ModelAndView("redirect:/admin/searchHR");
}

}
