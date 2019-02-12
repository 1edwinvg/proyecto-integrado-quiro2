/* Populate tables */
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('Andres', 'Guzman',15, 'profesor@bolsadeideas.com', '1111111','todas','2017-08-01', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('John', 'Doe', 15,'john.doe@gmail.com','1111112','todas','2017-08-02', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('Linus', 'Torvalds', 15,'linus.torvalds@gmail.com','1111113','todas','2017-08-03', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('Jane', 'Doe', 15,'jane.doe@gmail.com', '1111114','todas','2017-08-04', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('Rasmus', 'Lerdorf', 15,'rasmus.lerdorf@gmail.com','1111115','todas', '2017-08-05', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('Erich', 'Gamma',15, 'erich.gamma@gmail.com', '1111116','todas','2017-08-06', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('Richard', 'Helm',15, 'richard.helm@gmail.com', '1111117','todas','2017-08-07', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('Ralph', 'Johnson',15, 'ralph.johnson@gmail.com', '1111118','todas','2017-08-08', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('John', 'Vlissides', 15,'john.vlissides@gmail.com','1111119','todas', '2017-08-09', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('James', 'Gosling',15, 'james.gosling@gmail.com', '1111110','todas','2017-08-010', '');
INSERT INTO clientes (nombre, apellido,edad,email, movil, dolencia, create_at, foto) VALUES('Bruce', 'Lee',15, 'bruce.lee@gmail.com', '0111111','todas','2017-08-11', '');
INSERT INTO clientes (nombre, apellido,edad,email, movil, dolencia, create_at, foto) VALUES('Johnny', 'Doe',15, 'johnny.doe@gmail.com', '0011114','todas','2017-08-12', '');
INSERT INTO clientes (nombre, apellido,edad,email, movil, dolencia, create_at, foto) VALUES('John', 'Roe',15, 'john.roe@gmail.com', '1111114','todas','2017-08-13', '');
INSERT INTO clientes (nombre, apellido,edad,email, movil, dolencia, create_at, foto) VALUES('Jane', 'Roe', 15,'jane.roe@gmail.com', '1111114','todas','2017-08-14', '');
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('Richard', 'Doe',15, 'richard.doe@gmail.com','1111114','todas', '2017-08-15', '');
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('Janie', 'Doe',15, 'janie.doe@gmail.com', '1111114','todas','2017-08-16', '');
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('Phillip', 'Webb', 15,'phillip.webb@gmail.com', '1111114','todas','2017-08-17', '');
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('Stephane', 'Nicoll',15, 'stephane.nicoll@gmail.com','1111114','todas', '2017-08-18', '');
INSERT INTO clientes (nombre, apellido,edad, email, movil, dolencia, create_at, foto) VALUES('Sam', 'Brannen', 15,'sam.brannen@gmail.com', '1111114','todas','2017-08-19', '');  
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('Juergen', 'Hoeller', 15,'juergen.Hoeller@gmail.com', '1111114','todas','2017-08-20', ''); 
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('Janie', 'Roe', 15,'janie.roe@gmail.com', '1111114','todas', '2017-08-21', '');
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('John', 'Smith', 15,'john.smith@gmail.com', '1111114','todas', '2017-08-22', '');
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('Joe', 'Bloggs', 15,'joe.bloggs@gmail.com', '1111114','todas', '2017-08-23', '');
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('John', 'Stiles', 15,'john.stiles@gmail.com', '1111114','todas', '2017-08-24', '');
INSERT INTO clientes (nombre, apellido, edad, email, movil, dolencia, create_at, foto) VALUES('Richard', 'Roe', 15,'stiles.roe@gmail.com', '1111114','todas','2017-08-25', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);

/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');