package ar.edu.utn.frbb.tup.pereyraretail.persistance.dao;

import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;

import java.util.ArrayList;
import java.util.UUID;

public interface CategoriaDao {
    Categoria save(Categoria p);
    Categoria findById(UUID uuid);
    Categoria update(Categoria p);
    boolean delete(String id);
    ArrayList<Categoria> listAll();
    boolean existeCategoria(String categoria);

    Categoria buscarCategoria(String nombre);
}
