package ie.murph.sellyourownhome.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "photo_album")
public class PhotoAlbum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int photo_album_id;
	
	@Column(name = "property_photo_details_id", nullable = false)
	private int propertyPhotoDetailsId;
	
	@Column(name = "url_location", nullable = false)
	@OneToMany(targetEntity=PhotoInformation.class, mappedBy="property_photo_details_id", fetch=FetchType.EAGER)
	private List<String> listOfPhotoUrl;
	
	//Could not determine type for: java.util.List, at table: photo_album, for columns: [org.hibernate.mapping.Column(url_location)]

}
