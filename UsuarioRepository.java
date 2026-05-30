package com.educativo.apiaulapoo.dto.request;

/**
 * DTO para recibir datos de login desde el cliente.
 * Incluye email y contraseña para autenticación.
 */
public class LoginRequestDTO {
    private String correo;
    private String contraseña;

    // Constructor vacío
    public LoginRequestDTO() {
    }

    // Constructor con parámetros
    public LoginRequestDTO(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "LoginRequestDTO{" +
                "correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
