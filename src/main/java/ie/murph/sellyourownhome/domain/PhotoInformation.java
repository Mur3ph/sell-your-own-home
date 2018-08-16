package ie.murph.sellyourownhome.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "property_photo_details")
public class PhotoInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int property_photo_details_id;
	
	@Column(name = "product_id", nullable = false)
	private int productId;
	
	@Column(name = "is_main_url_photo", nullable = false)
	private boolean isMainURLPhoto;
	
	@Column(name = "url_location", nullable = false)
	private String urlLocation;
	
	@Column(name = "about", nullable = false)
	private String about;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "current_bidder", nullable = false)
	private String currentBidder;
	
	@Column(name = "current_bid", nullable = false)
	private int currentBid;

	public PhotoInformation() {
	}

	public int getProperty_photo_details_id() {
		return property_photo_details_id;
	}

	public void setProperty_photo_details_id(int property_photo_details_id) {
		this.property_photo_details_id = property_photo_details_id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isMainURLPhoto() {
		return isMainURLPhoto;
	}

	public void setMainURLPhoto(boolean isMainURLPhoto) {
		this.isMainURLPhoto = isMainURLPhoto;
	}

	public String getUrlLocation() {
		return urlLocation;
	}

	public void setUrlLocation(String urlLocation) {
		this.urlLocation = urlLocation;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCurrentBidder() {
		return currentBidder;
	}

	public void setCurrentBidder(String currentBidder) {
		this.currentBidder = currentBidder;
	}

	public int getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(int currentBid) {
		this.currentBid = currentBid;
	}

	@Override
	public String toString() {
		return "PhotoInformation [property_photo_details_id=" + property_photo_details_id + ", productId=" + productId
				+ ", isMainURLPhoto=" + isMainURLPhoto + ", urlLocation=" + urlLocation + ", about=" + about
				+ ", location=" + location + ", currentBidder=" + currentBidder + ", currentBid=" + currentBid + "]";
	}

}
