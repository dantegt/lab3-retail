package ar.edu.utn.frbb.tup.pereyraretail.model;

public class Item {
    private Producto producto;
    private Double precio;
    private int cantidad;

    public Item(Producto producto, Double precio, int cantidad) {
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto producto() {
        return producto;
    }

    public Item setProducto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public Double precio() {
        return precio;
    }

    public Item setPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public int cantidad() {
        return cantidad;
    }

    public Item setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }
}
