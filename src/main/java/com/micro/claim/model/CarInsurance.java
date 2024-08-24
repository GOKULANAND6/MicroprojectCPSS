package com.micro.claim.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "carinsurance")
public class CarInsurance 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int policyId;
	private String policyName;
	private int policyScheme;
	private String carMake;
	private String carName;
	private String carModel;
	private String carYear;
	private String carBuyingdate;
	private String carNumber;
	private int policyAmount;
	
	@ManyToOne(targetEntity = CustomerSignup.class, cascade = CascadeType.MERGE)
	@JoinColumn( name = "customerId")
	private CustomerSignup customer;

	public CarInsurance() 
	{
		super();
	}

	public CarInsurance(int policyId, String policyName, int policyScheme, String carMake, String carName,
			String carModel, String carYear, String carBuyingdate, String carNumber, int policyAmount,
			CustomerSignup customer) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyScheme = policyScheme;
		this.carMake = carMake;
		this.carName = carName;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carBuyingdate = carBuyingdate;
		this.carNumber = carNumber;
		this.policyAmount = policyAmount;
		this.customer = customer;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public int getPolicyScheme() {
		return policyScheme;
	}

	public void setPolicyScheme(int policyScheme) {
		this.policyScheme = policyScheme;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getCarBuyingdate() {
		return carBuyingdate;
	}

	public void setCarBuyingdate(String carBuyingdate) {
		this.carBuyingdate = carBuyingdate;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public int getPolicyAmount() {
		return policyAmount;
	}

	public void setPolicyAmount(int policyAmount) {
		this.policyAmount = policyAmount;
	}

	public CustomerSignup getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerSignup customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CarInsurance [policyId=" + policyId + ", policyName=" + policyName + ", policyScheme=" + policyScheme
				+ ", carMake=" + carMake + ", carName=" + carName + ", carModel=" + carModel + ", carYear=" + carYear
				+ ", carBuyingdate=" + carBuyingdate + ", carNumber=" + carNumber + ", policyAmount=" + policyAmount
				+ "]";
	}
}
