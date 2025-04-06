INSERT INTO Talleres (nombre, direccion, telefono) VALUES 
('Taller Mecánico Pérez', 'Calle Principal 123, Ciudad', '555-1002003'),
('Taller Rápido Martínez', 'Avenida Central 456, Ciudad', '555-4005006'),
('AutoServicio García', 'Boulevard Industrial 789, Ciudad', '555-7008009');

INSERT INTO Clientes (nombre, telefono, email, direccion, id_taller) VALUES 
('Juan García López', '555-1234567', 'juan.garcia@email.com', 'Calle Secundaria 321, Ciudad', 1),
('María López Fernández', '555-2345678', 'maria.lopez@email.com', 'Avenida Norte 654, Ciudad', 1),
('Carlos Martínez Ruiz', '555-3456789', 'carlos.martinez@email.com', 'Boulevard Sur 987, Ciudad', 2),
('Ana Rodríguez Sánchez', '555-4567890', 'ana.rodriguez@email.com', 'Calle Este 147, Ciudad', 2),
('Pedro Gómez Díaz', '555-5678901', 'pedro.gomez@email.com', 'Avenida Oeste 258, Ciudad', 3);

INSERT INTO Proveedores (nombre, telefono, email, direccion, id_taller, especialidad) VALUES 
('Autopartes del Norte', '555-1112233', 'ventas@autopartes.com', 'Polígono Industrial Norte, Ciudad', 1, 'Partes de motor'),
('Repuestos Premium SA', '555-2223344', 'contacto@repuestospremium.com', 'Zona Industrial Sur, Ciudad', 1, 'Suspensión y frenos'),
('Distribuidora de Piezas', '555-3334455', 'info@distribuidora.com', 'Parque Tecnológico Este, Ciudad', 2, 'Partes eléctricas'),
('Importadora de Componentes', '555-4445566', 'ventas@importadora.com', 'Área Comercial Oeste, Ciudad', 3, 'Partes de carrocería');

INSERT INTO Empleados (nombre, telefono, email, puesto, salario, fecha_contratacion, id_taller) VALUES 
('Luis Sánchez Pérez', '555-9876543', 'luis.sanchez@taller.com', 'Gerente', 2500.00, '2020-01-15', 1),
('Marta Fernández López', '555-8765432', 'marta.fernandez@taller.com', 'Mecánico', 1800.00, '2020-03-20', 1),
('Jorge Ramírez García', '555-7654321', 'jorge.ramirez@taller.com', 'Recepcionista', 1200.00, '2021-02-10', 1),
('Sofía Torres Martínez', '555-6543210', 'sofia.torres@taller.com', 'Mecánico', 1700.00, '2021-05-05', 2),
('David Gómez Rodríguez', '555-5432109', 'david.gomez@taller.com', 'Mecánico', 1900.00, '2021-07-15', 3);

INSERT INTO Mecanicos (id_empleado, especialidad, certificaciones) VALUES 
(2, 'Motor y transmisión', 'Certificación en motores diésel, Especialista en transmisiones automáticas'),
(4, 'Electricidad automotriz', 'Certificación en sistemas eléctricos avanzados'),
(5, 'Suspensión y dirección', 'Especialista en sistemas de suspensión neumática');

INSERT INTO Vehiculos (matricula, marca, modelo, año, color, id_propietario, id_taller) VALUES 
('ABC1234', 'Toyota', 'Corolla', 2018, 'Blanco', 1, 1),
('DEF5678', 'Honda', 'Civic', 2020, 'Negro', 2, 1),
('GHI9012', 'Ford', 'Fiesta', 2019, 'Rojo', 3, 2),
('JKL3456', 'Volkswagen', 'Golf', 2021, 'Azul', 4, 2),
('MNO7890', 'Nissan', 'Sentra', 2017, 'Gris', 5, 3);

INSERT INTO Piezas (nombre, descripcion, precio, cantidad_stock, stock_minimo, id_proveedor, id_taller) VALUES 
('Filtro de aceite', 'Filtro de aceite sintético para motor', 12.99, 25, 10, 1, 1),
('Pastillas de freno', 'Juego de pastillas de freno delanteras', 45.50, 15, 5, 2, 1),
('Batería 12V', 'Batería de 60Ah para automóvil', 89.99, 8, 3, 1, 1),
('Amortiguador delantero', 'Amortiguador delantero izquierdo', 120.00, 6, 2, 3, 2),
('Bujía de encendido', 'Bujía de platino para motores 4 cilindros', 8.75, 40, 20, 4, 3),
('Correa de distribución', 'Correa de distribución con kit', 75.25, 5, 2, 2, 2);

INSERT INTO Reparaciones (matricula_vehiculo, id_mecanico, descripcion, fecha_inicio, fecha_fin, costo_mano_obra, estado, id_taller) VALUES 
('ABC1234', 2, 'Cambio de aceite y filtro', '2023-05-10', '2023-05-10', 30.00, 'FINALIZADA', 1),
('DEF5678', 2, 'Revisión de frenos y cambio de pastillas', '2023-05-15', NULL, 50.00, 'EN_PROCESO', 1),
('GHI9012', 4, 'Diagnóstico de problemas eléctricos', '2023-05-12', '2023-05-13', 40.00, 'FINALIZADA', 2),
('JKL3456', 4, 'Cambio de amortiguadores delanteros', '2023-05-18', NULL, 60.00, 'EN_PROCESO', 2),
('MNO7890', 5, 'Mantenimiento preventivo general', '2023-05-20', NULL, 45.00, 'PENDIENTE', 3);

INSERT INTO PiezasReparaciones (id_reparacion, id_pieza, cantidad, precio_unitario) VALUES 
(1, 1, 1, 12.99),  
(2, 2, 2, 45.50),  
(3, 3, 1, 89.99),  
(4, 4, 2, 120.00); 