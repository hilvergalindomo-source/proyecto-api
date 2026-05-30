package com.educativo.apiaulapoo.service;

import com.educativo.apiaulapoo.dto.request.LoginRequestDTO;
import com.educativo.apiaulapoo.dto.request.UsuarioRequestDTO;
import com.educativo.apiaulapoo.dto.response.UsuarioResponseDTO;
import com.educativo.apiaulapoo.exception.BadRequestException;
import com.educativo.apiaulapoo.exception.ResourceNotFoundException;
import com.educativo.apiaulapoo.model.Usuario;
import com.educativo.apiaulapoo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementación del servicio de Usuario.
 * Contiene toda la lógica de negocio para usuarios.
 * Aquí se realizan las validaciones antes de guardar o actualizar usuarios.
 * 
 * @Service anotación que indica que esta clase es un servicio de negocio.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Crea un nuevo usuario validando sus datos
     * Validaciones:
     * - Nombre no debe ser nulo ni vacío
     * - Correo debe contener @
     * - Edad debe ser mayor a 0
     * 
     * @param usuarioRequestDTO datos del usuario desde la solicitud
     * @return DTO del usuario creado con ID asignado
     * @throws BadRequestException si alguna validación falla
     */
    @Override
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        validarUsuario(usuarioRequestDTO);
        
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setCorreo(usuarioRequestDTO.getCorreo());
        usuario.setEdad(usuarioRequestDTO.getEdad());
        usuario.setRol(usuarioRequestDTO.getRol());
        usuario.setEstado(usuarioRequestDTO.isEstado());
        usuario.setContraseña(usuarioRequestDTO.getContraseña());

        Usuario usuarioGuardado = usuarioRepository.guardar(usuario);
        
        return convertirADTO(usuarioGuardado);
    }

    /**
     * Obtiene un usuario por su ID
     * @param id el ID del usuario a buscar
     * @return DTO del usuario encontrado
     * @throws ResourceNotFoundException si el usuario no existe
     */
    @Override
    public UsuarioResponseDTO obtenerUsuario(Long id) {
        Usuario usuario = usuarioRepository.buscarPorId(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
        
        return convertirADTO(usuario);
    }

    /**
     * Obtiene todos los usuarios
     * @return lista de DTOs de todos los usuarios
     */
    @Override
    public List<UsuarioResponseDTO> obtenerTodos() {
        return usuarioRepository.obtenerTodos()
            .stream()
            .map(this::convertirADTO)
            .toList();
    }

    /**
     * Actualiza un usuario existente validando sus datos
     * @param id el ID del usuario a actualizar
     * @param usuarioRequestDTO nuevos datos del usuario
     * @return DTO del usuario actualizado
     * @throws ResourceNotFoundException si el usuario no existe
     * @throws BadRequestException si alguna validación falla
     */
    @Override
    public UsuarioResponseDTO actualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        // Verificar que el usuario existe
        usuarioRepository.buscarPorId(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
        
        // Validar los nuevos datos
        validarUsuario(usuarioRequestDTO);
        
        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado.setNombre(usuarioRequestDTO.getNombre());
        usuarioActualizado.setCorreo(usuarioRequestDTO.getCorreo());
        usuarioActualizado.setEdad(usuarioRequestDTO.getEdad());
        usuarioActualizado.setRol(usuarioRequestDTO.getRol());
        usuarioActualizado.setEstado(usuarioRequestDTO.isEstado());
        usuarioActualizado.setContraseña(usuarioRequestDTO.getContraseña());

        Usuario usuario = usuarioRepository.actualizar(id, usuarioActualizado);
        
        return convertirADTO(usuario);
    }

    /**
     * Elimina un usuario por su ID
     * @param id el ID del usuario a eliminar
     * @throws ResourceNotFoundException si el usuario no existe
     */
    @Override
    public void eliminarUsuario(Long id) {
        boolean eliminado = usuarioRepository.eliminar(id);
        if (!eliminado) {
            throw new ResourceNotFoundException("Usuario con ID " + id + " no encontrado");
        }
    }

    /**
     * Valida las credenciales de login
     * @param loginRequestDTO datos de login (correo y contraseña)
     * @return DTO del usuario si las credenciales son válidas
     * @throws BadRequestException si las credenciales son inválidas
     */
    @Override
    public UsuarioResponseDTO validarLogin(LoginRequestDTO loginRequestDTO) {
        // Validar que los campos no estén vacíos
        if (loginRequestDTO.getCorreo() == null || loginRequestDTO.getCorreo().trim().isEmpty()) {
            throw new BadRequestException("El correo no puede estar vacío");
        }
        if (loginRequestDTO.getContraseña() == null || loginRequestDTO.getContraseña().trim().isEmpty()) {
            throw new BadRequestException("La contraseña no puede estar vacía");
        }

        // Buscar usuario por correo
        Usuario usuario = usuarioRepository.obtenerTodos()
            .stream()
            .filter(u -> u.getCorreo().equals(loginRequestDTO.getCorreo()))
            .findFirst()
            .orElseThrow(() -> new BadRequestException("Credenciales inválidas"));

        // Verificar contraseña y estado
        if (!usuario.getContraseña().equals(loginRequestDTO.getContraseña())) {
            throw new BadRequestException("Credenciales inválidas");
        }
        if (!usuario.isEstado()) {
            throw new BadRequestException("Usuario inactivo");
        }

        return convertirADTO(usuario);
    }

    /**
     * Valida los datos de un usuario
     * @param usuarioRequestDTO datos a validar
     * @throws BadRequestException si alguna validación falla
     */
    private void validarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRequestDTO.getNombre() == null || usuarioRequestDTO.getNombre().trim().isEmpty()) {
            throw new BadRequestException("El nombre del usuario no puede estar vacío");
        }
        
        if (usuarioRequestDTO.getCorreo() == null || !usuarioRequestDTO.getCorreo().contains("@")) {
            throw new BadRequestException("El correo debe contener el símbolo @");
        }
        
        if (usuarioRequestDTO.getEdad() <= 0) {
            throw new BadRequestException("La edad debe ser mayor a 0");
        }

        if (usuarioRequestDTO.getRol() == null || usuarioRequestDTO.getRol().trim().isEmpty()) {
            throw new BadRequestException("El rol del usuario no puede estar vacío");
        }

        if (usuarioRequestDTO.getContraseña() == null || usuarioRequestDTO.getContraseña().trim().isEmpty()) {
            throw new BadRequestException("La contraseña del usuario no puede estar vacía");
        }
    }

    /**
     * Convierte una entidad Usuario a un DTO
     * @param usuario la entidad a convertir
     * @return DTO de respuesta
     */
    private UsuarioResponseDTO convertirADTO(Usuario usuario) {
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getCorreo(),
            usuario.getEdad(),
            usuario.getRol(),
            usuario.isEstado(),
            usuario.getContraseña()
        );
    }
}
