package ar.edu.utn.frbb.tup.pereyraretail.controllers;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping("/id/{id}")
    public Categoria categoriaId (
            @Parameter(description = "Id de la categoria")
            @PathVariable("id") String id) {
        Categoria categoria = categoriaBusiness.getCategoria(UUID.fromString(id));
        if(categoria == null) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontró la categoria"
        );
        return categoria;
    }

    @Operation(summary = "Ver la categoria por {nombre}")
    @GetMapping("/{nombre}")
    public Categoria categoriaNombre (
            @Parameter(description = "Nombre de la categoria")
            @PathVariable("nombre") String nombre) {
        Categoria categoria = categoriaBusiness.getCategoriaNombre(nombre);
        if(categoria == null) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontró la categoria"
        );
        return categoria;
    }

    @Operation(summary = "Buscar categorias por nombre")
    @GetMapping("/buscar/{nombre}")
    public ArrayList<Categoria> categoriasBuscar (
            @Parameter(description = "Nombre de la categoria")
            @PathVariable("nombre") String nombre) {
        ArrayList<Categoria> categorias = categoriaBusiness.buscarCategorias(nombre);
        if(categorias.size() == 0) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No hay categorias con ese nombre"
        );
        return categorias;
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
