package ar.edu.utn.frbb.tup.pereyraretail.business;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemExistsException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;

import java.util.ArrayList;

public interface CategoriaBusiness {
    Categoria getCategoria(String id) throws ItemNotFoundException;
    Categoria getCategoriaNombre(String nombre) throws ItemNotFoundException;
    Categoria altaCategoria(AltaCategoriaDto categoriaDto) throws ItemExistsException, ItemNotFoundException;
    Categoria editarCategoria(AltaCategoriaDto dto, String id) throws ItemNotFoundException;
    boolean borrarCategoria(String id) throws ItemNotFoundException;
    ArrayList<Categoria> listCategorias();
    ArrayList<Categoria> buscarCategorias(String nombre) throws ItemNotFoundException;
    boolean existeCategoria(String categoria, boolean debeExistir) throws ItemNotFoundException, ItemExistsException;
    ArrayList<Categoria> mockCategorias() throws ItemExistsException, ItemNotFoundException;
}
