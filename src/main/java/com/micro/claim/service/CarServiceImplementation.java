package com.micro.claim.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.claim.model.Car;
import com.micro.claim.repo.CarRepo;

@Service
public class CarServiceImplementation implements CarService
{
	CarRepo repo;
	
	public CarServiceImplementation(CarRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addCar(Car car) 
	{
		repo.save(car);
	}

	@Override
	public List<Car> getallCars() 
	{
		return repo.findAllCars();
	}

	@Override
	public void updateCar(Car car) 
	{
		repo.update(car);
	}

	@Override
	public void deleteCar(int carId) 
	{
		repo.deleteById(carId);
	}

	@Override
	public Car findCarById(int carId) 
	{
		return repo.findById(carId);
	}

	@Override
	public Car findCarByName(String carName) 
	{
		return repo.findByName(carName);
	}
}
