import java.util.ArrayList;

/**
 * Clase que registra una reparación concreta
 * Relaciona un vehículo con los servicios aplicados
 */
public class Reparacion {
    private String id;                  // Identificador único
    private Vehiculo vehiculo;          // Vehículo reparado
    private ArrayList<Servicio> servicios; // Servicios aplicados
    private String estado;              // Estado actual
    private String fecha;               // Fecha en formato dd/mm/aaaa

    /**
     * Constructor - Crea una nueva reparación
     * @param id Identificador único
     * @param vehiculo Vehículo a reparar
     * @param fecha Fecha de la reparación
     */
    public Reparacion(String id, Vehiculo vehiculo, String fecha) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.estado = "Pendiente"; // Estado inicial
        this.servicios = new ArrayList<Servicio>();
    }

    /**
     * Añade un servicio a esta reparación
     * @param servicio Servicio a añadir
     */
    public void añadirServicio(Servicio servicio) {
        servicios.add(servicio);
        System.out.println("Servicio añadido: " + servicio.getNombre());
    }

    /**
     * Calcula el precio total sumando todos los servicios
     * @return Total en euros
     */
    public double calcularTotal() {
        double total = 0;
        for(Servicio s : servicios) {
            total += s.getPrecio();
        }
        return total;
    }

    /**
     * Cambia el estado de la reparación
     * @param nuevoEstado Nuevo estado a asignar
     */
    public void cambiarEstado(String nuevoEstado) {
        // Validamos los estados posibles
        if(nuevoEstado.equals("Pendiente") || 
           nuevoEstado.equals("En progreso") || 
           nuevoEstado.equals("Completada")) {
            estado = nuevoEstado;
            System.out.println("Estado actualizado a: " + estado);
        } else {
            System.out.println("Error: Estado no válido");
        }
    }

    // ========== GETTERS ==========
    
    public String getId() { 
        return id; 
    }
    
    public Vehiculo getVehiculo() { 
        return vehiculo; 
    }
    
    public String getEstado() { 
        return estado; 
    }
    
    public String getFecha() { 
        return fecha; 
    }
    
    public ArrayList<Servicio> getServicios() { 
        return servicios; 
    }

    /**
     * Método toString - Muestra información resumida
     */
    @Override
    public String toString() {
        return String.format("Rep#%s - %s - %s - %.2f€ - %s", 
               id, vehiculo.getMatricula(), fecha, calcularTotal(), estado);
    }
}
