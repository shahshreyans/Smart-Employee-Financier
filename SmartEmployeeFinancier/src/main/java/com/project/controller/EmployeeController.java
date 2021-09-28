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
import com.project.model.LoginVO;
import com.project.service.DepartmentService;
import com.project.service.EmployeeService;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;;
@Controller
public class EmployeeController {
	@Autowired 
	EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentservice;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="admin/addEmployee" ,method=RequestMethod.GET)
	public ModelAndView addDepartment(DepartmentVO departmentVO)
	{
	    List departmentList = this.departmentservice.Search(departmentVO);	
		return new ModelAndView("admin/AddEmployee","employeeList",new EmployeeVO()).addObject("departmentList", departmentList);
		
	}
	@RequestMapping(value="admin/insertEmployee",method=RequestMethod.GET)
	public ModelAndView insert(@ModelAttribute EmployeeVO employeeVO,LoginVO loginVO)
	{
		String password = BaseMethods.generatePassword();

		BaseMethods.sendMail(employeeVO.getLoginVO().getUsername(), password,employeeVO.getEmployeeName());
		
		loginVO.setUsername(employeeVO.getLoginVO().getUsername());
		loginVO.setPassword(password);
		loginVO.setRole("ROLE_EMPLOYEE");
		loginVO.setEnabled(1);
		
		loginService.insertLogin(loginVO);
		
		employeeVO.setLoginVO(loginVO);
		
		this.employeeService.insert(employeeVO);
		return new ModelAndView("redirect:/admin/addEmployee");
		
	}
	@RequestMapping(value="admin/searchEmployee",method=RequestMethod.GET)
	public ModelAndView dataSearch(@ModelAttribute EmployeeVO EmployeeVO)
	{
		List serchempList = employeeService.Search(EmployeeVO);	
		
		return new ModelAndView("admin/viewEmployee","serchempList",serchempList);
			
		}
	@RequestMapping(value="HR/searchEmployee",method=RequestMethod.GET)
	public ModelAndView dataSearchToHr(@ModelAttribute EmployeeVO EmployeeVO)
	{
		List serchempList = this.employeeService.Search(EmployeeVO);	
		
		return new ModelAndView("HR/viewEmployee","serchempList",serchempList);
			
		}

@RequestMapping(value="admin/deleteEmployee",method=RequestMethod.GET)
public ModelAndView dataDelete(@ModelAttribute EmployeeVO EmployeeVO,HttpServletRequest request)
{		
	int id = Integer.parseInt(request.getParameter("employeeId"));
	EmployeeVO.setEmployeeId(id);
	
	employeeService.Delete(EmployeeVO);
	
	return new ModelAndView("redirect:/admin/searchEmployee");
}

@RequestMapping(value="admin/editEmployee",method=RequestMethod.GET)

public ModelAndView dataUpdate(@ModelAttribute EmployeeVO employeeVO,HttpServletRequest request)
{
	
	int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	employeeVO.setEmployeeId(employeeId);
	
	List ls=employeeService.Edit(employeeVO);
	return new ModelAndView("admin/editEmployee","editList",(EmployeeVO)ls.get(0));
}

@RequestMapping(value="admin/updateEmployee",method=RequestMethod.GET)

public ModelAndView dataUpdate(@ModelAttribute EmployeeVO employeeVO)
{	
	employeeService.Update(employeeVO);
	return new ModelAndView("redirect:/admin/searchEmployee");
}
}
