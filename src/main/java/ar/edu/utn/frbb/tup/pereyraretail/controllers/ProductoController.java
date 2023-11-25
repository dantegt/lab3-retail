package ar.edu.utn.frbb.tup.pereyraretail.controllers;

import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class ProductoController {
    private final AtomicLong idGen = new AtomicLong();
    @Operation(summary = "Ver el listado de productos")
    @GetMapping("/producto")
    public List<Producto> listaProductos () {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto("P001", "Monopatin S100", "Toyota", 12000.0));
        lista.add(new Producto("P002", "Monopatin S200", "Toyota", 22000.0));
        lista.add(new Producto("P003", "Monopatin S300", "Toyota", 32000.0));
        return lista;
    }

    @Operation(summary = "Ver el producto con {id}")
    @GetMapping("/producto/{id}")
    public Producto producto (
            @Parameter(description = "Id del producto")
            @PathVariable("id") int id) {
        return new Producto("P001", "Monopatin S100", "Toyota", 12000.0);
    }

}
