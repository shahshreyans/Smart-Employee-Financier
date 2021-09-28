package com.project.dao;
import java.util.List;

import com.project.model.HRComplainVO;
public interface HRComplainDAO {

	public void insertComplain(HRComplainVO complainVO);
	public List viewComplain();
	List searchComplain(HRComplainVO complainVO);

	List seeComplain(HRComplainVO complainVO);
}
