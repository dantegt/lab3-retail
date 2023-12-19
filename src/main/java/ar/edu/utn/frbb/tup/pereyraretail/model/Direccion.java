package ar.edu.utn.frbb.tup.pereyraretail.model;

public class Direccion {
    private String calle;
    private String numero;
    private String tipo;
    private String pisoDepto;
    private String provincia;
    private String ciudad;
    private String codigoPostal;

    public Direccion(String calle, String numero, String tipo, String pisoDepto, String provincia, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.tipo = tipo;
        this.pisoDepto = pisoDepto;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String calle() {
        return calle;
    }

    public Direccion setCalle(String calle) {
        this.calle = calle;
        return this;
    }

    public String numero() {
        return numero;
    }

    public Direccion setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String tipo() {
        return tipo;
    }

    public Direccion setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String pisoDepto() {
        return pisoDepto;
    }

    public Direccion setPisoDepto(String pisoDepto) {
        this.pisoDepto = pisoDepto;
        return this;
    }

    public String provincia() {
        return provincia;
    }

    public Direccion setProvincia(String provincia) {
        this.provincia = provincia;
        return this;
    }

    public String ciudad() {
        return ciudad;
    }

    public Direccion setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public String codigoPostal() {
        return codigoPostal;
    }

    public Direccion setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
        return this;
    }
}
