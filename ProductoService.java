package com.educativo.apiaulapoo.dto.request;

/**
 * DTO para recibir datos de Usuario desde el cliente.
 * No incluye el ID porque es generado automáticamente por el servidor.
 */
public class UsuarioRequestDTO {
    private String nombre;
    private String correo;
    private int edad;
    private String rol;
    private boolean estado;
    private String contraseña;

    // Constructor vacío
    public UsuarioRequestDTO() {
    }

    // Constructor con parámetros
    public UsuarioRequestDTO(String nombre, String correo, int edad, String rol, boolean estado, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.rol = rol;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    // Getters y Setters
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
        return "UsuarioRequestDTO{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                ", rol='" + rol + '\'' +
                ", estado=" + estado +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
