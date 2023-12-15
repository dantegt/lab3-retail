package ar.edu.utn.frbb.tup.pereyraretail;

import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductoTest {

    @DisplayName("Crear un Producto desde la entidad")
    @Test
    public void crearProductoTest() {
        Producto p = new Producto("Codigo", "Producto", "Marca", 199.99, "Categoria", "Descripcion");

        assertEquals(p.getCodigo(), "Codigo");
        assertEquals(p.getNombre(), "Producto");
        assertEquals(p.getMarca(), "Marca");
        assertEquals(p.getPrecio(), 199.99);
        assertEquals(p.getCategoria(), "Categoria");
        assertEquals(p.getDescripcion(), "Descripcion");
    }

    @DisplayName("Comparar 2 productos creados desde la entidad")
    @Test
    public void comparaProductoTest() {
        Producto producto1 = new Producto("Codigo", "Producto", "Marca", 199.99, "Categoria", "Descripcion");
        Producto producto2 = new Producto("Codigo", "Producto", "Marca", 199.99, "Categoria", "Descripcion");

        assertEquals(producto1, producto2);
    }
}
