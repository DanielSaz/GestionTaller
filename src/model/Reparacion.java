package model;
import java.util.ArrayList;

public class Reparacion {
    private int id;
    private Vehiculo vehiculo;
    private Empleado empleado;
    private String descripcion;
    private double costo;
    private String fecha;  
    private ArrayList<Pieza> piezasUsadas;

    public Reparacion(int id, Vehiculo vehiculo, Empleado empleado, 
                     String descripcion, double costo, String fecha) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.descripcion = descripcion;
        this.costo = costo;
        this.fecha = fecha;
        this.piezasUsadas = new ArrayList<>();
    }

    public void agregarPieza(Pieza pieza) {
        piezasUsadas.add(pieza);
    }

    // Getters
    public int getId() { return id; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public Empleado getEmpleado() { return empleado; }
    public String getDescripcion() { return descripcion; }
    public double getCosto() { return costo; }
    public String getFecha() { return fecha; }
    public ArrayList<Pieza> getPiezasUsadas() { return piezasUsadas; }


    public void setCosto(double costo){
        if(costo >=0 ){
            this.costo = costo;
    }else {
        System.out.println("El costo no puede ser negativo");
    }
    }
}