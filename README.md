**Sistema de Gestión de Libros — MVC (Spring Boot + Thymeleaf)**

**📌 Descripción**

Aplicación web MVC para la gestión de Usuarios y Publicaciones (Libros) que permite crear, listar, editar y eliminar registros, con validaciones de formulario, relaciones entre tablas e integridad referencial.

El proyecto implementa patrón MVC, validaciones de datos, formularios con Bootstrap y manejo de relaciones entre entidades.

**⚙️ Tecnologías usadas**

* Java 17+

* Spring Boot

* Spring MVC

* Spring Data JPA

* Thymeleaf

* Bootstrap 5

* Hibernate Validator (Jakarta Validation)

* MySQL

* Maven

**🗄️ Modelo de Datos**

**👤 Usuario**

* idUsuario (PK)

* nombre (obligatorio)

* email (obligatorio — único)

**📝 Publicacion**

* idPublicacion (PK)

* titulo (obligatorio)

* contenido (obligatorio)

* fechaPublicacion (obligatorio)

* usuario (FK → Usuario)


**📂 Estructura del Proyecto**
```bash
controller/
UsuarioController
PublicacionesController

model/
Usuario
Publicaciones

repository/
UsuarioRepository
PublicacionesRepository

service/
IUsuarioService
IPublicacionesService
impl/

templates/
usuarios/index.html
publicaciones/index.html
panel.html
```

**Cómo ejecutar**

**Descargar el backup**

Puedes descargar el archivo directamente desde GitHub:

Ve a la carpeta dentro del repositorio
```bash
database/
```


Click en:
```bash
inventarioLibros_backup.bak
```
Click en Download o Raw para descargar e importar a MYSQL 

Este archivo contiene:

* Estructura completa de las tablas (Usuario, Publicaciones)
* Relaciones y claves foráneas
* Datos de prueba precargados

**Clonar**
```bash
git clone https://github.com/CesarSanchez02/sistema-inventario-libros.git
```

Ejecutar
```bash
./mvnw spring-boot:run
```
o desde IDE → Run Application

Abrir navegador
```bash
http://localhost:8080
```

**✨ Autor**

César Andrés Sánchez 

📧 cesar.ssanchez02@gmail.com

🌐 GitHub – CesarSanchez02