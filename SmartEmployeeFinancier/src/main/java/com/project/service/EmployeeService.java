
package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.EmployeeDAO;
import com.project.model.DepartmentVO;
import com.project.model.EmployeeVO;

@Service
public class EmployeeService {
	@Autowired
   EmployeeDAO employeeDAO;
	@Transactional
		public void insert(EmployeeVO employeeVO) {
			this.employeeDAO.insert(employeeVO);
			
		}
	@Transactional
	public List Search(EmployeeVO employeeVO)
	{
		List ls=employeeDAO.Search(employeeVO);
		return ls;
	}
	@Transactional
	public void Delete(EmployeeVO employeeVO)
	{
		employeeDAO.Delete(employeeVO);
	}
	
	@Transactional
	public List Edit(EmployeeVO employeeVO)
	{
	List ls=employeeDAO.Edit(employeeVO);	
		return ls;
	}
	@Transactional
	public void Update(EmployeeVO employeeVO) 
	{	
		employeeDAO.Update(employeeVO);
	}

}

