DROP TABLE Users;

-- Task 1: Calculate yearly tax

CREATE TABLE Users
(
  user_id                                  INTEGER     NOT NULL,
  user_type                                VARCHAR(50) NOT NULL,
  first_name                               VARCHAR(50) NOT NULL,
  last_name                                VARCHAR(50) NOT NULL,
  country                                  VARCHAR(50) NOT NULL,
  city                                     VARCHAR(50) NOT NULL,
  date_of_birth                            DATE        NOT NULL,
  gender                                   VARCHAR(50) NOT NULL,
  phone                                    VARCHAR(50) NOT NULL,
  email                                    VARCHAR(50) NOT NULL,
  CONSTRAINT pk_user_id                    PRIMARY KEY (user_id),
  CONSTRAINT ck_date_of_birth              CHECK (date_of_birth < sysdate),
  CONSTRAINT ck_date_of_birth_overage      CHECK ( (EXTRACT(YEAR FROM sysdate) - EXTRACT(YEAR FROM date_of_birth)) >= 18)
);

CREATE TABLE Seller
(
  user_id                                 INTEGER     NOT NULL,
  property_id                             VARCHAR(50) NOT NULL,
  post_property_for                       VARCHAR(50) NOT NULL
);

CREATE TABLE Buyer
(
  user_id                                INTEGER     NOT NULL,
  property_type                          VARCHAR(50) NOT NULL,
  country                                VARCHAR(50) NOT NULL,
  city                                   VARCHAR(50) NOT NULL,
  min_area                               VARCHAR(50) NOT NULL,
  max_area                               VARCHAR(50) NOT NULL,
  min_budget                             VARCHAR(50) NOT NULL,
  max_budget                             VARCHAR(50) NOT NULL
);

CREATE TABLE Pauly_Admin
(
  ADMINID 		  	                       INTEGER NOT NULL,
	ADMINUSERNAME 		                     VARCHAR(20) NOT NULL,
	ADMINPASSWORD 		                     VARCHAR(20) NOT NULL,
  CONSTRAINT pk_adminid                  PRIMARY KEY (ADMINID)
);

CREATE TABLE Property
(
  property_id                              INTEGER     NOT NULL,
  property_type                            VARCHAR(50) NOT NULL,
  property_address_id                      INTEGER     NOT NULL,
  city                                     VARCHAR(50) NOT NULL,
  country                                  VARCHAR(50) NOT NULL,
  property_date                            DATE        NOT NULL,
  number_of_rooms                          INTEGER     NOT NULL,
  area_size                                INTEGER     NOT NULL,
  per_unit_price                           INTEGER     NOT NULL,
  CONSTRAINT pk_property_id                PRIMARY KEY (property_id)
);

CREATE TABLE Room
(
  property_id                              INTEGER     NOT NULL,
  room_name                                VARCHAR(50) NOT NULL,
  area                                     VARCHAR(50) NOT NULL,
  image                                    VARCHAR(50) NOT NULL
);

CREATE TABLE Address
(
  property_address_id                      INTEGER     NOT NULL,
  city                                     VARCHAR(50) NOT NULL,
  plot_number                              VARCHAR(50) NOT NULL,
  property_name                            VARCHAR(50) NOT NULL,
  floor_number                             VARCHAR(50) NOT NULL,
  area_name                                VARCHAR(50) NOT NULL,
  state                                    VARCHAR(50) NOT NULL,
  country                                  VARCHAR(50) NOT NULL,
  zip                                      VARCHAR(50) NOT NULL
);


CREATE TABLE Feature
(
  property_id                              INTEGER     NOT NULL,
  feature_name                             VARCHAR(50) NOT NULL,
  description                              VARCHAR(50) NOT NULL
);


