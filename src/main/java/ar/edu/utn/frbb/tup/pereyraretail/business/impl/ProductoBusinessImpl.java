package ar.edu.utn.frbb.tup.pereyraretail.business.impl;

import ar.edu.utn.frbb.tup.pereyraretail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class ProductoBusinessImpl implements ProductoBusiness {
    
    @Autowired
    ProductoDao productoDao;

    @Override
    public Producto crearProducto(AltaProductoDto productoDto) {
        Producto prod = new Producto(
            productoDto.getCodigo(),
            productoDto.getNombre(),
            productoDto.getMarca(),
            productoDto.getPrecio(),
            productoDto.getTipo(),
            productoDto.getDescripcion()
        );

        return this.productoDao.save(prod);
    }

    @Override
    public Producto getProducto(UUID uuid) {
        return this.productoDao.findById(uuid);
    }

    @Override
    public Producto updateProducto(AltaProductoDto productoDto) {
        Producto prod = new Producto(
            productoDto.getCodigo(),
            productoDto.getNombre(),
            productoDto.getMarca(),
            productoDto.getPrecio(),
            productoDto.getTipo(),
            productoDto.getDescripcion()
        );

        return this.productoDao.update(prod);
    }

    @Override
    public boolean deleteProducto(String id) {
        return this.productoDao.delete(id);
    }

    @Override
    public ArrayList<Producto> listProductos() {
        return null;
    }

    @Override
    public ArrayList<Producto> searchProductos() {
        return null;
    }
}
