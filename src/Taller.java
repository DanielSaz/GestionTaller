import java.util.ArrayList;

public class Taller {
    private String nombre;
    private String direccion;
    private ArrayList<Empleado> empleados;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pieza> piezas;

    public Taller(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.empleados = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.piezas = new ArrayList<>();
    }

    // Métodos para agregar elementos
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarPieza(Pieza pieza) {
        piezas.add(pieza);
    }

    // Getters
    public ArrayList<Empleado> getEmpleados() { return empleados; }
    public ArrayList<Vehiculo> getVehiculos() { return vehiculos; }
    public ArrayList<Cliente> getClientes() { return clientes; }
    public ArrayList<Pieza> getPiezas() { return piezas; }
}
