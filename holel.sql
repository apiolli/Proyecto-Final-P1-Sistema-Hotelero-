CREATE DATABASE hotel;
drop database hotel;-- 
USE hotel;

CREATE TABLE Huesped (
    id INT auto_increment PRIMARY KEY ,
	nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(100),
    documentoIdentidad VARCHAR(100) NOT NULL UNIQUE,
    fechaDeNacimiento DATE NOT NULL,
    telefono VARCHAR(20)
);





CREATE TABLE Habitacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    noHabitacion INT UNIQUE,
    tipo VARCHAR(50),
    estado ENUM('Disponible','Ocupada','Mantenimiento', 'Sucia') DEFAULT 'Disponible',
    precioNoche DECIMAL(10,2),
	nivel VARCHAR(50),
    capacidad INT(3),
    telefono varchar(50)    
);

CREATE TABLE reservas (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    id_huesped      INT NOT NULL,
    id_habitacion   INT NOT NULL,
    fecha_entrada   DATE NOT NULL,
    fecha_salida    DATE NOT NULL,
    num_personas    INT  NOT NULL,
    estado ENUM('Pendiente','Activa','Completada') DEFAULT 'Pendiente',
    fecha_reserva   DATETIME DEFAULT NOW(),
    dineroAbonado decimal(10, 2) NULL,
    FOREIGN KEY (id_huesped)    REFERENCES Huesped(id),
    FOREIGN KEY (id_habitacion) REFERENCES habitacion(id)
);

select * from reservas;
select * from huesped;
select * from usuarios;
select * from Habitacion;
UPDATE reservas SET estado = 'Pendiente' WHERE id = 5;
UPDATE huesped SET nombre = 'Patria' WHERE id = 2;

CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50),
    documento_identidad VARCHAR(20) UNIQUE NOT NULL,
    fecha_nacimiento DATE not null, 
    telefono VARCHAR(20),
    cargo VARCHAR(50),
    sueldo DECIMAL(10, 2),
    usuario VARCHAR(50) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL, 
    fecha_ingreso DATE not null
);

drop table usuarios;
select * from usuarios;

CREATE TABLE consumos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_reserva INT NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    precio DECIMAL(10,2) NOT NULL,
    fecha DATETIME DEFAULT NOW(),
    FOREIGN KEY (id_reserva) REFERENCES reservas(id)
);


select * from consumos;



CREATE TABLE ReporteFactura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_reserva INT NOT NULL,
    huesped VARCHAR(100),
    habitacion INT,
    subtotal DECIMAL(10,2),
    itbis DECIMAL(10,2),
    descuento DECIMAL(10,2),
    total DECIMAL(10,2),
    forma_pago VARCHAR(50),
    fecha_facturacion DATETIME DEFAULT NOW()
);

ALTER TABLE ReporteFactura 
DROP FOREIGN KEY reportefactura_ibfk_1;

ALTER TABLE ReporteFactura 
DROP COLUMN fecha_venta;

select * from ReporteFactura;

drop table reporteventa;

INSERT INTO Persona (
    nombre,
    apellido,
    nacionalidad,
    correoElectronico,
    telefono,
    rol
)
VALUES (
     ?,'Cliente'
);

INSERT INTO Cliente (id)
VALUES (LAST_INSERT_ID());



INSERT INTO Persona (
    nombre,
    apellido,
    nacionalidad,
    correoElectronico,
    telefono,
    rol
)
VALUES (
    ?, 'Empleado'
);

INSERT INTO Empleado (
    id,
    cargo,
    sueldo,
    usuario,
    contrasena,
    fechaIngreso
)
VALUES (
    LAST_INSERT_ID(),
    ?
);

INSERT INTO Habitacion (
    nivel,
    noHabitacion,
    tipo,
    estado,
    costoBase,
    capacidad
)
VALUES (
    ?, 'Disponible', ?
);

SELECT * 
FROM Habitacion;

SELECT *
FROM Habitacion
WHERE estado = 'Disponible';

SELECT 
    p.id,
    p.nombre,
    p.apellido,
    p.telefono
FROM Persona p
INNER JOIN Cliente c ON p.id = c.id
WHERE p.nombre LIKE CONCAT('%', ?, '%');

INSERT INTO Reserva (
    fechaReserva,
    fechaInicio,
    fechaFin,
    cliente_id,
    habitacion_id,
    dineroAbonado,
    costoTotal
)
VALUES (
    CURDATE(),
    ?,?
);

UPDATE Habitacion
SET estado = 'Ocupada'
WHERE id = ?;

SELECT
    r.idReserva,
    p.nombre,
    p.apellido,
    h.noHabitacion,
    h.tipo,
    r.fechaInicio,
    r.fechaFin,
    r.dineroAbonado,
    r.costoTotal
FROM Reserva r
INNER JOIN Cliente c ON r.cliente_id = c.id
INNER JOIN Persona p ON c.id = p.id
INNER JOIN Habitacion h ON r.habitacion_id = h.id;

SELECT
    r.idReserva,
    h.noHabitacion,
    r.fechaInicio,
    r.fechaFin,
    r.costoTotal
FROM Reserva r
INNER JOIN Habitacion h ON r.habitacion_id = h.id
WHERE r.cliente_id = ?;

DELETE FROM Reserva
WHERE idReserva = ?;

UPDATE Habitacion
SET estado = 'Disponible'
WHERE id = ?;

SELECT
    p.nombre,
    p.apellido,
    SUM(r.dineroAbonado) AS total_pagado
FROM Reserva r
INNER JOIN Cliente c ON r.cliente_id = c.id
INNER JOIN Persona p ON c.id = p.id
GROUP BY p.id;

SELECT *
FROM Habitacion
WHERE estado = 'Ocupada';

SELECT *
FROM Reserva
WHERE CURDATE() BETWEEN fechaInicio AND fechaFin;

select *
from Habitacion;

select * 
from ReporteFactura;


CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);


INSERT INTO productos (nombre, precio) VALUES 
('Agua Planeta Azul 600ml', 35.00),
('Refresco (Coca-Cola/Country Club)', 50.00),
('Cerveza Presidente (Pequeña)', 175.00),
('Sándwich de Jamón y Queso', 150.00),
('Pica Pollo (Servicio 2 piezas)', 250.00),
('Snack (Platanitos/Papitas)', 40.00),
('Jugo Natural de Chinola', 125.00),
('Servicio de Lavado (Camisa)', 100.00),
('Café Santo Domingo (Taza)', 45.00);

ALTER TABLE productos 
ADD COLUMN categoria VARCHAR(50) DEFAULT 'Otros';


-- Ejecuta esto para las bebidas
UPDATE productos 
SET categoria = 'Bebidas' 
WHERE nombre LIKE '%Agua%' OR nombre LIKE '%Refresco%' OR nombre LIKE '%Cerveza%' OR nombre LIKE '%Jugo%';

-- Ejecuta esto para las comidas
UPDATE productos 
SET categoria = 'Comidas' 
WHERE nombre LIKE '%Sándwich%' OR nombre LIKE '%Pica Pollo%';

-- Ejecuta esto para los snacks
UPDATE productos 
SET categoria = 'Snacks' 
WHERE nombre LIKE '%Snack%' OR nombre LIKE '%Platanitos%';

-- 1. Apagamos el modo seguro temporalmente
SET SQL_SAFE_UPDATES = 0;

-- 2. Hacemos todas las actualizaciones
UPDATE productos SET categoria = 'Bebidas' WHERE nombre LIKE '%Agua%' OR nombre LIKE '%Refresco%' OR nombre LIKE '%Cerveza%' OR nombre LIKE '%Jugo%';
UPDATE productos SET categoria = 'Comidas' WHERE nombre LIKE '%Sándwich%' OR nombre LIKE '%Pica Pollo%';
UPDATE productos SET categoria = 'Snacks' WHERE nombre LIKE '%Snack%' OR nombre LIKE '%Platanitos%';
UPDATE productos SET categoria = 'Bebidas' WHERE nombre LIKE '%Café%' OR nombre LIKE '%Cafe%';

-- 3. Volvemos a encender el modo seguro 
SET SQL_SAFE_UPDATES = 1;

select * from productos;
