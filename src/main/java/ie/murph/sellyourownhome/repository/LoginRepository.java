package ie.murph.sellyourownhome.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ie.murph.sellyourownhome.domain.Person;

public interface LoginRepository extends CrudRepository<Person, Long> {

	// The use of 'Optional' checks for 'NULL'
	// Optional<Person> findOneByUsername(String username);

	// In the HQL , you should use the java class name and property name
	// of the mapped @Entity instead of the actual table name and column
	// name , so the HQL should be :
	@Query("SELECT p FROM Person p WHERE p.username = :username AND p.password = :password")
	Person findPersonByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
