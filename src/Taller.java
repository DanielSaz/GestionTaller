import java.util.ArrayList;

public class Taller {
    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> servicios;
    
    public Taller() {
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }
    
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
    
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public ArrayList<Servicio> getServicios() {
        return servicios;
    }
}