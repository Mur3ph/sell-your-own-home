
-- #################################################################################################################################################

-- Tables: 
--			USER	 		(i.e. Buyer)
--			ORDER
--			ORDER-ITEM
--			PRODUCT	 		(House, Apartment etc.)	
-- 					PHOTO 	(Of Product)		
-- 					MESSAGE (Comment on Photo of Property)
--			SUPPLIER 		(i.e. Seller)

-- CHeck out SQL on Android App. KeepItLocal App


-- #################################################################################################################################################


-- Table: user - user is the buyer, bidder of the property

CREATE TABLE the_user
(
  person_id 						SERIAL NOT NULL,
  first_name 						CHARACTER VARYING(150) NOT NULL,
  last_name 						CHARACTER VARYING(150) NOT NULL,
  username 							CHARACTER VARYING(150) NOT NULL,
  password 							CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT pk_person 				PRIMARY KEY (person_id),
  CONSTRAINT uk_person_username 	UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE the_user
OWNER TO postgres;


-- #################################################################################################################################################

-- Table: supplier - used for seller or renter or viager of the property

CREATE TABLE supplier(
    supplier_id 		     SERIAL NOT NULL,
    supplier_name			 CHARACTER VARYING(150) NOT NULL,
	supplier_address 		 CHARACTER VARYING(150) NOT NULL,
	supplier_phone 		     CHARACTER VARYING(150) NOT NULL,
	CONSTRAINT pk_supplier   PRIMARY KEY (supplier_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE supplier
OWNER TO postgres;


-- #################################################################################################################################################

-- Table: product - used for house, apartment, land etc. 

CREATE TABLE product
(
  product_id						SERIAL NOT NULL,
  supplier_id 						SERIAL NOT NULL,
  type_of_property 					CHARACTER VARYING(150) NOT NULL,
  is_for_sale		 				BOOLEAN NOT NULL,
  is_for_rent		 				BOOLEAN NOT NULL,
  is_viager			 				BOOLEAN NOT NULL,
  property_asking_price			 	NUMERIC(12, 2) NOT NULL,
  CONSTRAINT pk_product			 	PRIMARY KEY (product_id),
  CONSTRAINT fk_seller			 	FOREIGN KEY (supplier_id) REFERENCES supplier (supplier_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE product
OWNER TO postgres;


-- #################################################################################################################################################

-- Table: property_photo_details - used for the photos of the property

CREATE TABLE property_photo_details
(
  property_photo_details_id 		SERIAL NOT NULL,
  product_id 						SERIAL NOT NULL,
  is_main_url_photo 				BOOLEAN NOT NULL,
  url_location 						CHARACTER VARYING(150) NOT NULL,
  about				 			    CHARACTER VARYING(150) NOT NULL,
  location				 			CHARACTER VARYING(150) NOT NULL,
  current_bidder				 	CHARACTER VARYING(150) NOT NULL,
  current_bid 						NUMERIC(12, 2) NOT NULL,
  CONSTRAINT pk_photo_details	 	PRIMARY KEY (property_photo_details_id),
  CONSTRAINT fk_product			 	FOREIGN KEY (product_id) REFERENCES product (product_id),
  CONSTRAINT uk_url_location	 	UNIQUE (url_location)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE property_photo_details
OWNER TO postgres;


-- #################################################################################################################################################


-- Table: order - used for user to place a bid on the property

CREATE TABLE order
(
	
)
WITH (
  OIDS=FALSE
);
ALTER TABLE order
OWNER TO postgres;


-- #################################################################################################################################################



-- Table: order - used for user to place a bid on the property

CREATE TABLE order_item
(
	
)
WITH (
  OIDS=FALSE
);
ALTER TABLE order_item
OWNER TO postgres;


-- #################################################################################################################################################



-- Table: message - might not use this table, to message on property photos

CREATE TABLE message
(
	
)
WITH (
  OIDS=FALSE
);
ALTER TABLE message
OWNER TO postgres;


-- #################################################################################################################################################


