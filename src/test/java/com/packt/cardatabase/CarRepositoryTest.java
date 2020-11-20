package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired 
	//Tells spring where an injection needs to occur meaning that a bean needs to be injected at the @Autowired annotation.
	private CarRepository repository;
	
	@Test
	public void saveCar() {
		Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000);
		entityManager.persistAndFlush(car);
		//persist and flush is provided through the TestEntityManager
		
		assertThat(car.getId()).isNotNull();
		//Checking that the car ID cannot be null if it is successfully saved.
	}
	
	@Test
	//Testing the deletion of cars
	//causes a new car object to be created and saved then all cars are deleted from the database.
	public void deleteCars() {
		entityManager.persistAndFlush(new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000));
		entityManager.persistAndFlush(new Car("Mini", "Cooper", "Yellow", "BWS-3007", 2015, 24500));
		
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
		//Every car should be deleted so, this should return an empty list.
	}	

}