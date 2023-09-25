package ar.edu.utn.frbb.tup.pereyraretail.business;

import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;

public interface ProductoBusiness {
    Producto getProducto(int id);
    Producto setProducto(Producto producto);
}
