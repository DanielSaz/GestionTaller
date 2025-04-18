package model;
public class Mecanico extends Empleado { //Hereda de la clase empleado 
    private String especialidad;

    public Mecanico(int id, String nombre, String puesto, String especialidad) {
        super(id, nombre, puesto); // Llama al constructor de la clase Empleado
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
}
