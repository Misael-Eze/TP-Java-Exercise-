CREATE DATABASE GRUPO1TPLAB3v3;
GO

USE GRUPO1TPLAB3v3;
GO

CREATE TABLE Juego (
    id_Juego int IDENTITY(1,1)
    CONSTRAINT pk_id_Juego PRIMARY KEY (id_Juego)
);


CREATE TABLE Modos_Juego (
    id_modo_juego int IDENTITY(1,1),
    modo_juego varchar(30),
    Id_juego int,
    CONSTRAINT pk_modos_juego PRIMARY KEY (id_modo_juego),
    CONSTRAINT fk_modo_juego FOREIGN KEY (Id_juego)
    REFFERENCES Juego(id_juego)
);
GO

CREATE TABLE Conservador (
    id INT IDENTITY(1,1) PRIMARY KEY,
    descripcion TEXT,
    id_perfiles INT,
    Id_modo_juego INT,
    FOREIGN KEY (id_perfiles) REFERENCES Perfiles(id_perfiles),
    FOREIGN KEY (id_modo_juego) REFERENCES Modos_Juego(id_modo_juego)
);
GO

CREATE TABLE Equilibrado (
    id INT IDENTITY(1,1) PRIMARY KEY,
    descripcion TEXT,
    id_perfiles INT,
    Id_modo_juego INT,
    FOREIGN KEY (id_perfiles) REFERENCES Perfiles(id_perfiles),
    FOREIGN KEY (id_modo_juego) REFERENCES Modos_Juego(id_modo_juego)

);
GO

CREATE TABLE Agresivo (
    id INT IDENTITY(1,1) PRIMARY KEY,
    descripcion TEXT,
    id_perfiles INT,
    Id_modo_juego INT,
    FOREIGN KEY (id_perfiles) REFERENCES Perfiles(id_perfiles),
    FOREIGN KEY (id_modo_juego) REFERENCES Modos_Juego(id_modo_juego)
);

GO
CREATE TABLE Perfiles (
    id_perfiles int IDENTITY(1,1),
    descripcion_perfil varchar(40),
    CONSTRAINT pk_perfiles PRIMARY KEY (id_perfiles)
);
GO

CREATE TABLE Tipos_tarjeta (
    id_tipo_tarjeta int IDENTITY(1,1),
    tipo_tarjeta varchar(40),
    CONSTRAINT pk_tipos_tarjeta PRIMARY KEY (id_tipo_tarjeta)
);
GO

CREATE TABLE Tarjetas (
    id_tarjeta int IDENTITY(1,1),
    descripcion_tarjeta varchar(50),
    tipo_tarjeta int,
    CONSTRAINT pk_tarjetas PRIMARY KEY (id_tarjeta),
    CONSTRAINT fk_tipos_tarjeta FOREIGN KEY (tipo_tarjeta) REFERENCES Tipos_tarjeta(id_tipo_tarjeta)
);
GO


CREATE TABLE Tipos_casilla (
    id_tipo_casilla int IDENTITY(1,1),
    tipo_casilla varchar(50),
    CONSTRAINT pk_tipos_casilla PRIMARY KEY (id_tipo_casilla)
);
GO

CREATE TABLE Provincias (
    id_provincia int IDENTITY(1,1),
    provincia varchar(60),
  Id_casilla INT,
    CONSTRAINT pk_provincias PRIMARY KEY (id_provincia),
    FOREIGN KEY (id_casilla) REFERENCES Casillas(id_casilla)
);
GO

CREATE TABLE Casillas (
    id_casilla int IDENTITY(1,1),
    descripcion_casilla varchar(40),
    tipo_casilla int,
    provincia_casilla int null,
    CONSTRAINT pk_casillas PRIMARY KEY (id_casilla),
    CONSTRAINT fk_tipo_casilla FOREIGN KEY (tipo_casilla) REFERENCES Tipos_casilla(id_tipo_casilla)
);
GO

CREATE TABLE banco (
    id_banco int IDENTITY(1,1),
    cantidad_unicial int,
    cantidad_billete int,
    Id_transaccion int,
    CONSTRAINT pk_id_banco PRIMARY KEY (id_banco)
    CONSTRAINT  FOREIGN KEY (id_transaccion) REFERENCES    Transaccion(id_transaccion)

);
GO

CREATE TABLE billete (
    id_billete int IDENTITY(1,1),
    enCirculacion int,
    Id_banco INT,
    CONSTRAINT pk_id_billete PRIMARY KEY (id_billete)
    CONSTRAINT FOREIGN KEY (id_banco) REFERENCES Banco(id_banco)

);
GO

CREATE TABLE Tipos_mazo (
    id_tipo_mazo int IDENTITY(1,1),
    nombre varchar(50),
    CONSTRAINT pk_mazo_tipo PRIMARY KEY (id_tipo_mazo)
);
GO

CREATE TABLE mazo (
    id_mazo int IDENTITY(1,1),
    id_tipo_mazo int,
    Id_peon int,
    CONSTRAINT pk_mazo PRIMARY KEY (id_mazo),
    CONSTRAINT fk_Tipos_mazo_mazo FOREIGN KEY (id_tipo_mazo) REFERENCES Tipos_mazo(id_tipo_mazo)
   CONSTRAINT FOREIGN KEY (id_peon) REFERENCES Peon(id_peon)
);
GO

CREATE TABLE tipo_peon (
    id_tipo_peon int IDENTITY(1,1),
    nombre varchar(50),
    CONSTRAINT pk_tipo_peon PRIMARY KEY (id_tipo_peon)
);
GO

CREATE TABLE peon (
    id_peon int IDENTITY(1,1),
    nombre varchar(50),
    id_tipo_peon int,
    Id_billete int,
    Id_dado int,
    CONSTRAINT pk_peon PRIMARY KEY (id_peon),
    CONSTRAINT fk_tipo_peon_mazo FOREIGN KEY (id_tipo_peon) REFERENCES tipo_peon(id_tipo_peon),
   CONSTRAINT FOREIGN KEY (id_billete) REFERENCES Billete(id_billete),
   CONSTRAINT FOREIGN KEY (id_tdado) REFERENCES Dado(id_dado)
);
GO

CREATE TABLE tipo_estado (
    id_tipo_estado int IDENTITY(1,1),
    nombre varchar(50),
    CONSTRAINT pk_tipo_estado PRIMARY KEY (id_tipo_estado)
);
GO

CREATE TABLE estado (
    id_estado int IDENTITY(1,1),
    id_tipo_estado int,
    Id_movimiento int,
    CONSTRAINT pk_estado PRIMARY KEY (id_estado),
    CONSTRAINT fk_tipo_estado_mazo FOREIGN KEY (id_tipo_estado) REFERENCES tipo_estado(id_tipo_estado)
    CONSTRAINT  FOREIGN KEY (id_movimiento) REFERENCES Movimiento(id_movimiento)
);
GO

CREATE TABLE tablero (
    id_tablero int IDENTITY(1,1),
    activo bit,
    Id_movimiento int,
    CONSTRAINT pk_tablero PRIMARY KEY (id_tablero)
    CONSTRAINT  FOREIGN KEY (id_movimiento) REFERENCES Movimiento(id_movimiento)
);
GO

CREATE TABLE tipo_movimiento (
    id_tipo_movimiento int IDENTITY(1,1),
    nombre varchar(50),
    CONSTRAINT pk_tipo_movimiento PRIMARY KEY (id_tipo_movimiento)
);
GO

CREATE TABLE movimiento (
    id_movimiento int IDENTITY(1,1),
    Id_gameplay int,
    CONSTRAINT pk_movimiento PRIMARY KEY (id_movimiento)
    CONSTRAINT  FOREIGN KEY (id_gameplay) REFERENCES Movimiento(id_gameplay)
);
GO

CREATE TABLE tipo_transaccion (
    id_tipo_transaccion int IDENTITY(1,1),
    nombre varchar(50),
    CONSTRAINT pk_tipo_transaccion PRIMARY KEY (id_tipo_transaccion)
);
GO

CREATE TABLE transaccion (
    id_transaccion int IDENTITY(1,1),
    id_tipo_transaccion int,
    Id_gameplay int,

    CONSTRAINT pk_transaccion PRIMARY KEY (id_transaccion),
    CONSTRAINT fk_tipo_transaccion_mazo FOREIGN KEY (id_tipo_transaccion) REFERENCES tipo_transaccion(id_tipo_transaccion),
     CONSTRAINT  FOREIGN KEY (id_gameplay) REFERENCES Movimiento(id_gameplay)
);
GO

-- Inserts para la tabla Modos_Juego
INSERT INTO Modos_Juego (modo_juego) VALUES ('Facil');
INSERT INTO Modos_Juego (modo_juego) VALUES ('Medio');
INSERT INTO Modos_Juego (modo_juego) VALUES ('Dificil');
GO

-- Inserts para la tabla Perfiles
INSERT INTO Perfiles (descripcion_perfil) VALUES ('Conservador');
INSERT INTO Perfiles (descripcion_perfil) VALUES ('Equilibrado');
INSERT INTO Perfiles (descripcion_perfil) VALUES ('Agresivo');
GO

-- Inserts para la tabla Conservador
INSERT INTO Conservador (descripcion, id_perfiles, Id_modo_juego) VALUES ('Este jugador tiende a ser cauteloso y prioriza la acumulación de propiedades de bajo costo. Comprará fuera de las provincias de preferencia 1 de cada 5 propiedades que compre. Construirá mejoras solo cuando el costo de la construcción no sobrepase el 30% de su dinero en cuenta.', 1, 1);
GO

-- Inserts para la tabla Equilibrado
INSERT INTO Equilibrado (descripcion, id_perfiles, Id_modo_juego) VALUES ('Este jugador busca un equilibrio entre la acumulación de propiedades y la construcción de mejoras. Buscará comprar la serie de Ferrocarriles. Comprará fuera de las provincias de preferencia 1 de cada 3 propiedades que compre. Construirá mejoras cuando el costo de la construcción no supere el 50% de su dinero en cuenta o cuando se hayan vendido más del 75% de las propiedades.', 2, 1);
GO

-- Inserts para la tabla Tipos_tarjeta
INSERT INTO Tipos_tarjeta (tipo_tarjeta) VALUES ('Escritura');
INSERT INTO Tipos_tarjeta (tipo_tarjeta) VALUES ('Ferrocarril');
INSERT INTO Tipos_tarjeta (tipo_tarjeta) VALUES ('Destino');
INSERT INTO Tipos_tarjeta (tipo_tarjeta) VALUES ('Suerte');
INSERT INTO Tipos_tarjeta (tipo_tarjeta) VALUES ('Empresa');
GO

-- Inserts para la tabla Agresivo
INSERT INTO Agresivo (descripcion, id_perfiles, Id_modo_juego) VALUES ('Este jugador busca maximizar el retorno de inversión rápidamente, incluso a costa de correr mayores riesgos. Buscará comprar la serie de Ferrocarriles y Compañías. No comprará fuera de las provincias de preferencia a no ser que ya se hayan vendido a otros jugadores al menos una propiedad de todas sus zonas de preferencia o él mismo haya completado sus zonas; en dicho caso, comprará tantas propiedades como pueda. Priorizará la expansión rápida y construirá mejoras cada vez que pueda.', 3, 1);
GO

-- Inserts para la tabla Tipos_casilla
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Comisaria');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Marche Preso');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Suerte');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Destino');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Impuesto');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Descanso');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Salida');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Propiedad');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Empresa');
INSERT INTO Tipos_casilla (tipo_casilla) VALUES ('Premio');
GO

-- Inserts para la tabla Provincias
INSERT INTO Provincias (provincia) VALUES ('Formosa');
INSERT INTO Provincias (provincia) VALUES ('Rio Negro');
INSERT INTO Provincias (provincia) VALUES ('Salta');
INSERT INTO Provincias (provincia) VALUES ('Mendoza');
INSERT INTO Provincias (provincia) VALUES ('Santa Fe');
INSERT INTO Provincias (provincia) VALUES ('Tucuman');
INSERT INTO Provincias (provincia) VALUES ('Cordoba');
INSERT INTO Provincias (provincia) VALUES ('Buenos Aires');
GO

INSERT INTO banco (cantidad_unicial, cantidad_billete) VALUES (35000, 900000);
GO

INSERT INTO billete (enCirculacion) VALUES (900000);
GO

-- Inserts para la tabla Tipos_mazo
INSERT INTO Tipos_mazo (nombre) VALUES ('chacra');
INSERT INTO Tipos_mazo (nombre) VALUES ('estancia');
INSERT INTO Tipos_mazo (nombre) VALUES ('ferrocarril');
INSERT INTO Tipos_mazo (nombre) VALUES ('companias');
INSERT INTO Tipos_mazo (nombre) VALUES ('bodegas');
GO

INSERT INTO mazo (id_tipo_mazo)
SELECT id_tipo_mazo FROM Tipos_mazo WHERE nombre = 'chacra';
GO

INSERT INTO mazo (id_tipo_mazo)
SELECT id_tipo_mazo FROM Tipos_mazo WHERE nombre = 'estancia';
GO

INSERT INTO mazo (id_tipo_mazo)
SELECT id_tipo_mazo FROM Tipos_mazo WHERE nombre = 'ferrocarril';
GO

INSERT INTO mazo (id_tipo_mazo)
SELECT id_tipo_mazo FROM Tipos_mazo WHERE nombre = 'companias';
GO

INSERT INTO mazo (id_tipo_mazo)
SELECT id_tipo_mazo FROM Tipos_mazo WHERE nombre = 'bodegas';
GO

-- Inserts para la tabla tipo_peon
INSERT INTO tipo_peon (nombre) VALUES ('Bot');
INSERT INTO tipo_peon (nombre) VALUES ('Jugador');
GO

-- Inserts para la tabla peon
INSERT INTO peon (nombre, id_tipo_peon) VALUES ('Bot1', 1);     
INSERT INTO peon (nombre, id_tipo_peon) VALUES ('Bot2', 1);   
INSERT INTO peon (nombre, id_tipo_peon) VALUES ('Bot3', 1);    
INSERT INTO peon (nombre, id_tipo_peon) VALUES ('Jugador1', 2);
GO

-- Inserts para la tabla tipo_estado
INSERT INTO tipo_estado (nombre) VALUES ('Descansando');
INSERT INTO tipo_estado (nombre) VALUES ('Preso');
INSERT INTO tipo_estado (nombre) VALUES ('Jugando');
GO

-- Inserts para la tabla estado
INSERT INTO estado (id_tipo_estado) VALUES (1); -- Descansando
INSERT INTO estado (id_tipo_estado) VALUES (2); -- Preso
INSERT INTO estado (id_tipo_estado) VALUES (3); -- Jugando
GO

INSERT INTO  tablero (activo) VALUES (1);
GO

-- Inserts para la tabla tipo_transaccion
INSERT INTO tipo_transaccion (nombre) VALUES ('Compra');
INSERT INTO tipo_transaccion (nombre) VALUES ('Venta');
INSERT INTO tipo_transaccion (nombre) VALUES ('Pago');
GO

-- Inserts para la tabla transaccion
INSERT INTO transaccion (id_tipo_transaccion) VALUES (1); -- Compra
INSERT INTO transaccion (id_tipo_transaccion) VALUES (2); -- Venta
INSERT INTO transaccion (id_tipo_transaccion) VALUES (3); -- Pago
GO



