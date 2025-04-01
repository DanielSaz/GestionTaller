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
        
        for(Cliente c : taller.getClientes()) {
            if(c.getId() == id) {
                System.out.print("Nuevo teléfono: ");
                String nuevoTelefono = scanner.nextLine();
                // Necesitaríamos un setter en la clase Cliente para modificar el teléfono
                System.out.println("Teléfono actualizado.");
                return;
            }
        }
        System.out.println("No se encontró cliente con ID: " + id);
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

    //Metodo para buschar coche por la matricula 
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

    

    
    // Métodos de gestión de reparaciones (implementación básica)
    private static void gestionReparaciones() {
        System.out.println("\nGestión de reparaciones - Implementar similar a gestión de clientes");
    }

    // Métodos de gestión de inventario (implementación básica)
    private static void gestionInventario() {
        System.out.println("\nGestión de inventario - Implementar similar a gestión de clientes");
    }

    // Métodos para mostrar reportes (implementación básica)
    private static void mostrarReportes() {
        System.out.println("\nMostrar reportes - Implementar según requerimientos");
    }
}