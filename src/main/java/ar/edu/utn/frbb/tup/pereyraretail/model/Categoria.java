package ar.edu.utn.frbb.tup.pereyraretail.model;

import java.util.UUID;

public class Categoria {
    private UUID id;
	private String nombre;
	private String descripcion;

	public UUID getId() {
		return id;
	}

	public void setId(UUID uuid) {
		this.id = uuid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria () {
		this.id = UUID.randomUUID();
	}

	public Categoria(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = UUID.randomUUID();
	}

	public Categoria(String nombre) {
		this(nombre, "");
	}
}
