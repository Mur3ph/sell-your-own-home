package ie.murph.sellyourownhome.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photo_information")
public class PhotoInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "is_main_url_photo", nullable = false)
	private int isMainURLPhoto;
	
	@Column(name = "url_location", nullable = false)
	private String urlLocation;
	
}
