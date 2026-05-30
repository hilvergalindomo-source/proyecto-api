# API Aula POO - Documentación

Proyecto académico de API REST para gestionar Usuarios y Productos, siguiendo principios de Programación Orientada a Objetos (POO).

## 📚 Información del Proyecto

- **Nombre**: api-aula-poo
- **Versión**: 1.0.0
- **Framework**: Spring Boot 3.1.5
- **Java**: 17
- **Propósito**: Proyecto académico para segundo semestre - POO aplicada

## 🎯 Objetivos

✅ Construir un API REST para gestionar Usuarios y Productos  
✅ Implementar CRUD completo para ambas entidades  
✅ Demostrar arquitectura en capas (Controller → Service → Repository)  
✅ Implementar validaciones y manejo de errores  
✅ Usar DTOs para no exponer entidades directamente  
✅ Persistencia en JSON (archivo plano) sin base de datos  

---

## 🏗️ ARQUITECTURA

### Estructura de Paquetes

```
com.educativo.apiaulapoo/
├── model/              # Entidades de dominio
├── dto/                # Data Transfer Objects
│   ├── request/       # DTOs para entrada
│   └── response/      # DTOs para salida
├── repository/         # Capa de persistencia (Map + JSON)
├── service/           # Lógica de negocio
├── controller/        # Endpoints REST
└── exception/         # Manejo de errores
```

### Flujo de una Solicitud

```
1. HTTP Request
   ↓
2. Controller (recibe DTO Request)
   ↓
3. Service (valida y ejecuta lógica)
   ↓
4. Repository (accede a datos)
   ↓
5. Service (convierte a DTO Response)
   ↓
6. Controller (devuelve DTO)
   ↓
7. HTTP Response
```

---

## 📋 COMPONENTES PRINCIPALES

### Model (Entidades de Dominio)

#### Usuario
```java
- id: Long
- nombre: String
- correo: String
- edad: int
```

**Validaciones**:
- nombre no vacío
- correo contiene @
- edad > 0

#### Producto
```java
- id: Long
- nombre: String
- precio: double
- stock: int
```

**Validaciones**:
- nombre no vacío
- precio > 0
- stock >= 0

---

### DTO (Data Transfer Objects)

Los DTOs separan los datos que se envían/reciben de la API de las entidades internas.

#### UsuarioRequestDTO
```json
{
  "nombre": "Juan Pérez",
  "correo": "juan@email.com",
  "edad": 22
}
```

#### UsuarioResponseDTO
```json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "correo": "juan@email.com",
  "edad": 22
}
```

#### ProductoRequestDTO
```json
{
  "nombre": "Laptop",
  "precio": 1200.50,
  "stock": 10
}
```

#### ProductoResponseDTO
```json
{
  "id": 1,
  "nombre": "Laptop",
  "precio": 1200.50,
  "stock": 10
}
```

---

### Repository (Persistencia)

**Patrón**: Interfaz + Implementación

- `UsuarioRepository`: Define operaciones CRUD de Usuario
- `UsuarioRepositoryImpl`: Implementación con `Map<Long, Usuario>` y persistencia en `data/usuarios.json`
- `ProductoRepository`: Define operaciones CRUD de Producto
- `ProductoRepositoryImpl`: Implementación con `Map<Long, Producto>` y persistencia en `data/productos.json`
- `IdGenerator`: Genera IDs secuenciales

**Métodos**:
- `guardar(Entity)`: Crea un nuevo registro
- `buscarPorId(Long)`: Obtiene un registro por ID
- `obtenerTodos()`: Obtiene todos los registros
- `actualizar(Long, Entity)`: Actualiza un registro existente
- `eliminar(Long)`: Elimina un registro

**Modo de persistencia actual**:
- Se trabaja en memoria con `Map<Long, ...>` durante la ejecución.
- Al iniciar la app, se cargan datos desde archivos JSON.
- En cada escritura (crear/actualizar/eliminar), se vuelve a guardar en JSON.
- Archivos usados:
   - `data/usuarios.json`
   - `data/productos.json`

---

### Service (Lógica de Negocio)

**Patrón**: Interfaz + Implementación

- `UsuarioService`: Define operaciones de negocio de Usuario
- `UsuarioServiceImpl`: Implementación con validaciones
- `ProductoService`: Define operaciones de negocio de Producto
- `ProductoServiceImpl`: Implementación con validaciones

**Responsabilidades**:
1. Validar datos de entrada
2. Ejecutar lógica de negocio
3. Llamar al repositorio
4. Convertir entidades a DTOs
5. Lanzar excepciones personalizadas si hay errores

---

### Controller (Endpoints REST)

Los controladores solo reciben/devuelven DTOs y delegan la lógica al servicio.

#### HealthController
- `GET /health`: Verifica que la app está corriendo

#### UsuarioController
- `POST /usuarios`: Crear usuario
- `GET /usuarios`: Listar todos
- `GET /usuarios/{id}`: Obtener por ID
- `PUT /usuarios/{id}`: Actualizar
- `DELETE /usuarios/{id}`: Eliminar

#### ProductoController
- `POST /productos`: Crear producto
- `GET /productos`: Listar todos
- `GET /productos/{id}`: Obtener por ID
- `PUT /productos/{id}`: Actualizar
- `DELETE /productos/{id}`: Eliminar

---

### Exception (Manejo de Errores)

- `ResourceNotFoundException`: Lanzada cuando un recurso no existe (404)
- `BadRequestException`: Lanzada cuando datos son inválidos (400)
- `ErrorResponse`: Estructura de respuesta de error
- `GlobalExceptionHandler`: Intercepta excepciones y devuelve respuestas HTTP apropiadas

**Flujo**:
```
Exception en Service
    ↓
GlobalExceptionHandler la captura
    ↓
Devuelve ResponseEntity con estado HTTP y ErrorResponse
    ↓
Cliente recibe respuesta de error formateada
```

---

## 🚀 CÓMO EJECUTAR

### Requisitos
- Java 17 o superior
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### Pasos

1. **Clonar o descargar el proyecto**
   ```bash
   cd /Users/diegovargas/proyects/educativo/api-aula-poo
   ```

2. **Compilar el proyecto**
   ```bash
   mvn clean package
   ```

3. **Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```
   O ejecutar desde el IDE

4. **Verificar que está corriendo**
   ```bash
   curl http://localhost:8080/api/health
   ```

La aplicación estará disponible en: `http://localhost:8080/api`

---

## 🧪 PRUEBAS CON POSTMAN

Ver archivo [GUIA_POSTMAN.md](GUIA_POSTMAN.md) para:
- URLs de todos los endpoints
- Ejemplos de requests y responses
- Casos de error (validaciones)
- Flujo completo de pruebas

También puedes importar la colección Postman lista en:
- [POSTMAN_EJEMPLOS.json](POSTMAN_EJEMPLOS.json)

---

## 📚 CONCEPTOS POO APLICADOS

### 1. Encapsulación
- Atributos privados en clases
- Getters y setters para acceso controlado
- Lógica de validación centralizada en servicios

### 2. Abstracción
- Interfaces para Repositories y Services
- Los clientes no conocen la implementación
- Pueden reemplazarse implementaciones fácilmente

### 3. Herencia (implícita)
- RuntimeException como base de excepciones personalizadas
- Reutilización de funcionalidad de Spring Boot

### 4. Polimorfismo
- Interfaces implementadas por diferentes clases
- GlobalExceptionHandler maneja múltiples excepciones

### 5. Separación de Responsabilidades
- Controlador: solo recibe y devuelve datos
- Servicio: lógica de negocio y validaciones
- Repositorio: persistencia
- DTO: transferencia de datos
- Excepciones: manejo de errores

---

## 🛠️ TECNOLOGÍAS UTILIZADAS

- **Spring Boot 3.1.5**: Framework web
- **Spring Web**: Para endpoints REST
- **Maven**: Gestor de dependencias
- **Java 17**: Lenguaje de programación

---

## 📝 NOTAS IMPORTANTES

1. **Persistencia en JSON**: Los datos se guardan en `data/usuarios.json` y `data/productos.json`
2. **Sin Base de Datos**: Propósito académico, no usa BD
3. **Sin JPA/Hibernate**: Implementación manual con Map + archivos JSON
4. **DTOs**: No se exponen entidades directamente en la API
5. **Validaciones**: Centralizadas en los servicios
6. **Manejo de Errores**: GlobalExceptionHandler para respuestas consistentes

---

## 📖 REFERENCIAS EDUCATIVAS

### Conceptos POO
- Encapsulación: Datos protegidos, acceso controlado
- Abstracción: Interfaces definen contratos
- Herencia: Clases base proporcionan funcionalidad común
- Polimorfismo: Múltiples implementaciones de interfaces

### Patrones de Diseño
- **DAO (Data Access Object)**: Patrón Repository
- **DTO (Data Transfer Object)**: Separación de datos
- **Service Layer**: Lógica de negocio centralizada
- **Exception Handling**: Manejo consistente de errores

### REST API
- Métodos HTTP: GET, POST, PUT, DELETE
- Códigos de estado: 200, 201, 204, 400, 404, 500
- Requests/Responses en JSON
- DTOs para contratación de API

---

## ✅ CHECKLIST DE REQUISITOS

- [x] Estructura de paquetes (model, dto, service, repository, controller, exception)
- [x] CRUD completo de Usuario
- [x] CRUD completo de Producto
- [x] Endpoint GET /health
- [x] Persistencia en memoria con Map
- [x] No hay lógica en Controllers
- [x] DTOs separados (request/response)
- [x] Validaciones básicas
- [x] Manejo de errores (400, 404)
- [x] Excepciones personalizadas
- [x] GlobalExceptionHandler
- [x] Repositorios con interfaces
- [x] IdGenerator para IDs secuenciales
- [x] Código claro y apropiado para estudiantes

---

## 📞 SOPORTE

Para dudas sobre la arquitectura o conceptos POO, revisar:
- Código comentado en cada clase
- Diagramas en este README
- Ejemplos en GUIA_POSTMAN.md

---

**Proyecto creado el 3 de mayo de 2026**  
**Versión 1.0.0**
