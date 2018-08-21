package ie.murph.sellyourownhome.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	
	private int supplier_id;
	
	@Column(name = "type_of_property", nullable = false)
	private String typeOfProperty;
	
	@Column(name = "is_for_sale", nullable = false)
	private boolean isForSale;
	
	@Column(name = "is_for_rent", nullable = false)
	private boolean isForRent;
	
	@Column(name = "is_viager", nullable = false)
	private boolean isViager;

	@Column(name = "property_asking_price", nullable = false)
	private double propertyASkingPrice;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getTypeOfProperty() {
		return typeOfProperty;
	}

	public void setTypeOfProperty(String typeOfProperty) {
		this.typeOfProperty = typeOfProperty;
	}

	public boolean isForSale() {
		return isForSale;
	}

	public void setForSale(boolean isForSale) {
		this.isForSale = isForSale;
	}

	public boolean isForRent() {
		return isForRent;
	}

	public void setForRent(boolean isForRent) {
		this.isForRent = isForRent;
	}

	public boolean isViager() {
		return isViager;
	}

	public void setViager(boolean isViager) {
		this.isViager = isViager;
	}

	public double getPropertyASkingPrice() {
		return propertyASkingPrice;
	}

	public void setPropertyASkingPrice(double propertyASkingPrice) {
		this.propertyASkingPrice = propertyASkingPrice;
	}

	@Override
	public String toString() {
		return "Property [product_id=" + product_id + ", supplier_id=" + supplier_id + ", typeOfProperty="
				+ typeOfProperty + ", isForSale=" + isForSale + ", isForRent=" + isForRent + ", isViager=" + isViager
				+ ", propertyASkingPrice=" + propertyASkingPrice + "]";
	}

	
}
