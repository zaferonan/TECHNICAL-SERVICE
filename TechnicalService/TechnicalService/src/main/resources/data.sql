insert into technicalservice.service(desktop, service_name, service_duration, laptop, mac) values (50, 'Formatlama', 2, 50, 200) ON CONFLICT DO NOTHING;
insert into technicalservice.service(desktop, service_name, service_duration, laptop, mac) values (100, 'Virüs temizliği', 4, 100, 100) ON CONFLICT DO NOTHING;
insert into technicalservice.service(desktop, service_name, service_duration, laptop, mac) values (200, 'Diskten veri kurtarma', 10, 200, 400) ON CONFLICT DO NOTHING;
insert into technicalservice.service(desktop, service_name, service_duration, laptop, mac) values (30, 'Fan ve termal macun temizliği', 1, 100, 200) ON CONFLICT DO NOTHING;

insert into technicalservice.role (role_name) VALUES ('ROLE_ADMIN');
insert into technicalservice.role (role_name) VALUES ('ROLE_USER');
--1234
insert into technicalservice.system_user (mail, name, password) VALUES ( '1@1.com', 'admin', '$2a$10$WDtUVEjZuuQ7YNOfweEOu.5BxWq/yRH/LIyU9jv0g.TYjP8DfiMfC');
insert into technicalservice.system_user (mail, name, password) VALUES ( '2@2.com', 'kullanici', '$2a$10$WDtUVEjZuuQ7YNOfweEOu.5BxWq/yRH/LIyU9jv0g.TYjP8DfiMfC');

insert into technicalservice.system_user_roles (system_user_system_user_id, roles_role_id)VALUES (1, 1);
insert into technicalservice.system_user_roles (system_user_system_user_id, roles_role_id)VALUES (2, 2);

insert into technicalservice.product(product_name) values ("CPU");
insert into technicalservice.product(product_name) values ("GPU");
insert into technicalservice.product(product_name) values ("RAM");
insert into technicalservice.product(product_name) values ("MOTHERBOARD");