package com.project.dao;



import java.util.List;

import com.project.model.DepartmentVO;

public interface DepartmentDAO {

 public void insert(DepartmentVO departmentVO);
 
 public List Search(DepartmentVO departmentVO);

	public void Delete(DepartmentVO departmentVO);

	public List Edit(DepartmentVO departmentVO);

	public void Update(DepartmentVO departmentVO); 
}
