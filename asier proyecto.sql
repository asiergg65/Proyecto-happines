  CREATE DATABASE happinessco;
USE happinessco;

-- USUARIOS
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

-- EVENTOS
CREATE TABLE eventos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    titulo VARCHAR(200),
    ubicacion VARCHAR(200),
    descripcion TEXT
);

-- GALERIAS
CREATE TABLE galerias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200),
    id_evento INT,
    FOREIGN KEY (id_evento) REFERENCES eventos(id)
);

-- IMAGENES
CREATE TABLE imagenes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200),
    imagen VARCHAR(255),
    id_galeria INT,
    FOREIGN KEY (id_galeria) REFERENCES galerias(id)
);

-- FAVORITOS
CREATE TABLE favoritos (
    id_usuario INT,
    id_evento INT,
    PRIMARY KEY (id_usuario, id_evento),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_evento) REFERENCES eventos(id)
);

INSERT INTO usuarios (nombre, email, password) VALUES
('Juan Perez', 'juan@mail.com', '1234'),
('Maria Lopez', 'maria@mail.com', '1234'),
('Carlos Ruiz', 'carlos@mail.com', '1234');

INSERT INTO eventos (fecha, titulo, ubicacion, descripcion) VALUES
('2026-01-01', 'Concierto Año Nuevo', 'Madrid', 'Gran concierto de inicio de año'),
('2026-01-12', 'Festival de Teatro', 'Madrid', 'Obras teatrales modernas'),
('2026-01-24', 'Exposición de Arte', 'Madrid', 'Arte contemporáneo'),
('2026-06-05', 'Festival de Música', 'Madrid', 'Bandas en vivo'),
('2026-06-15', 'Cine al Aire Libre', 'Madrid', 'Películas clásicas'),
('2026-06-25', 'Feria Cultural', 'Madrid', 'Eventos culturales variados');

INSERT INTO galerias (titulo, id_evento) VALUES
('Galeria Evento 1', 1),
('Galeria Evento 2', 2),
('Galeria Evento 3', 3);

INSERT INTO imagenes (titulo, imagen, id_galeria) VALUES
('Img1', 'img1.jpg', 1),
('Img2', 'img2.jpg', 1),
('Img3', 'img3.jpg', 1),

('Img4', 'img4.jpg', 2),
('Img5', 'img5.jpg', 2),
('Img6', 'img6.jpg', 2),

('Img7', 'img7.jpg', 3),
('Img8', 'img8.jpg', 3),
('Img9', 'img9.jpg', 3);

INSERT INTO favoritos (id_usuario, id_evento) VALUES
-- Usuario 1
(1,1),(1,2),(1,4),

-- Usuario 2
(2,1),(2,3),(2,5),

-- Usuario 3
(3,2),(3,3),(3,6);

CREATE VIEW galerias_anteriores AS
SELECT g.*
FROM galerias g
JOIN eventos e ON g.id_evento = e.id
WHERE e.fecha < '2026-02-28';

CREATE VIEW favoritos_usuario1 AS
SELECT e.*
FROM favoritos f
JOIN eventos e ON f.id_evento = e.id
WHERE f.id_usuario = 1;

CREATE VIEW imagenes_evento2 AS
SELECT i.*
FROM imagenes i
JOIN galerias g ON i.id_galeria = g.id
WHERE g.id_evento = 2;

CREATE VIEW favoritos_usuario2_futuros AS
SELECT e.*
FROM favoritos f
JOIN eventos e ON f.id_evento = e.id
WHERE f.id_usuario = 2
AND e.fecha > '2026-02-28';

