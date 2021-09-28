package com.project.dao;

import java.util.List;

import com.project.model.EmployeeVO;
import com.project.model.HRVO;

public interface HRDAO {

	public void insert(HRVO hrVO);
	public List Search(HRVO hrVO);
	public void Delete(HRVO hrVO);
	public List Edit(HRVO hrVO);

	public void Update(HRVO hrVO); 


}