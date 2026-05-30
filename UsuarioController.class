package com.educativo.apiaulapoo.repository;

/**
 * Clase utilitaria para generar IDs secuenciales de forma simple.
 * Es un contador que incrementa cada vez que se solicita un nuevo ID.
 */
public class IdGenerator {
    private static long usuarioIdCounter = 1;
    private static long productoIdCounter = 1;

    /**
     * Genera el siguiente ID para un Usuario
     * @return ID único para usuario
     */
    public static synchronized long generarIdUsuario() {
        return usuarioIdCounter++;
    }

    /**
     * Genera el siguiente ID para un Producto
     * @return ID único para producto
     */
    public static synchronized long generarIdProducto() {
        return productoIdCounter++;
    }

    /**
     * Permite ajustar el siguiente ID de usuario cuando se cargan datos desde archivo.
     * @param siguienteId siguiente ID a usar
     */
    public static synchronized void setSiguienteIdUsuario(long siguienteId) {
        if (siguienteId > usuarioIdCounter) {
            usuarioIdCounter = siguienteId;
        }
    }

    /**
     * Permite ajustar el siguiente ID de producto cuando se cargan datos desde archivo.
     * @param siguienteId siguiente ID a usar
     */
    public static synchronized void setSiguienteIdProducto(long siguienteId) {
        if (siguienteId > productoIdCounter) {
            productoIdCounter = siguienteId;
        }
    }
}
