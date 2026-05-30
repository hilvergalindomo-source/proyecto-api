package com.educativo.apiaulapoo.controller;

import com.educativo.apiaulapoo.dto.request.LoginRequestDTO;
import com.educativo.apiaulapoo.dto.request.UsuarioRequestDTO;
import com.educativo.apiaulapoo.dto.response.UsuarioResponseDTO;
import com.educativo.apiaulapoo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para gestionar Usuarios.
 * Expone los endpoints CRUD para la entidad Usuario.
 * No contiene lógica de negocio; solo recibe y devuelve DTOs.
 * 
 * @RestController anotación que indica que esta clase es un controlador REST.
 * @RequestMapping define la ruta base para todos los endpoints de este controlador.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * POST /usuarios
     * Crea un nuevo usuario
     * 
     * @param usuarioRequestDTO datos del usuario a crear
     * @return ResponseEntity con estado 201 (CREATED) y el usuario creado
     */
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(
            @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        
        UsuarioResponseDTO usuarioCreado = usuarioService.crearUsuario(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

    /**
     * GET /usuarios/{id}
     * Obtiene un usuario por su ID
     * 
     * @param id el ID del usuario a obtener
     * @return ResponseEntity con estado 200 (OK) y el usuario encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.obtenerUsuario(id);
        return ResponseEntity.ok(usuario);
    }

    /**
     * GET /usuarios
     * Obtiene todos los usuarios
     * 
     * @return ResponseEntity con estado 200 (OK) y lista de todos los usuarios
     */
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerTodos() {
        List<UsuarioResponseDTO> usuarios = usuarioService.obtenerTodos();
        return ResponseEntity.ok(usuarios);
    }

    /**
     * PUT /usuarios/{id}
     * Actualiza un usuario existente
     * 
     * @param id el ID del usuario a actualizar
     * @param usuarioRequestDTO nuevos datos del usuario
     * @return ResponseEntity con estado 200 (OK) y el usuario actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        
        UsuarioResponseDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioRequestDTO);
        return ResponseEntity.ok(usuarioActualizado);
    }

    /**
     * DELETE /usuarios/{id}
     * Elimina un usuario por su ID
     * 
     * @param id el ID del usuario a eliminar
     * @return ResponseEntity con estado 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * POST /usuarios/login
     * Valida las credenciales de login
     *
     * @param loginRequestDTO datos de login (correo y contraseña)
     * @return ResponseEntity con estado 200 (OK) y el usuario autenticado
     */
    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        UsuarioResponseDTO usuario = usuarioService.validarLogin(loginRequestDTO);
        return ResponseEntity.ok(usuario);
    }
}
