package ar.edu.utn.frbb.tup.pereyraretail.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AltaCategoriaDto {
    @NotNull(message = "Nombre no puede ser nulo")
    @NotBlank(message = "Nombre no puede estar vacío")
    @Pattern(regexp = "[\\w- ]*", message = "Nombre - Sólo caracteres alfanuméricos y guiones")
    @Schema(name = "nombre", example = "Hogar")
    private String nombre;

    @NotNull(message = "Descripción no puede ser nulo")
    @NotBlank(message = "Descripción no puede estar vacío")
    @Pattern(regexp = "[\\w-!\"#$%&'()*+,-./:;<=>?@\\[\\]_| ]*", message = "Descripción - Sólo caracteres alfanuméricos y guiones")
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
