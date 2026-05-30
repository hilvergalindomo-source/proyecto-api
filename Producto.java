package com.educativo.apiaulapoo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador de Health Check.
 * Proporciona un endpoint para verificar si la aplicación está en funcionamiento.
 * 
 * @RestController anotación que indica que esta clase es un controlador REST.
 * @RequestMapping define la ruta base para todos los endpoints de este controlador.
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    /**
     * Endpoint GET /health
     * Devuelve un estado de salud de la aplicación
     * 
     * @return ResponseEntity con estado OK y mensaje de estado
     */
    @GetMapping
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("estado", "UP");
        respuesta.put("mensaje", "La aplicación está funcionando correctamente");
        
        return ResponseEntity.ok(respuesta);
    }
}
