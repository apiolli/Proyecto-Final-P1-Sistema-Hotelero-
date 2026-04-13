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
    precio DECIMAL(10,2) NOT NULL,
    fecha DATETIME DEFAULT NOW(),
    FOREIGN KEY (id_reserva) REFERENCES reservas(id)
);

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

