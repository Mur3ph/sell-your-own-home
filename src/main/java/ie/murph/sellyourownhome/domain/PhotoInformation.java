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
	
	@Column(name = "type_of_property", nullable = false)
	private String typeOfProperty;
	
	@Column(name = "is_main_url_photo", nullable = false)
	private int isMainURLPhoto;
	
	@Column(name = "is_for_sale", nullable = false)
	private int isForSale;
	
	@Column(name = "is_for_rent", nullable = false)
	private int isForRent;
	
	@Column(name = "is_viager", nullable = false)
	private int isViager;
	
	@Column(name = "url_location", nullable = false)
	private String urlLocation;
	
}
