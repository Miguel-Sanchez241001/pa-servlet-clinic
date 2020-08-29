package pe.edu.autonoma.clinica.entity;

public class Paciente {
    private String dni;
    private String nombreApellido;
    private String email;
    private String telefono;
    private Integer edad;

    public Paciente(String nombreApellido, String email, String telefono, Integer edad) {
        this.nombreApellido = nombreApellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }

    public Paciente(String dni, String nombreApellido, String email, String telefono, Integer edad) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
