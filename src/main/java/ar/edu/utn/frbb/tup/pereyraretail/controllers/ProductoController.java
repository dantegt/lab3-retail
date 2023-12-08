package ar.edu.utn.frbb.tup.pereyraretail.controllers;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
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
            @PathVariable("id") String id) {
        Producto producto = productoBusiness.getProducto(UUID.fromString(id));
        if(producto == null) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No se encontró el producto"
        );
        return producto;
    }

    @Operation(summary = "Ver lista de productos por categoria")
    @GetMapping("/categoria/{categoria}")
    public ArrayList<Producto> productosPorCategoria (
            @Parameter(description = "Categoria del producto")
            @PathVariable("categoria") String categoria) {
        if(!categoriaBusiness.existeCategoria(categoria)) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe esa categoria"
        );
        ArrayList<Producto> productos = productoBusiness.getProductosPorCategoria(categoria);
        if(productos.size() == 0) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No hay productos en esa categoria"
        );
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
}
