package ar.edu.utn.frbb.tup.pereyraretail.model;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private int dni;
    private int codigoArea;
    private int telefono;

    public Cliente(String nombre, String apellido, String email, int dni, int codigoArea, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.codigoArea = codigoArea;
        this.telefono = telefono;
    }

    public String nombre() {
        return nombre;
    }

    public Cliente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String apellido() {
        return apellido;
    }

    public Cliente setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String email() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }

    public int dni() {
        return dni;
    }

    public Cliente setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public int codigoArea() {
        return codigoArea;
    }

    public Cliente setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
        return this;
    }

    public int telefono() {
        return telefono;
    }

    public Cliente setTelefono(int telefono) {
        this.telefono = telefono;
        return this;
    }
}
