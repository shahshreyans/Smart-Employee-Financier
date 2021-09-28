package com.project.dao;

import java.util.List;

import com.project.model.DatasetVO;

public interface DatasetDAO {
	 public void insert(DatasetVO DatasetVO);
	 public List Search(DatasetVO DatasetVO);
}
