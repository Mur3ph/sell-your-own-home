
-- #################################################################################################################################################

-- User Table

INSERT INTO the_user (person_id, first_name, last_name, username, password)
VALUES( 101, 'Lola', 'Murphy', 'lo', 'password' );

INSERT INTO the_user (person_id, first_name, last_name, username, password)
VALUES( 102, 'Minnie', 'Murphy', 'min', 'password' );

INSERT INTO the_user (person_id, first_name, last_name, username, password)
VALUES( 103, 'Angie', 'Murphy', 'angie', 'password' );



-- #################################################################################################################################################

-- Supplier Table


INSERT INTO supplier (supplier_id, supplier_name, supplier_address, supplier_phone)
VALUES( 201, 'John Lennon', 'Roscommon', '041 1234567' );

INSERT INTO supplier (supplier_id, supplier_name, supplier_address, supplier_phone)
VALUES( 202, 'John Bonham', 'Tipperary', '041 1234567' );

INSERT INTO supplier (supplier_id, supplier_name, supplier_address, supplier_phone)
VALUES( 203, 'Eddie Vedder', 'Wexford', '041 1234567' );



-- #################################################################################################################################################

-- Product table

INSERT INTO product (product_id, supplier_id, type_of_property, is_for_sale, is_for_rent, is_viager, property_asking_price)
VALUES( 301, 201, 'House', TRUE, FALSE, TRUE, 1200.00 );

INSERT INTO product (product_id, supplier_id, type_of_property, is_for_sale, is_for_rent, is_viager, property_asking_price)
VALUES( 302, 202, 'House', TRUE, FALSE, TRUE, 1200.00 );

INSERT INTO product (product_id, supplier_id, type_of_property, is_for_sale, is_for_rent, is_viager, property_asking_price)
VALUES( 303, 203, 'House', TRUE, FALSE, TRUE, 1200.00 );



-- #################################################################################################################################################

-- Photo Information table

INSERT INTO property_photo_details (property_photo_details_id, product_id, is_main_url_photo, url_location, about, location, current_bidder, current_bid)
VALUES( 401, 301, TRUE, '/images/property-listings/property_2.jpg', '2 kitchens, 3 bed, 2 bath...', 'Tub of Curry, Co. Tipperary', 'Lola', 120000.00 );

INSERT INTO property_photo_details (property_photo_details_id, product_id, is_main_url_photo, url_location, about, location, current_bidder, current_bid)
VALUES( 402, 302, TRUE, '/images/property-listings/property_3.jpg', '1 kitchens, 2 bed, 1 bath...', 'FAr side of Balscaddin..Co. Galway', 'Minnie', 100000.00  );

INSERT INTO property_photo_details (property_photo_details_id, product_id, is_main_url_photo, url_location, about, location, current_bidder, current_bid)
VALUES( 403, 303, TRUE, '/images/property-listings/property_1.jpg', '1 kitchens, 4 bed, 2 bath...', 'Its a long way to Tipperary, Co. Wexford', 'Angie', 145000.00  );



-- #################################################################################################################################################
