package ar.edu.utn.frbb.tup.pereyraretail.business;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;

import java.util.ArrayList;
import java.util.UUID;

public interface CategoriaBusiness {
    Categoria getCategoria(UUID uuid);
    Categoria getCategoriaNombre(String nombre);
    Categoria altaCategoria(AltaCategoriaDto categoriaDto);
    ArrayList<Categoria> listCategorias();
    ArrayList<Categoria> buscarCategorias(String nombre);
    boolean existeCategoria(String categoria);
}
