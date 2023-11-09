package co.com.delichori.model;

public class Administrador {


    private int cedulaAdministrador;
    private String nombreAdministrador;
    private String apellidoAdministrador;
    private String email;
    private String clave;

    public Administrador(){

    }

    public Administrador(int cedulaAdministrador, String nombreAdministrador, String apellidoAdministrador, String email, String clave) {
        this.cedulaAdministrador = cedulaAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.email = email;
        this.clave = clave;
    }

    public Administrador(String email) {

    }

    public Administrador(int cedulaAdministrador, String nombreAdministrador, String apellidoAdministrador, String clave) {
        this.cedulaAdministrador = cedulaAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
        this.clave = clave;

    }

    public int getCedulaAdministrador() {
        return cedulaAdministrador;
    }

    public void setCedulaAdministrador(int cedulaAdministrador) {
        this.cedulaAdministrador = cedulaAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

