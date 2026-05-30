package com.educativo.apiaulapoo.controller;

import com.educativo.apiaulapoo.dto.request.ProductoRequestDTO;
import com.educativo.apiaulapoo.dto.response.ProductoResponseDTO;
import com.educativo.apiaulapoo.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para gestionar Productos.
 * Expone los endpoints CRUD para la entidad Producto.
 * No contiene lógica de negocio; solo recibe y devuelve DTOs.
 * 
 * @RestController anotación que indica que esta clase es un controlador REST.
 * @RequestMapping define la ruta base para todos los endpoints de este controlador.
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /**
     * POST /productos
     * Crea un nuevo producto
     * 
     * @param productoRequestDTO datos del producto a crear
     * @return ResponseEntity con estado 201 (CREATED) y el producto creado
     */
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(
            @RequestBody ProductoRequestDTO productoRequestDTO) {
        
        ProductoResponseDTO productoCreado = productoService.crearProducto(productoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    /**
     * GET /productos/{id}
     * Obtiene un producto por su ID
     * 
     * @param id el ID del producto a obtener
     * @return ResponseEntity con estado 200 (OK) y el producto encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtenerProducto(@PathVariable Long id) {
        ProductoResponseDTO producto = productoService.obtenerProducto(id);
        return ResponseEntity.ok(producto);
    }

    /**
     * GET /productos
     * Obtiene todos los productos
     * 
     * @return ResponseEntity con estado 200 (OK) y lista de todos los productos
     */
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> obtenerTodos() {
        List<ProductoResponseDTO> productos = productoService.obtenerTodos();
        return ResponseEntity.ok(productos);
    }

    /**
     * PUT /productos/{id}
     * Actualiza un producto existente
     * 
     * @param id el ID del producto a actualizar
     * @param productoRequestDTO nuevos datos del producto
     * @return ResponseEntity con estado 200 (OK) y el producto actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizarProducto(
            @PathVariable Long id,
            @RequestBody ProductoRequestDTO productoRequestDTO) {
        
        ProductoResponseDTO productoActualizado = productoService.actualizarProducto(id, productoRequestDTO);
        return ResponseEntity.ok(productoActualizado);
    }

    /**
     * DELETE /productos/{id}
     * Elimina un producto por su ID
     * 
     * @param id el ID del producto a eliminar
     * @return ResponseEntity con estado 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
