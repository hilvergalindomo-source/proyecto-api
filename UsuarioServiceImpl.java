package com.educativo.apiaulapoo.dto.response;

/**
 * DTO para devolver datos de Usuario al cliente.
 * Incluye todos los campos incluyendo el ID generado por el servidor.
 */
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String correo;
    private int edad;
    private String rol;
    private boolean estado;
    private String contraseña;

    // Constructor vacío
    public UsuarioResponseDTO() {
    }

    // Constructor con parámetros
    public UsuarioResponseDTO(Long id, String nombre, String correo, int edad, String rol, boolean estado, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.rol = rol;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "UsuarioResponseDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                ", rol='" + rol + '\'' +
                ", estado=" + estado +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
