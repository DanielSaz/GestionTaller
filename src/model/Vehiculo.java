package model;
import java.util.ArrayList;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private Cliente propietario;
    private ArrayList<Reparacion> historialReparaciones;

    public Vehiculo(String matricula, String marca, String modelo, Cliente propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.historialReparaciones = new ArrayList<>();
    }

    public void agregarReparacion(Reparacion reparacion) {
        if(reparacion != null) {
            historialReparaciones.add(reparacion);
        }
    }

    // Getters
    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public Cliente getPropietario() { return propietario; }
    public ArrayList<Reparacion> getHistorialReparaciones() { return historialReparaciones; }

    // Setter
    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }
}