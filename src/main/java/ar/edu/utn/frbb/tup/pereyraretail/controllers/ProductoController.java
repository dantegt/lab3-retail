package ar.edu.utn.frbb.tup.pereyraretail.controllers;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.InvalidUuidException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemExistsException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    ProductoBusiness productoBusiness;

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @Operation(summary = "Ver el listado de productos")
    @GetMapping("/")
    public ResponseEntity<ArrayList<Producto>> listaProductos () {
        ArrayList<Producto> productos = productoBusiness.listProductos();
        return ResponseEntity.ok(productos);
    }

    @Operation(summary = "Ver el producto con {id}")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> producto (
            @Parameter(description = "Id del producto")
            @PathVariable("id") String id) throws ItemNotFoundException, InvalidUuidException {
        Producto producto = productoBusiness.getProducto(id);
        return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Ver lista de productos por categoria")
    @GetMapping("/categoria/{categoria:[a-zA-Z0-9]*}")
    public ResponseEntity<ArrayList<Producto>> productosPorCategoria (
            @Parameter(description = "Categoria del producto")
            @PathVariable("categoria") String categoria) throws ItemNotFoundException, ItemExistsException {
        boolean existe = categoriaBusiness.existeCategoria(categoria, true);
        ArrayList<Producto> productos = productoBusiness.getProductosPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }


    @Operation(summary = "Agregar productos mock al listado de productos")
    @GetMapping("/mock")
    public ResponseEntity<ArrayList<Producto>> agregarMockProductos () {
        ArrayList<Producto> productos = productoBusiness.mockProductos();
        return ResponseEntity.status(HttpStatus.CREATED).body(productos);
    }

    @Operation(summary = "Crear un producto")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> productoCrear (
            @Valid @RequestBody AltaProductoDto dto) {
        Producto producto = productoBusiness.crearProducto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @Operation(summary = "Editar un producto")
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> productoEditar (
            @PathVariable("id") String id,
            @Valid @RequestBody AltaProductoDto dto) throws ItemNotFoundException {
        Producto productoEditado = productoBusiness.updateProducto(dto, id);
        return ResponseEntity.ok(productoEditado);
    }

    @Operation(summary = "Borrar la producto con {id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> productoBorrar (
            @Parameter(description = "Id de la producto")
            @PathVariable("id") String id) throws ItemNotFoundException {
        productoBusiness.borrarProducto(id);
        return ResponseEntity.accepted().body("Borrado");
    }
}
