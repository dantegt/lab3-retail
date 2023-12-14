package ar.edu.utn.frbb.tup.pereyraretail.business.impl;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.InvalidUuidException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemExistsException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.CategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CategoriaBusinessImpl implements CategoriaBusiness {
    @Autowired
    CategoriaDao categoriaDao;

    @Override
    public Categoria getCategoria(String id) throws ItemNotFoundException {
        UUID uuid = validUuid(id);
        Categoria categoria = categoriaDao.findById(uuid);
        if(categoria == null) {
            throw new ItemNotFoundException("No existe esa categoria");
        }
        return categoria;
    }

    @Override
    public Categoria getCategoriaNombre(String nombre) throws ItemNotFoundException {
        ArrayList<Categoria> categorias = categoriaDao.listAll();
        for(Categoria categoria: categorias) {
            if (categoria.getNombre().equals(nombre)) {
                return categoria;
            }
        }
        throw new ItemNotFoundException("No existe esa categoria");
    }

    public Categoria altaCategoria(AltaCategoriaDto dto) throws ItemExistsException, ItemNotFoundException {
        Categoria categoria = new Categoria(
                dto.getNombre(),
                dto.getDescripcion()
        );
        boolean existe = existeCategoria(dto.getNombre(), false);
        return categoriaDao.save(categoria);
    }

    @Override
    public Categoria editarCategoria(AltaCategoriaDto dto, String id) throws ItemNotFoundException {
        UUID uuid = validUuid(id);
        Categoria existeCategoria = getCategoria(id);
        return categoriaDao.update(dto, uuid);
    }

    @Override
    public ArrayList<Categoria> listCategorias() {
        return categoriaDao.listAll();
    }

    @Override
    public boolean borrarCategoria(String id) throws ItemNotFoundException {
        UUID uuid = validUuid(id);
        Categoria existeCategoria = getCategoria(id);
        return categoriaDao.delete(uuid);
    }

    @Override
    public ArrayList<Categoria> buscarCategorias(String nombre) throws ItemNotFoundException {
        ArrayList<Categoria> categorias = categoriaDao.listAll();
        ArrayList<Categoria> filtered = new ArrayList<>();
        for(Categoria categoria: categorias) {
            if (categoria.getNombre().contains(nombre)) {
                filtered.add(categoria);
            }
        }
        if(filtered.size() == 0) {
            throw new ItemNotFoundException("No hay categorias con ese nombre");
        }
        return filtered;
    }

    @Override
    public boolean existeCategoria(String nombre, boolean shouldExist) throws ItemNotFoundException, ItemExistsException {
        ArrayList<Categoria> categorias = categoriaDao.listAll();
        boolean exists = false;
        for(Categoria categoria: categorias) {
            if (categoria.getNombre().equals(nombre)) {
                exists = true;
                break;
            }
        }

        if (shouldExist && !exists) {
            throw new ItemNotFoundException("No existe esa categoria");
        } else if (!shouldExist && exists) {
            throw new ItemExistsException("Ya existe esa categoría");
        }

        return exists;
    }

    @Override
    public ArrayList<Categoria> mockCategorias() throws ItemExistsException, ItemNotFoundException {
        List<AltaCategoriaDto> lista = new ArrayList<>();
        lista.add(new AltaCategoriaDto("Vehiculos", "Todos los vehiculos"));
        lista.add(new AltaCategoriaDto("Electrodomesticos", "Mejora tu hogar"));
        lista.add(new AltaCategoriaDto("Muebles", "Mejora tu hogar"));
        for(AltaCategoriaDto categoria: lista) {
            altaCategoria(categoria);
        }
        return listCategorias();
    }

    private UUID validUuid(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException err) {
            throw new InvalidUuidException("El UUID ingresado no es válido", err);
        }
        return uuid;
    }

}
