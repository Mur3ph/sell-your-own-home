package ie.murph.sellyourownhome.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.murph.sellyourownhome.domain.Person;
import ie.murph.sellyourownhome.repository.LoginRepository;

@Service
public class LoginService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private LoginRepository repository;

	public Person doesPersonExist(String username, String password) {
		LOGGER.info("+doesPersonExist()");
		Person person = repository.findPersonByUsernameAndPassword(username, password);
		return person;
	}

}
