package com.micro.claim.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "customerdetails")
public class CustomerSignup 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String customerEmail;
	private String customerMobile;
	private String customerAddress;
	private String customerPincode;
	private Date customerDob;
	private String customerAge;
	private String customerGender;
	private String customerPassword;

	
	public CustomerSignup() 
	{
		super();
	}

	public CustomerSignup(int customerId, String customerName, String customerEmail, String customerMobile,
			String customerAddress, String customerPincode, Date customerDob, String customerAge, String customerGender,
			String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.customerPincode = customerPincode;
		this.customerDob = customerDob;
		this.customerAge = customerAge;
		this.customerGender = customerGender;
		this.customerPassword = customerPassword;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPincode() {
		return customerPincode;
	}

	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	public String getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "CustomerSignup [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerMobile=" + customerMobile + ", customerAddress=" + customerAddress
				+ ", customerPincode=" + customerPincode + ", customerDob=" + customerDob + ", customerAge="
				+ customerAge + ", customerGender=" + customerGender + ", customerPassword=" + customerPassword + "]";
	}
}
