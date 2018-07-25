package ie.murph.sellyourownhome.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.murph.sellyourownhome.domain.Person;
import ie.murph.sellyourownhome.repository.RegisterRepository;

@Service
public class RegisterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
    private RegisterRepository repository;
	
	public Person register(Person person)
	{
		LOGGER.info("++register()");
		return repository.save(person);
}
	
}
