package com.project.controller;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.DatasetService;
import com.project.model.*;
@Controller
public class DatasetController 
{
	@Autowired 
	DatasetService datasetService;
	
	@RequestMapping(value="admin/addDataset" ,method=RequestMethod.GET)
	public ModelAndView addDepartment(){
		
		return new ModelAndView("admin/AddDataset","datasetList",new DatasetVO());
		
	}
	@RequestMapping(value="admin/insertDataset",method=RequestMethod.POST)
	
	public ModelAndView insert(@ModelAttribute DatasetVO datasetVO,@RequestParam ("file")MultipartFile file,HttpSession session)
	{
		
		String path = session.getServletContext().getRealPath("/");
		
		String finalPath = path + "document\\demo\\";
		
		String fileName = file.getOriginalFilename();
		
		try
		{
			byte b[] = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(finalPath+"/"+fileName));
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		datasetVO.setDatasetName(fileName);
		datasetVO.setDatasetPath(finalPath);
		
		this.datasetService.insert(datasetVO);
		
		return new ModelAndView("redirect:/admin/addDataset");
		
	}
	
@RequestMapping(value="admin/searchDataset",method=RequestMethod.GET)
	
	public ModelAndView dataSearch(@ModelAttribute DatasetVO datasetVO)
	{ 
		 
		List serchdatasetList = datasetService.Search(datasetVO);	
		
		return new ModelAndView("admin/viewDataset","serchdatasetList",serchdatasetList);
			
		}
@RequestMapping(value="HR/searchDataset",method=RequestMethod.GET)

public ModelAndView dataSearchToHr(@ModelAttribute DatasetVO datasetVO)
{ 
	 
	List serchdatasetList = datasetService.Search(datasetVO);	
	
	return new ModelAndView("HR/viewDataset","serchdatasetList",serchdatasetList);
		
	}
@RequestMapping(value="employee/searchDataset",method=RequestMethod.GET)

public ModelAndView dataSearchToEmployee(@ModelAttribute DatasetVO datasetVO)
{ 
	 
	List serchdatasetList = datasetService.Search(datasetVO);	
	
	return new ModelAndView("employee/viewDataset","serchdatasetList",serchdatasetList);
		
	}
}
