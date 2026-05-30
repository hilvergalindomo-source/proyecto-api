# GUÍA RÁPIDA DE PRUEBAS - API Aula POO

## URLs Base
- **URL Base**: `http://localhost:8080/api`
- **Contexto**: `/api`

## Persistencia de Datos
- Los datos se guardan en archivos JSON dentro de la carpeta `data/` del proyecto.
- Archivos:
  - `data/usuarios.json`
  - `data/productos.json`
- Puedes importar la colección Postman desde `POSTMAN_EJEMPLOS.json`.

---

## 🏥 HEALTH CHECK

### GET /health
Verifica que la aplicación está funcionando.

**URL**: `GET http://localhost:8080/api/health`

**Respuesta 200**:
```json
{
  "estado": "UP",
  "mensaje": "La aplicación está funcionando correctamente"
}
```

---

## 👥 USUARIOS

### 1. CREAR USUARIO
**URL**: `POST http://localhost:8080/api/usuarios`

**Headers**:
```
Content-Type: application/json
```

**Body (Request)**:
```json
{
  "nombre": "Juan Pérez",
  "correo": "juan@email.com",
  "edad": 22
}
```

**Respuesta 201 CREATED**:
```json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "correo": "juan@email.com",
  "edad": 22
}
```

**Respuesta 400 BAD REQUEST** (nombre vacío):
```json
{
  "estado": 400,
  "mensaje": "El nombre del usuario no puede estar vacío",
  "timestamp": "2026-05-03T10:15:30.123456",
  "ruta": "/api/usuarios"
}
```

**Respuesta 400 BAD REQUEST** (correo sin @):
```json
{
  "estado": 400,
  "mensaje": "El correo debe contener el símbolo @",
  "timestamp": "2026-05-03T10:15:30.123456",
  "ruta": "/api/usuarios"
}
```

**Respuesta 400 BAD REQUEST** (edad inválida):
```json
{
  "estado": 400,
  "mensaje": "La edad debe ser mayor a 0",
  "timestamp": "2026-05-03T10:15:30.123456",
  "ruta": "/api/usuarios"
}
```

---

### 2. OBTENER UN USUARIO
**URL**: `GET http://localhost:8080/api/usuarios/1`

**Respuesta 200 OK**:
```json
{
  "id": 1,
  "nombre": "Juan Pérez",
  "correo": "juan@email.com",
  "edad": 22
}
```

**Respuesta 404 NOT FOUND**:
```json
{
  "estado": 404,
  "mensaje": "Usuario con ID 999 no encontrado",
  "timestamp": "2026-05-03T10:16:45.123456",
  "ruta": "/api/usuarios/999"
}
```

---

### 3. OBTENER TODOS LOS USUARIOS
**URL**: `GET http://localhost:8080/api/usuarios`

**Respuesta 200 OK**:
```json
[
  {
    "id": 1,
    "nombre": "Juan Pérez",
    "correo": "juan@email.com",
    "edad": 22
  },
  {
    "id": 2,
    "nombre": "María García",
    "correo": "maria@email.com",
    "edad": 23
  }
]
```

---

### 4. ACTUALIZAR USUARIO
**URL**: `PUT http://localhost:8080/api/usuarios/1`

**Headers**:
```
Content-Type: application/json
```

**Body (Request)**:
```json
{
  "nombre": "Juan Carlos Pérez",
  "correo": "juancarlos@email.com",
  "edad": 23
}
```

**Respuesta 200 OK**:
```json
{
  "id": 1,
  "nombre": "Juan Carlos Pérez",
  "correo": "juancarlos@email.com",
  "edad": 23
}
```

---

### 5. ELIMINAR USUARIO
**URL**: `DELETE http://localhost:8080/api/usuarios/1`

**Respuesta 204 NO CONTENT** (sin body)

**Respuesta 404 NOT FOUND**:
```json
{
  "estado": 404,
  "mensaje": "Usuario con ID 999 no encontrado",
  "timestamp": "2026-05-03T10:17:30.123456",
  "ruta": "/api/usuarios/999"
}
```

---

## 📦 PRODUCTOS

### 1. CREAR PRODUCTO
**URL**: `POST http://localhost:8080/api/productos`

**Headers**:
```
Content-Type: application/json
```

**Body (Request)**:
```json
{
  "nombre": "Laptop",
  "precio": 1200.50,
  "stock": 10
}
```

**Respuesta 201 CREATED**:
```json
{
  "id": 1,
  "nombre": "Laptop",
  "precio": 1200.50,
  "stock": 10
}
```

**Respuesta 400 BAD REQUEST** (nombre vacío):
```json
{
  "estado": 400,
  "mensaje": "El nombre del producto no puede estar vacío",
  "timestamp": "2026-05-03T10:20:15.123456",
  "ruta": "/api/productos"
}
```

**Respuesta 400 BAD REQUEST** (precio inválido):
```json
{
  "estado": 400,
  "mensaje": "El precio debe ser mayor a 0",
  "timestamp": "2026-05-03T10:20:15.123456",
  "ruta": "/api/productos"
}
```

**Respuesta 400 BAD REQUEST** (stock negativo):
```json
{
  "estado": 400,
  "mensaje": "El stock no puede ser negativo",
  "timestamp": "2026-05-03T10:20:15.123456",
  "ruta": "/api/productos"
}
```

---

### 2. OBTENER UN PRODUCTO
**URL**: `GET http://localhost:8080/api/productos/1`

**Respuesta 200 OK**:
```json
{
  "id": 1,
  "nombre": "Laptop",
  "precio": 1200.50,
  "stock": 10
}
```

**Respuesta 404 NOT FOUND**:
```json
{
  "estado": 404,
  "mensaje": "Producto con ID 999 no encontrado",
  "timestamp": "2026-05-03T10:21:30.123456",
  "ruta": "/api/productos/999"
}
```

---

### 3. OBTENER TODOS LOS PRODUCTOS
**URL**: `GET http://localhost:8080/api/productos`

**Respuesta 200 OK**:
```json
[
  {
    "id": 1,
    "nombre": "Laptop",
    "precio": 1200.50,
    "stock": 10
  },
  {
    "id": 2,
    "nombre": "Mouse",
    "precio": 25.99,
    "stock": 50
  }
]
```

---

### 4. ACTUALIZAR PRODUCTO
**URL**: `PUT http://localhost:8080/api/productos/1`

**Headers**:
```
Content-Type: application/json
```

**Body (Request)**:
```json
{
  "nombre": "Laptop Gaming",
  "precio": 1500.00,
  "stock": 5
}
```

**Respuesta 200 OK**:
```json
{
  "id": 1,
  "nombre": "Laptop Gaming",
  "precio": 1500.00,
  "stock": 5
}
```

---

### 5. ELIMINAR PRODUCTO
**URL**: `DELETE http://localhost:8080/api/productos/1`

**Respuesta 204 NO CONTENT** (sin body)

**Respuesta 404 NOT FOUND**:
```json
{
  "estado": 404,
  "mensaje": "Producto con ID 999 no encontrado",
  "timestamp": "2026-05-03T10:22:45.123456",
  "ruta": "/api/productos/999"
}
```

---

## 📋 RESUMEN DE ENDPOINTS

| Método | Ruta | Descripción | Status |
|--------|------|-------------|--------|
| GET | `/health` | Verificar salud de la app | 200 |
| POST | `/usuarios` | Crear usuario | 201 |
| GET | `/usuarios` | Listar todos los usuarios | 200 |
| GET | `/usuarios/{id}` | Obtener usuario por ID | 200 |
| PUT | `/usuarios/{id}` | Actualizar usuario | 200 |
| DELETE | `/usuarios/{id}` | Eliminar usuario | 204 |
| POST | `/productos` | Crear producto | 201 |
| GET | `/productos` | Listar todos los productos | 200 |
| GET | `/productos/{id}` | Obtener producto por ID | 200 |
| PUT | `/productos/{id}` | Actualizar producto | 200 |
| DELETE | `/productos/{id}` | Eliminar producto | 204 |

---

## 🧪 EJEMPLO DE FLUJO COMPLETO EN POSTMAN

### Paso 1: Verificar que la app está corriendo
```
GET http://localhost:8080/api/health
```

### Paso 2: Crear un usuario
```
POST http://localhost:8080/api/usuarios
Body:
{
  "nombre": "Carlos López",
  "correo": "carlos@example.com",
  "edad": 25
}
```
**Guardar el ID devuelto (ej: 1)**

### Paso 3: Crear otro usuario
```
POST http://localhost:8080/api/usuarios
Body:
{
  "nombre": "Ana Martínez",
  "correo": "ana@example.com",
  "edad": 28
}
```

### Paso 4: Obtener todos los usuarios
```
GET http://localhost:8080/api/usuarios
```

### Paso 5: Obtener un usuario específico
```
GET http://localhost:8080/api/usuarios/1
```

### Paso 6: Actualizar usuario
```
PUT http://localhost:8080/api/usuarios/1
Body:
{
  "nombre": "Carlos Alberto López",
  "correo": "carlosalberto@example.com",
  "edad": 26
}
```

### Paso 7: Crear productos
```
POST http://localhost:8080/api/productos
Body:
{
  "nombre": "Teclado",
  "precio": 89.99,
  "stock": 20
}
```

### Paso 8: Obtener todos los productos
```
GET http://localhost:8080/api/productos
```

### Paso 9: Eliminar un usuario
```
DELETE http://localhost:8080/api/usuarios/1
```

### Paso 10: Intentar obtener el usuario eliminado (debe devolver 404)
```
GET http://localhost:8080/api/usuarios/1
```

---

## ⚠️ CÓDIGOS DE ESTADO HTTP

- **200 OK**: La solicitud fue exitosa
- **201 CREATED**: El recurso fue creado exitosamente
- **204 NO CONTENT**: La solicitud fue exitosa pero no hay contenido para devolver
- **400 BAD REQUEST**: La solicitud contiene datos inválidos
- **404 NOT FOUND**: El recurso solicitado no existe
- **500 INTERNAL SERVER ERROR**: Error interno del servidor

---

## 💡 NOTAS IMPORTANTES

1. Todos los IDs se generan automáticamente en el servidor
2. Los datos se almacenan en memoria (se pierden al reiniciar la aplicación)
3. Las validaciones se realizan en el servicio
4. Los DTOs Request no incluyen el ID
5. Los DTOs Response incluyen el ID generado por el servidor
6. El contexto de la aplicación es `/api`
