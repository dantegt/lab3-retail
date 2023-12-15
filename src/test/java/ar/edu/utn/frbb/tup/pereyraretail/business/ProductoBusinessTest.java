package ar.edu.utn.frbb.tup.pereyraretail.business;

import ar.edu.utn.frbb.tup.pereyraretail.business.impl.ProductoBusinessImpl;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.ProductoDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductoBusinessTest {

    @Mock
    private ProductoDao productoDaoMock;
    @InjectMocks
    private ProductoBusinessImpl business;

    @DisplayName("Crear un Producto desde el servicio")
    @Test
    public void crearProductoBusinessTest() {
        AltaProductoDto altaProductoDto = new AltaProductoDto("Codigo", "Producto", "Marca", 199.99, "Hogar", "Descripcion");
        Producto producto = new Producto("Codigo", "Producto", "Marca", 199.99, "Hogar", "Descripcion");

        Mockito.when(productoDaoMock.save(Mockito.<AltaProductoDto>any())).thenReturn(producto);

        Producto resultado = business.crearProducto(altaProductoDto);

        assertEquals(resultado.getCodigo(), altaProductoDto.getCodigo());
        assertEquals(resultado.getNombre(), altaProductoDto.getNombre());
        assertEquals(resultado.getMarca(), altaProductoDto.getMarca());
        assertEquals(resultado.getPrecio(), altaProductoDto.getPrecio());
        assertEquals(resultado.getCategoria(), altaProductoDto.getCategoria());
        assertEquals(resultado.getDescripcion(), altaProductoDto.getDescripcion());
    }

    @DisplayName("Update de un Producto desde el servicio")
    @Test
    public void editarProductoBusinessTest() throws ItemNotFoundException {
        String id = "d84338d4-9b3c-11ee-b9d1-0242ac120002";
        AltaProductoDto altaProductoDto = new AltaProductoDto("Codigo", "Producto", "Marca", 199.99, "Hogar", "Descripcion");
        Producto productoOriginal = new Producto("Codigo", "Producto", "Marca", 199.99, "Hogar", "Descripcion");
        productoOriginal.setId(UUID.fromString(id));
        AltaProductoDto updateProductoDto = new AltaProductoDto("Codigo", "ProductoDiferente", "Marca", 188.99, "Hogar", "Descripcion");
        Producto productoModificado = new Producto("Codigo", "ProductoDiferente", "Marca", 188.99, "Hogar", "Descripcion");
        productoModificado.setId(UUID.fromString(id));
        Producto resultado;

        Mockito.when(productoDaoMock.save(Mockito.<AltaProductoDto>any())).thenReturn(productoOriginal);
        Mockito.when(productoDaoMock.findById(Mockito.<UUID>any())).thenReturn(productoOriginal);
        Mockito.when(productoDaoMock.update(Mockito.<AltaProductoDto>any(), Mockito.<UUID>any())).thenReturn(productoModificado);

        try {
            Producto creado = business.crearProducto(altaProductoDto);
            resultado = business.updateProducto(altaProductoDto, id);
        } catch (ItemNotFoundException err) {
          throw new ItemNotFoundException("Producto no encontrado.");
        }

        assertEquals(resultado, productoModificado);

        assertEquals(resultado.getCodigo(), updateProductoDto.getCodigo());
        assertEquals(resultado.getNombre(), updateProductoDto.getNombre());
        assertEquals(resultado.getMarca(), updateProductoDto.getMarca());
        assertEquals(resultado.getPrecio(), updateProductoDto.getPrecio());
        assertEquals(resultado.getCategoria(), updateProductoDto.getCategoria());
        assertEquals(resultado.getDescripcion(), updateProductoDto.getDescripcion());
    }

    @DisplayName("Borrar un Producto desde el servicio")
    @Test
    public void borrarProductoBusinessTest() throws ItemNotFoundException {
        String id = "d84338d4-9b3c-11ee-b9d1-0242ac120002";
        Producto producto= new Producto("Codigo", "Producto", "Marca", 199.99, "Hogar", "Descripcion");
        producto.setId(UUID.fromString(id));

        Mockito.when(productoDaoMock.findById(Mockito.<UUID>any())).thenReturn(producto);
        Mockito.when(productoDaoMock.delete(Mockito.<UUID>any())).thenReturn(true);

        business.borrarProducto(id);

        verify(productoDaoMock, times(1)).findById(producto.getId());
        verify(productoDaoMock, times(1)).delete(producto.getId());
    }
}
