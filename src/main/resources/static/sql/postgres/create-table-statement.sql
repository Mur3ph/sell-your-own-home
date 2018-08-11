-- Database: sell_your_own_home_db


-- DROP DATABASE sellyourownhomedb;

CREATE DATABASE sellyourownhomedb
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_Ireland.1252'
       LC_CTYPE = 'English_Ireland.1252'
       CONNECTION LIMIT = -1;
       
       
-- #################################################################################################################################################


-- Table: person

-- DROP TABLE person;


CREATE TABLE person
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
ALTER TABLE person
OWNER TO postgres;


INSERT INTO person (person_id, first_name, last_name, username, password)
VALUES( 101, 'Lola', 'Murphy', 'lo', 'pass' );

SELECT * FROM person;


-- #################################################################################################################################################


-- Table: photo_information ** Might change name of table to property_details **

-- DROP TABLE photo_information;


CREATE TABLE photo_information
(
  photo_information_id 				SERIAL NOT NULL,
  -- enter_foreign_key 				SERIAL NOT NULL,
  type_of_property 					CHARACTER VARYING(150) NOT NULL,
  is_main_url_photo 				BOOLEAN NOT NULL,
  is_for_sale		 				BOOLEAN NOT NULL,
  is_for_rent		 				BOOLEAN NOT NULL,
  is_viager			 				BOOLEAN NOT NULL,
  url_location 						CHARACTER VARYING(150) NOT NULL,
  CONSTRAINT pk_photo_information 	PRIMARY KEY (photo_information_id),
  CONSTRAINT uk_url_location	 	UNIQUE (url_location)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE photo_information
OWNER TO postgres;


INSERT INTO photo_information (photo_information_id, type_of_property, is_main_url_photo, is_for_sale, is_for_rent, is_viager, url_location)
VALUES( 1001, 'House', TRUE, FALSE, FALSE, TRUE, '/images/property-listings/property_2.jpg' );

INSERT INTO photo_information (photo_information_id, type_of_property, is_main_url_photo, is_for_sale, is_for_rent, is_viager, url_location)
VALUES( 1002, 'House', TRUE, FALSE, FALSE, TRUE, '/images/property-listings/property_3.jpg' );

INSERT INTO photo_information (photo_information_id, type_of_property, is_main_url_photo, is_for_sale, is_for_rent, is_viager, url_location)
VALUES( 1002, 'House', TRUE, FALSE, FALSE, TRUE, '/images/property-listings/property_1.jpg' );

SELECT * FROM photo_information;


-- #################################################################################################################################################

-- Table: 
--			USER	 		(i.e. Buyer)
--			ORDER
--			ORDER-ITEM
--			PRODUCT	 		(House, Apartment etc.)	
-- 					PHOTO 	(Of Product)		
-- 					MESSAGE (Comment on Photo of Property)
--			SUPPLIER 		(i.e. Seller)



-- #################################################################################################################################################

/* ORIGINAL DATABASE ALL WHOLE LOT EXECUTES TOGETHER......................................*/
-- TODO Create check constraints on tables, columns

CREATE TABLE Users(
    user_id 	           NUMBER(11) NOT NULL,
    first_name 		       VARCHAR(50) NOT NULL,
    last_name 		       VARCHAR(50) NOT NULL,
	phone 		  	       VARCHAR(20) NOT NULL,
	card_type 		       VARCHAR(20) NOT NULL,
	card_number 	       VARCHAR(20) NOT NULL,
	card_id_number 	       VARCHAR(20) NOT NULL,
	valid_date 		       VARCHAR(20) NOT NULL,
	CONSTRAINT pk_user     PRIMARY KEY (user_id)
);


CREATE TABLE Buyer(
  buyer_id                          INTEGER        NOT NULL,
  user_id 	                        NUMBER(11)     NOT NULL,
  first_name 		                VARCHAR(50)    NOT NULL,
  last_name 		                VARCHAR(50)    NOT NULL,
  email 	                        VARCHAR(50)    NOT NULL,
  username 		                    VARCHAR(50)    NOT NULL,
  password 		                    VARCHAR(50)    NOT NULL,
  budget                            NUMBER(10, 2)  NOT NULL,
  CONSTRAINT pk_buyer               PRIMARY KEY (buyer_id),
  CONSTRAINT fk_buyer_user          FOREIGN KEY (user_id) REFERENCES Users (user_id) ON DELETE CASCADE,
  CONSTRAINT ck_max_min_budget      CHECK ( min_budget <= max_budget )
);


CREATE TABLE Seller (
    seller_id 		  	            NUMBER(11) NOT NULL,
    user_id 	                    NUMBER(11) NOT NULL,
    first_name 		                VARCHAR(50) NOT NULL,
    last_name 		                VARCHAR(50) NOT NULL,
    email 	                        VARCHAR(50) NOT NULL,
	username 		                VARCHAR(50) NOT NULL,
	password 		                VARCHAR(50) NOT NULL,
	CONSTRAINT pk_seller            PRIMARY KEY (seller_id),
	CONSTRAINT fk_seller_user       FOREIGN KEY (user_id) REFERENCES Users (user_id) ON DELETE CASCADE
);

CREATE TABLE Address(
     address_id 	                NUMBER(11)  NOT NULL,
     user_id 	                    NUMBER(11) NOT NULL,
     address_line1 	                VARCHAR(50) NOT NULL,
     address_line2 	                VARCHAR(50) NOT NULL,
     city 		  	                VARCHAR(20) NOT NULL,
     county 		                VARCHAR(20) NOT NULL,
     country 		                VARCHAR(20) NOT NULL,
     zip 		  	                VARCHAR(20) NOT NULL,
     CONSTRAINT pk_address          PRIMARY KEY (address_id),
     CONSTRAINT fk_address_user     FOREIGN KEY (user_id) REFERENCES Users (user_id) ON DELETE CASCADE
);


CREATE TABLE Local_Order (
    order_id 					    NUMBER(11) NOT NULL,
    user_id 			            NUMBER(11) NOT NULL,
    order_date  				    DATE,
    CONSTRAINT pk_order             PRIMARY KEY (order_id),
    CONSTRAINT fk_order_user        FOREIGN KEY (user_id) REFERENCES Users (user_id) ON DELETE CASCADE
);


CREATE TABLE Supplier(
    supplier_id 		     NUMBER(11)  NOT NULL,
    supplier_name			 VARCHAR(40) NOT NULL,
	supplier_address 		 VARCHAR(30) NOT NULL,
	supplier_phone 		     VARCHAR(20) NOT NULL,
	CONSTRAINT pk_supplier   PRIMARY KEY (supplier_id)
);


CREATE TABLE Product(
    product_id 				      NUMBER(11)  NOT NULL,
	supplier_id 				  NUMBER(11)  NOT NULL,
	product_code				  VARCHAR(30) NOT NULL,
    product_name			      VARCHAR(30) NOT NULL,
    product_price 			      NUMBER(7,2) NOT NULL,
    CONSTRAINT pk_product         PRIMARY KEY (product_id),
	CONSTRAINT fk_prod_supplier   FOREIGN KEY (supplier_id) REFERENCES Supplier (supplier_id) ON DELETE CASCADE
);


CREATE TABLE Image
(
  image_id                  INTEGER         NOT NULL,
  product_id                NUMBER(11)      NOT NULL,
  image_name                VARCHAR2(30),
  mime_type                 VARCHAR2(30),
  image_content             BLOB,
  CONSTRAINT pk_image       PRIMARY KEY (image_id),
  CONSTRAINT fk_image_room  FOREIGN KEY (product_id) REFERENCES product (product_id) ON DELETE CASCADE
);


CREATE TABLE Order_Item(
    order_id 		              NUMBER(11) NOT NULL,
    product_id 		              NUMBER(11) NOT NULL,
    CONSTRAINT pk_order_item      PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk_item_order      FOREIGN KEY (order_id)   REFERENCES Local_Order (order_id)  ON DELETE CASCADE,
	CONSTRAINT fk_item_product    FOREIGN KEY (product_id) REFERENCES Product (product_id)    ON DELETE CASCADE
);





