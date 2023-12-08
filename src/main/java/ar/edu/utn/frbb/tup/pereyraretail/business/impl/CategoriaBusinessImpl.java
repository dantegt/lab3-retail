package ar.edu.utn.frbb.tup.pereyraretail.business.impl;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class CategoriaBusinessImpl implements CategoriaBusiness {
    @Autowired
    CategoriaDao categoriaDao;

    @Override
    public Categoria getCategoria(UUID uuid) {
        ArrayList<Categoria> categorias = categoriaDao.listAll();
        for(Categoria categoria: categorias) {
            if (categoria.getId().equals(uuid)) {
                return categoria;
            }
        }
        return null;
    }

    @Override
    public Categoria getCategoriaNombre(String nombre) {
        ArrayList<Categoria> categorias = categoriaDao.listAll();
        for(Categoria categoria: categorias) {
            if (categoria.getNombre().equals(nombre)) {
                return categoria;
            }
        }
        return null;
    }

    public Categoria altaCategoria(AltaCategoriaDto dto) {
        Categoria categoria = new Categoria(
                dto.getNombre(),
                dto.getDescripcion()
        );
        return categoriaDao.save(categoria);
    }

    @Override
    public ArrayList<Categoria> listCategorias() {
        return categoriaDao.listAll();
    }

    @Override
    public ArrayList<Categoria> buscarCategorias(String nombre) {
        ArrayList<Categoria> categorias = categoriaDao.listAll();
        ArrayList<Categoria> filtered = new ArrayList<>();
        for(Categoria categoria: categorias) {
            if (categoria.getNombre().contains(nombre)) {
                filtered.add(categoria);
            }
        }
        if(filtered.size() == 0) { return null; }
        return filtered;
    }

    @Override
    public boolean existeCategoria(String nombre) {
        ArrayList<Categoria> categorias = categoriaDao.listAll();
        for(Categoria categoria: categorias) {
            if (categoria.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

}
