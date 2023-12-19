package ar.edu.utn.frbb.tup.pereyraretail.model;

public class Especificacion {
    private String nombre;
    private String valor;
    private String unidad;

    public Especificacion(String nombre, String valor, String unidad) {
        this.nombre = nombre;
        this.valor = valor;
        this.unidad = unidad;
    }

    public Especificacion(String categoria, String valor) {
        this(categoria, valor, "");
    }

    public String getNombre() {
        return nombre;
    }
    public String getValor() {
        return valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

}
