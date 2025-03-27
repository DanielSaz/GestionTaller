import java.util.ArrayList;

/**
 * Clase que representa a un cliente del taller
 * Contiene información personal y sus vehículos asociados
 */
public class Cliente {
    // Atributos de la clase (privados para encapsulación)
    private String dni;          // Documento de identidad
    private String nombre;       // Nombre completo
    private String telefono;     // Número de contacto
    private ArrayList<Vehiculo> vehiculos; // Lista de vehículos del cliente

    /**
     * Constructor - Inicializa un nuevo cliente
     * @param dni Número de documento identificativo
     * @param nombre Nombre completo del cliente
     * @param telefono Número de teléfono de contacto
     */
    public Cliente(String dni, String nombre, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.vehiculos = new ArrayList<Vehiculo>(); // Inicializa lista vacía
    }

    /**
     * Añade un vehículo a la lista del cliente
     * @param v Objeto Vehiculo a añadir
     */
    public void añadirVehiculo(Vehiculo v) {
        vehiculos.add(v); // Añade el vehículo a la lista
        System.out.println("Vehículo añadido correctamente a " + nombre);
    }

    /**
     * Muestra por pantalla todos los vehículos del cliente
     */
    public void listarVehiculos() {
        System.out.println("\n--- Vehículos de " + nombre + " ---");
        // Recorre la lista con un for tradicional (mejor para 1º DAM)
        for(int i = 0; i < vehiculos.size(); i++) {
            // Muestra número, matrícula y modelo
            System.out.println((i+1) + ". " + vehiculos.get(i).getMatricula() + 
                             " - " + vehiculos.get(i).getMarca() + 
                             " " + vehiculos.get(i).getModelo());
        }
    }

    // ========== GETTERS Y SETTERS ==========
    // Métodos para acceder a los atributos privados
    
    public String getDni() { 
        return dni; 
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    public String getTelefono() { 
        return telefono; 
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono; 
    }
    
    public ArrayList<Vehiculo> getVehiculos() { 
        return vehiculos; 
    }

    /**
     * Método toString - Representación textual del cliente
     * @return String con información del cliente
     */
    @Override
    public String toString() {
        return nombre + " (DNI: " + dni + ") - Tel: " + telefono + 
               " - Vehículos: " + vehiculos.size();
    }
}