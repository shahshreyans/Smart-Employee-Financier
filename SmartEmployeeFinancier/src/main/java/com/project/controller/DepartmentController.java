package com.project.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.DepartmentService;
import com.project.model.*;
@Controller

public class DepartmentController {

	@Autowired 
	DepartmentService departmentService;
	
	@RequestMapping(value="admin/addDepartment" ,method=RequestMethod.GET)
	public ModelAndView addDepartment(){
		
		return new ModelAndView("admin/AddDepartment","deptList",new DepartmentVO());
		
	}
	@RequestMapping(value="admin/insertDepartment",method=RequestMethod.GET)
	
	public ModelAndView insert(@ModelAttribute DepartmentVO departmentVO)
	{
		
		this.departmentService.insert(departmentVO);
		
		return new ModelAndView("redirect:/admin/addDepartment");
		
	}
	
	@RequestMapping(value="admin/searchDepartment",method=RequestMethod.GET)
	
	public ModelAndView dataSearch(@ModelAttribute DepartmentVO departmentVO)
	{ 
		 
		List serchdeptList = departmentService.Search(departmentVO);	
		
		return new ModelAndView("admin/viewDepartment","serchdeptList",serchdeptList);
			
		}
	

	@RequestMapping(value="HR/searchDepartment",method=RequestMethod.GET)
	
	public ModelAndView dataSearchToHr(@ModelAttribute DepartmentVO departmentVO)
	{ 
		 
		List serchdeptList = departmentService.Search(departmentVO);	
		
		return new ModelAndView("HR/viewDepartment","serchdeptList",serchdeptList);
			
		}
	
@RequestMapping(value="employee/searchDepartment",method=RequestMethod.GET)
	
	public ModelAndView dataSearchToEmployee(@ModelAttribute DepartmentVO departmentVO)
	{ 
		 
		List serchdeptList = departmentService.Search(departmentVO);	
		
		return new ModelAndView("employee/viewDepartment","serchdeptList",serchdeptList);
			
		}
	@RequestMapping(value="admin/deleteDepartment",method=RequestMethod.GET)
public ModelAndView dataDelete(@ModelAttribute DepartmentVO departmentVO,HttpServletRequest request)
	{		
		int id = Integer.parseInt(request.getParameter("departmentId"));
		departmentVO.setDepartmentId(id);
		
		departmentService.Delete(departmentVO);
		
		return new ModelAndView("redirect:/admin/searchDepartment");
	}
	@RequestMapping(value="admin/editDepartment",method=RequestMethod.GET)

	public ModelAndView dataUpdate(@ModelAttribute DepartmentVO departmentVO,HttpServletRequest request)
	{
		
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		departmentVO.setDepartmentId(departmentId);
		
		List ls=departmentService.Edit(departmentVO);
		return new ModelAndView("admin/editDepartment","editList",(DepartmentVO)ls.get(0));
	}

	@RequestMapping(value="admin/updateDepartment",method=RequestMethod.GET)
	
	public ModelAndView dataUpdate(@ModelAttribute DepartmentVO departmentVO)
	{	
		departmentService.Update(departmentVO);
		return new ModelAndView("redirect:/admin/searchDepartment");
	}
	
}
