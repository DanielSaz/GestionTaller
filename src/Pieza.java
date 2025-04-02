public class Pieza {
    private int id;
    private String nombre;
    private double precio;
    private int cantidadStock;
    private Proveedor proveedor;

    public Pieza(int id, String nombre, double precio, int cantidadStock, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.proveedor = proveedor;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidadStock() { return cantidadStock; }
    public Proveedor getProveedor() { return proveedor; }


    //Setters
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
}