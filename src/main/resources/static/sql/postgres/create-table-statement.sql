
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


-- Table: user

CREATE TABLE user
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
ALTER TABLE user
OWNER TO postgres;


-- #################################################################################################################################################


CREATE TABLE product
(
  product_id						SERIAL NOT NULL,
  seller_id 						SERIAL NOT NULL,
  type_of_property 					CHARACTER VARYING(150) NOT NULL,
  is_for_sale		 				BOOLEAN NOT NULL,
  is_for_rent		 				BOOLEAN NOT NULL,
  is_viager			 				BOOLEAN NOT NULL,
  property_price			 		NUMERIC(12, 2) NOT NULL,
  CONSTRAINT pk_product			 	PRIMARY KEY (product_id),
  CONSTRAINT fk_seller			 	FOREIGN KEY (seller_id) REFERENCES seller (seller_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE product
OWNER TO postgres;


-- #################################################################################################################################################

** Might change name of table to property_details **

CREATE TABLE photo_information
(
  photo_information_id 				SERIAL NOT NULL,
  -- product_id 					SERIAL NOT NULL,
  is_main_url_photo 				BOOLEAN NOT NULL,
  url_location 						CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT pk_photo_information 	PRIMARY KEY (photo_information_id),
  CONSTRAINT fk_product			 	FOREIGN KEY (product_id) REFERENCES product (product_id),
  CONSTRAINT uk_url_location	 	UNIQUE (url_location)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE photo_information
OWNER TO postgres;


-- #################################################################################################################################################





