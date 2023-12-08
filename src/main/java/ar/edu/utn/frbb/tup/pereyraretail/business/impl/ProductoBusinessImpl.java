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

        return productoDao.save(prod);
    }

    @Override
    public Producto getProducto(UUID uuid) {
        return productoDao.findById(uuid);
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

        return productoDao.update(prod);
    }

    @Override
    public boolean deleteProducto(String id) {
        return productoDao.delete(id);
    }

    @Override
    public ArrayList<Producto> listProductos() {
        return productoDao.listAll();
    }

    @Override
    public ArrayList<Producto> getProductosPorCategoria(String categoria) {
        return this.productoDao.listPorCategoria(categoria);
    }

    @Override
    public ArrayList<Producto> searchProductos(String query) {
        return productoDao.searchProductos(query);
    }
}
