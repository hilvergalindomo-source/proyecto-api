package com.educativo.apiaulapoo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.educativo.apiaulapoo.model.Usuario;
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
 * Implementación en memoria del repositorio de Usuario.
 * Utiliza un Map<Long, Usuario> para almacenar los usuarios.
 * Esta implementación es ideal para propósitos académicos y pruebas.
 */
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    // Map que almacena los usuarios en memoria: key = id, value = usuario
    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Path archivoUsuarios = Paths.get("data", "usuarios.json");

    @PostConstruct
    public void inicializar() {
        cargarDesdeArchivo();
    }

    /**
     * Guarda un nuevo usuario asignándole un ID automático
     * @param usuario el usuario a guardar
     * @return el usuario guardado con su ID asignado
     */
    @Override
    public synchronized Usuario guardar(Usuario usuario) {
        Long nuevoId = IdGenerator.generarIdUsuario();
        usuario.setId(nuevoId);
        usuarios.put(nuevoId, usuario);
        guardarEnArchivo();
        return usuario;
    }

    /**
     * Busca un usuario por su ID
     * @param id el ID del usuario
     * @return Optional con el usuario si existe
     */
    @Override
    public synchronized Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(usuarios.get(id));
    }

    /**
     * Obtiene todos los usuarios almacenados
     * @return lista con todos los usuarios
     */
    @Override
    public synchronized List<Usuario> obtenerTodos() {
        return List.copyOf(usuarios.values());
    }

    /**
     * Actualiza un usuario existente
     * @param id el ID del usuario a actualizar
     * @param usuario los nuevos datos del usuario
     * @return el usuario actualizado
     */
    @Override
    public synchronized Usuario actualizar(Long id, Usuario usuario) {
        usuario.setId(id);
        usuarios.put(id, usuario);
        guardarEnArchivo();
        return usuario;
    }

    /**
     * Elimina un usuario por su ID
     * @param id el ID del usuario a eliminar
     * @return true si se eliminó, false si no existe
     */
    @Override
    public synchronized boolean eliminar(Long id) {
        boolean eliminado = usuarios.remove(id) != null;
        if (eliminado) {
            guardarEnArchivo();
        }
        return eliminado;
    }

    private void cargarDesdeArchivo() {
        try {
            if (Files.notExists(archivoUsuarios)) {
                Files.createDirectories(archivoUsuarios.getParent());
                Files.createFile(archivoUsuarios);
                guardarEnArchivo();
                return;
            }

            if (Files.size(archivoUsuarios) == 0) {
                guardarEnArchivo();
                return;
            }

            List<Usuario> usuariosCargados = objectMapper.readValue(
                    archivoUsuarios.toFile(),
                    new TypeReference<List<Usuario>>() {}
            );

            for (Usuario usuario : usuariosCargados) {
                if (usuario.getId() != null) {
                    usuarios.put(usuario.getId(), usuario);
                }
            }

            long siguienteId = usuarios.keySet().stream()
                    .max(Comparator.naturalOrder())
                    .orElse(0L) + 1;
            IdGenerator.setSiguienteIdUsuario(siguienteId);
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo cargar usuarios desde archivo JSON", e);
        }
    }

    private void guardarEnArchivo() {
        try {
            Files.createDirectories(archivoUsuarios.getParent());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(
                    archivoUsuarios.toFile(),
                    usuarios.values()
            );
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo guardar usuarios en archivo JSON", e);
        }
    }
}
