-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-05-17 08:34:50.273

-- tables
-- Table: booking
CREATE TABLE booking (
    id serial  NOT NULL,
    customer_user_id int  NOT NULL,
    listing_id int  NOT NULL,
    people_count int  NOT NULL,
    check_in date  NOT NULL,
    check_out date  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT booking_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    email varchar(255)  NOT NULL,
    phone_no varchar(15)  NULL,
    image bytea  NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: county
CREATE TABLE county (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: feature
CREATE TABLE feature (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT feature_ak_1 UNIQUE (name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT feature_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    listing_id int  NOT NULL,
    data bytea  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: listing
CREATE TABLE listing (
    id serial  NOT NULL,
    owner_user_id int  NOT NULL,
    location_id int  NULL,
    name varchar(255)  NOT NULL,
    description varchar(500)  NULL,
    additional_info varchar(500)  NULL,
    price int  NULL,
    status char(1)  NOT NULL,
    CONSTRAINT listing_ak_1 UNIQUE (name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT listing_pk PRIMARY KEY (id)
);

-- Table: listing_feature
CREATE TABLE listing_feature (
    id serial  NOT NULL,
    listing_id int  NOT NULL,
    feature_id int  NOT NULL,
    is_selected boolean  NOT NULL,
    CONSTRAINT listing_feature_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    county_id int  NOT NULL,
    address varchar(255)  NOT NULL,
    longitude decimal(8,6)  NOT NULL,
    latitude decimal(8,6)  NOT NULL,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: review
CREATE TABLE review (
    id serial  NOT NULL,
    listing_id int  NOT NULL,
    user_id int  NOT NULL,
    score int  NOT NULL,
    comment varchar(500)  NULL,
    CONSTRAINT review_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT user_ak_1 UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: booking_listing (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_listing
    FOREIGN KEY (listing_id)
    REFERENCES listing (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: booking_user (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_user
    FOREIGN KEY (customer_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: image_listing (table: image)
ALTER TABLE image ADD CONSTRAINT image_listing
    FOREIGN KEY (listing_id)
    REFERENCES listing (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: listing_feature_feature (table: listing_feature)
ALTER TABLE listing_feature ADD CONSTRAINT listing_feature_feature
    FOREIGN KEY (feature_id)
    REFERENCES feature (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: listing_feature_listing (table: listing_feature)
ALTER TABLE listing_feature ADD CONSTRAINT listing_feature_listing
    FOREIGN KEY (listing_id)
    REFERENCES listing (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: listing_location (table: listing)
ALTER TABLE listing ADD CONSTRAINT listing_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: listing_user (table: listing)
ALTER TABLE listing ADD CONSTRAINT listing_user
    FOREIGN KEY (owner_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: location_country (table: location)
ALTER TABLE location ADD CONSTRAINT location_country
    FOREIGN KEY (county_id)
    REFERENCES county (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: review_listing (table: review)
ALTER TABLE review ADD CONSTRAINT review_listing
    FOREIGN KEY (listing_id)
    REFERENCES listing (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: review_user (table: review)
ALTER TABLE review ADD CONSTRAINT review_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

