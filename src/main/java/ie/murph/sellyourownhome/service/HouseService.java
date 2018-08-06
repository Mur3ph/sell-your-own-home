package ie.murph.sellyourownhome.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.murph.sellyourownhome.domain.PhotoInformation;
import ie.murph.sellyourownhome.repository.HouseRepository;

@Service
public class HouseService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HouseService.class);

	@Autowired
	private HouseRepository repository;

	public PhotoInformation getPhotoInformation() {
		LOGGER.info("++getPhotoInformation()");
		PhotoInformation photoInformation = repository.findPhotoInformation();
		return photoInformation;
	}

}
