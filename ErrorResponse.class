package com.educativo.apiaulapoo.service;

import com.educativo.apiaulapoo.dto.request.ProductoRequestDTO;
import com.educativo.apiaulapoo.dto.response.ProductoResponseDTO;
import com.educativo.apiaulapoo.exception.BadRequestException;
import com.educativo.apiaulapoo.exception.ResourceNotFoundException;
import com.educativo.apiaulapoo.model.Producto;
import com.educativo.apiaulapoo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementación del servicio de Producto.
 * Contiene toda la lógica de negocio para productos.
 * Aquí se realizan las validaciones antes de guardar o actualizar productos.
 * 
 * @Service anotación que indica que esta clase es un servicio de negocio.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Crea un nuevo producto validando sus datos
     * Validaciones:
     * - Nombre no debe ser nulo ni vacío
     * - Precio debe ser mayor a 0
     * - Stock no debe ser negativo
     * 
     * @param productoRequestDTO datos del producto desde la solicitud
     * @return DTO del producto creado con ID asignado
     * @throws BadRequestException si alguna validación falla
     */
    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO productoRequestDTO) {
        validarProducto(productoRequestDTO);
        
        Producto producto = new Producto();
        producto.setNombre(productoRequestDTO.getNombre());
        producto.setPrecio(productoRequestDTO.getPrecio());
        producto.setStock(productoRequestDTO.getStock());
        producto.setCategoria(productoRequestDTO.getCategoria());

        Producto productoGuardado = productoRepository.guardar(producto);
        
        return convertirADTO(productoGuardado);
    }

    /**
     * Obtiene un producto por su ID
     * @param id el ID del producto a buscar
     * @return DTO del producto encontrado
     * @throws ResourceNotFoundException si el producto no existe
     */
    @Override
    public ProductoResponseDTO obtenerProducto(Long id) {
        Producto producto = productoRepository.buscarPorId(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));
        
        return convertirADTO(producto);
    }

    /**
     * Obtiene todos los productos
     * @return lista de DTOs de todos los productos
     */
    @Override
    public List<ProductoResponseDTO> obtenerTodos() {
        return productoRepository.obtenerTodos()
            .stream()
            .map(this::convertirADTO)
            .toList();
    }

    /**
     * Actualiza un producto existente validando sus datos
     * @param id el ID del producto a actualizar
     * @param productoRequestDTO nuevos datos del producto
     * @return DTO del producto actualizado
     * @throws ResourceNotFoundException si el producto no existe
     * @throws BadRequestException si alguna validación falla
     */
    @Override
    public ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO productoRequestDTO) {
        // Verificar que el producto existe
        productoRepository.buscarPorId(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));
        
        // Validar los nuevos datos
        validarProducto(productoRequestDTO);
        
        Producto productoActualizado = new Producto();
        productoActualizado.setNombre(productoRequestDTO.getNombre());
        productoActualizado.setPrecio(productoRequestDTO.getPrecio());
        productoActualizado.setStock(productoRequestDTO.getStock());
        productoActualizado.setCategoria(productoRequestDTO.getCategoria());

        Producto producto = productoRepository.actualizar(id, productoActualizado);
        
        return convertirADTO(producto);
    }

    /**
     * Elimina un producto por su ID
     * @param id el ID del producto a eliminar
     * @throws ResourceNotFoundException si el producto no existe
     */
    @Override
    public void eliminarProducto(Long id) {
        boolean eliminado = productoRepository.eliminar(id);
        if (!eliminado) {
            throw new ResourceNotFoundException("Producto con ID " + id + " no encontrado");
        }
    }

    /**
     * Valida los datos de un producto
     * @param productoRequestDTO datos a validar
     * @throws BadRequestException si alguna validación falla
     */
    private void validarProducto(ProductoRequestDTO productoRequestDTO) {
        if (productoRequestDTO.getNombre() == null || productoRequestDTO.getNombre().trim().isEmpty()) {
            throw new BadRequestException("El nombre del producto no puede estar vacío");
        }
        
        if (productoRequestDTO.getPrecio() <= 0) {
            throw new BadRequestException("El precio debe ser mayor a 0");
        }
        
        if (productoRequestDTO.getStock() < 0) {
            throw new BadRequestException("El stock no puede ser negativo");
        }
    }

    /**
     * Convierte una entidad Producto a un DTO
     * @param producto la entidad a convertir
     * @return DTO de respuesta
     */
    private ProductoResponseDTO convertirADTO(Producto producto) {
        return new ProductoResponseDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getCategoria()
        );
    }
}
