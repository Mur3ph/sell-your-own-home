
-- #################################################################################################################################################

-- User Table

INSERT INTO user (person_id, first_name, last_name, username, password)
VALUES( 101, 'Lola', 'Murphy', 'lo', 'pass' );



-- #################################################################################################################################################

-- Product table

INSERT INTO product (product_id, seller_id, type_of_property, is_for_sale, is_for_rent, is_viager, property_price)
VALUES( 2001, 101, 'House', TRUE, FALSE, TRUE, 1200.00 );


-- #################################################################################################################################################

-- Photo Information table

INSERT INTO photo_information (photo_information_id, product_id, is_main_url_photo, url_location)
VALUES( 1001, 101, TRUE, '/images/property-listings/property_2.jpg' );

INSERT INTO photo_information (photo_information_id, product_id, is_main_url_photo, url_location)
VALUES( 1002, 101, TRUE, '/images/property-listings/property_3.jpg' );

INSERT INTO photo_information (photo_information_id, product_id, is_main_url_photo, url_location)
VALUES( 1002, 101, TRUE, '/images/property-listings/property_1.jpg' );


-- #################################################################################################################################################
