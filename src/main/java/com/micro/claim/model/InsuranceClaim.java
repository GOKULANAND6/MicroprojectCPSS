package com.micro.claim.model;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "claimdetails")
public class InsuranceClaim 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int claimId;
	private String claimIssue;
	private String carMake;
	private String carName;
	private String carModel;
	private String carYear;
	private String carBuyingdate;
	private String carNumber;
	private String claimStatus;
	
	@Lob
    @Column(length = 100000)
    private byte[] vehicleInvoice;
	
	@Lob
    @Column(length = 100000)
    private byte[] presentImage;
	
	@OneToOne(targetEntity = CarInsurance.class, cascade = CascadeType.ALL)
	private CarInsurance carinsurance;
	
	public InsuranceClaim() 
	{
		super();
	}

	public InsuranceClaim(int claimId, String claimIssue, String carMake, String carName, String carModel,
			String carYear, String carBuyingdate, String carNumber, String claimStatus, byte[] vehicleInvoice,
			byte[] presentImage, CarInsurance carinsurance) {
		super();
		this.claimId = claimId;
		this.claimIssue = claimIssue;
		this.carMake = carMake;
		this.carName = carName;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carBuyingdate = carBuyingdate;
		this.carNumber = carNumber;
		this.claimStatus = claimStatus;
		this.vehicleInvoice = vehicleInvoice;
		this.presentImage = presentImage;
		this.carinsurance = carinsurance;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getClaimIssue() {
		return claimIssue;
	}

	public void setClaimIssue(String claimIssue) {
		this.claimIssue = claimIssue;
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

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public byte[] getVehicleInvoice() {
		return vehicleInvoice;
	}

	public void setVehicleInvoice(byte[] vehicleInvoice) {
		this.vehicleInvoice = vehicleInvoice;
	}

	public byte[] getPresentImage() {
		return presentImage;
	}

	public void setPresentImage(byte[] presentImage) {
		this.presentImage = presentImage;
	}

	public CarInsurance getCarinsurance() {
		return carinsurance;
	}

	public void setCarinsurance(CarInsurance carinsurance) {
		this.carinsurance = carinsurance;
	}

	@Override
	public String toString() {
		return "InsuranceClaim [claimId=" + claimId + ", claimIssue=" + claimIssue + ", carMake=" + carMake
				+ ", carName=" + carName + ", carModel=" + carModel + ", carYear=" + carYear + ", carBuyingdate="
				+ carBuyingdate + ", carNumber=" + carNumber + ", claimStatus=" + claimStatus + ", vehicleInvoice="
				+ Arrays.toString(vehicleInvoice) + ", presentImage=" + Arrays.toString(presentImage)
				+ ", carinsurance=" + carinsurance + "]";
	}
}
