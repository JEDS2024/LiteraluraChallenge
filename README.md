# Literalura Challenge

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Maven](https://img.shields.io/badge/Maven-4.0.0-red)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue)

Literalura es una aplicación de catálogo de libros de línea de comandos desarrollada como parte de un desafío de Alura. La aplicación permite a los usuarios interactuar con la API de [Gutendex](https://gutendex.com/) para buscar libros y gestionar una base de datos local de libros y autores.

## Demostración
Aquí se muestra cómo se ve la aplicación en ejecución:

*Menú Principal:*
![Menú Principal] <img width="758" height="357" alt="image" src="https://github.com/user-attachments/assets/0705d1ad-b9da-4f67-8ef2-f26a65357aa7" />


*Búsqueda de Libros:*
![Búsqueda de Libros] <img width="858" height="310" alt="image" src="https://github.com/user-attachments/assets/f1af5dfc-2d57-40cb-a821-a5843b859985" />


*Libros Registrados:*
![Libros Registrados] <img width="1291" height="485" alt="image" src="https://github.com/user-attachments/assets/2341df9b-f68b-4fc8-bc5f-8fd313e0cebc" />


## Características
- **Buscar libros por título:** Busca libros en la API de Gutendex y guarda el resultado en la base de datos local si no existe.
- **Listar libros registrados:** Muestra una lista de todos los libros guardados en la base de datos.
- **Listar autores registrados:** Muestra una lista de todos los autores guardados en la base de datos.
- **Listar autores vivos por año:** Permite filtrar y mostrar autores que estaban vivos en un año determinado.
- **Listar libros por idioma:** Muestra una lista de libros filtrados por idioma (español, inglés, francés, portugués).
- **Top 10 Libros:** Muestra los 10 libros más descargados.

## Tecnologías Utilizadas
| Tecnología | Versión/Tipo |
| :--- | :--- |
| Lenguaje | Java 17 |
| Framework | Spring Boot |
| Persistencia | Spring Data JPA |
| Base de Datos | PostgreSQL |
| Build Tool | Maven |
| API Externa | Gutendex API |

## Cómo Empezar

### Prerrequisitos
- JDK 17 o superior
- Maven 3.8 o superior
- Una instancia de PostgreSQL en ejecución

### Instalación y Ejecución
1.  **Clonar el repositorio:**
    ```sh
    git clone https://github.com/JEDS2024/LiteraluraChallenge.git
    cd LiteraluraChallenge
    ```
2.  **Configurar la base de datos:**
    - Cree una base de datos en PostgreSQL para la aplicación.
    - Abra el archivo `src/main/resources/application.properties`.
    - Actualice las siguientes propiedades con la configuración de su base de datos:
        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_bd
        spring.datasource.username=tu_usuario
        spring.datasource.password=tu_contraseña
        ```
3.  **Construir el proyecto:**
    Utilice Maven para compilar y empaquetar la aplicación.
    ```sh
    mvn clean install
    ```
4.  **Ejecutar la aplicación:**
    Una vez que el proyecto se haya construido correctamente, puede ejecutar la aplicación desde la línea de comandos.
    ```sh
    java -jar target/demo-0.0.1-SNAPSHOT.jar
    ```

---
*Proyecto desarrollado por Jader como parte del Desafío Literalura de Alura Latam.*

