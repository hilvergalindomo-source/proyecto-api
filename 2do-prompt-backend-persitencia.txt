# 🚀 INICIO RÁPIDO

## Requisitos
- ✅ Java 17 o superior
- ✅ Maven 3.6 o superior
- ✅ Postman (opcional, para pruebas)

---

## 1️⃣ COMPILAR EL PROYECTO

```bash
cd /Users/diegovargas/proyects/educativo/api-aula-poo
mvn clean package
```

**Resultado esperado**:
```
[INFO] BUILD SUCCESS
[INFO] Total time: XX.XXXs
```

---

## 2️⃣ EJECUTAR LA APLICACIÓN

### Opción A: Con Maven
```bash
mvn spring-boot:run
```

### Opción B: Desde el IDE
1. Abrir el proyecto en IntelliJ IDEA, Eclipse o VS Code
2. Hacer clic derecho en `ApiAulaApplication.java`
3. Seleccionar "Run" o "Run as Java Application"

### Opción C: Ejecutar el JAR compilado
```bash
java -jar target/api-aula-poo-1.0.0.jar
```

---

## 3️⃣ VERIFICAR QUE ESTÁ CORRIENDO

```bash
curl http://localhost:8080/api/health
```

**Respuesta esperada**:
```json
{
  "estado": "UP",
  "mensaje": "La aplicación está funcionando correctamente"
}
```

La aplicación estará disponible en: **http://localhost:8080/api**

---

## 📝 ARCHIVOS IMPORTANTES

| Archivo | Descripción |
|---------|-------------|
| `README.md` | Documentación principal |
| `ESTRUCTURA.md` | Explicación de la arquitectura |
| `GUIA_POSTMAN.md` | Ejemplos de todos los endpoints |
| `POSTMAN_EJEMPLOS.json` | Colección Postman v2.1 importable |
| `pom.xml` | Configuración de Maven |

### Persistencia de datos (JSON)

- `data/usuarios.json`
- `data/productos.json`

Estos archivos se crean automáticamente cuando inicia la aplicación.

---

## 🧪 PROBAR LA API CON CURL

### Crear un usuario
```bash
curl -X POST http://localhost:8080/api/usuarios \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez",
    "correo": "juan@email.com",
    "edad": 22
  }'
```

### Obtener todos los usuarios
```bash
curl http://localhost:8080/api/usuarios
```

### Obtener un usuario específico
```bash
curl http://localhost:8080/api/usuarios/1
```

### Actualizar un usuario
```bash
curl -X PUT http://localhost:8080/api/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Carlos",
    "correo": "juancarlos@email.com",
    "edad": 23
  }'
```

### Eliminar un usuario
```bash
curl -X DELETE http://localhost:8080/api/usuarios/1
```

---

## 📊 ENDPOINTS DISPONIBLES

### Health
- `GET /api/health` - Verificar estado de la app

### Usuarios
- `POST /api/usuarios` - Crear usuario
- `GET /api/usuarios` - Listar todos
- `GET /api/usuarios/{id}` - Obtener por ID
- `PUT /api/usuarios/{id}` - Actualizar
- `DELETE /api/usuarios/{id}` - Eliminar

### Productos
- `POST /api/productos` - Crear producto
- `GET /api/productos` - Listar todos
- `GET /api/productos/{id}` - Obtener por ID
- `PUT /api/productos/{id}` - Actualizar
- `DELETE /api/productos/{id}` - Eliminar

---

## 🛠️ SOLUCIONAR PROBLEMAS

### Puerto 8080 ya está en uso
```bash
# Cambiar el puerto en application.properties
server.port=8081
```

### Error "Java not found"
```bash
# Verificar que Java está instalado
java -version

# Si no lo está, instalarlo desde https://openjdk.org/
```

### Error de compilación Maven
```bash
# Limpiar caché de Maven
rm -rf ~/.m2/repository

# Reintentar compilación
mvn clean package
```

---

## 📚 SIGUIENTE PASO

Leer [README.md](README.md) para entender la arquitectura en detalle.

---

**¡La API está lista para usar! 🎉**
