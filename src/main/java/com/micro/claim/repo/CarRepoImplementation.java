package com.micro.claim.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.claim.model.Car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarRepoImplementation implements CarRepo
{
	EntityManager manager;
	
	public CarRepoImplementation(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public void save(Car car) 
	{
		manager.persist(car);
	}

	@Override
	public List<Car> findAllCars() 
	{
		String str = "From Car";
		Query query = manager.createQuery(str);
		return query.getResultList();
	}

	@Override
	public void update(Car car) 
	{
		manager.merge(car);
	}

	@Override
	public void deleteById(int carId) 
	{
		Car car = manager.find(Car.class, carId);
		manager.remove(car);
	}

	@Override
	public Car findById(int carId) 
	{
		return manager.find(Car.class, carId);
	}

	@Override
	public Car findByName(String carName) 
	{
		String str = "From Car where carName=:name";
		Query query = manager.createQuery(str);
		query.setParameter("name", carName);
		return (Car) query.getSingleResult();
	}
}
