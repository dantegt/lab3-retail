package ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.impl;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class InMemoryCategoriaDao implements CategoriaDao {

    private final ArrayList<Categoria> categorias = new ArrayList<>();

    @Override
    public Categoria save(Categoria c) {
        Categoria categoria = new Categoria(
                c.getNombre(),
                c.getDescripcion()
        );
        this.categorias.add(categoria);
        return categoria;
    }

    @Override
    public Categoria findById(UUID uuid) {
        for(Categoria categoria: categorias) {
            if (categoria.getId().equals(uuid)) {
                return categoria;
            }
        }
        return null;
    }

    @Override
    public boolean existeCategoria(String nombre) {
        for(Categoria categoria: categorias) {
            if (categoria.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Categoria update(AltaCategoriaDto c, UUID uuid) {
        for(Categoria categoria: categorias) {
            if (categoria.getId().equals(uuid)) {
                categoria.setNombre(c.getNombre());
                categoria.setDescripcion(c.getDescripcion());
                return categoria;
            }
        }
        return null;
    }

    @Override
    public boolean delete(UUID uuid) {
        for(Categoria categoria: categorias) {
            if (categoria.getId().equals(uuid)) {
                categorias.remove(categoria);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Categoria> listAll() {
        return categorias;
    }

    @Override
    public Categoria buscarCategoria(String nombre) {
        for(Categoria categoria: categorias) {
            if (categoria.getNombre().equalsIgnoreCase(nombre)) {
                return categoria;
            }
        }
        return null;
    }
}
