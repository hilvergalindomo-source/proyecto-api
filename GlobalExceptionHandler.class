package com.educativo.apiaulapoo.service;

import com.educativo.apiaulapoo.dto.request.LoginRequestDTO;
import com.educativo.apiaulapoo.dto.request.UsuarioRequestDTO;
import com.educativo.apiaulapoo.dto.response.UsuarioResponseDTO;
import java.util.List;

/**
 * Interface que define las operaciones de negocio para Usuario.
 * Define el contrato que debe cumplir cualquier implementación del servicio de Usuario.
 */
public interface UsuarioService {
    
    /**
     * Crea un nuevo usuario validando sus datos
     * @param usuarioRequestDTO datos del usuario a crear
     * @return DTO del usuario creado
     */
    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioRequestDTO);
    
    /**
     * Obtiene un usuario por su ID
     * @param id el ID del usuario
     * @return DTO del usuario encontrado
     */
    UsuarioResponseDTO obtenerUsuario(Long id);
    
    /**
     * Obtiene todos los usuarios
     * @return lista de DTOs de todos los usuarios
     */
    List<UsuarioResponseDTO> obtenerTodos();
    
    /**
     * Actualiza un usuario existente
     * @param id el ID del usuario a actualizar
     * @param usuarioRequestDTO nuevos datos del usuario
     * @return DTO del usuario actualizado
     */
    UsuarioResponseDTO actualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO);
    
    /**
     * Elimina un usuario
     * @param id el ID del usuario a eliminar
     */
    void eliminarUsuario(Long id);

    /**
     * Valida las credenciales de login
     * @param loginRequestDTO datos de login (correo y contraseña)
     * @return DTO del usuario si las credenciales son válidas
     */
    UsuarioResponseDTO validarLogin(LoginRequestDTO loginRequestDTO);
}
