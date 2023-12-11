package ar.edu.utn.frbb.tup.pereyraretail.persistance.dao;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;

import java.util.ArrayList;
import java.util.UUID;

public interface CategoriaDao {
    Categoria save(Categoria p);
    Categoria findById(UUID uuid);
    Categoria update(AltaCategoriaDto p, UUID uuid);
    boolean delete(UUID id);
    ArrayList<Categoria> listAll();
    boolean existeCategoria(String categoria);

    Categoria buscarCategoria(String nombre);
}
