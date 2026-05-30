# 📋 ESTRUCTURA DEL PROYECTO

```
api-aula-poo/
│
├── 📄 pom.xml                          # Dependencias Maven
├── 📄 README.md                        # Documentación principal
├── 📄 GUIA_POSTMAN.md                  # Guía de pruebas en Postman
├── 📄 ESTRUCTURA.md                    # Este archivo
├── 📄 .gitignore                       # Archivos a ignorar en Git
│
├── 📁 src/main/
│   │
│   ├── 📁 java/com/educativo/apiaulapoo/
│   │   │
│   │   ├── 📄 ApiAulaApplication.java  # Clase principal de Spring Boot
│   │   │
│   │   ├── 📁 model/                   # ===== CAPA DE MODELOS =====
│   │   │   ├── 📄 Usuario.java         # POJO con id, nombre, correo, edad
│   │   │   └── 📄 Producto.java        # POJO con id, nombre, precio, stock
│   │   │
│   │   ├── 📁 dto/                     # ===== CAPA DE DTOs =====
│   │   │   ├── 📁 request/
│   │   │   │   ├── 📄 UsuarioRequestDTO.java
│   │   │   │   └── 📄 ProductoRequestDTO.java
│   │   │   └── 📁 response/
│   │   │       ├── 📄 UsuarioResponseDTO.java
│   │   │       └── 📄 ProductoResponseDTO.java
│   │   │
│   │   ├── 📁 repository/              # ===== CAPA DE PERSISTENCIA =====
│   │   │   ├── 📄 IdGenerator.java     # Generador de IDs secuenciales
│   │   │   ├── 📄 UsuarioRepository.java (Interface)
│   │   │   ├── 📄 UsuarioRepositoryImpl.java (Implementación con Map)
│   │   │   ├── 📄 ProductoRepository.java (Interface)
│   │   │   └── 📄 ProductoRepositoryImpl.java (Implementación con Map)
│   │   │
│   │   ├── 📁 service/                 # ===== CAPA DE LÓGICA DE NEGOCIO =====
│   │   │   ├── 📄 UsuarioService.java (Interface)
│   │   │   ├── 📄 UsuarioServiceImpl.java (Implementación + Validaciones)
│   │   │   ├── 📄 ProductoService.java (Interface)
│   │   │   └── 📄 ProductoServiceImpl.java (Implementación + Validaciones)
│   │   │
│   │   ├── 📁 controller/              # ===== CAPA DE ENDPOINTS REST =====
│   │   │   ├── 📄 HealthController.java (GET /health)
│   │   │   ├── 📄 UsuarioController.java (CRUD Usuarios)
│   │   │   └── 📄 ProductoController.java (CRUD Productos)
│   │   │
│   │   └── 📁 exception/               # ===== CAPA DE EXCEPCIONES =====
│   │       ├── 📄 ResourceNotFoundException.java (404)
│   │       ├── 📄 BadRequestException.java (400)
│   │       ├── 📄 ErrorResponse.java
│   │       └── 📄 GlobalExceptionHandler.java
│   │
│   └── 📁 resources/
│       └── 📄 application.properties    # Configuración de la aplicación
│
└── 📁 target/                          # Archivos compilados (generados por Maven)
```

---

## 📊 RESUMEN DE CAPAS

### 1️⃣ CAPA DE MODELOS (Model Layer)
**Ubicación**: `model/`  
**Responsabilidad**: Definir las entidades de dominio del negocio  
**Archivos**:
- `Usuario.java`: Entidad Usuario con atributos
- `Producto.java`: Entidad Producto con atributos

---

### 2️⃣ CAPA DE DTOs (Transfer Objects Layer)
**Ubicación**: `dto/request/` y `dto/response/`  
**Responsabilidad**: Transferir datos entre cliente y servidor  
**Por qué**: No exponer las entidades directamente en la API  
**Archivos**:
- Request DTOs: Datos que recibe el servidor (sin ID)
- Response DTOs: Datos que devuelve el servidor (con ID)

---

### 3️⃣ CAPA DE REPOSITORIO (Persistence Layer)
**Ubicación**: `repository/`  
**Responsabilidad**: Acceso a datos y persistencia  
**Implementación**: Map en memoria (sin base de datos)  
**Archivos**:
- Interfaces: Definen el contrato de operaciones
- Implementaciones: `RepositoryImpl` con Map<Long, Entity>
- `IdGenerator.java`: Genera IDs secuenciales

---

### 4️⃣ CAPA DE SERVICIOS (Business Logic Layer)
**Ubicación**: `service/`  
**Responsabilidad**: Lógica de negocio y validaciones  
**Características**:
- Valida datos de entrada
- Ejecuta lógica de negocio
- Convierte entidades a DTOs
- Lanza excepciones personalizadas
**Archivos**:
- Interfaces: Definen operaciones de negocio
- Implementaciones: `ServiceImpl` con validaciones y lógica

---

### 5️⃣ CAPA DE CONTROLADORES (REST Controller Layer)
**Ubicación**: `controller/`  
**Responsabilidad**: Endpoints REST y enrutamiento  
**Características**:
- NO contiene lógica de negocio
- Solo recibe y devuelve DTOs
- Delega al servicio
**Archivos**:
- `HealthController.java`: GET /health
- `UsuarioController.java`: CRUD de usuarios
- `ProductoController.java`: CRUD de productos

---

### 6️⃣ CAPA DE EXCEPCIONES (Exception Handling Layer)
**Ubicación**: `exception/`  
**Responsabilidad**: Manejo centralizado de errores  
**Características**:
- Excepciones personalizadas
- Interceptor global de excepciones
- Respuestas de error consistentes
**Archivos**:
- `ResourceNotFoundException.java`: Para 404
- `BadRequestException.java`: Para 400
- `ErrorResponse.java`: Estructura de error
- `GlobalExceptionHandler.java`: Interceptor global

---

## 🔄 FLUJO DE UNA SOLICITUD

```
┌─────────────────────────────────────────────────────────────────┐
│ 1. CLIENT REQUEST                                               │
│    POST /api/usuarios                                           │
│    {nombre: "Juan", correo: "juan@email.com", edad: 22}        │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 2. CONTROLLER                                                   │
│    UsuarioController.crearUsuario(UsuarioRequestDTO)           │
│    - Recibe DTO Request                                         │
│    - Delega al servicio                                         │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 3. SERVICE                                                      │
│    UsuarioServiceImpl.crearUsuario()                            │
│    - Valida datos:                                              │
│      * nombre no vacío ✓                                        │
│      * correo contiene @ ✓                                      │
│      * edad > 0 ✓                                               │
│    - Crea objeto Usuario                                        │
│    - Delega al repositorio                                      │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 4. REPOSITORY                                                   │
│    UsuarioRepositoryImpl.guardar()                              │
│    - Genera ID con IdGenerator                                  │
│    - Guarda en Map<Long, Usuario>                               │
│    - Retorna Usuario con ID asignado                            │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 5. SERVICE (Conversión)                                         │
│    UsuarioServiceImpl.convertirADTO()                           │
│    - Convierte Usuario a UsuarioResponseDTO                     │
│    - Retorna DTO al controlador                                 │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 6. CONTROLLER (Respuesta)                                       │
│    - Devuelve ResponseEntity con DTO                            │
│    - Status HTTP 201 CREATED                                    │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 7. CLIENT RESPONSE                                              │
│    201 CREATED                                                  │
│    {id: 1, nombre: "Juan", correo: "juan@email.com", edad: 22}│
└─────────────────────────────────────────────────────────────────┘
```

---

## 🔀 FLUJO EN CASO DE ERROR

```
┌─────────────────────────────────────────────────────────────────┐
│ 1. CLIENT REQUEST (con datos inválidos)                         │
│    POST /api/usuarios                                           │
│    {nombre: "", correo: "juan", edad: 22}                       │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 2. CONTROLLER                                                   │
│    UsuarioController.crearUsuario(UsuarioRequestDTO)           │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 3. SERVICE                                                      │
│    UsuarioServiceImpl.crearUsuario()                            │
│    - Valida datos:                                              │
│      * nombre vacío ✗ → LANZA BadRequestException               │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 4. EXCEPTION HANDLER                                            │
│    GlobalExceptionHandler.manejarBadRequest()                   │
│    - Captura BadRequestException                                │
│    - Crea ErrorResponse                                         │
│    - Devuelve ResponseEntity con status 400                     │
└─────────────────────────────────────────────────────────────────┘
                              ↓
┌─────────────────────────────────────────────────────────────────┐
│ 5. CLIENT RESPONSE (Error)                                      │
│    400 BAD REQUEST                                              │
│    {                                                            │
│      estado: 400,                                               │
│      mensaje: "El nombre no puede estar vacío",                 │
│      timestamp: "2026-05-03T10:15:30.123456",                   │
│      ruta: "/api/usuarios"                                      │
│    }                                                            │
└─────────────────────────────────────────────────────────────────┘
```

---

## 📝 CONVENIOS Y PATRONES

### Convención de Nombres
- **Interfaces**: `NombreService`, `NombreRepository`
- **Implementaciones**: `NombreServiceImpl`, `NombreRepositoryImpl`
- **DTOs**: `NombreRequestDTO`, `NombreResponseDTO`
- **Excepciones**: `NombreException` (heredan de Exception/RuntimeException)

### Patrones Utilizados
1. **DAO (Data Access Object)**: Repositories
2. **DTO (Data Transfer Object)**: Request/Response DTOs
3. **Service Layer**: Capa de lógica de negocio
4. **Exception Handling**: GlobalExceptionHandler
5. **Dependency Injection**: @Autowired de Spring

### Anotaciones Spring Utilizadas
- `@SpringBootApplication`: Marca la clase principal
- `@RestController`: Controlador REST
- `@Service`: Servicio de negocio
- `@Repository`: Componente de persistencia
- `@Autowired`: Inyección de dependencias
- `@RequestMapping`: Mapeo de rutas
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: Mapeos HTTP
- `@PathVariable`: Variable en la ruta
- `@RequestBody`: Cuerpo de la solicitud
- `@ExceptionHandler`: Manejo de excepciones
- `@RestControllerAdvice`: Interceptor global

---

## 🎓 CONCEPTOS POO APLICADOS

### Encapsulación
```java
// Atributos privados
private String nombre;
private String correo;

// Acceso controlado mediante getters/setters
public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }
```

### Abstracción
```java
// Interface define qué hacer
public interface UsuarioRepository {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorId(Long id);
}

// Implementación define cómo hacerlo
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Override
    public Usuario guardar(Usuario usuario) { ... }
}
```

### Polimorfismo
```java
// GlobalExceptionHandler maneja múltiples excepciones
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorResponse> manejarResourceNotFound(...) { ... }

@ExceptionHandler(BadRequestException.class)
public ResponseEntity<ErrorResponse> manejarBadRequest(...) { ... }
```

### Separación de Responsabilidades
```
Controller     → Solo enrutamiento y DTOs
Service        → Validaciones y lógica de negocio
Repository     → Acceso a datos
Exception      → Manejo de errores
Model          → Datos del dominio
DTO            → Transferencia de datos
```

---

## 📦 ESTADÍSTICAS DEL PROYECTO

| Elemento | Cantidad |
|----------|----------|
| Clases Java | 20 |
| Interfaces | 4 |
| Controladores | 3 |
| Servicios | 2 |
| Repositorios | 2 |
| Excepciones Personalizadas | 2 |
| DTOs | 4 |
| Modelos | 2 |
| Endpoints REST | 11 |

---

## ✅ CHECKLIST DE VALIDACIONES

### Usuario
- [x] Nombre no vacío
- [x] Correo contiene @
- [x] Edad > 0

### Producto
- [x] Nombre no vacío
- [x] Precio > 0
- [x] Stock >= 0

### API
- [x] CRUD completo para Usuario
- [x] CRUD completo para Producto
- [x] Endpoint /health
- [x] Validaciones en servicio
- [x] Manejo de errores 400 y 404
- [x] DTOs separados
- [x] Excepciones personalizadas
- [x] GlobalExceptionHandler
- [x] Persistencia en memoria
- [x] Generación de IDs

---

**Proyecto: API Aula POO**  
**Versión: 1.0.0**  
**Fecha: 3 de mayo de 2026**
