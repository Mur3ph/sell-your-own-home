package ie.murph.sellyourownhome.repository;

import org.springframework.data.repository.CrudRepository;

import ie.murph.sellyourownhome.domain.Person;

public interface RegisterRepository extends CrudRepository<Person, Long>{
	
}
