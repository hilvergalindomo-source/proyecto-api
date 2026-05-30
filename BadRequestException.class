package com.educativo.apiaulapoo.service;

import com.educativo.apiaulapoo.dto.request.ProductoRequestDTO;
import com.educativo.apiaulapoo.dto.response.ProductoResponseDTO;
import java.util.List;

/**
 * Interface que define las operaciones de negocio para Producto.
 * Define el contrato que debe cumplir cualquier implementación del servicio de Producto.
 */
public interface ProductoService {
    
    /**
     * Crea un nuevo producto validando sus datos
     * @param productoRequestDTO datos del producto a crear
     * @return DTO del producto creado
     */
    ProductoResponseDTO crearProducto(ProductoRequestDTO productoRequestDTO);
    
    /**
     * Obtiene un producto por su ID
     * @param id el ID del producto
     * @return DTO del producto encontrado
     */
    ProductoResponseDTO obtenerProducto(Long id);
    
    /**
     * Obtiene todos los productos
     * @return lista de DTOs de todos los productos
     */
    List<ProductoResponseDTO> obtenerTodos();
    
    /**
     * Actualiza un producto existente
     * @param id el ID del producto a actualizar
     * @param productoRequestDTO nuevos datos del producto
     * @return DTO del producto actualizado
     */
    ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO productoRequestDTO);
    
    /**
     * Elimina un producto
     * @param id el ID del producto a eliminar
     */
    void eliminarProducto(Long id);
}
