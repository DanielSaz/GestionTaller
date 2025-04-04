package model;
import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private ArrayList<Vehiculo> vehiculos;

    public Cliente(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public ArrayList<Vehiculo> getVehiculos() { return vehiculos; }

     // Setters añadidos para permitir modificaciones
     public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public void setTelefono(String telefono) {
        // Validación del teléfono
        if(telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono;
        }
    }
}