package ar.edu.utn.frbb.tup.pereyraretail.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Producto {
    private UUID id;
    private String codigo;
    private String nombre;
    private String marca;
    private String categoria;
    private Double precio;
    private String descripcion;
    private ArrayList<Especificacion> specs;

    public Producto(String codigo, String nombre, String marca, Double precio, String categoria, String descripcion, ArrayList<Especificacion> specs) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.specs = specs;
        this.id = UUID.randomUUID();
    }

    public Producto(String codigo, String nombre, String marca, Double precio, String categoria, String descripcion) {
        this(codigo, nombre, marca, precio, categoria, descripcion, new ArrayList<>());
    }

    public Producto(String codigo, String nombre, String marca, Double precio) {
        this(codigo, nombre, marca, precio, "", "", new ArrayList<>());
    }

    public Producto(){
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public void setCategoria(String categoria) {
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
    public void setSpecs(ArrayList<Especificacion> specs) {
        this.specs = specs;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Especificacion> getSpecsList() {
        return specs;
    }

    public void setSpecsList(ArrayList<Especificacion> specs) {
        this.specs = specs;
    }

    public Especificacion getSpecById(int id) {
        return specs.get(id);
    }

    public void setSpec(Especificacion spec) {
        this.specs.add(spec);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return getCodigo().equals(producto.getCodigo()) && getNombre().equals(producto.getNombre()) && getMarca().equals(producto.getMarca()) && getCategoria().equals(producto.getCategoria()) && getPrecio().equals(producto.getPrecio()) && getDescripcion().equals(producto.getDescripcion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getNombre(), getMarca(), getCategoria(), getPrecio(), getDescripcion());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", specs=" + specs +
                '}';
    }
}
