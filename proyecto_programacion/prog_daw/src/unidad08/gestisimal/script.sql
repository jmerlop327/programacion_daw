create database gestisimal;
grant all privileges on gestisimal.* to 'admin'@'localhost';
flush privileges;
use gestisimal;
CREATE TABLE almacen (
    id INTEGER PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);
CREATE TABLE articulo (
    codigo varchar(5) PRIMARY KEY,
    descripcion VARCHAR(256) NOT NULL
);
-- Tabla relacional almacenes_articulos
CREATE TABLE rel_almacen_articulo (
    id_almacen INTEGER,
    codigo_articulo varCHAR(5),
    precio_compra DOUBLE NOT NULL,
    precio_venta DOUBLE NOT NULL,
    stock INTEGER NOT NULL,
    PRIMARY KEY (id_almacen, codigo_articulo),
    FOREIGN KEY (id_almacen) REFERENCES almacen(id) ON DELETE CASCADE,
    FOREIGN KEY (codigo_articulo) REFERENCES articulo(codigo) ON DELETE CASCADE
);