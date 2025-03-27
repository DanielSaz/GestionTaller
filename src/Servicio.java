/**
 * Clase que representa un servicio de reparación
 * Contiene información sobre precio y duración
 */
public class Servicio {
    private String codigo;       // Código identificativo (ej: "S001")
    private String nombre;       // Nombre del servicio
    private String descripcion;  // Descripción detallada
    private double precio;       // Precio en euros
    private int duracion;        // Duración en minutos

    /**
     * Constructor - Crea un nuevo servicio
     * @param codigo Código único del servicio
     * @param nombre Nombre descriptivo
     * @param descripcion Detalles del servicio
     * @param precio Coste en euros
     * @param duracion Tiempo estimado en minutos
     */
    public Servicio(String codigo, String nombre, String descripcion, double precio, int duracion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
    }

    /**
     * Aplica un descuento al precio del servicio
     * @param porcentaje Descuento a aplicar (0-100)
     */
    public void aplicarDescuento(double porcentaje) {
        // Validamos que el descuento sea razonable
        if(porcentaje > 0 && porcentaje <= 20) { 
            precio = precio * (1 - porcentaje/100);
            System.out.printf("Descuento aplicado: %.2f%%\n", porcentaje);
        } else {
            System.out.println("Error: El descuento debe ser entre 1% y 20%");
        }
    }

    // ========== GETTERS ==========
    
    public String getCodigo() { 
        return codigo; 
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    public String getDescripcion() { 
        return descripcion; 
    }
    
    public double getPrecio() { 
        return precio; 
    }
    
    public int getDuracion() { 
        return duracion; 
    }

    /**
     * Método toString - Muestra información resumida
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %.2f€ - %d mins", 
               codigo, nombre, precio, duracion);
    }
}