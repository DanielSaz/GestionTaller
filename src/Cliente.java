public class Cliente {
    
    private String dni;
    private String nombre;
    private int telefono; 
     

    public Cliente(String dni, String nombre, int telefono) {
        
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getTelefono() {
        return telefono;
    }

    public String mostrarInfo() {
        return "Nombre: " + nombre + " | DNI: " + dni + " | Teléfono: " + telefono;
    }
    
}