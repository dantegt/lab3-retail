package ar.edu.utn.frbb.tup.pereyraretail.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class AltaCategoriaDto {
    @Schema(name = "nombre", example = "Hogar")
    private String nombre;
    @Schema(name = "descripcion", example = "Todo para equipar tu Hogar.")
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public AltaCategoriaDto() {
        super();
    }

    public AltaCategoriaDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
