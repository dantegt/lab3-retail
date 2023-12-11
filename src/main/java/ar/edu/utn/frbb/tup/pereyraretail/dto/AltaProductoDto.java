package ar.edu.utn.frbb.tup.pereyraretail.dto;

import ar.edu.utn.frbb.tup.pereyraretail.model.Especificacion;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;

public class AltaProductoDto {
    @Schema(name = "codigo", example = "AZ-909")
    private String codigo;
    @Schema(name = "nombre", example = "Bicicleta RX-90")
    private String nombre;
    @Schema(name = "marca", example = "Speed-Way")
    private String marca;
    @Schema(name = "tipo", example = "Vehiculos", allowableValues= { "Hogar", "Vehiculos" })
    private String tipo;
    @Schema(name = "precio", example = "19999.99")
    private Double precio;
    @Schema(name = "descripcion", example = "Bicicleta todo terreno!")
    private String descripcion;

    public AltaProductoDto(String codigo, String nombre, String marca, Double precio, String tipo, String descripcion) {
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
