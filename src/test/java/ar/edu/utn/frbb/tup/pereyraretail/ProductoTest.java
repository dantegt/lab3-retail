package ar.edu.utn.frbb.tup.pereyraretail;

import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ProductoTest {

    @Test
    void toStringTest() {
        Producto p = new Producto();
        p.setNombre("Producto1");
        p.setMarca("Samsung");
        p.setPrecio(12.00);
        String expected = "Producto{codigo='null', nombre='Producto1', marca='Samsung', tipo='null', precio=12.0, descripcion='null', specs=null}";
        assertEquals(expected, p.toString());
    }
}
