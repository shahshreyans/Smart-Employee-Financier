
package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.HRComplainVO;
import com.project.model.LoginVO;
import com.project.service.HRComplainService;
import com.project.service.LoginService;
import com.project.utils.*;
@Controller
public class HRComplainController {

	@Autowired
	HRComplainService complainService;
	
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value="/HR/addComplain",method=RequestMethod.GET)
	public ModelAndView loadComplaint(@ModelAttribute HRComplainVO complainVO){
		
		return new ModelAndView("HR/AddComplain","ComplainVO", new HRComplainVO());
	}
	
	@RequestMapping(value="/HR/insertComplain",method=RequestMethod.POST)
	public ModelAndView insertComplaint(@ModelAttribute HRComplainVO complainVO, @RequestParam(name="file") MultipartFile file ,HttpSession session){
		
		String path = session.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();
		
		String finalPath = path+"document/complain/"; 
		
		try {
			byte b[] = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = 
					 new BufferedOutputStream(new FileOutputStream(finalPath+fileName));
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		complainVO.setComplainDate(dateFormat.format(d));

		String userName = BaseMethods.getUser();

		List loginList  = loginService.getLoginId(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		complainVO.setLoginVO(loginVO2);
		
		complainVO.setComplainFileName(fileName);
		complainVO.setComplainFilePath(finalPath);
		complainVO.setComplainStatus("PENDING");
		this.complainService.insertComplain(complainVO);
		return new ModelAndView("redirect:/HR/addComplain");
	}
	
	@RequestMapping(value="/employee/addComplain",method=RequestMethod.GET)
	public ModelAndView loadComplaintToemployee(@ModelAttribute HRComplainVO complainVO){
		
		return new ModelAndView("employee/AddComplain","ComplainVO", new HRComplainVO());
	}
	
	@RequestMapping(value="/employee/insertComplain",method=RequestMethod.POST)
	public ModelAndView insertComplaintToemployee(@ModelAttribute HRComplainVO complainVO, @RequestParam(name="file") MultipartFile file ,HttpSession session){
		
		String path = session.getServletContext().getRealPath("/");
		String fileName = file.getOriginalFilename();
		
		String finalPath = path+"document/complain/"; 
		
		try {
			byte b[] = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = 
					 new BufferedOutputStream(new FileOutputStream(finalPath+fileName));
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		complainVO.setComplainDate(dateFormat.format(d));

		String userName = BaseMethods.getUser();

		List loginList  = loginService.getLoginId(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		complainVO.setLoginVO(loginVO2);
		
		complainVO.setComplainFileName(fileName);
		complainVO.setComplainFilePath(finalPath);
		complainVO.setComplainStatus("PENDING");
		this.complainService.insertComplain(complainVO);
		return new ModelAndView("redirect:/employee/addComplain");
	}
	
	@RequestMapping(value="/admin/viewComplain",method=RequestMethod.GET)
	public ModelAndView viewComplain() {
		
		List complainList = this.complainService.viewComplain();
		
		return new ModelAndView("/admin/viewComplain","complainList",complainList);
		
	}
	
	@RequestMapping(value="admin/replytoUser",method=RequestMethod.GET)
	public ModelAndView loadReply(@RequestParam("id")int id,@ModelAttribute HRComplainVO complainVO) {
		
		
		complainVO.setComplainid(id);;
		
		List complainList = this.complainService.searchComplain(complainVO);
		
		return new ModelAndView("admin/AddReply","complainVO",complainList.get(0));
	}
	
	@RequestMapping(value="admin/insertReply",method=RequestMethod.POST)
	public ModelAndView insertReply(@ModelAttribute HRComplainVO complainVO) {
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		complainVO.setReplyDate(dateFormat.format(d));
		complainVO.setComplainStatus("resolved");
		
		this.complainService.insertComplain(complainVO);
		
		return new ModelAndView("redirect:/admin/viewComplain");
	}
	
	@RequestMapping(value="/employee/seeComplain",method=RequestMethod.GET)
	public ModelAndView seeComplainToemployee(@ModelAttribute HRComplainVO complainVO) {
		
		
		String userName = BaseMethods.getUser();

		List loginList  = loginService.getLoginId(userName);
    	
    	System.out.println(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		complainVO.setLoginVO(loginVO2);
		
		List complainList = this.complainService.seeComplain(complainVO);
		
		return new ModelAndView("/employee/viewComplain","complainList",complainList);
		
	}
	
	@RequestMapping(value="/HR/seeComplain",method=RequestMethod.GET)
	public ModelAndView seeComplain(@ModelAttribute HRComplainVO complainVO) {
		
		
		String userName = BaseMethods.getUser();

		List loginList  = loginService.getLoginId(userName);
    	
    	System.out.println(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		complainVO.setLoginVO(loginVO2);
		
		List complainList = this.complainService.seeComplain(complainVO);
		
		return new ModelAndView("/HR/viewComplain","complainList",complainList);
		
	}
}

