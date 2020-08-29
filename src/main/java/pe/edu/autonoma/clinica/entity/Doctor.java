package pe.edu.autonoma.clinica.entity;

public class Doctor {
    private Integer id;
    private String nombreApellido;
    private String email;
    private String telefono;
    private String numeroColegiatura;
    private Especialidad especialidad;
    private Turno turno;

    public Doctor(String nombreApellido, String email, String telefono, String numeroColegiatura, Especialidad especialidad, Turno turno) {
        this.nombreApellido = nombreApellido;
        this.email = email;
        this.telefono = telefono;
        this.numeroColegiatura = numeroColegiatura;
        this.especialidad = especialidad;
        this.turno = turno;
    }

    public Doctor(Integer id, String nombreApellido, String email, String telefono, String numeroColegiatura, Especialidad especialidad, Turno turno) {
        this.id = id;
        this.nombreApellido = nombreApellido;
        this.email = email;
        this.telefono = telefono;
        this.numeroColegiatura = numeroColegiatura;
        this.especialidad = especialidad;
        this.turno = turno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNumeroColegiatura() {
        return numeroColegiatura;
    }

    public void setNumeroColegiatura(String numeroColegiatura) {
        this.numeroColegiatura = numeroColegiatura;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
