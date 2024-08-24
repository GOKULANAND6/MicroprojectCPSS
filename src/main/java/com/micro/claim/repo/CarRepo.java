package com.micro.claim.repo;

import java.util.List;

import com.micro.claim.model.Car;

public interface CarRepo 
{
	public void save(Car car);

	public List<Car> findAllCars();

	public void update(Car car);

	public void deleteById(int carId);
	
	public Car findById(int carId);
	
	public Car findByName(String carName);
}
