create database gestisimal;
grant all privileges on gestisimal.* to 'admin'@'localhost';
flush privileges;
use gestisimal;

CREATE TABLE articulo (
    codigo varchar(5) PRIMARY KEY,
    descripcion VARCHAR(256) NOT NULL,
    precio_compra DOUBLE NOT NULL,
    precio_venta DOUBLE NOT NULL,
    stock INT NOT NULL
);