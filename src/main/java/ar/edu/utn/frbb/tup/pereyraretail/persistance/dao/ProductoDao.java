package ar.edu.utn.frbb.tup.pereyraretail.persistance.dao;

import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;

import java.util.ArrayList;
import java.util.UUID;

public interface ProductoDao {
    Producto save(Producto p);
    Producto findById(UUID uuid);
    Producto update(Producto p);
    boolean delete(String id);
    ArrayList<Producto> listAll();
}
