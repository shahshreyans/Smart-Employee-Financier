
package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.HRDAO;
import com.project.model.EmployeeVO;
import com.project.model.HRVO;

@Service
public class HRService {
	@Autowired
   HRDAO hrDAO;
	@Transactional
		public void insert(HRVO hrVO) {
			this.hrDAO.insert(hrVO);
		}
	@Transactional
	public List Search(HRVO hrVO)
	{
		List ls=hrDAO.Search(hrVO);
		return ls;
	}
	@Transactional
	public void Delete(HRVO hrVO)
	{
		hrDAO.Delete(hrVO);
	}
	@Transactional
	public List Edit(HRVO hrVO)
	{
	List ls=hrDAO.Edit(hrVO);	
		return ls;
	}
	@Transactional
	public void Update(HRVO hrVO) 
	{	
		hrDAO.Update(hrVO);
	}

}
