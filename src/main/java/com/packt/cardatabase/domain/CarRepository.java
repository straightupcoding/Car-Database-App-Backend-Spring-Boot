
package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository <Car, Long> {
	// Fetch cars by brand
	List<Car> findByBrand(@Param("brand") String brand);

	// Fetch cars by color
	List<Car> findByColor(@Param("color") String color);
}



/*import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//Crud Repository interface is used for CRUD operations in entity class
CarRepository now extends the Srping Boot JPA CrudRepository interface
 * <Car, Long> type arguements define that this repsoitory for the car entity class and the type of the ID
 * field is Long

//Spring Data JPA provides PagingAndSortingRepository which extends CrudRepository.
public interface CarRepository extends PagingAndSortingRepository,Car, Long> {
	
} see page 49
@RepositoryRestResource 
//^^this is added to include queries in the service
//Query parameters are annotated with the @Param annotation
public interface CarRepository extends CrudRepository <Car, Long> {
	//Fetch cars by brand
	List<Car> findByBrand(@Param("brand") String brand);
	//Fetch cars by color
	List<Car> findByColor(@Param("color") String color);
	//Fetch cars by year
	List<Car> findByYear(int year);
	//There can be multiple fields after the By keyword, concatenated with the And or Or keywords
	//Fetch cars by brand and model
	List<Car> findByBrandAndModel(String brand, String model);
	List<Car> findByBrandOrColor(String brand, String color);
	//Queries can be sorted by using the OrderBy keyword
	//Fetch cars by brand and sorty by year List<Car>
	List<Car> findByBrandOrderByYearAsc(String brand);
	//You can also create queries by using SQL statements via the @Query annotation in the CrudRepository.
	//Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand = ?1") List<Car> findByBrand1(String brand);
	//You can also use more advanced expressions with the @Query annotation with like
	//fetch cars by brand using SQL 
	@Query("select c from Car c where c.brand like %?1")
		List<Car> findByBrandEndsWith(String brand);
	}*/

