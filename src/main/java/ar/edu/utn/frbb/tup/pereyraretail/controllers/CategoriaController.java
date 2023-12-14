package ar.edu.utn.frbb.tup.pereyraretail.controllers;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.InvalidUuidException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemExistsException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        return categoriaBusiness.getCategoria(id);
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
        return categoriaBusiness.buscarCategorias(nombre);
    }

    @Operation(summary = "Crear una categoria")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria categoriaCrear (
            @Valid @RequestBody AltaCategoriaDto dto) throws ItemExistsException, ItemNotFoundException {
        boolean yaExiste = categoriaBusiness.existeCategoria(dto.getNombre(), false);
        return categoriaBusiness.altaCategoria(dto);
    }

    @Operation(summary = "Editar una categoria")
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> categoriaEditar (
            @Valid @RequestBody AltaCategoriaDto dto,
            @Parameter(description = "Id de la categoria")
            @PathVariable("id") String id) throws ItemNotFoundException, InvalidUuidException {
        Categoria categoriaEditada = categoriaBusiness.editarCategoria(dto, id);
        return ResponseEntity.ok(categoriaEditada);
    }

    @Operation(summary = "Borrar la categoria con {id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> categoriaBorrarId (
            @Parameter(description = "Id de la categoria")
            @PathVariable("id") String id) throws ItemNotFoundException, InvalidUuidException {
        boolean borrado = categoriaBusiness.borrarCategoria(id);
        if(!borrado) {
            throw new ItemNotFoundException("No se encontró la categoria");
        }
        return ResponseEntity.accepted().body("Borrado");
    }

    @Operation(summary = "Agregar mock data de Categorias y Categorias")
    @GetMapping("/mock")
    public ResponseEntity<ArrayList<Categoria>> agregarMockCategorias () throws ItemExistsException, ItemNotFoundException {
        ArrayList<Categoria> categorias = categoriaBusiness.mockCategorias();
        return ResponseEntity.status(HttpStatus.CREATED).body(categorias);
    }
}
