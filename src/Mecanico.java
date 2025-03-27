public class Mecanico extends Empleado {
    private String especialidad;

    public Mecanico(int id, String nombre, String puesto, String especialidad) {
        super(id, nombre, puesto);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
