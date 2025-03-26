import java.util.Date;

public class Servicio {
    private String codigo;
    private Date fecha;
    private String descripcion;
    private double precio;
    private Vehiculo vehiculo;
    
    public Servicio(String codigo, Date fecha, String descripcion, double precio, Vehiculo vehiculo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
        this.vehiculo = vehiculo;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    @Override
    public String toString() {
        return "Servicio #" + codigo + " - " + descripcion + " - Precio: " + precio + "€ - " +
               "Vehículo: " + vehiculo.getMatricula() + " - Fecha: " + fecha;
    }
}