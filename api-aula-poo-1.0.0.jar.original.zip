package com.educativo.apiaulapoo.exception;

import java.time.LocalDateTime;

/**
 * Clase que representa la estructura de respuesta cuando ocurre un error.
 * Se devuelve al cliente con los detalles del error ocurrido.
 */
public class ErrorResponse {
    private int estado;                      // Código HTTP (400, 404, etc)
    private String mensaje;                  // Mensaje de error
    private LocalDateTime timestamp;         // Momento en que ocurrió el error
    private String ruta;                     // Ruta que causó el error

    // Constructor vacío
    public ErrorResponse() {
    }

    // Constructor con parámetros
    public ErrorResponse(int estado, String mensaje, LocalDateTime timestamp, String ruta) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
        this.ruta = ruta;
    }

    // Getters y Setters
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
