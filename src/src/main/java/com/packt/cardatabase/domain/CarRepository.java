package com.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;

/*CarRepository now extends the Srping Boot JPA CrudRepository interface
 * <Car, Long> type arguements define that this repsoitory for the car entity class and the type of the ID
 * field is Long*/
public interface CarRepository extends CrudRepository <Car, Long> {
	
}
