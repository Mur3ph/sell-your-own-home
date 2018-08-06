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
	private int photo_information_id;
	
	@Column(name = "type_of_property", nullable = false)
	private String typeOfProperty;
	
	@Column(name = "is_main_url_photo", nullable = false)
	private boolean isMainURLPhoto;
	
	@Column(name = "is_for_sale", nullable = false)
	private boolean isForSale;
	
	@Column(name = "is_for_rent", nullable = false)
	private boolean isForRent;
	
	@Column(name = "is_viager", nullable = false)
	private boolean isViager;
	
	@Column(name = "url_location", nullable = false)
	private String urlLocation;

	public PhotoInformation() {
	}

	public int getId() {
		return photo_information_id;
	}

	public void setId(int id) {
		this.photo_information_id = id;
	}

	public String getTypeOfProperty() {
		return typeOfProperty;
	}

	public void setTypeOfProperty(String typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}

	public boolean getIsMainURLPhoto() {
		return isMainURLPhoto;
	}

	public void setIsMainURLPhoto(boolean isMainURLPhoto) {
		this.isMainURLPhoto = isMainURLPhoto;
	}

	public boolean getIsForSale() {
		return isForSale;
	}

	public void setIsForSale(boolean isForSale) {
		this.isForSale = isForSale;
	}

	public boolean getIsForRent() {
		return isForRent;
	}

	public void setIsForRent(boolean isForRent) {
		this.isForRent = isForRent;
	}

	public boolean getIsViager() {
		return isViager;
	}

	public void setIsViager(boolean isViager) {
		this.isViager = isViager;
	}

	public String getUrlLocation() {
		return urlLocation;
	}

	public void setUrlLocation(String urlLocation) {
		this.urlLocation = urlLocation;
	}

	@Override
	public String toString() {
		return "PhotoInformation [id=" + photo_information_id + ", typeOfProperty=" + typeOfProperty + ", isMainURLPhoto="
				+ isMainURLPhoto + ", isForSale=" + isForSale + ", isForRent=" + isForRent + ", isViager=" + isViager
				+ ", urlLocation=" + urlLocation + "]";
	}
	
	
}
