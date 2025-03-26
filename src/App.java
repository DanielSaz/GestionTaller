import java.util.Date;

public class App {
    public static void main(String[] args) {
        Taller taller = new Taller();
        
        Cliente cliente1 = new Cliente("12345678A", "Juan Pérez", "Calle Mayor 1", "600123456");
        Cliente cliente2 = new Cliente("87654321B", "María López", "Avenida Central 5", "655987321");
        
        taller.agregarCliente(cliente1);
        taller.agregarCliente(cliente2);
        
        Vehiculo vehiculo1 = new Vehiculo("1234ABC", "Toyota", "Corolla", 2018, cliente1);
        Vehiculo vehiculo2 = new Vehiculo("5678DEF", "Ford", "Focus", 2020, cliente2);
        
        taller.agregarVehiculo(vehiculo1);
        taller.agregarVehiculo(vehiculo2);
        
        Servicio servicio1 = new Servicio("SER001", new Date(), "Cambio de aceite", 50.0, vehiculo1);
        Servicio servicio2 = new Servicio("SER002", new Date(), "Revisión general", 80.0, vehiculo2);
        
        taller.agregarServicio(servicio1);
        taller.agregarServicio(servicio2);
        
        System.out.println("=== CLIENTES DEL TALLER ===");
        for (Cliente cliente : taller.getClientes()) {
            System.out.println(cliente);
        }
        
        System.out.println("\n=== VEHÍCULOS EN EL TALLER ===");
        for (Vehiculo vehiculo : taller.getVehiculos()) {
            System.out.println(vehiculo);
        }
        
        System.out.println("\n=== SERVICIOS REALIZADOS ===");
        for (Servicio servicio : taller.getServicios()) {
            System.out.println(servicio);
        }
    }
}