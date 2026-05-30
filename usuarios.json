# 🏛️ DIAGRAMA DE ARQUITECTURA

## ARQUITECTURA EN CAPAS

```
┌─────────────────────────────────────────────────────────────────────────┐
│                         CLIENTE (POSTMAN, CURL)                         │
└─────────────────────────────────────────────────────────────────────────┘
                                    ↓
┌─────────────────────────────────────────────────────────────────────────┐
│                   CONTROLLER LAYER (Endpoints REST)                     │
│                                                                          │
│  ┌──────────────────┐  ┌──────────────────┐  ┌────────────────────┐   │
│  │ HealthController │  │UsuarioController│  │ProductoController │   │
│  │                  │  │                  │  │                    │   │
│  │ GET /health      │  │ CRUD Usuarios    │  │ CRUD Productos     │   │
│  └──────────────────┘  └──────────────────┘  └────────────────────┘   │
│                                                                          │
│  Responsabilidad: Enrutamiento, recepción de DTOs, devolución DTOs     │
└─────────────────────────────────────────────────────────────────────────┘
                                    ↓
            ┌───────────────────────┴───────────────────────┐
            ↓                                               ↓
┌──────────────────────────────────┐    ┌──────────────────────────────┐
│  SERVICE LAYER                   │    │  EXCEPTION LAYER             │
│  (Lógica de Negocio)             │    │  (Manejo de Errores)         │
│                                  │    │                              │
│ ┌────────────────────────────┐   │    │ ┌────────────────────────┐   │
│ │UsuarioService (I)         │   │    │ │ResourceNotFound        │   │
│ │UsuarioServiceImpl          │   │    │ │Exception               │   │
│ │                            │   │    │ │(404)                   │   │
│ │ ✓ Validaciones            │   │    │ └────────────────────────┘   │
│ │ ✓ Conversión DTO ↔ Entity │   │    │                              │
│ │ ✓ Lógica de negocio       │   │    │ ┌────────────────────────┐   │
│ └────────────────────────────┘   │    │ │BadRequestException     │   │
│                                  │    │ │(400)                   │   │
│ ┌────────────────────────────┐   │    │ └────────────────────────┘   │
│ │ProductoService (I)        │   │    │                              │
│ │ProductoServiceImpl         │   │    │ ┌────────────────────────┐   │
│ │                            │   │    │ │GlobalExceptionHandler  │   │
│ │ ✓ Validaciones            │   │    │ │@RestControllerAdvice   │   │
│ │ ✓ Conversión DTO ↔ Entity │   │    │ │                        │   │
│ │ ✓ Lógica de negocio       │   │    │ │Intercepta excepciones  │   │
│ └────────────────────────────┘   │    │ └────────────────────────┘   │
│                                  │    │                              │
│  Validaciones:                   │    │ ┌────────────────────────┐   │
│  • Usuario: nombre, correo, edad │    │ │ErrorResponse           │   │
│  • Producto: nombre, precio, stock   │    │{estado, mensaje,       │   │
│                                  │    │ timestamp, ruta}       │   │
└──────────────────────────────────┘    │ └────────────────────────┘   │
                                  │    │                              │
                                  └──────────────────────────────────┘
            ↓
┌─────────────────────────────────────────────────────────────────────────┐
│  REPOSITORY LAYER (Persistencia)                                        │
│                                                                          │
│  ┌──────────────────────────┐   ┌──────────────────────────┐           │
│  │UsuarioRepository (I)     │   │ProductoRepository (I)    │           │
│  │UsuarioRepositoryImpl      │   │ProductoRepositoryImpl    │           │
│  │                           │   │                          │           │
│  │ Map<Long, Usuario>        │   │ Map<Long, Producto>     │           │
│  │ ┌─────────────────────┐   │   │ ┌─────────────────────┐ │           │
│  │ │ 1 → Usuario{...}    │   │   │ │ 1 → Producto{...}   │ │           │
│  │ │ 2 → Usuario{...}    │   │   │ │ 2 → Producto{...}   │ │           │
│  │ │ 3 → Usuario{...}    │   │   │ │ 3 → Producto{...}   │ │           │
│  │ └─────────────────────┘   │   │ └─────────────────────┘ │           │
│  │                           │   │                          │           │
│  │ Métodos:                  │   │ Métodos:                 │           │
│  │ • guardar()               │   │ • guardar()              │           │
│  │ • buscarPorId()           │   │ • buscarPorId()          │           │
│  │ • obtenerTodos()          │   │ • obtenerTodos()         │           │
│  │ • actualizar()            │   │ • actualizar()           │           │
│  │ • eliminar()              │   │ • eliminar()             │           │
│  └──────────────────────────┘   └──────────────────────────┘           │
│                                                                          │
│  IdGenerator                                                            │
│  ┌────────────────────────────────────────────────────────┐           │
│  │ generarIdUsuario()    → 1, 2, 3, ...                   │           │
│  │ generarIdProducto()   → 1, 2, 3, ...                   │           │
│  └────────────────────────────────────────────────────────┘           │
│                                                                          │
│  Responsabilidad: Acceso a datos en memoria                             │
└─────────────────────────────────────────────────────────────────────────┘
                                    ↓
┌─────────────────────────────────────────────────────────────────────────┐
│  MODEL LAYER (Entidades de Dominio)                                    │
│                                                                          │
│  ┌──────────────────────┐   ┌──────────────────────┐                   │
│  │ Usuario              │   │ Producto             │                   │
│  │                      │   │                      │                   │
│  │ - id: Long           │   │ - id: Long           │                   │
│  │ - nombre: String     │   │ - nombre: String     │                   │
│  │ - correo: String     │   │ - precio: double     │                   │
│  │ - edad: int          │   │ - stock: int         │                   │
│  │                      │   │                      │                   │
│  │ + getters/setters    │   │ + getters/setters    │                   │
│  │ + toString()         │   │ + toString()         │                   │
│  └──────────────────────┘   └──────────────────────┘                   │
│                                                                          │
│  Responsabilidad: Representar datos del dominio                         │
└─────────────────────────────────────────────────────────────────────────┘
                                    ↓
┌─────────────────────────────────────────────────────────────────────────┐
│  DTO LAYER (Transfer Objects)                                           │
│                                                                          │
│  Request DTOs               │   Response DTOs                           │
│  ┌────────────────────────┐ │   ┌────────────────────────┐             │
│  │UsuarioRequestDTO      │ │   │UsuarioResponseDTO      │             │
│  │ - nombre: String       │ │   │ - id: Long             │             │
│  │ - correo: String       │ │   │ - nombre: String       │             │
│  │ - edad: int            │ │   │ - correo: String       │             │
│  └────────────────────────┘ │   │ - edad: int            │             │
│                             │   └────────────────────────┘             │
│  ┌────────────────────────┐ │   ┌────────────────────────┐             │
│  │ProductoRequestDTO      │ │   │ProductoResponseDTO     │             │
│  │ - nombre: String       │ │   │ - id: Long             │             │
│  │ - precio: double       │ │   │ - nombre: String       │             │
│  │ - stock: int           │ │   │ - precio: double       │             │
│  └────────────────────────┘ │   │ - stock: int           │             │
│                             │   └────────────────────────┘             │
│                                                                          │
│  Responsabilidad: Transferir datos entre cliente y servidor             │
└─────────────────────────────────────────────────────────────────────────┘
```

---

## FLUJO DE UNA SOLICITUD POST /usuarios

```
Cliente: POST /api/usuarios
         Body: {nombre: "Juan", correo: "juan@email.com", edad: 22}
              ↓
         Spring Boot mapea a UsuarioRequestDTO
              ↓
         UsuarioController.crearUsuario(UsuarioRequestDTO)
              ↓
         UsuarioServiceImpl.crearUsuario(UsuarioRequestDTO)
              │
              ├─ validarUsuario()
              │  ├─ ¿nombre vacío? → No ✓
              │  ├─ ¿correo sin @? → No ✓
              │  └─ ¿edad ≤ 0? → No ✓
              │
              ├─ new Usuario()
              ├─ usuario.setNombre(...)
              ├─ usuario.setCorreo(...)
              ├─ usuario.setEdad(...)
              │
              ├─ UsuarioRepositoryImpl.guardar(usuario)
              │  ├─ IdGenerator.generarIdUsuario() → 1
              │  ├─ usuario.setId(1)
              │  ├─ map.put(1, usuario)
              │  └─ return usuario
              │
              └─ convertirADTO(usuario)
                 └─ new UsuarioResponseDTO(1, "Juan", "juan@email.com", 22)
              ↓
         ResponseEntity.status(201).body(DTO)
              ↓
Cliente: 201 CREATED
         Body: {id: 1, nombre: "Juan", correo: "juan@email.com", edad: 22}
```

---

## FLUJO EN CASO DE ERROR

```
Cliente: POST /api/usuarios
         Body: {nombre: "", correo: "juan@email.com", edad: 22}
              ↓
         UsuarioController.crearUsuario(UsuarioRequestDTO)
              ↓
         UsuarioServiceImpl.crearUsuario(UsuarioRequestDTO)
              │
              ├─ validarUsuario()
              │  ├─ ¿nombre vacío? → Sí ✗
              │  │
              │  └─ throw new BadRequestException("El nombre no puede estar vacío")
              │
              ↓ [Excepción capturada]
         ↓
         GlobalExceptionHandler.manejarBadRequest(exception, request)
              │
              ├─ new ErrorResponse(
              │    estado: 400,
              │    mensaje: "El nombre no puede estar vacío",
              │    timestamp: "2026-05-03T10:15:30.123456",
              │    ruta: "/api/usuarios"
              │  )
              │
              └─ ResponseEntity.status(400).body(ErrorResponse)
              ↓
Cliente: 400 BAD REQUEST
         Body: {
           estado: 400,
           mensaje: "El nombre no puede estar vacío",
           timestamp: "2026-05-03T10:15:30.123456",
           ruta: "/api/usuarios"
         }
```

---

## INYECCIÓN DE DEPENDENCIAS (@Autowired)

```
┌──────────────────────────┐
│ UsuarioController        │
│                          │
│ @Autowired               │
│ UsuarioService service   │ ←── Spring inyecta
└──────────────────────────┘
         ↓
┌──────────────────────────┐
│ UsuarioServiceImpl        │
│                          │
│ @Autowired               │
│ UsuarioRepository repo   │ ←── Spring inyecta
└──────────────────────────┘
         ↓
┌──────────────────────────┐
│ UsuarioRepositoryImpl     │
│                          │
│ Implementa persistencia  │
└──────────────────────────┘
```

---

## CICLO DE VIDA DE UN USUARIO EN MEMORIA

```
1. CREAR
   IdGenerator.generarIdUsuario() → 1
   UsuarioRepositoryImpl.map.put(1, usuario)
   map = {1 → Usuario{id:1, nombre:"Juan", correo:"juan@email.com", edad:22}}

2. OBTENER
   UsuarioRepositoryImpl.map.get(1)
   → Usuario{id:1, nombre:"Juan", correo:"juan@email.com", edad:22}

3. ACTUALIZAR
   usuario.setNombre("Juan Carlos")
   UsuarioRepositoryImpl.map.put(1, usuario)
   map = {1 → Usuario{id:1, nombre:"Juan Carlos", correo:"juan@email.com", edad:22}}

4. ELIMINAR
   UsuarioRepositoryImpl.map.remove(1)
   map = {} (vacío)

5. OBTENER DESPUÉS DE ELIMINAR
   UsuarioRepositoryImpl.map.get(1) → null → ResourceNotFoundException
```

---

**Arquitectura diseñada para estudiantes de segundo semestre en POO**
