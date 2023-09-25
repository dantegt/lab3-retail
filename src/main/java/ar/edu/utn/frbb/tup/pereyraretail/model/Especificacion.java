package ar.edu.utn.frbb.tup.pereyraretail.model;

public class Especificacion {
    private String categoria;
    private String titulo;
    private String valor;

    public Especificacion(String categoria, String titulo, String valor) {
        this.categoria = categoria;
        this.titulo = titulo;
        this.valor = valor;
    }

    public Especificacion(String categoria, String titulo) {
        this(categoria, titulo, "");
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getValor() {
        return valor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
