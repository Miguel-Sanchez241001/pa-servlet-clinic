package pe.edu.autonoma.clinica.entity;

public class Turno {
    private Integer id;
    private String tanda;

    public Turno(String tanda) {
        this.tanda = tanda;
    }

    public Turno(Integer id, String tanda) {
        this.id = id;
        this.tanda = tanda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTanda() {
        return tanda;
    }

    public void setTanda(String tanda) {
        this.tanda = tanda;
    }
}
