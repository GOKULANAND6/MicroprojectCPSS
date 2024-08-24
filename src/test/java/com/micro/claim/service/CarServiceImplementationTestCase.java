package com.micro.claim.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.micro.claim.model.Car;
import com.micro.claim.repo.CarRepo;

public class CarServiceImplementationTestCase {

    @Mock
    private CarRepo repo;

    @InjectMocks
    private CarServiceImplementation service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCar() {
        Car car = new Car(1, "Toyota", "Corolla", "2022", "2022", new Date(), "ABC123");
        service.addCar(car);
        verify(repo).save(car);
    }

    @Test
    public void testGetAllCars() {
        Car car1 = new Car(1, "Toyota", "Corolla", "2022", "2022", new Date(), "ABC123");
        Car car2 = new Car(2, "Honda", "Civic", "2021", "2021", new Date(), "XYZ789");
        when(repo.findAllCars()).thenReturn(List.of(car1, car2));

        List<Car> cars = service.getallCars();
        assertEquals(2, cars.size());
        assertEquals(car1, cars.get(0));
        assertEquals(car2, cars.get(1));
    }

    @Test
    public void testUpdateCar() {
        Car car = new Car(1, "Toyota", "Corolla", "2022", "2022", new Date(), "ABC123");
        service.updateCar(car);
        verify(repo).update(car);
    }

    @Test
    public void testDeleteCar() {
        int carId = 1;
        service.deleteCar(carId);
        verify(repo).deleteById(carId);
    }

    @Test
    public void testFindCarById() {
        Car car = new Car(1, "Toyota", "Corolla", "2022", "2022", new Date(), "ABC123");
        when(repo.findById(anyInt())).thenReturn(car);

        Car foundCar = service.findCarById(1);
        assertNotNull(foundCar);
        assertEquals(1, foundCar.getCarId());
    }

    @Test
    public void testFindCarByName() {
        Car car = new Car(1, "Toyota", "Corolla", "2022", "2022", new Date(), "ABC123");
        when(repo.findByName(any())).thenReturn(car);

        Car foundCar = service.findCarByName("Corolla");
        assertNotNull(foundCar);
        assertEquals("Corolla", foundCar.getCarName());
    }
}
