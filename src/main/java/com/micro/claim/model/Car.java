package com.micro.claim.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "car")
public class Car 
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int carId;
	private String carMake;
	private String carName;
	private String carModel;
	private String carYear;
	private Date carBuyingdate;
	private String carNumber;
	
	public Car() 
	{
		super();
	}

	public Car(int carId, String carMake, String carName, String carModel, String carYear, Date carBuyingdate,
			String carNumber) {
		super();
		this.carId = carId;
		this.carMake = carMake;
		this.carName = carName;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carBuyingdate = carBuyingdate;
		this.carNumber = carNumber;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
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

	public Date getCarBuyingdate() {
		return carBuyingdate;
	}

	public void setCarBuyingdate(Date carBuyingdate) {
		this.carBuyingdate = carBuyingdate;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carMake=" + carMake + ", carName=" + carName + ", carModel=" + carModel
				+ ", carYear=" + carYear + ", carBuyingdate=" + carBuyingdate + ", carNumber=" + carNumber + "]";
	}
}
