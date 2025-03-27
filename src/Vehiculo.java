public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;  
    private Cliente propietario;

    public Vehiculo(String matricula, String marca, String modelo, Cliente propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public Cliente getPropietario() {
        return propietario;
    }

    public String mostrarInfo() {
        return "Matrícula: " + matricula + " | Marca: " + marca + 
               " | Modelo: " + modelo + "\nPropietario: " + propietario.mostrarInfo();
    }
}