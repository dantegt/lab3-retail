package ar.edu.utn.frbb.tup.pereyraretail.controllers;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.InvalidUuidException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemExistsException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    ProductoBusiness productoBusiness;

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @Operation(summary = "Ver el listado de productos")
    @GetMapping("/")
    public List<Producto> listaProductos () {
        return productoBusiness.listProductos();
    }

    @Operation(summary = "Ver el producto con {id}")
    @GetMapping("/{id}")
    public Producto producto (
            @Parameter(description = "Id del producto")
            @PathVariable("id") String id) throws ItemNotFoundException, InvalidUuidException {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException err) {
            throw new InvalidUuidException("El UUID ingresado no es válido", err);
        }

        Producto producto = productoBusiness.getProducto(uuid);

        if(producto == null) {
            throw new ItemNotFoundException("No se encontró el producto");
        }
        return producto;
    }

    @Operation(summary = "Ver lista de productos por categoria")
    @GetMapping("/categoria/{categoria:[a-zA-Z0-9]*}")
    public ArrayList<Producto> productosPorCategoria (
            @Parameter(description = "Categoria del producto")
            @PathVariable("categoria") String categoria) throws ItemNotFoundException {
        if(!categoriaBusiness.existeCategoria(categoria)) {
            throw new ItemNotFoundException("No existe esa categoria");
        }
        ArrayList<Producto> productos = productoBusiness.getProductosPorCategoria(categoria);
        if(productos.size() == 0) {
            throw new ItemNotFoundException("No hay productos en esa categoria");
        }
        return productos;
    }


    @Operation(summary = "Agregar productos mock al listado de productos")
    @GetMapping("/mock")
    public List<Producto> agregarMockProductos () {
        List<AltaProductoDto> lista = new ArrayList<>();
        lista.add(new AltaProductoDto("P001", "Monopatin S100", "Toyota", 12000.0 , "Vehiculos", "Monopatin de acero"));
        lista.add(new AltaProductoDto("P002", "Bicicleta BC2X", "Nero", 42000.0 , "Vehiculos", "Bicicleta Nero, te lleva a donde vos quieras"));
        lista.add(new AltaProductoDto("P003", "Motocicleta RX70", "Motomel", 300000.0 , "Vehiculos", "Motocicleta RX70, todo terreno"));
        lista.add(new AltaProductoDto("X006", "Heladera Frigomax RV2", "Frigomax", 250000.0 , "Electrodomesticos", "Heladera Frigomax RV2, la que más enfría"));
        lista.add(new AltaProductoDto("X007", "Cafetera Nescafe NCF23", "Nescafe", 75000.0 , "Electrodomesticos", "Cafetera Nescafe NCF23, para hacer cafecito"));
        lista.add(new AltaProductoDto("X008", "Tostadora Mimi TO45T", "Mimi", 55000.0 , "Electrodomesticos", "Tostadora Mimi TO45T, para unos buenos tostados"));
        for(AltaProductoDto producto: lista) {
            productoBusiness.crearProducto(producto);
        }
        return productoBusiness.listProductos();
    }

    @Operation(summary = "Crear un producto")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto productoCrear (
            @RequestBody AltaProductoDto dto) {
        return productoBusiness.crearProducto(dto);
    }

    @Operation(summary = "Editar un producto")
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto productoEditar (
            @PathVariable("id") String id,
            @RequestBody AltaProductoDto dto) throws ItemNotFoundException, InvalidUuidException {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException err) {
            throw new InvalidUuidException("El UUID ingresado no es válido", err);
        }

        if(productoBusiness.getProducto(uuid) == null) {
            throw new ItemNotFoundException("No existe ese producto");
        }
        return productoBusiness.updateProducto(dto, uuid);
    }

    @Operation(summary = "Borrar la producto con {id}")
    @DeleteMapping("/{id}")
    public ResponseEntity productoBorrar (
            @Parameter(description = "Id de la producto")
            @PathVariable("id") String id) throws ItemNotFoundException {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException err) {
            throw new InvalidUuidException("El UUID ingresado no es válido", err);
        }

        boolean borrado = productoBusiness.borrarProducto(uuid);
        if(!borrado) {
            throw new ItemNotFoundException("No se encontró la producto");
        }
        return new ResponseEntity<>("Accepted", HttpStatus.ACCEPTED);
    }
}
