package ie.murph.sellyourownhome.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private List<String> listOfPhotoUrl;

}
