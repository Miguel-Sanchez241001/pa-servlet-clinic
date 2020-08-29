package pe.edu.autonoma.clinica.entity;

public class Usuario {
    private Integer id;
    private String username;
    private String password;
    private boolean enable;
    private String name;

    public Usuario(String username, String password, boolean enable, String name) {
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.name = name;
    }

    public Usuario(Integer id, String username, String password, boolean enable, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
