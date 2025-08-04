# Literalura Challenge

Literalura es una aplicación de catálogo de libros de línea de comandos desarrollada como parte de un desafío de Alura. La aplicación permite a los usuarios interactuar con la API de [Gutendex](https://gutendex.com/) para buscar libros y gestionar una base de datos local de libros y autores.

## Características

- **Buscar libros por título:** Busca libros en la API de Gutendex y guarda el resultado en la base de datos local si no existe.
- **Listar libros registrados:** Muestra una lista de todos los libros guardados en la base de datos.
- **Listar autores registrados:** Muestra una lista de todos los autores guardados en la base de datos.
- **Listar autores vivos por año:** Permite filtrar y mostrar autores que estaban vivos en un año determinado.
- **Listar libros por idioma:** Muestra una lista de libros filtrados por idioma (español, inglés, francés, portugués).
- **Top 10 Libros:** Muestra los 10 libros más descargados.

## Tecnologías Utilizadas

- **Lenguaje:** Java 17
- **Framework:** Spring Boot
- **Persistencia de Datos:** Spring Data JPA
- **Base de Datos:** PostgreSQL
- **Build Tool:** Maven
- **API Externa:** Gutendex API

## Prerrequisitos

- JDK 17 o superior
- Maven 3.8 o superior
- Una instancia de PostgreSQL en ejecución

## Configuración y Ejecución

1.  **Clonar el repositorio:**
    ```sh
    git clone <URL-DEL-REPOSITORIO>
    cd demo
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

Al ejecutar la aplicación, se le presentará un menú en la consola para interactuar con las diferentes funcionalidades.

---
*Proyecto desarrollado por Jader como parte del Desafío Literalura de Alura Latam.*
Ejecucion del programa: 
<img width="419" height="727" alt="image" src="https://github.com/user-attachments/assets/52b1f5ab-f6e7-4c71-82ad-8d0f10c92cbc" />
<img width="770" height="425" alt="image" src="https://github.com/user-attachments/assets/0e9abd23-d0e6-432e-9a1a-c75d480cc03d" />
<img width="208" height="521" alt="image" src="https://github.com/user-attachments/assets/45eaba37-b838-4ec9-acbc-4df69e3d0d48" />
<img width="532" height="391" alt="image" src="https://github.com/user-attachments/assets/622a443f-e6ea-4a88-9147-6473bfaed0cc" />
<img width="758" height="357" alt="image" src="https://github.com/user-attachments/assets/0a29029f-b2a1-4b63-8390-08c8f96c62ba" />
<img width="858" height="310" alt="image" src="https://github.com/user-attachments/assets/586b0a58-7d14-4c73-9250-473816f0f647" />
<img width="403" height="213" alt="image" src="https://github.com/user-attachments/assets/1e8b4918-3155-486e-85aa-dc1ca5730e83" />
<img width="523" height="293" alt="image" src="https://github.com/user-attachments/assets/8d28ff56-d7a0-4ed3-980c-312fef6afbbf" />
<img width="995" height="314" alt="image" src="https://github.com/user-attachments/assets/2052a37c-686e-4b84-ad85-3201dabd27de" />
<img width="436" height="265" alt="image" src="https://github.com/user-attachments/assets/684a84b4-d184-48f4-bb48-e8fc73b0f863" />











