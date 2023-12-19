package ar.edu.utn.frbb.tup.pereyraretail.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Compra {
    private UUID id;
    private ArrayList<Item> items;
    private LocalDateTime fecha;
    private Cliente cliente;
    private String tipoPago;
    private String tipoEnvio;
    private Direccion direccionEnvio;
    private Double subtotalItems;
    private Double costoEnvio;
    private Double total;

    public Compra(ArrayList<Item> items, LocalDateTime fecha, Cliente cliente, String tipoPago, String tipoEnvio, Direccion direccionEnvio, Double subtotalItems, Double costoEnvio, Double total) {
        this.items = items;
        this.fecha = fecha;
        this.cliente = cliente;
        this.tipoPago = tipoPago;
        this.tipoEnvio = tipoEnvio;
        this.direccionEnvio = direccionEnvio;
        this.subtotalItems = subtotalItems;
        this.costoEnvio = costoEnvio;
        this.total = total;
        this.id = UUID.randomUUID();
    }

    public UUID id() {
        return id;
    }

    public Compra setId(UUID id) {
        this.id = id;
        return this;
    }

    public ArrayList<Item> items() {
        return items;
    }

    public Compra setItems(ArrayList<Item> items) {
        this.items = items;
        return this;
    }

    public LocalDateTime fecha() {
        return fecha;
    }

    public Compra setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public Cliente cliente() {
        return cliente;
    }

    public Compra setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public String tipoPago() {
        return tipoPago;
    }

    public Compra setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
        return this;
    }

    public String tipoEnvio() {
        return tipoEnvio;
    }

    public Compra setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
        return this;
    }

    public Direccion direccionEnvio() {
        return direccionEnvio;
    }

    public Compra setDireccionEnvio(Direccion direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
        return this;
    }

    public Double subtotalItems() {
        return subtotalItems;
    }

    public Compra setSubtotalItems(Double subtotalItems) {
        this.subtotalItems = subtotalItems;
        return this;
    }

    public Double costoEnvio() {
        return costoEnvio;
    }

    public Compra setCostoEnvio(Double costoEnvio) {
        this.costoEnvio = costoEnvio;
        return this;
    }

    public Double total() {
        return total;
    }

    public Compra setTotal(Double total) {
        this.total = total;
        return this;
    }
}
