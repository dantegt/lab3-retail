package ar.edu.utn.frbb.tup.pereyraretail.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Categoria {
    private Long id;
	private String nombre;
	private String descripcion;
	private ArrayList<Producto> ListaProductos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ArrayList<Producto> getListaProductos() {
		return ListaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		ListaProductos = listaProductos;
	}

	public Categoria () {}

	public Categoria(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id = new AtomicLong().incrementAndGet();
	}

	public Categoria(String nombre) {
		this(nombre, "");
	}

	public Producto agregarProducto(Producto producto) {
		List<Producto> lista = this.getListaProductos();
		lista.add(producto);
		return producto;
	}
}
