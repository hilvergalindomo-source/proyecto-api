package com.educativo.apiaulapoo.repository;

import com.educativo.apiaulapoo.model.Producto;
import java.util.List;
import java.util.Optional;

/**
 * Interface que define las operaciones CRUD para la entidad Producto.
 * Define el contrato que debe cumplir cualquier implementación de repositorio de Producto.
 */
public interface ProductoRepository {
    
    /**
     * Guarda un nuevo producto en el repositorio
     * @param producto el producto a guardar
     * @return el producto guardado con su ID asignado
     */
    Producto guardar(Producto producto);
    
    /**
     * Busca un producto por su ID
     * @param id el ID del producto
     * @return Optional con el producto si existe, vacío en caso contrario
     */
    Optional<Producto> buscarPorId(Long id);
    
    /**
     * Obtiene todos los productos del repositorio
     * @return lista de todos los productos
     */
    List<Producto> obtenerTodos();
    
    /**
     * Actualiza un producto existente
     * @param id el ID del producto a actualizar
     * @param producto los nuevos datos del producto
     * @return el producto actualizado
     */
    Producto actualizar(Long id, Producto producto);
    
    /**
     * Elimina un producto por su ID
     * @param id el ID del producto a eliminar
     * @return true si se eliminó, false si no existe
     */
    boolean eliminar(Long id);
}
