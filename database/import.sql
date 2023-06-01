/* ------------- USER PACKAGE ------------- */
/*role*/
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');

/*user*/
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'rain', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'matkaja', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'ants', '123', 'D');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'Rännumees', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'Metsavana', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'Maret', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'MeesMetsast', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'TädiMaali', '123', 'A');


/*contact*/
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 1, 'Admin', 'Admin', 'admin@mail.ee', '111222333', null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 2, 'Rain', 'Viljandist', 'rain@mail.ee', '222333444', null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 3, 'Peeter', 'Mets', 'matka@mail.ee', '333222111', null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 4, 'Ants', 'Passiivne', 'ants@mail.ee', 8375957, null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 5, 'Tõnis', 'Tamm', 'tonis43@mail.ee', 9603759, null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 6, 'Maret', 'Nurm', 'nurmmari@mail.ee', 0874957, null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 7, 'Jüri', 'Väli', 'metsavana@mail.ee', 2641995, null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 8, 'Maali', 'Rannaväli', 'tadimaali@mail.ee', 0185965, null);


/* ------------- LISTING PACKAGE ------------- */
/*county*/
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Harjumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Hiiumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Ida-Virumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Jõgevamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Järvamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Lääne-Virumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Põlvamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Pärnumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Raplamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Saaremaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Tartumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Valgamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Viljandimaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Võrumaa');


/*location*/
INSERT INTO public.location(id, county_id, address, longitude, latitude) VALUES (DEFAULT, 1, 'Matkaplatsi 4, Aegviidu', 59.286220, 25.612050);
INSERT INTO public.location(id, county_id, address, longitude, latitude) VALUES (DEFAULT, 2, 'Metsaküla, Hiiumaa', 58.928530, 22.659848);
INSERT INTO public.location(id, county_id, address, longitude, latitude) VALUES (DEFAULT, 2, 'Mägipe, Hiiumaa', 58.929341, 22.225784);
INSERT INTO public.location(id, county_id, address, longitude, latitude) VALUES (DEFAULT, 14, 'Karisöödi küla, Sepa talu', 57.539412, 26.570079);
INSERT INTO public.location(id, county_id, address, longitude, latitude) VALUES (DEFAULT, 1, 'Mäe tee 10, lohusalu', 59.393887, 224.196887);
INSERT INTO public.location(id, county_id, address, longitude, latitude) VALUES (DEFAULT, 13, 'Soomaa, Kuresoo', 58.503700, 25.077465);


/*listing*/
INSERT INTO public.listing (id, owner_user_id, location_id, name, description, additional_info, price, status) VALUES (DEFAULT, 2, 1, 'Aegviidu külastuskeskus', 'See on üks väga äge telkimisplats. Siin on kõik vajalik olemas - on päikest on vihma. ' ||
                                                                                                                                                                 'Kõik on lageda taeva all! Oled heldesti oodatud.', 'Telkida saab', 23, 'A');
INSERT INTO public.listing (id, owner_user_id, location_id, name, description, additional_info, price, status) VALUES (DEFAULT, 6, 5, 'Mareti tagahoov', 'Eestiaegse maja vana taluhoov ilusas Laulasmaa külas.', 'Pakume süüa ka"', 25, 'A');
INSERT INTO public.listing (id, owner_user_id, location_id, name, description, additional_info, price, status) VALUES (DEFAULT, 5, 6, 'Sooonn', 'Matkaonn Navesti jõe lähedal Kuresoo rabas. Ligipääs jala ja kanuuga. Kuula sookurgede hüüdeid!', ':)', 28, 'A');
INSERT INTO public.listing (id, owner_user_id, location_id, name, description, additional_info, price, status) VALUES (DEFAULT, 8, 3, 'Tädi Maali mets', 'Kaunis koht Kõpu looduskaitsealal. Lähedal meri ja Rebastemäe matkarada.','lähim hoone 700m kaugusel', 10, 'A');
INSERT INTO public.listing (id, owner_user_id, location_id, name, description, additional_info, price, status) VALUES (DEFAULT, 3, 4, 'Peetri heinamaa', 'Tule telgi mu heinamaal kui tahad.', 'Telkida saab','',10, 'A');
INSERT INTO public.listing (id, owner_user_id, location_id, name, description, additional_info, price, status) VALUES (DEFAULT, 7, 2, 'Metsavana lõkkeplats', 'Tule telgi sügaval Hiiumaa põlismetsas!','Loomad lähedal.',16, 'A');

/*features*/
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Lõkkeplats/grillplats');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Kämpinguauto koht');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Telgi laenutus');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Joogivesi');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Elekter');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Pesemisvõimalus');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'WC/DC');


/*listing_features*/
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 1, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 2, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 3, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 4, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 5, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 6, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 7, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 2, 1, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 2, 2, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 2, 3, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 2, 4, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 2, 5, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 2, 6, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 2, 7, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 3, 1, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 3, 2, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 3, 3, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 3, 4, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 3, 5, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 3, 6, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 3, 7, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 4, 1, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 4, 2, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 4, 3, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 4, 4, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 4, 5, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 4, 6, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 4, 7, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 5, 1, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 5, 2, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 5, 3, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 5, 4, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 5, 5, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 5, 6, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 5, 7, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 6, 1, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 6, 2, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 6, 3, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 6, 4, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 6, 5, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 6, 6, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 6, 7, true);


/*image*/
INSERT INTO public.image(id, listing_id, data) VALUES (DEFAULT, 1, E'\\x000800');
INSERT INTO public.image(id, listing_id, data) VALUES (DEFAULT, 1, E'\\x000800');


/* ------------- REVIEW PACKAGE ------------- */
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 1, 1, 5, 'Väga hea host ja kohvi pakuti ka.');
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 1, 3, 3, 'OK koht');
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 1, 4, 4, null);
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 4, 6, 5, 'Väga ilus koht!');
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 4, 6, 3, 'Oli liiga palju inimesi ja meri oli külm.');
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 5, 2, 4, 'Vähenõudlikele kõlbab');
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 6, 5, 5, null);
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 6, 5, 5, null);


/* ------------- BOOKING PACKAGE ------------- */


