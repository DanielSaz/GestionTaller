-- Tabla Talleres
CREATE TABLE Talleres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    telefono VARCHAR(20),
    fecha_creacion DATE DEFAULT CURRENT_DATE
);

-- Tabla Clientes
CREATE TABLE Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    direccion VARCHAR(200),
    id_taller INT NOT NULL,
    fecha_registro DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_taller) REFERENCES Talleres(id)
);

-- Tabla Proveedores
CREATE TABLE Proveedores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    direccion VARCHAR(200),
    id_taller INT NOT NULL,
    especialidad VARCHAR(100),
    FOREIGN KEY (id_taller) REFERENCES Talleres(id)
);

-- Tabla Empleados
CREATE TABLE Empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    email VARCHAR(100),
    puesto VARCHAR(50) NOT NULL,
    salario DECIMAL(10,2),
    fecha_contratacion DATE,
    id_taller INT NOT NULL,
    FOREIGN KEY (id_taller) REFERENCES Talleres(id)
);

-- Tabla Mecanicos (especialización de Empleados)
CREATE TABLE Mecanicos (
    id_empleado INT PRIMARY KEY,
    especialidad VARCHAR(100) NOT NULL,
    certificaciones VARCHAR(200),
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id)
);

-- Tabla Vehiculos
CREATE TABLE Vehiculos (
    matricula VARCHAR(10) PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    año INT,
    color VARCHAR(30),
    id_propietario INT NOT NULL,
    id_taller INT NOT NULL,
    FOREIGN KEY (id_propietario) REFERENCES Clientes(id),
    FOREIGN KEY (id_taller) REFERENCES Talleres(id)
);

-- Tabla Piezas
CREATE TABLE Piezas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    cantidad_stock INT NOT NULL DEFAULT 0,
    stock_minimo INT DEFAULT 5,
    id_proveedor INT,
    id_taller INT NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES Proveedores(id),
    FOREIGN KEY (id_taller) REFERENCES Talleres(id)
);

-- Tabla Reparaciones
CREATE TABLE Reparaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    matricula_vehiculo VARCHAR(10) NOT NULL,
    id_mecanico INT NOT NULL,
    descripcion TEXT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    costo_mano_obra DECIMAL(10,2) NOT NULL,
    costo_total DECIMAL(10,2),
    id_taller INT NOT NULL,
    FOREIGN KEY (matricula_vehiculo) REFERENCES Vehiculos(matricula),
    FOREIGN KEY (id_mecanico) REFERENCES Mecanicos(id_empleado),
    FOREIGN KEY (id_taller) REFERENCES Talleres(id)
);

-- Tabla intermedia PiezasReparaciones
CREATE TABLE PiezasReparaciones (
    id_reparacion INT NOT NULL,
    id_pieza INT NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    precio_unitario DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id_reparacion, id_pieza),
    FOREIGN KEY (id_reparacion) REFERENCES Reparaciones(id),
    FOREIGN KEY (id_pieza) REFERENCES Piezas(id)
);

-- Tabla Facturas
CREATE TABLE Facturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_reparacion INT NOT NULL,
    fecha DATE NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    iva DECIMAL(10,2) NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_reparacion) REFERENCES Reparaciones(id)
);