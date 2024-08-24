package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.Car;


@Service
public interface CarService 
{
	public void addCar(Car car);
	 
	public List<Car> getallCars();

	public void updateCar(Car car);

	public void deleteCar(int carId);
	
	public Car findCarById(int carId);
	
	public Car findCarByName(String carName);

}
