

-- Giving error with both check constraints
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
  phone                                    VARCHAR(20) NOT NULL,
  email                                    VARCHAR(50) NOT NULL,
  CONSTRAINT pk_user                       PRIMARY KEY (user_id)
  --CONSTRAINT ck_date_of_birth              CHECK (date_of_birth < SYSDATE),
  --CONSTRAINT ck_date_of_birth_overage      CHECK ( (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM date_of_birth)) >= 18)
);


CREATE TABLE Buyer
(
  buyer_id                               INTEGER        NOT NULL,
  user_id                                INTEGER        NOT NULL,
  property_type                          VARCHAR(50)    NOT NULL,
  country                                VARCHAR(50)    NOT NULL,
  city                                   VARCHAR(50)    NOT NULL,
  min_area                               NUMBER(10, 2)  NOT NULL,
  max_area                               NUMBER(10, 2)  NOT NULL,
  min_budget                             NUMBER(10, 2)  NOT NULL,
  max_budget                             NUMBER(10, 2)  NOT NULL,
  CONSTRAINT pk_buyer                    PRIMARY KEY (buyer_id),
  CONSTRAINT fk_buyer_user               FOREIGN KEY (user_id) REFERENCES Users (user_id),
  CONSTRAINT ck_max_min_budget           CHECK ( min_budget <= max_budget ),
  CONSTRAINT ck_max_min_area             CHECK ( min_area <= max_area )
);

CREATE TABLE Pauly_Admin
(
  admin_id 		  	                     INTEGER     NOT NULL,
  user_id                                INTEGER     NOT NULL,
  username 		                         VARCHAR(20) NOT NULL,
  password 		                         VARCHAR(20) NOT NULL,
  CONSTRAINT pk_admin                    PRIMARY KEY (admin_id),
  CONSTRAINT fk_admin_user               FOREIGN KEY (user_id) REFERENCES Users (user_id)
);

-- TODO: property_address_id column might actually meant to be property_advertizment_id
CREATE TABLE Property
(
  property_id                              INTEGER          NOT NULL,
  property_type                            VARCHAR(50)      NOT NULL,
  property_ad_id                           INTEGER          NOT NULL,
  city                                     VARCHAR(50)      NOT NULL,
  country                                  VARCHAR(50)      NOT NULL,
  property_date                            DATE             NOT NULL,
  number_of_rooms                          INTEGER          NOT NULL,
  area_size                                INTEGER          NOT NULL,
  per_unit_price                           NUMBER(10, 2)    NOT NULL,
  CONSTRAINT pk_property                   PRIMARY KEY (property_id)
);


-- TODO Foreign key might be better suited with property_add_id
CREATE TABLE Seller
(
  seller_id                                INTEGER     NOT NULL,
  user_id                                  INTEGER     NOT NULL,
  property_id                              INTEGER     NOT NULL,
  post_property_for                        VARCHAR(50) NOT NULL,
  CONSTRAINT pk_seller                     PRIMARY KEY (seller_id),
  CONSTRAINT fk_seller_user                FOREIGN KEY (user_id) REFERENCES Users (user_id),
  CONSTRAINT fk_seller_prop                FOREIGN KEY (property_id) REFERENCES Property (property_id)
);


CREATE TABLE Room
(
  room_id                                  INTEGER          NOT NULL,
  property_id                              INTEGER          NOT NULL,
  room_name                                VARCHAR(50)      NOT NULL,
  area                                     NUMBER(20, 2)    NOT NULL,
  CONSTRAINT pk_room                       PRIMARY KEY (room_id),
  CONSTRAINT fk_room_prop                  FOREIGN KEY (property_id) REFERENCES Property (property_id)
);

CREATE TABLE Images
(
  image_id                  INTEGER         NOT NULL,
  room_id                   INTEGER         NOT NULL,
  image_name                VARCHAR2(30),
  mime_type                 VARCHAR2(30),
  image_content             BLOB,
  CONSTRAINT pk_image       PRIMARY KEY (image_id),
  CONSTRAINT fk_image_room  FOREIGN KEY (room_id) REFERENCES Room (room_id)
);


CREATE TABLE Address
(
  address_id                               INTEGER     NOT NULL,
  property_id                              INTEGER     NOT NULL,
  plot_number                              VARCHAR(50) NOT NULL,
  property_name                            VARCHAR(50) NOT NULL,
  floor_number                             VARCHAR(50) NOT NULL,
  area_name                                VARCHAR(50) NOT NULL,
  city                                     VARCHAR(50) NOT NULL,
  county                                   VARCHAR(50) NOT NULL,
  country                                  VARCHAR(50) NOT NULL,
  zip                                      VARCHAR(50) NOT NULL,
  CONSTRAINT pk_address                    PRIMARY KEY (address_id),
  CONSTRAINT fk_address_prop               FOREIGN KEY (property_id) REFERENCES Property (property_id)
);


CREATE TABLE Feature
(
  feature_id                               INTEGER     NOT NULL,
  property_id                              INTEGER     NOT NULL,
  feature_name                             VARCHAR(50) NOT NULL,
  feature_description                      VARCHAR(50) NOT NULL,
  CONSTRAINT pk_feature                    PRIMARY KEY (feature_id),
  CONSTRAINT fk_feature_prop               FOREIGN KEY (property_id) REFERENCES Property (property_id)
);

