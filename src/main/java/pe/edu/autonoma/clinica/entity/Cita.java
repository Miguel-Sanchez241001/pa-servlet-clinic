package pe.edu.autonoma.clinica.entity;

public class Cita {
    private Integer id;
    private String asunto;
    private Paciente pacienteId;
    private Doctor doctorId;
    private String fecha;

    public Cita(String asunto, Paciente pacienteId, Doctor doctorId, String fecha) {
        this.asunto = asunto;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.fecha = fecha;
    }

    public Cita(Integer id, String asunto, Paciente pacienteId, Doctor doctorId, String fecha) {
        this.id = id;
        this.asunto = asunto;
        this.pacienteId = pacienteId;
        this.doctorId = doctorId;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Paciente getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Paciente pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
