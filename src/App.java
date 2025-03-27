import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static App taller = new Taller("Taller Pérez", "Calle Principal 123");
    private static int currentId = 1;

    public static void main(String[] args) {
        cargarDatosEjemplo();
        mostrarMenuPrincipal();
    }

    private static void cargarDatosEjemplo() {
        // Clientes de ejemplo
        Cliente cliente1 = new Cliente(nextId(), "Juan Martínez", "600111222");
        Cliente cliente2 = new Cliente(nextId(), "María López", "600333444");
        taller.agregarCliente(cliente1);
        taller.agregarCliente(cliente2);
        
        // Vehículos de ejemplo
        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota", "Corolla", cliente1);
        Vehiculo vehiculo2 = new Vehiculo("XYZ789", "Renault", "Clio", cliente2);
        cliente1.agregarVehiculo(vehiculo1);
        cliente2.agregarVehiculo(vehiculo2);
        taller.agregarVehiculo(vehiculo1);
        taller.agregarVehiculo(vehiculo2);
        
        // Empleados de ejemplo
        Mecanico mecanico1 = new Mecanico(nextId(), "Carlos Gómez", "Mecánico", "Motor");
        Mecanico mecanico2 = new Mecanico(nextId(), "Ana Ruiz", "Mecánico", "Electricidad");
        taller.agregarEmpleado(mecanico1);
        taller.agregarEmpleado(mecanico2);
        
        // Piezas de ejemplo
        Proveedor proveedor1 = new Proveedor(nextId(), "Autopartes S.L.", "900100200");
        Pieza pieza1 = new Pieza(nextId(), "Filtro de aceite", 15.99, 50, proveedor1);
        Pieza pieza2 = new Pieza(nextId(), "Pastillas de freno", 45.50, 30, proveedor1);
        taller.agregarPieza(pieza1);
        taller.agregarPieza(pieza2);
        
        // Reparaciones de ejemplo
        Reparacion reparacion1 = new Reparacion(nextId(), vehiculo1, mecanico1, "Cambio de aceite", 50.0, "15/03/2023");
        reparacion1.agregarPieza(pieza1);
        vehiculo1.agregarReparacion(reparacion1);
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

    // Métodos completos para las otras gestiones (vehículos, empleados, reparaciones, etc.)
    // ... (implementar similar a los métodos de clientes)
    
    public static void main(String[] args) {
        new App().mostrarMenuPrincipal();
    }
}