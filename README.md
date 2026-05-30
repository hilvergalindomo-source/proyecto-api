Actúa como desarrollador Java Spring Boot con enfoque académico (segundo semestre, POO básica).

Tengo una API REST ya hecha con arquitectura en capas:
- controller
- service
- repository
- model
- dto
- exception

Contexto:
- Ya existe CRUD de Usuario y Producto.
- Actualmente la persistencia es en memoria usando Map<Long, ...>.
- NO usar base de datos.
- NO usar JPA ni Hibernate.
- NO usar Lombok.
- Mantener código simple y claro.
- No mover lógica de negocio al controller.

Objetivo:
Implementar persistencia en archivos JSON para que los datos sobrevivan al reinicio de la app.

Requisitos obligatorios:
1. Mantener el Map en memoria como estructura principal de trabajo.
2. Al iniciar la app, cargar datos desde JSON al Map.
3. En cada operación de escritura (crear, actualizar, eliminar), guardar nuevamente en JSON.
4. Si el archivo o carpeta no existe, crearla automáticamente.
5. Si el archivo está vacío, inicializarlo correctamente (por ejemplo con lista vacía).
6. Mantener IDs autoincrementales y que continúen desde el último ID guardado en JSON.
7. No romper endpoints existentes ni contratos de DTO.
8. Conservar manejo de errores actual (400 y 404).
9. Código entendible para estudiantes (sin patrones complejos).
10. Usar JSON separado para cada entidad (usuarios y productos).

Entregables:
1. Plan breve de cambios por archivo.
2. Código completo por archivo modificado.
3. Explicación corta de cada cambio.
4. Pasos para probar:
   - crear registro
   - reiniciar app
   - consultar y confirmar persistencia
5. Ejemplos de curl o Postman para validar.

Criterios de calidad:
- Compila sin errores.
- No introduce dependencias innecesarias.
- No cambia la arquitectura principal.
- Comentarios cortos solo donde aporten claridad.