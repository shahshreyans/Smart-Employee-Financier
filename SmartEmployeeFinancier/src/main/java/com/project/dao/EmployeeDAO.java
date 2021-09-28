package com.project.dao;

import java.util.List;

import com.project.model.DepartmentVO;
import com.project.model.EmployeeVO;

public interface EmployeeDAO {

	public void insert(EmployeeVO employeeVO);
	
	public List Search(EmployeeVO employeeVO);
	
	public void Delete(EmployeeVO employeeVO);
	
	public List Edit(EmployeeVO employeeVO);

	public void Update(EmployeeVO employeeVO); 

}
