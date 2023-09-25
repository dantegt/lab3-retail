package ar.edu.utn.frbb.tup.pereyraretail.business;

import ar.edu.utn.frbb.tup.pereyraretail.dto.AltaCategoriaDto;
import ar.edu.utn.frbb.tup.pereyraretail.model.Categoria;
import ar.edu.utn.frbb.tup.pereyraretail.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class CategoriaBusiness {
    public Categoria altaCategoria(AltaCategoriaDto categoriaDto) {
        Categoria categoria = new Categoria(categoriaDto.getNombre(), categoriaDto.getDescripcion());
        return categoria;
    }

 /*   public List<Producto> obtenerCategoria(String id, String order_price, String marca, String precio_min, String precio_max) {

    }*/
}
