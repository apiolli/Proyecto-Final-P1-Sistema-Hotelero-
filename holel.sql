CREATE DATABASE hotel;
USE hotel;

CREATE TABLE Persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(100),
    correoElectronico VARCHAR(150),
    telefono VARCHAR(20),
    rol VARCHAR(50)
);

CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Persona(id) ON DELETE CASCADE
);

CREATE TABLE Empleado (
    id INT PRIMARY KEY,
    cargo VARCHAR(100),
    sueldo DECIMAL(10,2),
    usuario VARCHAR(50),
    contrasena VARCHAR(100),
    fechaIngreso DATE,
    FOREIGN KEY (id) REFERENCES Persona(id) ON DELETE CASCADE
);

CREATE TABLE Administrador (
    id INT PRIMARY KEY,
    usuario VARCHAR(50),
    contrasena VARCHAR(100),
    FOREIGN KEY (id) REFERENCES Persona(id) ON DELETE CASCADE
);

CREATE TABLE Habitacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nivel VARCHAR(50),
    noHabitacion INT UNIQUE,
    tipo VARCHAR(50),
    estado ENUM('Disponible','Ocupada','Mantenimiento') DEFAULT 'Disponible',
    costoBase DECIMAL(10,2),
    capacidad INT
);

CREATE TABLE HabitacionSimple (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Habitacion(id) ON DELETE CASCADE
);

CREATE TABLE HabitacionDoble (
    id INT PRIMARY KEY,
    tipoCama VARCHAR(50),
    FOREIGN KEY (id) REFERENCES Habitacion(id) ON DELETE CASCADE
);

CREATE TABLE Suite (
    id INT PRIMARY KEY,
    equipoExtra VARCHAR(255),
    FOREIGN KEY (id) REFERENCES Habitacion(id) ON DELETE CASCADE
);

CREATE TABLE Reserva (
    idReserva INT AUTO_INCREMENT PRIMARY KEY,
    fechaReserva DATE,
    fechaInicio DATE,
    fechaFin DATE,
    cliente_id INT,
    habitacion_id INT,
    dineroAbonado DECIMAL(10,2) DEFAULT 0,
    costoTotal DECIMAL(10,2),

    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (habitacion_id) REFERENCES Habitacion(id)
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

