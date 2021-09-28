package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.DatasetDAO;
import com.project.model.DatasetVO;
import com.project.model.DepartmentVO;

@Service
public class DatasetService
{
	@Autowired
	DatasetDAO datasetDAO;

	@Transactional
		public void insert(DatasetVO datasetVO) {
			this.datasetDAO.insert(datasetVO);
			
		}
	
	@Transactional
	public List Search(DatasetVO datasetVO)
	{
		List ls=datasetDAO.Search(datasetVO);
		return ls;
	}
}
