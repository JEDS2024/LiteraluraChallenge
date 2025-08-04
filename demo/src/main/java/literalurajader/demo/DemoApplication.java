package literalurajader.demo;

import literalurajader.demo.model.Autor;
import literalurajader.demo.model.Libro;
import literalurajader.demo.model.ResultadoBusqueda;
import literalurajader.demo.repository.AutorRepository;
import literalurajader.demo.repository.LibroRepository;
import literalurajader.demo.service.ConsumoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;

	private Scanner teclado = new Scanner(System.in);
	private ConsumoAPI consumoAPI = new ConsumoAPI();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var opcion = -1;
		while (opcion != 0) {
			var menu = """
				1 - buscar libro por titulo
				2 - listar libros registrados
				3 - listar autores registrados
				4 - listar autores vivos en un determinado año
				5 - listar libros por idioma
				6 - mostrar top 10 libros más descargados
				0 - salir
				Elija la opción a través de su número:
				""" ;
			System.out.println(menu);
			opcion = teclado.nextInt();
			teclado.nextLine(); // Consumir el salto de línea

			switch (opcion) {
				case 1:
					buscarLibroPorTitulo();
					break;
				case 2:
					listarLibrosRegistrados();
					break;
				case 3:
					listarAutoresRegistrados();
					break;
				case 4:
					listarAutoresVivosPorAno();
					break;
				case 5:
					listarLibrosPorIdioma();
					break;
				case 6:
					mostrarTop10LibrosMasDescargados();
					break;
				case 0:
					System.out.println("Cerrando la aplicación...");
					break;
				default:
					System.out.println("Opción inválida. Por favor, intente de nuevo.");
			}
		}
	}

	private void buscarLibroPorTitulo() {
		System.out.println("Ingrese el título del libro que desea buscar:");
		var tituloLibro = teclado.nextLine();
		var json = consumoAPI.obtenerDatos("https://gutendex.com/books/?search=" + tituloLibro.replace(" ", "+"));
		ResultadoBusqueda resultado = consumoAPI.convertirDatos(json, ResultadoBusqueda.class);

		if (resultado != null && !resultado.getResultados().isEmpty()) {
			Libro libroAPI = resultado.getResultados().get(0); // Tomamos el primer resultado

			// Verificar si el libro ya existe en la base de datos
			Optional<Libro> libroExistente = libroRepository.findByTitulo(libroAPI.getTitulo());

			if (libroExistente.isPresent()) {
				System.out.println("El libro \"" + libroAPI.getTitulo() + "\" ya está registrado.");
			} else {
				// Procesar autor
				Autor autorParaGuardar = libroAPI.getAutor(); // Obtener el autor del libroAPI

				// Buscar si el autor ya existe
				Optional<Autor> autorExistente = autorRepository.findByNombre(autorParaGuardar.getNombre());
				Autor autor;
				if (autorExistente.isPresent()) {
					autor = autorExistente.get();
				} else {
					autorRepository.save(autorParaGuardar);
					autor = autorParaGuardar;
				}

				libroAPI.setAutor(autor); // Asignar el autor (existente o nuevo) al libro
				libroRepository.save(libroAPI);
				System.out.println("Libro \"" + libroAPI.getTitulo() + "\" guardado exitosamente.");
			}
		} else {
			System.out.println("Libro no encontrado.");
		}
	}

	private void listarLibrosRegistrados() {
		List<Libro> libros = libroRepository.findAll();
		if (libros.isEmpty()) {
			System.out.println("No hay libros registrados.");
		} else {
			libros.forEach(System.out::println);
		}
	}

	private void listarAutoresRegistrados() {
		List<Autor> autores = autorRepository.findAll();
		if (autores.isEmpty()) {
			System.out.println("No hay autores registrados.");
		} else {
			autores.forEach(System.out::println);
		}
	}

	private void listarAutoresVivosPorAno() {
		System.out.println("Ingrese el año para buscar autores vivos:");
		var ano = teclado.nextInt();
		teclado.nextLine(); // Consumir el salto de línea
		List<Autor> autores = autorRepository.findAutoresVivosEnAno(ano);
		if (autores.isEmpty()) {
			System.out.println("No se encontraron autores vivos en el año " + ano + ".");
		} else {
			autores.forEach(System.out::println);
		}
	}

	private void listarLibrosPorIdioma() {
		System.out.println("Ingrese el idioma para buscar libros (ej. es, en, fr, pt):");
		var idioma = teclado.nextLine();
		List<Libro> libros = libroRepository.findByIdioma(idioma);
		if (libros.isEmpty()) {
			System.out.println("No se encontraron libros en el idioma " + idioma + ".");
		} else {
			libros.forEach(System.out::println);
		}
	}

	private void mostrarTop10LibrosMasDescargados() {
		List<Libro> top10Libros = libroRepository.findTop10ByOrderByNumeroDescargasDesc();
		if (top10Libros.isEmpty()) {
			System.out.println("No hay libros registrados para mostrar el top 10.");
		} else {
			System.out.println("------ TOP 10 LIBROS MÁS DESCARGADOS ------");
			top10Libros.forEach(System.out::println);
			System.out.println("-------------------------------------------");
		}
	}

}


