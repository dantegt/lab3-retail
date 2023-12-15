package ar.edu.utn.frbb.tup.pereyraretail.persistance.dao;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;

import java.util.ArrayList;
import java.util.UUID;

public interface ProductoDao {
    Producto save(AltaProductoDto p);
    Producto findById(UUID uuid);
    Producto update(AltaProductoDto p, UUID uuid);
    boolean delete(UUID id);
    ArrayList<Producto> listAll();
    ArrayList<Producto> listPorCategoria(String categoria);
    ArrayList<Producto> searchProductos(String query);
}
