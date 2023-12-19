package ar.edu.utn.frbb.tup.pereyraretail.business.impl;

import ar.edu.utn.frbb.tup.pereyraretail.business.CategoriaBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.business.ProductoBusiness;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.InvalidUuidException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemExistsException;
import ar.edu.utn.frbb.tup.pereyraretail.exceptions.ItemNotFoundException;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductoBusinessImpl implements ProductoBusiness {
    
    @Autowired
    ProductoDao productoDao;

    @Autowired
    CategoriaBusiness categoriaBusiness;

    @Override
    public Producto crearProducto(AltaProductoDto productoDto) throws ItemExistsException, ItemNotFoundException {
        Categoria categoria = categoriaBusiness.getCategoriaNombre(productoDto.getCategoria());
        return productoDao.save(productoDto, categoria);
    }

    @Override
    public Producto getProducto(String id) throws ItemNotFoundException {
        UUID uuid = validUuid(id);
        Producto producto = productoDao.findById(uuid);
        if(producto == null) {
            throw new ItemNotFoundException("No existe ese producto");
        }
        return producto;
    }

    @Override
    public Producto updateProducto(AltaProductoDto productoDto, String id) throws ItemNotFoundException {
        UUID uuid = validUuid(id);
        Producto productoExiste = getProducto(id);
        Categoria categoria = categoriaBusiness.getCategoriaNombre(productoDto.getCategoria());
        return productoDao.update(productoDto, categoria, uuid);
    }

    @Override
    public void borrarProducto(String id) throws ItemNotFoundException {
        UUID uuid = validUuid(id);
        Producto productoExiste = getProducto(id);
        productoDao.delete(uuid);
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
    public ArrayList<Producto> mockProductos() throws ItemExistsException, ItemNotFoundException {
        categoriaBusiness.altaCategoria(new AltaCategoriaDto("Vehiculos", "Todos los automotores"));
        categoriaBusiness.altaCategoria(new AltaCategoriaDto("Electrodomesticos", "Te simplifican la vida"));
        List<AltaProductoDto> lista = new ArrayList<>();
        lista.add(new AltaProductoDto("P001", "Monopatin S100", "Toyota", 12000.0 , "Vehiculos", "Monopatin de acero"));
        lista.add(new AltaProductoDto("P002", "Bicicleta BC2X", "Nero", 42000.0 , "Vehiculos", "Bicicleta Nero, te lleva a donde vos quieras"));
        lista.add(new AltaProductoDto("P003", "Motocicleta RX70", "Motomel", 300000.0 , "Vehiculos", "Motocicleta RX70, todo terreno"));
        lista.add(new AltaProductoDto("X006", "Heladera Frigomax RV2", "Frigomax", 250000.0 , "Electrodomesticos", "Heladera Frigomax RV2, la que más enfría"));
        lista.add(new AltaProductoDto("X007", "Cafetera Nescafe NCF23", "Nescafe", 75000.0 , "Electrodomesticos", "Cafetera Nescafe NCF23, para hacer cafecito"));
        lista.add(new AltaProductoDto("X008", "Tostadora Mimi TO45T", "Mimi", 55000.0 , "Electrodomesticos", "Tostadora Mimi TO45T, para unos buenos tostados"));
        for(AltaProductoDto producto: lista) {
            crearProducto(producto);
        }
        return listProductos();
    }

    @Override
    public ArrayList<Producto> searchProductos(String query) {
        return productoDao.searchProductos(query);
    }

    private UUID validUuid(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException err) {
            throw new InvalidUuidException("El UUID ingresado no es válido", err);
        }
        return uuid;
    }

}
