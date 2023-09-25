package ar.edu.utn.frbb.tup.pereyraretail.model;

public class FiltroCategoria {
    private String order_price;
    private String marca;
    private String precio_min;
    private String precio_max;

    public FiltroCategoria(String order_price, String marca, String precio_min, String precio_max) {
        this.order_price = order_price;
        this.marca = marca;
        this.precio_min = precio_min;
        this.precio_max = precio_max;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio_min() {
        return precio_min;
    }

    public void setPrecio_min(String precio_min) {
        this.precio_min = precio_min;
    }

    public String getPrecio_max() {
        return precio_max;
    }

    public void setPrecio_max(String precio_max) {
        this.precio_max = precio_max;
    }
}
