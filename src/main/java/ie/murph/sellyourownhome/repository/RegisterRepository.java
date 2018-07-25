package ie.murph.sellyourownhome.repository;

import org.springframework.data.repository.CrudRepository;

import ie.murph.sellyourownhome.domain.Person;

public interface RegisterRepository extends CrudRepository<Person, Long>{

	// The use of 'Optional' checks for 'NULL'
		// Optional<Person> findOneByUsername(String username);

		// In the HQL , you should use the java class name and property name
		// of the mapped @Entity instead of the actual table name and column
		// name , so the HQL should be :
//		@Query("INSERT INTO Person (first_name, last_name, username, password) SELECT p.firstName, p.lastName, p.username, p.password FROM Person p")
//		Person register(@Param("firstName") String firstName, @Param("lastName") String surname, @Param("username") String username, @Param("password") String password);

	
}
