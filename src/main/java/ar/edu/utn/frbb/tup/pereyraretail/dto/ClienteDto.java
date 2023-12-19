package ar.edu.utn.frbb.tup.pereyraretail.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class ClienteDto {
    @Valid

    @NotNull(message = "Nombre no puede ser nulo")
    @NotBlank(message = "Nombre no puede estar vacío")
    @Pattern(regexp = "[\\w- ]*", message = "Nombre - Sólo caracteres alfanuméricos y guiones")
    @Size(min = 2, max = 155, message = "Nombre debe ser tener entre 5 y 23 caracteres alfanuméricos y guiones")
    @Schema(name = "nombre", example = "Marina")
    private String nombre;

    @NotNull(message = "Apellido no puede ser nulo")
    @NotBlank(message = "Apellido no puede estar vacío")
    @Pattern(regexp = "[\\w- ]*", message = "Apellido - Sólo caracteres alfanuméricos y guiones")
    @Size(min = 2, max = 155, message = "Apellido debe ser tener entre 5 y 23 caracteres alfanuméricos y guiones")
    @Schema(name = "apellido", example = "Paz")
    private String apellido;

    @NotNull(message = "Email no puede ser nulo")
    @NotBlank(message = "Email no puede estar vacío")
    @Email(message = "Debe ser un Email válido")
    @Schema(name = "email", example = "marina.paz@email.com")
    private String email;

    @NotNull(message = "DNI no puede ser nulo")
    @NotBlank(message = "DNI no puede estar vacío")
    @Positive(message = "DNI debe ser un número positivo")
    @Size(min = 7, max = 8, message = "DNI debe ser tener entre 7 y 8 dígitos")
    @Schema(name = "dni", example = "7665544")
    private int dni;

    @NotNull(message = "Código de Area no puede ser nulo")
    @NotBlank(message = "Código de Area no puede estar vacío")
    @Positive(message = "Código de Area debe ser un número positivo")
    @Size(min = 2, max = 4, message = "Código de Area debe ser tener entre 2 y 4 dígitos, sin 0 inicial")
    @Schema(name = "codigoArea", example = "11")
    private int codigoArea;

    @NotNull(message = "Teléfono no puede ser nulo")
    @NotBlank(message = "Teléfono no puede estar vacío")
    @Positive(message = "Teléfono debe ser un número positivo")
    @Size(min = 6, max = 8, message = "Teléfono debe ser tener entre 6 y 8 dígitos, sin incluir Código de Area, ni 0, ni 15 inicial")
    @Schema(name = "telefono", example = "22334455")
    private int telefono;

    public ClienteDto(String nombre, String apellido, String email, int dni, int codigoArea, int telefono) {
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

    public ClienteDto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String apellido() {
        return apellido;
    }

    public ClienteDto setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String email() {
        return email;
    }

    public ClienteDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public int dni() {
        return dni;
    }

    public ClienteDto setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public int codigoArea() {
        return codigoArea;
    }

    public ClienteDto setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
        return this;
    }

    public int telefono() {
        return telefono;
    }

    public ClienteDto setTelefono(int telefono) {
        this.telefono = telefono;
        return this;
    }
}
