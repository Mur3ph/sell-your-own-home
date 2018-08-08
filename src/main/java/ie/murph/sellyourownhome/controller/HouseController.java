package ie.murph.sellyourownhome.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.murph.sellyourownhome.domain.PhotoInformation;
import ie.murph.sellyourownhome.service.HouseService;

@Controller
public class HouseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HouseController.class);
	private List<PhotoInformation> photoInformation;
	
	@Autowired
	private HouseService houseService;
	
	// http://localhost:8080/house/index
	@RequestMapping(value = "house/index", method = RequestMethod.GET)
	public String index(Model model) {
		LOGGER.info("++index()");
		photoInformation = houseService.getPhotoInformation();
		savePhotoInformationToHousePage(model, photoInformation);
		LOGGER.info("--index()" + " Size: " + photoInformation.size());
		return "house/index";
	}
	
	private void savePhotoInformationToHousePage(Model model, List<PhotoInformation> photoInformation2) {
		model.addAttribute("photoInformation", photoInformation2);
	}
	
	@RequestMapping("house/property")
	public String property() {
		return "house/property";
	}

}
