package ar.edu.utn.frbb.tup.pereyraretail.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class AltaProductoDto {
    @Valid

    @NotNull(message = "Código no puede ser nulo")
    @NotBlank(message = "Código no puede estar vacío")
    @Pattern(regexp = "[\\w-]*", message = "Código - Sólo caracteres alfanuméricos y guiones")
    @Size(min = 5, max = 23, message = "Código debe ser de entre 5 y 23 caracteres alfanuméricos y guiones")
    @Schema(name = "codigo", example = "AZ-909")
    private String codigo;

    @NotNull(message = "Nombre no puede ser nulo")
    @NotBlank(message = "Nombre no puede estar vacío")
    @Pattern(regexp = "[\\w- ]*", message = "Nombre - Sólo caracteres alfanuméricos y guiones")
    @Schema(name = "nombre", example = "Bicicleta RX-90")
    private String nombre;

    @NotNull(message = "Marca no puede ser nula")
    @NotBlank(message = "Marca no puede estar vacía")
    @Pattern(regexp = "[\\w- ]*", message = "Marca - Sólo caracteres alfanuméricos y guiones")
    @Schema(name = "marca", example = "Speed-Way")
    private String marca;

    @NotNull(message = "Categoría no puede ser nula")
    @NotBlank(message = "Categoría no puede estar vacía")
    @Pattern(regexp = "[\\w- ]*", message = "Categoría - Sólo caracteres alfanuméricos y guiones")
    @Schema(name = "categoria", example = "Vehiculos")
    private String categoria;

    @NotNull(message = "Precio no puede ser nulo")
    @PositiveOrZero(message = "Precio debe ser numérico, con decimales luego de un punto")
    @Schema(name = "precio", example = "19999.99")
    private Double precio;
    
    @NotNull(message = "Descripción no puede ser nulo")
    @NotBlank(message = "Descripción no puede estar vacío")
    @Pattern(regexp = "[\\w-!\"#$%&'()*+,-./:;<=>?@\\[\\]_| ]*", message = "Descripción - Sólo caracteres alfanuméricos y guiones")
    @Schema(name = "descripcion", example = "Bicicleta todo terreno!")
    private String descripcion;

    public AltaProductoDto(String codigo, String nombre, String marca, Double precio, String categoria, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setTipo(String categoria) {
        this.categoria = categoria;
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
