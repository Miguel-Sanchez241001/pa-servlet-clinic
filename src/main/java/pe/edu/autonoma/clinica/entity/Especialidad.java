package pe.edu.autonoma.clinica.entity;

public class Especialidad {
    private Integer id;
    private String nombre;
    private Integer costo;

    public Especialidad(String nombre, Integer costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public Especialidad(Integer id, String nombre, Integer costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
}
