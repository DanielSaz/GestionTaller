public class Cliente {
    
     int id;
     String nombre;
     int telefono; 
     String direccion;
     String email;

    public Cliente(int id String nombre, int telefono, String direccion, String email) {
        
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String toString() {
        return "Cliente #" + id + ": " + nombre + " - Tel: " + telefono;
    }


}