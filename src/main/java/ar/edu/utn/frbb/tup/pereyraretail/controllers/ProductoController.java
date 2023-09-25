package ar.edu.utn.frbb.tup.pereyraretail.controllers;

import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class ProductoController {
    private final AtomicLong idGen = new AtomicLong();

    @GetMapping("/producto/{id}")
    public Producto producto (@PathVariable("id") int id) {
        return new Producto("P001", "Monopatin S100", "Toyota", 12000.0);
    }

}
