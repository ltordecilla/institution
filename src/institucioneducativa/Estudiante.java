    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institucioneducativa;

/**
 * Clase que representa la información de un estudiante.
 */
public class Estudiante {

    private String identificacion;
    private String nombre;
    private String sexo;
    private int edad;
    private int grado;
    private String nombreAcudiente;
    private String telefonoAcudiente;

    public Estudiante(String identificacion, String nombre, String sexo,
                      int edad, int grado, String nombreAcudiente,
                      String telefonoAcudiente) {

        this.identificacion = identificacion;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.grado = grado;
        this.nombreAcudiente = nombreAcudiente;
        this.telefonoAcudiente = telefonoAcudiente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getTelefonoAcudiente() {
        return telefonoAcudiente;
    }

    public void setTelefonoAcudiente(String telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
    }

    @Override
    public String toString() {
        return identificacion + " - " + nombre;
    }
}