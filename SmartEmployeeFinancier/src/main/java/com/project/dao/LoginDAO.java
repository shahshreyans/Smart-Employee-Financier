package com.project.dao;

import java.util.List;

import com.project.model.LoginVO;

public interface LoginDAO {
	
	public List getLoginId(String userName);
	
	public void insertLogin(LoginVO loginVO);
}
