Actúa como un estudiante universitario de segundo semestre de Ingeniería de Software que está aprendiendo HTML, CSS, JavaScript puro y consumo de APIs REST.

Necesito que crees un frontend sencillo, claro y fácil de entender para consumir una API REST hecha en Java con Spring Boot.

IMPORTANTE:
- No uses frameworks.
- No uses React, Vue, Angular, Bootstrap ni librerías externas.
- Usa solamente HTML, CSS y JavaScript puro.
- El código debe parecer hecho por un estudiante de segundo semestre, pero debe funcionar bien.
- El código debe ser simple, ordenado y fácil de explicar en sustentación.
- Agrega comentarios en el código para entender qué hace cada parte.
- No compliques la arquitectura.
- No uses TypeScript.
- No uses módulos avanzados.
- No uses build tools ni npm.
- Todo debe funcionar abriendo los archivos HTML en el navegador o usando Live Server de VSCode.
- El archivo CSS debe estar separado y referenciado desde los HTML.
- El archivo JavaScript debe estar separado y referenciado desde los HTML.

Objetivo de la aplicación:
Crear una aplicación web sencilla tipo dashboard para administrar usuarios y productos consumiendo una API REST.

URL base de la API:
http://localhost:8080/api

Endpoints disponibles:

Health:
GET http://localhost:8080/api/health

CRUD de usuarios:
GET http://localhost:8080/api/usuarios
GET http://localhost:8080/api/usuarios/{id}
POST http://localhost:8080/api/usuarios
PUT http://localhost:8080/api/usuarios/{id}
DELETE http://localhost:8080/api/usuarios/{id}

Datos de usuario:
{
  "nombre": "Juan Perez",
  "correo": "juan@email.com",
  "edad": 22
}

CRUD de productos:
GET http://localhost:8080/api/productos
GET http://localhost:8080/api/productos/{id}
POST http://localhost:8080/api/productos
PUT http://localhost:8080/api/productos/{id}
DELETE http://localhost:8080/api/productos/{id}

Datos de producto:
{
  "nombre": "Laptop",
  "precio": 1200.5,
  "stock": 10
}

Estructura de archivos requerida:

frontend-api-aula/
│
├── index.html
├── usuarios.html
├── productos.html
│
├── css/
│   └── styles.css
│
└── js/
    ├── config.js
    ├── usuarios.js
    └── productos.js

Descripción de cada archivo:

1. index.html
Debe ser la página principal del dashboard.
Debe tener:
- Menú lateral.
- Título de la aplicación.
- Una explicación corta del proyecto.
- Un botón o enlace para ir a Usuarios.
- Un botón o enlace para ir a Productos.
- Una pequeña sección que consulte el endpoint GET /health y muestre si la API está funcionando.
- Debe referenciar css/styles.css.
- Debe usar JavaScript sencillo para consultar el endpoint /health. Puede ser en un archivo JS aparte o directamente en un script sencillo, pero preferiblemente usa un archivo JS separado si lo consideras necesario.

2. usuarios.html
Debe permitir administrar usuarios.
Debe tener:
- Menú lateral con enlaces a Inicio, Usuarios y Productos.
- Tabla para listar usuarios.
- Botón para crear nuevo usuario.
- Formulario sencillo para crear o editar usuario.
- Campos: nombre, correo, edad.
- Botón Guardar.
- Botón Cancelar o Limpiar.
- En cada fila de la tabla debe haber botones de Editar y Eliminar.
- Al presionar Editar, debe cargar los datos del usuario en el formulario.
- Al guardar:
  - Si no hay id seleccionado, debe hacer POST.
  - Si hay id seleccionado, debe hacer PUT.
- Al eliminar, debe pedir confirmación con confirm().
- Después de crear, editar o eliminar, debe volver a listar los usuarios.
- Debe mostrar mensajes sencillos de éxito o error.

3. productos.html
Debe permitir administrar productos.
Debe tener:
- Menú lateral con enlaces a Inicio, Usuarios y Productos.
- Tabla para listar productos.
- Botón para crear nuevo producto.
- Formulario sencillo para crear o editar producto.
- Campos: nombre, precio, stock.
- Botón Guardar.
- Botón Cancelar o Limpiar.
- En cada fila de la tabla debe haber botones de Editar y Eliminar.
- Al presionar Editar, debe cargar los datos del producto en el formulario.
- Al guardar:
  - Si no hay id seleccionado, debe hacer POST.
  - Si hay id seleccionado, debe hacer PUT.
- Al eliminar, debe pedir confirmación con confirm().
- Después de crear, editar o eliminar, debe volver a listar los productos.
- Debe mostrar mensajes sencillos de éxito o error.

4. css/styles.css
Debe contener estilos sencillos y claros.
Debe crear una apariencia tipo dashboard:
- Menú lateral.
- Contenido principal.
- Tablas.
- Formularios.
- Botones.
- Mensajes.
- Diseño responsive para que en pantallas pequeñas el menú y contenido se acomoden bien.
- No usar estilos demasiado complejos.
- Evitar diseños exagerados.
- Usar nombres de clases fáciles de entender.

5. js/config.js
Debe contener una constante con la URL base:
const API_URL = "http://localhost:8080/api";

6. js/usuarios.js
Debe contener toda la lógica de usuarios:
- listarUsuarios()
- guardarUsuario()
- editarUsuario(id)
- eliminarUsuario(id)
- limpiarFormulario()
- mostrarMensaje(texto, tipo)

Debe usar fetch.
Debe usar async/await.
Debe manejar errores con try/catch.
Debe tener comentarios sencillos explicando las partes importantes.

7. js/productos.js
Debe contener toda la lógica de productos:
- listarProductos()
- guardarProducto()
- editarProducto(id)
- eliminarProducto(id)
- limpiarFormulario()
- mostrarMensaje(texto, tipo)

Debe usar fetch.
Debe usar async/await.
Debe manejar errores con try/catch.
Debe tener comentarios sencillos explicando las partes importantes.

Reglas importantes del código:
- Usar nombres de variables claros en español.
- Usar funciones sencillas.
- No crear código innecesariamente avanzado.
- No usar clases JavaScript.
- No usar programación compleja.
- No usar localStorage porque los datos vienen de la API.
- No simular datos quemados.
- Consumir realmente la API REST.
- Si la API devuelve error 400 o 404, mostrar un mensaje entendible.
- Usar Content-Type: application/json en POST y PUT.
- Después de cada operación, actualizar la tabla.

Diseño esperado:
- Dashboard sencillo.
- Menú lateral a la izquierda en escritorio.
- En móvil, el menú puede pasar arriba.
- Tablas limpias.
- Formularios claros.
- Botones básicos: Crear, Editar, Eliminar, Guardar, Cancelar.
- Mensajes visibles para el usuario.

Entrega esperada:
Genera todos los archivos completos.
Primero muestra la estructura de carpetas.
Luego entrega el contenido completo de cada archivo.
El código debe estar listo para copiar y pegar.
No omitas partes.
No entregues solo fragmentos.
No uses pseudocódigo.
No expliques demasiado; enfócate en entregar el código funcional.

Ten presente que este frontend es para estudiantes de segundo semestre que están aprendiendo a consumir una API REST, por eso debe ser muy entendible y fácil de sustentar.