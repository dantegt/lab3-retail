package ar.edu.utn.frbb.tup.pereyraretail.business;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;

import java.util.ArrayList;
import java.util.UUID;

public interface ProductoBusiness {
    Producto crearProducto(AltaProductoDto productoDto);
    Producto getProducto(UUID uuid);
    Producto updateProducto(AltaProductoDto productoDto);
    boolean deleteProducto(String id);
    ArrayList<Producto> listProductos();
    ArrayList<Producto> searchProductos();
}
