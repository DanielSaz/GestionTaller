public class Empleado {
    private int id;
    private String nombre;
    private String puesto;

    public Empleado(int id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }

    // Setters añadidos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
