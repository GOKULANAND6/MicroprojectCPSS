package com.micro.claim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "admindetails")
public class AdminSignup 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String adminMobile;
	private String adminPassword;
	
	public AdminSignup() 
	{
		super();
	}

	public AdminSignup(int adminId, String adminName, String adminMobile, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminMobile = adminMobile;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "AdminSignup [adminId=" + adminId + ", adminName=" + adminName + ", adminMobile=" + adminMobile
				+ ", adminPassword=" + adminPassword + "]";
	}
}
