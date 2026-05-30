package com.educativo.apiaulapoo.dto.request;

/**
 * DTO para recibir datos de Producto desde el cliente.
 * No incluye el ID porque es generado automáticamente por el servidor.
 */
public class ProductoRequestDTO {
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    // Constructor vacío
    public ProductoRequestDTO() {
    }

    // Constructor con parámetros
    public ProductoRequestDTO(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProductoRequestDTO{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
