package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="AddHR")
public class HRVO {
	@Id
	@Column(name="HRId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int hrId;
	
	@Column(name="HRName")
	private String hrName;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="PhoneNumber")
	private String phoneNo;

	@ManyToOne DepartmentVO departmentVO;
	@ManyToOne LoginVO loginVO;
	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public int getHrId() {
		return hrId;
	}

	public void setHrId(int hrId) {
		this.hrId = hrId;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}