import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Taller taller = new Taller("Taller Pérez", "Calle Principal 123");
    private static int currentId = 1;

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    private static int nextId() {
        return currentId++;
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DEL TALLER ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Vehículos");
            System.out.println("3. Gestión de Empleados");
            System.out.println("4. Gestión de Reparaciones");
            System.out.println("5. Gestión de Inventario");
            System.out.println("6. Mostrar Reportes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero();
            
            switch(opcion) {
                case 1: gestionClientes(); break;
                case 2: gestionVehiculos(); break;
                case 3: gestionEmpleados(); break;
                case 4: gestionReparaciones(); break;
                case 5: gestionInventario(); break;
                case 6: mostrarReportes(); break;
                case 0: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }

    private static int leerEntero() {
        while(!scanner.hasNextInt()) {
            System.out.println("Error: Debe ingresar un número.");
            scanner.next();
            System.out.print("Seleccione una opción: ");
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    private static double leerDouble() {
        while(!scanner.hasNextDouble()) {
            System.out.println("Error: Debe ingresar un número decimal.");
            scanner.next();
            System.out.print("Ingrese el valor: ");
        }
        double num = scanner.nextDouble();
        scanner.nextLine();
        return num;
    }

    // Métodos de gestión de clientes
    private static void gestionClientes() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CLIENTES ===");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Listar todos los clientes");
            System.out.println("3. Buscar cliente por ID");
            System.out.println("4. Modificar teléfono de cliente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione: ");
            
            opcion = leerEntero();
            
            switch(opcion) {
                case 1: registrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: buscarCliente(); break;
                case 4: modificarTelefonoCliente(); break;
                case 0: break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }

    private static void registrarCliente() {
        System.out.println("\n--- REGISTRO DE CLIENTE ---");
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        
        Cliente nuevoCliente = new Cliente(nextId(), nombre, telefono);
        taller.agregarCliente(nuevoCliente);
        System.out.println("Cliente registrado con ID: " + nuevoCliente.getId());
    }

    private static void listarClientes() {
        ArrayList<Cliente> clientes = taller.getClientes();
        if(clientes.isEmpty()) {
            System.out.println("\nNo hay clientes registrados.");
            return;
        }
        
        System.out.println("\n--- LISTADO DE CLIENTES ---");
        for(Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre() + 
                             " | Tel: " + c.getTelefono() + " | Vehículos: " + c.getVehiculos().size());
        }
    }
    //Metodo para buscar un cliente 
    private static void buscarCliente() {
        System.out.print("\nIngrese ID del cliente a buscar: ");
        int id = leerEntero();
        
        for(Cliente c : taller.getClientes()) {
            if(c.getId() == id) {
                System.out.println("\nCliente encontrado:");
                System.out.println("ID: " + c.getId());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }
        System.out.println("No se encontró cliente con ID: " + id);
    }

    private static void modificarTelefonoCliente() {    
        System.out.print("\nIngrese ID del cliente a modificar: ");
        int id = leerEntero();

        Cliente cliente = buscarClientePorId(id);
        if(cliente == null) {
            System.out.println("No se encontró cliente con ID: " + id);
            return;
        }   
        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();

        // Actualizar el teléfono del cliente
        cliente.setTelefono(nuevoTelefono);
        System.out.println("Teléfono actualizado correctamente para: " + cliente.getNombre());
    }




    // Método de gestión de vehículos 
    private static void gestionVehiculos() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE VEHÍCULOS ===");
            System.out.println("1. Registrar nuevo vehículo");
            System.out.println("2. Listar todos los vehículos");
            System.out.println("3. Buscar vehículo por matrícula");
            System.out.println("4. Asignar vehículo a cliente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione: ");
            
            opcion = leerEntero();
            
            switch(opcion) {
                case 1: registrarVehiculo(); break;
                case 2: listarVehiculos(); break;
                case 3: buscarVehiculo(); break;
                case 4: asignarVehiculoACliente(); break;
                case 0: break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }

    // Metodo para registrar un nuevo vehiculo
    private static void registrarVehiculo(){
        System.out.println("\n--- REGISTRO DE VEHÍCULO ---");
        
        // Validación de matrícula
        String matricula;
        do {
            System.out.print("Matrícula (6-8 caracteres): ");
            matricula = scanner.nextLine().trim();
        } while(matricula.length() < 6 || matricula.length() > 8);
        
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        
        // Mostrar clientes para selección
        listarClientes();
        System.out.print("ID del propietario: ");
        int idPropietario = leerEntero();
        
        Cliente propietario = buscarClientePorId(idPropietario);
        if(propietario == null) {
            System.out.println("Cliente no encontrado");
            return;
        }
        // Crear y registrar el vehículo
        Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, propietario);
        taller.agregarVehiculo(nuevoVehiculo);
        propietario.agregarVehiculo(nuevoVehiculo);
        System.out.println("Vehículo registrado correctamente");
        System.out.println("Matrícula: " + matricula);
        System.out.println("Propietario: " + propietario.getNombre());
    }

    //Metodo para buscar Cliente por ID
    private static Cliente buscarClientePorId(int id) {
        for(Cliente c : taller.getClientes()) {
            if(c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    
    //Metodo para listar los vehiculos
    private static void listarVehiculos() {
        ArrayList<Vehiculo> vehiculos = taller.getVehiculos();
        if(vehiculos.isEmpty()) {
            System.out.println("\nNo hay vehículos registrados.");
            return;
        }
        
        System.out.println("\n--- LISTADO DE VEHÍCULOS ---");
        // Imprimir los títulos de las columnas con formato:
        // %-10s = Matrícula (10 caracteres de ancho, alineado a izquierda)
        // %-15s = Marca (15 caracteres de ancho, alineado a izquierda)
        // %-15s = Modelo (15 caracteres de ancho, alineado a izquierda)
        // %-20s = Propietario (20 caracteres de ancho, alineado a izquierda)
        System.out.printf("%-10s %-15s %-15s %-20s%n", "Matrícula", "Marca", "Modelo", "Propietario");
        System.out.println("--------------------------------------------------");
        
        for(Vehiculo carros : vehiculos) {
            System.out.printf("%-10s %-15s %-15s %-20s%n",
                carros.getMatricula(),
                carros.getMarca(),
                carros.getModelo(),
                carros.getPropietario().getNombre());
        }
        System.out.println("Total vehículos: " + vehiculos.size());
    }

    //Metodo para buschar coche
    private static void buscarVehiculo() {
        System.out.print("\nIngrese matrícula del vehículo: ");
        String matricula = scanner.nextLine().trim().toUpperCase();
       // Lee la entrada del usuario, elimina espacios en blanco al inicio/fin y convierte a mayúsculas

        Vehiculo vehiculo = buscarVehiculoPorMatricula(matricula);
        if(vehiculo == null) {
            System.out.println("No se encontró vehículo con matrícula: " + matricula);
            return;
        }
        
        System.out.println("\n--- DATOS DEL VEHÍCULO ---");
        System.out.println("Matrícula: " + vehiculo.getMatricula());
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Modelo: " + vehiculo.getModelo());
        System.out.println("Propietario: " + vehiculo.getPropietario().getNombre());
        System.out.println("Teléfono propietario: " + vehiculo.getPropietario().getTelefono());
        System.out.println("Reparaciones realizadas: " + vehiculo.getHistorialReparaciones().size());
    }
    //Metodo para buscar un vehiculo por la matricula
    private static Vehiculo buscarVehiculoPorMatricula(String matricula) {

        for(Vehiculo carro : taller.getVehiculos()) {
            // Comparar la matrícula (ignorando mayúsculas/minúsculas)
            if(carro.getMatricula().equalsIgnoreCase(matricula)) {
                return carro; 
            }
        }
        return null; 
    }

    //Metodo para reasignar el vehiculo al cliente 
    private static void asignarVehiculoACliente() {
        listarVehiculos();
        System.out.print("\nIngrese matrícula del vehículo: ");  
        String matricula = scanner.nextLine().trim().toUpperCase(); 
        // Lee la matrícula ingresada, eliminando espacios y convirtiendo a mayúsculas
        Vehiculo vehiculo = buscarVehiculoPorMatricula(matricula);
        // Busca el vehículo por su matrícula en la lista del taller
        if(vehiculo == null) {
            System.out.println("Vehículo no encontrado");
            return; // Termina el método si el vehículo no existe
        }
        listarClientes();
        System.out.print("ID del nuevo propietario: ");
        int idNuevoPropietario = leerEntero(); 
        // Busca el cliente por su ID en la lista del taller
        Cliente nuevoPropietario = buscarClientePorId(idNuevoPropietario);

        if(nuevoPropietario == null) {
            System.out.println("Cliente no encontrado");
            return; // Termina el método si el cliente no existe
        }
        // Obtiene el propietario actual del vehículo
        Cliente antiguoPropietario = vehiculo.getPropietario();
        // Remueve el vehículo de la lista del antiguo propietario
        antiguoPropietario.getVehiculos().remove(vehiculo);
        vehiculo.setPropietario(nuevoPropietario); 
        nuevoPropietario.agregarVehiculo(vehiculo);
        
        System.out.println("Vehículo reasignado correctamente");
        System.out.println("Nuevo propietario: " + nuevoPropietario.getNombre());
        System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() + 
                        " (" + vehiculo.getMatricula() + ")");
    }

    
    
    
    // Métodos de gestión de empleados 
    private static void gestionEmpleados() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
            System.out.println("1. Registrar nuevo empleado");
            System.out.println("2. Listar todos los empleados");
            System.out.println("3. Buscar empleado por ID");
            System.out.println("4. Modificar datos de empleado");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione: ");
            
            opcion = leerEntero();
            
            switch(opcion) {
                case 1: registrarEmpleado(); break;
                case 2: listarEmpleados(); break;
                case 3: buscarEmpleado(); break;
                case 4: modificarEmpleado(); break;
                case 0: break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }

    // Metodo para registrar el empleado
    private static void registrarEmpleado() {
        System.out.println("\n--- REGISTRO DE EMPLEADO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Puesto: ");
        String puesto = scanner.nextLine();
        
        System.out.print("¿Es mecánico? (s/n): ");
        String esMecanico = scanner.nextLine().toLowerCase();
        
        if(esMecanico.equals("s")) {
            System.out.print("Especialidad: ");
            String especialidad = scanner.nextLine();
            Mecanico nuevoMecanico = new Mecanico(nextId(), nombre, puesto, especialidad);
            taller.agregarEmpleado(nuevoMecanico);
        } else {
            Empleado nuevoEmpleado = new Empleado(nextId(), nombre, puesto);
            taller.agregarEmpleado(nuevoEmpleado);
        }
        System.out.println("Empleado registrado con éxito");
    }

    //Metodo para listar los empleados 
    private static void listarEmpleados() {
        ArrayList<Empleado> empleados = taller.getEmpleados();
        
        if(empleados.isEmpty()) { 
            System.out.println("\nNo hay empleados registrados.");  
            return;
        }
        System.out.println("\n--- LISTADO DE EMPLEADOS ---");
        System.out.printf("%-5s %-20s %-15s %-15s%n", "ID", "Nombre", "Puesto", "Especialidad"); 
        System.out.println("--------------------------------------------------");  
        
        for(Empleado trabajador : empleados) {
            // Determinar especialidad (solo para mecánicos)
            String especialidad = (trabajador instanceof Mecanico) ? 
                ((Mecanico)trabajador).getEspecialidad() : "N/A"; 
            
            System.out.printf("%-5d %-20s %-15s %-15s%n",
            trabajador.getId(), 
            trabajador.getNombre(),  
            trabajador.getPuesto(),  
                especialidad);  
        }
    }

    // Metodo para buscar un empleado
    private static void buscarEmpleado() {
        System.out.print("\nIngrese ID del empleado: ");
        int id = leerEntero();
        Empleado empleado = buscarEmpleadoPorId(id);  // Buscar empleado
        
        if(empleado == null) {  
            System.out.println("No se encontró empleado con ID: " + id);  
            return; 
        }
        
        System.out.println("\n--- DATOS DEL EMPLEADO ---");
        System.out.println("ID: " + empleado.getId());  
        System.out.println("Nombre: " + empleado.getNombre());  
        System.out.println("Puesto: " + empleado.getPuesto());  
        
        if(empleado instanceof Mecanico) {  
            System.out.println("Especialidad: " + ((Mecanico)empleado).getEspecialidad());  // Mostrar especialidad
        }
    }
    //Metodo para buscar un empleado por su ID 
    private static Empleado buscarEmpleadoPorId(int id) {
        
        for(Empleado trabajador : taller.getEmpleados()) {
            if(trabajador.getId() == id) {  
                return trabajador;  
            }
        }
        return null;  
    }

    //Metodo para modifiar los datos de un empleado
    private static void modificarEmpleado() {
        System.out.print("\nIngrese ID del empleado a modificar: "); 
        int id = leerEntero(); 
        Empleado empleado = buscarEmpleadoPorId(id);  // Buscar empleado  
        if(empleado == null) { 
            System.out.println("Empleado no encontrado");  
            return;  
        }
        System.out.println("\nDatos actuales:");
        System.out.println("Nombre: " + empleado.getNombre());  
        System.out.println("Puesto: " + empleado.getPuesto());  
        
        if(empleado instanceof Mecanico) {  // Si es mecánico
            System.out.println("Especialidad: " + ((Mecanico)empleado).getEspecialidad());  // Especialidad actual
        }
    
        System.out.println("\nIngrese nuevos datos (dejar en blanco para no modificar):");
        
        System.out.print("Nuevo nombre: ");  
        String nuevoNombre = scanner.nextLine();  
        if(!nuevoNombre.isEmpty()) {  
            empleado.setNombre(nuevoNombre); 
        }
        
        System.out.print("Nuevo puesto: ");  
        String nuevoPuesto = scanner.nextLine();  
        if(!nuevoPuesto.isEmpty()) { 
            empleado.setPuesto(nuevoPuesto);  
        }
        // Modificar especialidad si es mecánico (si se proporciona)
        if(empleado instanceof Mecanico) {  
            System.out.print("Nueva especialidad: ");  
            String nuevaEspecialidad = scanner.nextLine();  
            if(!nuevaEspecialidad.isEmpty()) {  // Si se ingresó especialidad
                ((Mecanico)empleado).setEspecialidad(nuevaEspecialidad);  // Actualizar especialidad
            }
        }
        System.out.println("Datos actualizados correctamente");
    }

    

    
    // Métodos de gestión de reparaciones 
    private static void gestionReparaciones() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE REPARACIONES ===");
            System.out.println("1. Registrar nueva reparación");
            System.out.println("2. Listar todas las reparaciones");
            System.out.println("3. Buscar reparación por ID");
            System.out.println("4. Agregar pieza a reparación");
            System.out.println("5. Finalizar reparación");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione: ");
            
            opcion = leerEntero();
            
            switch(opcion) {
                case 1: registrarReparacion(); break;
                case 2: listarReparaciones(); break;
                case 3: buscarReparacion(); break;
                case 4: añadirPiezaAReparacion(); break;
                case 5: finalizarReparacion(); break;
                case 0: break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
        
    }

    //Metodo para registrar una reparacion 
    private static void registrarReparacion() {
        System.out.println("\n--- NUEVA REPARACIÓN ---");
        
        // Seleccionar vehículo
        listarVehiculos();
        System.out.print("Matrícula del vehículo: ");
        String matricula = scanner.nextLine().trim().toUpperCase();
        Vehiculo vehiculo = buscarVehiculoPorMatricula(matricula);
        
        if(vehiculo == null) {
            System.out.println("Vehículo no encontrado");
            return;
        }
        
        // Seleccionar mecánico
        listarMecanicos();
        System.out.print("ID del mecánico: ");
        int idMecanico = leerEntero();
        Mecanico mecanico = (Mecanico)buscarEmpleadoPorId(idMecanico);
        
        if(mecanico == null) {
            System.out.println("Mecánico no encontrado o ID no corresponde a mecánico");
            return;
        }
        
        // Ingresar detalles
        System.out.print("Descripción del problema: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Fecha (dd/mm/aaaa): ");
        String fecha = scanner.nextLine();
        
        // Crear nueva reparación
        Reparacion nuevaReparacion = new Reparacion(
            nextId(),
            vehiculo,
            mecanico,
            descripcion,
            0.0, // Costo inicial 0
            fecha
        );
        
        // Agregar al sistema
        vehiculo.agregarReparacion(nuevaReparacion);
        taller.agregarReparacion(nuevaReparacion);
        
        System.out.println("Reparación registrada con ID: " + nuevaReparacion.getId());
    }
    //Metodo para listar los mecanicos 
    private static void listarMecanicos() {
        System.out.println("\n--- MECÁNICOS DISPONIBLES ---");
        for(Empleado mecanico : taller.getEmpleados()) {
            if(mecanico instanceof Mecanico) {
                Mecanico m = (Mecanico)mecanico;
                System.out.println("ID: " + m.getId() + " | Nombre: " + m.getNombre() + 
                                 " | Especialidad: " + m.getEspecialidad());
            }
        }
    }
    //Metodo para listar reparaciones
    private static void listarReparaciones() {
        ArrayList<Reparacion> reparaciones = taller.getReparaciones(); 
        if(reparaciones.isEmpty()) {  
            System.out.println("\nNo hay reparaciones registradas.");
            return;
        }
        
        System.out.println("\n--- LISTADO DE REPARACIONES ---");
        System.out.printf("%-5s %-12s %-15s %-20s %-10s %-15s%n", 
            "ID", "Vehículo", "Mecánico", "Descripción", "Costo", "Fecha");
        System.out.println("-------------------------------------------------------------------");   
        // Mostrar cada reparación
        for(Reparacion rep : reparaciones) {
            System.out.printf("%-5d %-12s %-15s %-20s %-10.2f %-15s%n",
                rep.getId(),  
                rep.getVehiculo().getMatricula(),  
                rep.getEmpleado().getNombre(),  
                // Descripción abreviada (20 caracteres)
                rep.getDescripcion().substring(0, Math.min(rep.getDescripcion().length(), 20)) + "...", 
                rep.getCosto(),  // Costo
                rep.getFecha());  // Fecha
        }
    }
    //Metodo para buscar una reparacion 
    private static void buscarReparacion() {
        System.out.print("\nIngrese ID de reparación: ");
        int id = leerEntero(); 
        Reparacion reparacion = buscarReparacionPorId(id);  
        
        if(reparacion == null) {  
            System.out.println("Reparación no encontrada");
            return;
        }
        System.out.println("\n--- DETALLES DE REPARACIÓN ---");
        System.out.println("ID: " + reparacion.getId());
        System.out.println("Vehículo: " + reparacion.getVehiculo().getMarca() + " " + 
                          reparacion.getVehiculo().getModelo() + " (" + 
                          reparacion.getVehiculo().getMatricula() + ")");
        System.out.println("Propietario: " + reparacion.getVehiculo().getPropietario().getNombre());
        System.out.println("Mecánico: " + reparacion.getEmpleado().getNombre() + 
                          " (" + ((Mecanico)reparacion.getEmpleado()).getEspecialidad() + ")");
        System.out.println("Fecha: " + reparacion.getFecha());
        System.out.println("Descripción: " + reparacion.getDescripcion());
        System.out.println("Costo total: " + reparacion.getCosto() + "€");
        
        // Mostrar piezas utilizadas
        System.out.println("\nPiezas utilizadas:");
        if(reparacion.getPiezasUsadas().isEmpty()) {
            System.out.println("No se han registrado piezas");
        } else {
            for(Pieza pieza : reparacion.getPiezasUsadas()) {
                System.out.println("- " + pieza.getNombre() + " (" + pieza.getPrecio() + "€)");
            }
        }
    }
    //Metodo para buscar reparacion por ID
    private static Reparacion buscarReparacionPorId(int id) {
        for(Reparacion IDrep : taller.getReparaciones()) {  
            if(IDrep.getId() == id) {  // Comparar ID
                return IDrep; 
            }
        }
        return null; 
    }

    //Metodo para agregar una pieza a la reparacion
    private static void añadirPiezaAReparacion() {
        System.out.print("\nIngrese ID de reparación: ");
        int idReparacion = leerEntero();  
        Reparacion reparacion = buscarReparacionPorId(idReparacion);  
        if(reparacion == null) {  // Validar si existe
            System.out.println("Reparación no encontrada");
            return;
        }
        // Mostrar y seleccionar pieza
        listaPiezasDisponibles();
        System.out.print("ID de pieza a agregar: ");
        int idPieza = leerEntero();  // Leer ID de pieza
        Pieza pieza = buscarPiezaPorId(idPieza);  // Buscar pieza
        
        if(pieza == null) {  // Validar si existe
            System.out.println("Pieza no encontrada");
            return;
        } 
        // Verificar stock disponible
        if(pieza.getCantidadStock() <= 0) {
            System.out.println("No hay suficiente stock de esta pieza");
            return;
        } 
        // Agregar pieza a la reparación
        reparacion.agregarPieza(pieza);
        // Actualizar costo total
        reparacion.setCosto(reparacion.getCosto() + pieza.getPrecio());      
        // Reducir stock
        pieza.setCantidadStock(pieza.getCantidadStock() - 1);

        System.out.println("Pieza agregada correctamente");
        System.out.println("Nuevo costo total: " + reparacion.getCosto() + "€");
    }
    //Metodo para listar piezas disponibles
    private static void listaPiezasDisponibles() {
        System.out.println("\n--- PIEZAS DISPONIBLES ---");
        for(Pieza recambio : taller.getPiezas()) {  
            if(recambio.getCantidadStock() > 0) {  // Verificar stock
                System.out.println("ID: " + recambio.getId() + " | Nombre: " + recambio.getNombre() + 
                                 " | Precio: " + recambio.getPrecio() + "€ | Stock: " + recambio.getCantidadStock());
            }
        }
    }
    //Metodo para buscar pieza por ID
    private static Pieza buscarPiezaPorId(int id) {
        ArrayList<Pieza> piezas = taller.getPiezas();
        for(Pieza pieza : piezas) {
            // Verificar si el ID coincide
            if(pieza.getId() == id) {
                return pieza; 
            }
        }
        return null; 
    }

    //Metodo para finalizar reparacion 
    private static void finalizarReparacion() {
        System.out.print("\nIngrese ID de reparación a finalizar: ");
        int id = leerEntero();  
        Reparacion reparacion = buscarReparacionPorId(id);  // Buscar reparación
        
        if(reparacion == null) {  
            System.out.println("Reparación no encontrada");
            return;
        }
        System.out.println("\nReparación finalizada correctamente");
        System.out.println("Vehículo: " + reparacion.getVehiculo().getMatricula());
        System.out.println("Costo total: " + reparacion.getCosto() + "€");
        System.out.println("Piezas utilizadas: " + reparacion.getPiezasUsadas().size());
    }    




    // Métodos de gestión de inventario 
    private static void gestionInventario() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE INVENTARIO ===");
            System.out.println("1. Agregar pieza al inventario");
            System.out.println("2. Listar todas las piezas");
            System.out.println("3. Buscar pieza por ID");
            System.out.println("4. Modificar stock de pieza");
            System.out.println("5. Registrar nuevo proveedor");
            System.out.println("6. Listar proveedores");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero();
            
            switch(opcion) {
                case 1: agregarPieza(); break;
                case 2: listarPiezas(); break;
                case 3: buscarPieza(); break;
                case 4: modificarStockPieza(); break;
                case 5: registrarProveedor(); break;
                case 6: listarProveedores(); break;
                case 0: break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }

    //Metodo para agrear una pieza 
    private static void agregarPieza() {
        System.out.println("\n--- AGREGAR NUEVA PIEZA ---");
        // Mostrar lista de proveedores disponibles
        listarProveedores();
        System.out.print("ID del proveedor: ");
        int idProveedor = leerEntero(); 
        // Busca el proveedor en la lista
        Proveedor proveedor = buscarProveedorPorId(idProveedor);
        
        if(proveedor == null) {
            System.out.println("Proveedor no encontrado");
            return; 
        }
        System.out.print("Nombre de la pieza: ");
        String nombre = scanner.nextLine(); 
        
        System.out.print("Precio: ");
        double precio = leerDouble(); 
        
        System.out.print("Cantidad en stock: ");
        int stock = leerEntero(); 
        // Crea la nueva pieza con los datos ingresados
        Pieza nuevaPieza = new Pieza(nextId(), nombre, precio, stock, proveedor);
        // Agrega la pieza al inventario del taller
        taller.agregarPieza(nuevaPieza);
        System.out.println("Pieza agregada con ID: " + nuevaPieza.getId());
    }
    //Metodo para listar los proveedores
    private static void listarProveedores() {
        ArrayList<Proveedor> proveedores = taller.getProveedores();
        System.out.println("\n--- LISTADO DE PROVEEDORES ---");
        System.out.printf("%-5s %-25s %-15s%n", "ID", "Nombre", "Teléfono");
        System.out.println("------------------------------------------");
        // Mostrar cada proveedor en formato de tabla
        for(Proveedor prov : proveedores) {
            System.out.printf("%-5d %-25s %-15s%n",
                prov.getId(),
                prov.getNombre(),
                prov.getTelefono());
        }
    }
    //Metodo para buscar un proveedor por id
    private static Proveedor buscarProveedorPorId(int id) {
        for(Proveedor prov : taller.getProveedores()) {
            if(prov.getId() == id) {
                return prov;
            }
        }
        return null;
    }

    //Metodo para listar piezas
    private static void listarPiezas() {
        ArrayList<Pieza> piezas = taller.getPiezas();
        if(piezas.isEmpty()) {
            System.out.println("\nNo hay piezas en el inventario.");
            return; 
        }
        System.out.println("\n--- LISTADO DE PIEZAS ---");
        // Formato de columnas: ID (5), Nombre (25), Precio (10), Stock (8), Proveedor (20)
        System.out.printf("%-5s %-25s %-10s %-8s %-20s%n", 
                         "ID", "Nombre", "Precio", "Stock", "Proveedor");
        System.out.println("------------------------------------------------------------");
        // Recorre todas las piezas y muestra sus datos
        for(Pieza pieza : piezas) {
            System.out.printf("%-5d %-25s %-10.2f %-8d %-20s%n",
            pieza.getId(),         
            pieza.getNombre(),      
            pieza.getPrecio(),     
            pieza.getCantidadStock(), 
            pieza.getProveedor().getNombre()); 
        }
    }

    //Metodo para buscar piezas
    private static void buscarPieza() {
        System.out.print("\nIngrese ID de la pieza: ");
        int id = leerEntero();
        Pieza pieza = buscarPiezaPorId(id);
        if(pieza == null) {
            System.out.println("Pieza no encontrada");
            return; 
        }
        System.out.println("\n--- DETALLES DE LA PIEZA ---");
        System.out.println("ID: " + pieza.getId());
        System.out.println("Nombre: " + pieza.getNombre());
        System.out.println("Precio: " + pieza.getPrecio() + "€");
        System.out.println("Stock disponible: " + pieza.getCantidadStock());
        System.out.println("Proveedor: " + pieza.getProveedor().getNombre());
        System.out.println("Teléfono proveedor: " + pieza.getProveedor().getTelefono());
    }

    //Metodo para modificar el stock de una pieza
    private static void modificarStockPieza() {
        System.out.print("\nIngrese ID de la pieza: ");
        int id = leerEntero();

        Pieza pieza = buscarPiezaPorId(id);
        if(pieza == null) {
            System.out.println("Pieza no encontrada");
            return; 
        }
        System.out.println("\nStock actual: " + pieza.getCantidadStock());
        System.out.print("Nuevo valor de stock: ");
        int nuevoStock = leerEntero(); 

        if(nuevoStock >= 0) {
            pieza.setCantidadStock(nuevoStock); // Actualiza el stock
            System.out.println("Stock actualizado correctamente");
        } else {
            System.out.println("El stock no puede ser negativo"); 
        }
    }

    //Metodo para registrar un proveedor
    private static void registrarProveedor() {
        System.out.println("\n--- REGISTRAR NUEVO PROVEEDOR ---");
        System.out.print("Nombre del proveedor: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        
        Proveedor nuevoProveedor = new Proveedor(nextId(), nombre, telefono);
        taller.agregarProveedor(nuevoProveedor);
        System.out.println("Proveedor registrado con ID: " + nuevoProveedor.getId());
    }
    
    
    


    // Métodos para mostrar reportes 
    private static void mostrarReportes() {
            int opcion;
        do {
            System.out.println("\n=== REPORTES DEL TALLER ===");
            System.out.println("1. Reporte de clientes y vehículos");
            System.out.println("2. Reporte de reparaciones");
            System.out.println("3. Estado del inventario");
            System.out.println("4. Resumen financiero");
            System.out.println("5. Productividad de empleados");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione un reporte: ");
            
            opcion = leerEntero();
            
            switch(opcion) {
                case 1: reporteClientesVehiculos(); break;
                case 2: reporteReparaciones(); break;
                case 3: reporteInventario(); break;
                case 4: reporteFinanciero(); break;
                case 5: reporteProductividad(); break;
                case 0: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
        }

    //Metodo para reportar los vehiculos de los clientes
    private static void reporteClientesVehiculos() {
        System.out.println("\n--- REPORTE DE CLIENTES Y VEHÍCULOS ---");
        // Formato de columnas: ID (5), Nombre (20), Teléfono (15), Vehículos (10), Última visita (15)
        System.out.printf("%-5s %-20s %-15s %-10s %-15s%n", 
                         "ID", "Nombre", "Teléfono", "Vehículos", "Última visita");
        System.out.println("------------------------------------------------------------");

        for(Cliente cliente : taller.getClientes()) {
            String ultimaVisita = "Nunca";
            if(!cliente.getVehiculos().isEmpty()) {
                // Buscar la reparación más reciente entre todos sus vehículos
                for(Vehiculo vehiculo : cliente.getVehiculos()) {
                    if(!vehiculo.getHistorialReparaciones().isEmpty()) {
                        // Obtener la fecha de la última reparación 
                        ultimaVisita = vehiculo.getHistorialReparaciones()
                                              .get(vehiculo.getHistorialReparaciones().size()-1)
                                              .getFecha();
                    }
                }
            }
            
            // Mostrar los datos del cliente formateados
            System.out.printf("%-5d %-20s %-15s %-10d %-15s%n",
                cliente.getId(),            
                cliente.getNombre(),       
                cliente.getTelefono(),   
                cliente.getVehiculos().size(), 
                ultimaVisita);            
        }

        System.out.println("\nTotal clientes: " + taller.getClientes().size());
        System.out.println("Total vehículos registrados: " + taller.getVehiculos().size());
    }

    //Metodo para reportar reparaciones
    private static void reporteReparaciones() {
        System.out.println("\n--- REPORTE DE REPARACIONES ---");
        System.out.printf("%-5s %-12s %-15s %-10s %-15s %-10s%n", 
                         "ID", "Vehículo", "Mecánico", "Piezas", "Costo", "Fecha");
        System.out.println("------------------------------------------------------------------");
        
        // Variables para calcular totales
        double totalReparaciones = 0; // Acumulador del costo total
        int totalPiezasUsadas = 0;    // Contador de piezas usadas
        
        for(Reparacion reparacion : taller.getReparaciones()) {
            int numPiezas = reparacion.getPiezasUsadas().size(); // Piezas usadas en esta reparación
            totalPiezasUsadas += numPiezas; // Sumar al total
            totalReparaciones += reparacion.getCosto(); // Sumar al acumulador

            System.out.printf("%-5d %-12s %-15s %-10d %-10.2f€ %-15s%n",
                reparacion.getId(),                     
                reparacion.getVehiculo().getMatricula(), 
                reparacion.getEmpleado().getNombre(),   
                numPiezas,                            
                reparacion.getCosto(),                  
                reparacion.getFecha());                 
        }
        System.out.println("\nTotal reparaciones: " + taller.getReparaciones().size());
        System.out.println("Total piezas utilizadas: " + totalPiezasUsadas);
        System.out.printf("Ingresos totales por reparaciones: %.2f€%n", totalReparaciones);
    }

    //Metodo para reportar el inventario
    private static void reporteInventario() {
        System.out.println("\n--- REPORTE DE INVENTARIO ---");
        // Formato de columnas: ID (5), Pieza (25), Precio (10), Stock (8), Proveedor (20)
        System.out.printf("%-5s %-25s %-10s %-8s %-20s%n", 
                         "ID", "Pieza", "Precio", "Stock", "Proveedor");
        System.out.println("------------------------------------------------------------");
        
        // Variables para calcular totales
        int piezasBajoStock = 0;         
        double valorTotalInventario = 0; 

        for(Pieza pieza : taller.getPiezas()) {
            // Verificar si el stock contiene menos de 5 
            if(pieza.getCantidadStock() < 5) {
                piezasBajoStock++;
            }
            // Calcular el valor total de esta pieza 
            valorTotalInventario += (pieza.getPrecio() * pieza.getCantidadStock());
            
            System.out.printf("%-5d %-25s %-10.2f %-8d %-20s%n",
                pieza.getId(),            
                pieza.getNombre(),        
                pieza.getPrecio(),        
                pieza.getCantidadStock(), 
                pieza.getProveedor().getNombre()); 
        }
        System.out.println("\nTotal piezas en inventario: " + taller.getPiezas().size());
        System.out.println("Piezas con stock bajo (<5 unidades): " + piezasBajoStock);
        System.out.printf("Valor total del inventario: %.2f€%n", valorTotalInventario);
    }

    //Metodo para reportar la financiacion 
    private static void reporteFinanciero() {
        System.out.println("\n--- REPORTE FINANCIERO ---");
        // Calcular ingresos por reparaciones
        double ingresosReparaciones = 0; 
        for(Reparacion reparacion : taller.getReparaciones()) {
            ingresosReparaciones += reparacion.getCosto(); 
        }
        // Calcular valor del inventario
        double valorInventario = 0; 
        for(Pieza pieza : taller.getPiezas()) {
            valorInventario += (pieza.getPrecio() * pieza.getCantidadStock()); 
        }
        System.out.printf("Ingresos por reparaciones: %10.2f€%n", ingresosReparaciones);
        System.out.printf("Valor del inventario:      %10.2f€%n", valorInventario);
        System.out.println("----------------------------------");
        System.out.printf("Total:                     %10.2f€%n", (ingresosReparaciones + valorInventario));
        // Calcular promedio por reparación
        System.out.printf("Promedio por reparación:   %10.2f€%n", 
            taller.getReparaciones().isEmpty() ? 0 : ingresosReparaciones / taller.getReparaciones().size());
        System.out.printf("Clientes atendidos:        %10d%n", taller.getClientes().size());
    }

    //Metodo para reportar la productividad
    private static void reporteProductividad() {
        System.out.println("\n--- PRODUCTIVIDAD DE EMPLEADOS ---");
        // Formato de columnas: ID (5), Nombre (20), Puesto (15), Reparaciones (15), Ingresos (10)
        System.out.printf("%-5s %-20s %-15s %-15s %-10s%n", 
                         "ID", "Nombre", "Puesto", "Reparaciones", "Ingresos");
        System.out.println("------------------------------------------------------------");
 
        for(Empleado empleado : taller.getEmpleados()) {
            int reparaciones = 0;    // Contador de reparaciones
            double ingresos = 0;     // Acumulador de ingresos

            // Solo los mecánicos tienen reparaciones asignadas
            if(empleado instanceof Mecanico) {
                // Contar reparaciones y calcular ingresos generados por este mecánico
                for(Reparacion reparacion : taller.getReparaciones()) {
                    if(reparacion.getEmpleado().getId() == empleado.getId()) {
                        reparaciones++;
                        ingresos += reparacion.getCosto();
                    }
                }
            }
            System.out.printf("%-5d %-20s %-15s %-15d %-10.2f€%n",
                empleado.getId(),     
                empleado.getNombre(), 
                empleado.getPuesto(), 
                reparaciones,         
                ingresos);            
        }
    }

}

    
    