package ar.edu.utn.frbb.tup.pereyraretail.controllers;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.InvalidUuidException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemExistsException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @Operation(summary = "Ver el listado de categorias")
    @GetMapping("/")
    public List<Categoria> listCategorias () {
        return categoriaBusiness.listCategorias();
    }

    @Operation(summary = "Ver la categoria con {id}")
    @GetMapping("/{id}")
    public Categoria categoriaId (
            @Parameter(description = "Id de la categoria")
            @PathVariable("id") String id) throws ItemNotFoundException {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException err) {
            throw new InvalidUuidException("El UUID ingresado no es válido", err);
        }

        Categoria categoria = categoriaBusiness.getCategoria(uuid);
        if(categoria == null) {
            throw new ItemNotFoundException("No se encontró la categoria");
        }
        return categoria;
    }

    @Operation(summary = "Ver la categoria por {nombre}")
    @GetMapping("/nombre/{nombre:[a-zA-Z0-9]*}")
    public Categoria categoriaNombre (
            @Parameter(description = "Nombre de la categoria")
            @PathVariable("nombre") String nombre) throws ItemNotFoundException {
        Categoria categoria = categoriaBusiness.getCategoriaNombre(nombre);
        if(categoria == null) {
            throw new ItemNotFoundException("No se encontró la categoria");
        }
        return categoria;
    }

    @Operation(summary = "Buscar categorias por nombre")
    @GetMapping("/buscar/{nombre:[a-zA-Z0-9]*}")
    public ArrayList<Categoria> categoriasBuscar (
            @Parameter(description = "Nombre de la categoria")
            @PathVariable("nombre") String nombre) throws ItemNotFoundException {
        ArrayList<Categoria> categorias = categoriaBusiness.buscarCategorias(nombre);
        if(categorias.size() == 0) {
            throw new ItemNotFoundException("No hay categorias con ese nombre");
        }
        return categorias;
    }

    @Operation(summary = "Crear una categoria")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria categoriaCrear (
            @RequestBody AltaCategoriaDto dto) throws ItemExistsException {
        if(categoriaBusiness.existeCategoria(dto.getNombre())) {
            throw new ItemExistsException("Existe esa categoria");
        }
        return categoriaBusiness.altaCategoria(dto);
    }

    @Operation(summary = "Editar una categoria")
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria categoriaEditar (
            @RequestBody AltaCategoriaDto dto,
            @Parameter(description = "Id de la categoria")
            @PathVariable("id") String id) throws ItemNotFoundException, InvalidUuidException {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException err) {
            throw new InvalidUuidException("El UUID ingresado no es válido", err);
        }

        if(categoriaBusiness.getCategoria(uuid) == null) {
            throw new ItemNotFoundException("No existe esa categoria");
        }
        return categoriaBusiness.editarCategoria(dto, uuid);
    }

    @Operation(summary = "Borrar la categoria con {id}")
    @DeleteMapping("/{id}")
    public ResponseEntity categoriaBorrarId (
            @Parameter(description = "Id de la categoria")
            @PathVariable("id") String id) throws ItemNotFoundException, InvalidUuidException {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException err) {
            throw new InvalidUuidException("El UUID ingresado no es válido", err);
        }

        boolean borrado = categoriaBusiness.borrarCategoria(uuid);
        if(!borrado) {
            throw new ItemNotFoundException("No se encontró la categoria");
        }
        return new ResponseEntity<>("Accepted", HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Agregar mock data de Categorias y Categorias")
    @GetMapping("/mock")
    public ArrayList<Categoria> agregarMockCategorias () {
        List<AltaCategoriaDto> lista = new ArrayList<>();
        lista.add(new AltaCategoriaDto("Vehiculos", "Todos los vehiculos"));
        lista.add(new AltaCategoriaDto("Electrodomesticos", "Mejora tu hogar"));
        lista.add(new AltaCategoriaDto("Muebles", "Mejora tu hogar"));
        for(AltaCategoriaDto categoria: lista) {
            categoriaBusiness.altaCategoria(categoria);
        }
        return categoriaBusiness.listCategorias();
    }
}
