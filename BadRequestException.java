package com.educativo.apiaulapoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 * Esta es la clase que inicia la aplicación.
 * 
 * @SpringBootApplication anotación que combina:
 * - @Configuration: la clase puede definir beans
 * - @EnableAutoConfiguration: activa la configuración automática de Spring Boot
 * - @ComponentScan: escanea automáticamente componentes en este paquete y sus subpaquetes
 */
@SpringBootApplication
public class ApiAulaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAulaApplication.class, args);
    }
}
