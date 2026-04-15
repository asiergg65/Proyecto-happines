-- 1. Creación de la Base de Datos
CREATE DATABASE IF NOT EXISTS happiness_co;
USE happiness_co;

-- 2. Tabla de Categorías (Siguiendo el código de colores del PDF)
CREATE TABLE categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    color_hex VARCHAR(7), -- #ba007c (Rosa), #009bdb (Azul), etc.
    descripcion VARCHAR(255)
);

-- 3. Tabla de Eventos (Recopilando lo que hay en proximos.html y las categorías)
CREATE TABLE eventos (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion_corta TEXT,
    fecha_inicio DATE,
    fecha_fin DATE,
    ubicacion VARCHAR(100),
    precio_base DECIMAL(10,2),
    imagen_url VARCHAR(255),
    id_categoria INT,
    estado ENUM('proximo', 'finalizado') DEFAULT 'proximo',
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

-- 4. Tabla de Usuarios (Para el sistema de contacto y favoritos)
CREATE TABLE usuarios (
    email VARCHAR(100) PRIMARY KEY, -- El PDF pide identificar por correo
    nombre VARCHAR(100) NOT NULL,
    suscrito BOOLEAN DEFAULT FALSE,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 5. Tabla de Galerías (Como pide el PDF para el historial)
CREATE TABLE galerias (
    id_galeria INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT,
    imagen_url VARCHAR(255),
    descripcion_foto VARCHAR(255),
    FOREIGN KEY (id_evento) REFERENCES eventos(id_evento) ON DELETE CASCADE
);

-- 6. Tabla de Favoritos (Relación N:M entre Usuarios y Eventos)
CREATE TABLE favoritos (
    id_favorito INT AUTO_INCREMENT PRIMARY KEY,
    email_usuario VARCHAR(100),
    id_evento INT,
    fecha_anadido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (email_usuario) REFERENCES usuarios(email) ON DELETE CASCADE,
    FOREIGN KEY (id_evento) REFERENCES eventos(id_evento) ON DELETE CASCADE
);

-- ---------------------------------------------------------
-- INSERCIÓN DE DATOS REALES (Extraídos de tus HTML)
-- ---------------------------------------------------------

-- Insertar Categorías
INSERT INTO categorias (nombre, color_hex, descripcion) VALUES 
('Música', '#ba007c', 'Conciertos y festivales musicales'),
('Cine y Teatro', '#009bdb', 'Artes escénicas y proyecciones'),
('Exposiciones', '#ff7b00', 'Museos y galerías de arte'),
('Extras', '#555555', 'Artesanía, gastronomía y otros');

-- Insertar Eventos actuales de tus archivos
INSERT INTO eventos (titulo, ubicacion, fecha_inicio, id_categoria, precio_base, estado) VALUES 
('Metrópoli Gijón 2026', 'Recinto Ferial', '2026-06-26', 1, 15.00, 'proximo'),
('Gijón Jazz Festival', 'Teatro Jovellanos', '2026-11-10', 1, 25.00, 'proximo'),
('Don Juan Tenorio', 'Teatro Jovellanos', '2026-06-25', 2, 20.00, 'proximo'),
('Cine bajo las estrellas', 'Playa de Poniente', '2026-07-15', 2, 0.00, 'proximo'),
('Asturias en el s.XX', 'Muséu del Pueblu d’Asturies', '2026-05-01', 3, 5.00, 'proximo'),
('Océanos de Plástico', 'Acuario de Gijón', '2026-06-05', 3, 8.00, 'proximo'),
('Jornadas de la Sidra', 'Plaza Mayor', '2026-10-12', 4, 10.00, 'proximo'),
('Mercado de Artesanía', 'Plaza Mayor', '2026-04-15', 4, 0.00, 'proximo');

-- Insertar un evento finalizado para el Historial (según evento-detalle.html)
INSERT INTO eventos (titulo, ubicacion, fecha_inicio, id_categoria, estado) VALUES 
('Exposición de Arte Moderno', 'Museo de Arte', '2026-01-12', 3, 'finalizado');