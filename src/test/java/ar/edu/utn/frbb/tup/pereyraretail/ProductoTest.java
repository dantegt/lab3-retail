package ar.edu.utn.frbb.tup.pereyraretail;

import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductoTest {

    @DisplayName("Crear un Producto desde la entidad")
    @Test
    public void crearProductoTest() {
        Categoria categoria = new Categoria("Hogar", "Todo para el Hogar");
        Producto p = new Producto("Codigo", "Producto", "Marca", 199.99, categoria, "Descripcion");

        assertEquals(p.getCodigo(), "Codigo");
        assertEquals(p.getNombre(), "Producto");
        assertEquals(p.getMarca(), "Marca");
        assertEquals(p.getPrecio(), 199.99);
        assertEquals(p.getCategoria(), categoria);
        assertEquals(p.getDescripcion(), "Descripcion");
    }

    @DisplayName("Comparar 2 productos creados desde la entidad")
    @Test
    public void comparaProductoTest() {
        Categoria categoria = new Categoria("Hogar", "Todo para el Hogar");
        Producto producto1 = new Producto("Codigo", "Producto", "Marca", 199.99, categoria, "Descripcion");
        Producto producto2 = new Producto("Codigo", "Producto", "Marca", 199.99, categoria, "Descripcion");

        assertEquals(producto1, producto2);
    }
}
