package ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.impl;

import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.ProductoDao;

import java.util.ArrayList;
import java.util.UUID;

public class InMemoryProductoDao implements ProductoDao {

    private final ArrayList<Producto> productos = new ArrayList<>();

    @Override
    public Producto save(Producto p) {
        Producto producto = new Producto(
                p.getCodigo(),
                p.getNombre(),
                p.getMarca(),
                p.getPrecio(),
                p.getTipo(),
                p.getDescripcion(),
                p.getSpecsList()
        );
        this.productos.add(producto);
        return producto;
    }

    @Override
    public Producto findById(UUID uuid) {
        for(Producto producto: productos) {
            if (producto.getId().equals(uuid)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public Producto update(Producto p) {
        Producto productoUpdate = this.findById(p.getId());
        if (productoUpdate == null) {
            return null;
        }

        productoUpdate.setNombre(p.getNombre());
        productoUpdate.setMarca(p.getMarca());
        productoUpdate.setTipo(p.getTipo());
        productoUpdate.setPrecio(p.getPrecio());
        productoUpdate.setDescripcion(p.getDescripcion());
        productoUpdate.setSpecsList(p.getSpecsList());

        return productoUpdate;
    }

    @Override
    public boolean delete(String id) {
        UUID uuid = UUID.fromString(id);
        for(Producto producto: productos) {
            if (producto.getId().equals(uuid)) {
                productos.remove(producto);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Producto> listAll() {
        return productos;
    }
}
