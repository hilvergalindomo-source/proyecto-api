package com.educativo.apiaulapoo.repository;

import com.educativo.apiaulapoo.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 * Interface que define las operaciones CRUD para la entidad Usuario.
 * Define el contrato que debe cumplir cualquier implementación de repositorio de Usuario.
 */
public interface UsuarioRepository {
    
    /**
     * Guarda un nuevo usuario en el repositorio
     * @param usuario el usuario a guardar
     * @return el usuario guardado con su ID asignado
     */
    Usuario guardar(Usuario usuario);
    
    /**
     * Busca un usuario por su ID
     * @param id el ID del usuario
     * @return Optional con el usuario si existe, vacío en caso contrario
     */
    Optional<Usuario> buscarPorId(Long id);
    
    /**
     * Obtiene todos los usuarios del repositorio
     * @return lista de todos los usuarios
     */
    List<Usuario> obtenerTodos();
    
    /**
     * Actualiza un usuario existente
     * @param id el ID del usuario a actualizar
     * @param usuario los nuevos datos del usuario
     * @return el usuario actualizado
     */
    Usuario actualizar(Long id, Usuario usuario);
    
    /**
     * Elimina un usuario por su ID
     * @param id el ID del usuario a eliminar
     * @return true si se eliminó, false si no existe
     */
    boolean eliminar(Long id);
}
