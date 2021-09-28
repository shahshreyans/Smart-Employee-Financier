package com.project.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.DepartmentDAO;
import com.project.model.DepartmentVO;

@Service
public class DepartmentService {
@Autowired
DepartmentDAO departmentDAO;

@Transactional
	public void insert(DepartmentVO departmentVO) {
		this.departmentDAO.insert(departmentVO);
		
	}

@Transactional
public List Search(DepartmentVO departmentVO)
{
	List ls=departmentDAO.Search(departmentVO);
	return ls;
}

@Transactional
public void Delete(DepartmentVO departmentVO)
{
	departmentDAO.Delete(departmentVO);
}

@Transactional
public List Edit(DepartmentVO departmentVO)
{
List ls=departmentDAO.Edit(departmentVO);	
	return ls;
}
@Transactional
public void Update(DepartmentVO departmentVO) 
{	
	departmentDAO.Update(departmentVO);
}

}
