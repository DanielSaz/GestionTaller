import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal que gestiona el taller mecánico
 * Contiene el menú interactivo y la lógica principal
 */
public class App {
    // Colecciones principales
    private ArrayList<Cliente> clientes;
    private ArrayList<Servicio> servicios;
    private ArrayList<Reparacion> reparaciones;
    private Scanner scanner;
    private int contadorReparaciones = 1; // Para generar IDs únicos

    /**
     * Constructor - Inicializa las estructuras de datos
     */
    public App() {
        clientes = new ArrayList<>();
        servicios = new ArrayList<>();
        reparaciones = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Método principal que inicia la aplicación
     */
    public void iniciar() {
        System.out.println("=== SISTEMA DE GESTIÓN DE TALLER MECÁNICO ===");
        
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerOpcion();
            
            switch(opcion) {
                case 1: gestionClientes(); break;
                case 2: gestionVehiculos(); break;
                case 3: gestionServicios(); break;
                case 4: gestionReparaciones(); break;
                case 5: mostrarResumen(); break;
                case 0: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
        
        scanner.close();
    }

    /**
     * Muestra el menú principal
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Gestión de Clientes");
        System.out.println("2. Gestión de Vehículos");
        System.out.println("3. Gestión de Servicios");
        System.out.println("4. Gestión de Reparaciones");
        System.out.println("5. Mostrar Resumen General");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Lee una opción del menú validando que sea numérica
     * @return Opción seleccionada
     */
    private int leerOpcion() {
        while(!scanner.hasNextInt()) {
            System.out.println("Error: Debe ingresar un número.");
            scanner.next(); // Limpiar entrada incorrecta
            System.out.print("Seleccione una opción: ");
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return opcion;
    }

    // ========== MÉTODOS DE GESTIÓN DE CLIENTES ==========
    
    private void gestionClientes() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CLIENTES ===");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Listar todos los clientes");
            System.out.println("3. Buscar cliente por DNI");
            System.out.println("4. Modificar teléfono de cliente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione: ");
            
            opcion = leerOpcion();
            
            switch(opcion) {
                case 1: registrarCliente(); break;
                case 2: listarClientes(); break;
                case 3: buscarCliente(); break;
                case 4: modificarTelefono(); break;
                case 0: break;
                default: System.out.println("Opción no válida.");
            }
        } while(opcion != 0);
    }

    private void registrarCliente() {
        System.out.println("\n--- REGISTRO DE CLIENTE ---");
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        
        // Verificar si el cliente ya existe
        if(buscarClientePorDni(dni) != null) {
            System.out.println("Error: Ya existe un cliente con este DNI.");
            return;
        }
        
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        
        Cliente nuevoCliente = new Cliente(dni, nombre, telefono);
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente!");
    }

    private void listarClientes() {
        if(clientes.isEmpty()) {
            System.out.println("\nNo hay clientes registrados.");
            return;
        }
        
        System.out.println("\n--- LISTADO DE CLIENTES ---");
        for(int i = 0; i < clientes.size(); i++) {
            System.out.println((i+1) + ". " + clientes.get(i));
        }
    }

    private void buscarCliente() {
        System.out.print("\nIngrese DNI a buscar: ");
        String dni = scanner.nextLine();
        
        Cliente cliente = buscarClientePorDni(dni);
        if(cliente != null) {
            System.out.println("\n--- DATOS DEL CLIENTE ---");
            System.out.println(cliente);
            System.out.println("Vehículos registrados: " + cliente.getVehiculos().size());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private void modificarTelefono() {
        System.out.print("\nIngrese DNI del cliente: ");
        String dni = scanner.nextLine();
        
        Cliente cliente = buscarClientePorDni(dni);
        if(cliente != null) {
            System.out.print("Nuevo número de teléfono: ");
            String nuevoTelefono = scanner.nextLine();
            cliente.setTelefono(nuevoTelefono);
            System.out.println("Teléfono actualizado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    // ========== MÉTODOS AUXILIARES ==========
    
    private Cliente buscarClientePorDni(String dni) {
        for(Cliente c : clientes) {
            if(c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    // [Resto de métodos de gestión de vehículos, servicios y reparaciones...]
    // Estos seguirían el mismo patrón que los métodos de gestión de clientes

    /**
     * Punto de entrada principal del programa
     */
    public static void main(String[] args) {
        App app = new App();
        app.iniciar();
    }
}