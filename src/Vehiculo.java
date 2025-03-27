/**
 * Clase que representa un vehículo en el taller
 * Contiene información técnica y referencia a su dueño
 */
public class Vehiculo {
    // Atributos
    private String matricula;    // Identificador único
    private String marca;       // Fabricante (Ej: Ford)
    private String modelo;      // Modelo específico (Ej: Focus)
    private int año;            // Año de fabricación
    private Cliente propietario; // Dueño del vehículo

    /**
     * Constructor - Crea un nuevo vehículo
     * @param matricula Número de matrícula
     * @param marca Marca del vehículo
     * @param modelo Modelo específico
     * @param año Año de fabricación
     * @param propietario Cliente dueño del vehículo
     */
    public Vehiculo(String matricula, String marca, String modelo, int año, Cliente propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.propietario = propietario;
    }

    /**
     * Calcula la antigüedad del vehículo
     * @return Años de antigüedad (basado en año actual 2023)
     */
    public int calcularAntiguedad() {
        final int AÑO_ACTUAL = 2023; // Constante para simplificar
        return AÑO_ACTUAL - año;
    }

    // ========== GETTERS ==========
    // No hay setters porque no deberían modificarse estos datos
    
    public String getMatricula() { 
        return matricula; 
    }
    
    public String getMarca() { 
        return marca; 
    }
    
    public String getModelo() { 
        return modelo; 
    }
    
    public int getAño() { 
        return año; 
    }
    
    public Cliente getPropietario() { 
        return propietario; 
    }

    /**
     * Método toString - Representación textual del vehículo
     * @return String con información básica
     */
    @Override
    public String toString() {
        return marca + " " + modelo + " (" + año + ") - Mat: " + matricula;
    }
}