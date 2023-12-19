package ar.edu.utn.frbb.tup.pereyraretail.business;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemExistsException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;

import java.util.ArrayList;

public interface ProductoBusiness {
    Producto crearProducto(AltaProductoDto productoDto) throws ItemExistsException, ItemNotFoundException;
    Producto getProducto(String id) throws ItemNotFoundException;
    Producto updateProducto(AltaProductoDto productoDto, String id) throws ItemNotFoundException;
    void borrarProducto(String id) throws ItemNotFoundException;
    ArrayList<Producto> listProductos();
    ArrayList<Producto> searchProductos(String query);
    ArrayList<Producto> getProductosPorCategoria(String categoria);
    ArrayList<Producto> mockProductos() throws ItemExistsException, ItemNotFoundException;
}
