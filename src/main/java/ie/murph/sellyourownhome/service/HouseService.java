package ie.murph.sellyourownhome.service;

import java.util.List;

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

	public List<PhotoInformation> getPhotoInformation() {
		LOGGER.info("++getPhotoInformation()");
		List<PhotoInformation> photoInformation = repository.findPhotoInformation();
		return photoInformation;
	}

}
