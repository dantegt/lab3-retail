package ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.impl;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaProductoDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import ar.edu.utn.frbb.tup.pereyraretail.persistance.dao.ProductoDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class InMemoryProductoDao implements ProductoDao {

    private final ArrayList<Producto> productos = new ArrayList<>();

    @Override
    public Producto save(AltaProductoDto p) {
        Producto producto = new Producto(
                p.getCodigo(),
                p.getNombre(),
                p.getMarca(),
                p.getPrecio(),
                p.getCategoria(),
                p.getDescripcion()
        );
        this.productos.add(producto);
        return producto;
    }

    @Override
    public Producto findById(UUID uuid) {
        for(Producto producto: productos) {
            if (producto.getId().equals(uuid)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public Producto update(AltaProductoDto p, UUID uuid) {
        for(Producto producto: productos) {
            if (producto.getId().equals(uuid)) {
                producto.setCodigo(p.getCodigo());
                producto.setNombre(p.getNombre());
                producto.setMarca(p.getMarca());
                producto.setCategoria(p.getCategoria());
                producto.setPrecio(p.getPrecio());
                producto.setDescripcion(p.getDescripcion());
                return producto;
            }
        }
        return null;
    }

    @Override
    public boolean delete(UUID uuid) {
        for(Producto producto: productos) {
            if (producto.getId().equals(uuid)) {
                productos.remove(producto);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Producto> listAll() {
        return productos;
    }

    @Override
    public ArrayList<Producto> searchProductos(String query) {
        ArrayList<Producto> filtered = new ArrayList<>();
        for(Producto producto: productos) {
            if (this.compareSearch(producto, query)) {
                filtered.add(producto);
            }
        }
        return filtered;
    }

    @Override
    public ArrayList<Producto> listPorCategoria(String categoria) {
        ArrayList<Producto> filtered = new ArrayList<>();
        for(Producto producto: productos) {
            boolean matchesCategoria = producto.getCategoria().equalsIgnoreCase(categoria);
            if (matchesCategoria) {
                filtered.add(producto);
            }
        }
        return filtered;
    }

    private boolean compareSearch(Producto producto, String query) {
        boolean matchesNombre = producto.getNombre().toLowerCase().contains(query.toLowerCase());
        boolean matchesMarca = producto.getMarca().toLowerCase().contains(query.toLowerCase());
        boolean matchesCodigo = producto.getCodigo().toLowerCase().contains(query.toLowerCase());
        return matchesNombre || matchesMarca || matchesCodigo;
    }
}
