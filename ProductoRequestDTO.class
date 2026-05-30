package com.educativo.apiaulapoo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.educativo.apiaulapoo.model.Producto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Implementación en memoria del repositorio de Producto.
 * Utiliza un Map<Long, Producto> para almacenar los productos.
 * Esta implementación es ideal para propósitos académicos y pruebas.
 */
@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    // Map que almacena los productos en memoria: key = id, value = producto
    private final Map<Long, Producto> productos = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Path archivoProductos = Paths.get("data", "productos.json");

    @PostConstruct
    public void inicializar() {
        cargarDesdeArchivo();
    }

    /**
     * Guarda un nuevo producto asignándole un ID automático
     * @param producto el producto a guardar
     * @return el producto guardado con su ID asignado
     */
    @Override
    public synchronized Producto guardar(Producto producto) {
        Long nuevoId = IdGenerator.generarIdProducto();
        producto.setId(nuevoId);
        productos.put(nuevoId, producto);
        guardarEnArchivo();
        return producto;
    }

    /**
     * Busca un producto por su ID
     * @param id el ID del producto
     * @return Optional con el producto si existe
     */
    @Override
    public synchronized Optional<Producto> buscarPorId(Long id) {
        return Optional.ofNullable(productos.get(id));
    }

    /**
     * Obtiene todos los productos almacenados
     * @return lista con todos los productos
     */
    @Override
    public synchronized List<Producto> obtenerTodos() {
        return List.copyOf(productos.values());
    }

    /**
     * Actualiza un producto existente
     * @param id el ID del producto a actualizar
     * @param producto los nuevos datos del producto
     * @return el producto actualizado
     */
    @Override
    public synchronized Producto actualizar(Long id, Producto producto) {
        producto.setId(id);
        productos.put(id, producto);
        guardarEnArchivo();
        return producto;
    }

    /**
     * Elimina un producto por su ID
     * @param id el ID del producto a eliminar
     * @return true si se eliminó, false si no existe
     */
    @Override
    public synchronized boolean eliminar(Long id) {
        boolean eliminado = productos.remove(id) != null;
        if (eliminado) {
            guardarEnArchivo();
        }
        return eliminado;
    }

    private void cargarDesdeArchivo() {
        try {
            if (Files.notExists(archivoProductos)) {
                Files.createDirectories(archivoProductos.getParent());
                Files.createFile(archivoProductos);
                guardarEnArchivo();
                return;
            }

            if (Files.size(archivoProductos) == 0) {
                guardarEnArchivo();
                return;
            }

            List<Producto> productosCargados = objectMapper.readValue(
                    archivoProductos.toFile(),
                    new TypeReference<List<Producto>>() {}
            );

            for (Producto producto : productosCargados) {
                if (producto.getId() != null) {
                    productos.put(producto.getId(), producto);
                }
            }

            long siguienteId = productos.keySet().stream()
                    .max(Comparator.naturalOrder())
                    .orElse(0L) + 1;
            IdGenerator.setSiguienteIdProducto(siguienteId);
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo cargar productos desde archivo JSON", e);
        }
    }

    private void guardarEnArchivo() {
        try {
            Files.createDirectories(archivoProductos.getParent());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(
                    archivoProductos.toFile(),
                    productos.values()
            );
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo guardar productos en archivo JSON", e);
        }
    }
}
