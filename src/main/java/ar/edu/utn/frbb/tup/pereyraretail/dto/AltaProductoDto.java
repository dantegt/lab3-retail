package ar.edu.utn.frbb.tup.pereyraretail.dto;

import ar.edu.utn.frbb.tup.pereyraretail.model.Especificacion;

import java.util.ArrayList;
import java.util.UUID;

public class AltaProductoDto {
    private String codigo;
    private String nombre;
    private String marca;
    private String tipo;
    private Double precio;
    private String descripcion;

    public AltaProductoDto(String codigo, String nombre, String marca, Double precio, String tipo, String descripcion, ArrayList<Especificacion> specs) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public AltaProductoDto(){}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
