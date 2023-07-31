package libreria.servicios;

import java.util.List;
import java.util.Scanner;

import libreria.Persistencia.AutorDAO;
import libreria.Persistencia.EditorialDAO;
import libreria.Persistencia.LibrosDAO;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libros;

public class ServiciosLibro {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    LibrosDAO librosDAO = new LibrosDAO();
    AutorDAO autorDAO = new AutorDAO();
    EditorialDAO editorialDAO = new EditorialDAO();
    ServiciosAutor serviciosAutor = new ServiciosAutor();
    ServiciosEditorial serviciosEditorial = new ServiciosEditorial();

    public void ingresarLibro() throws Exception {
        System.out.println("Ingrese el ISBm para buscar");
        Long isbm = leer.nextLong();
        try {
            Libros buscarLibro = librosDAO.buscarLibrosxISBN(isbm);
            mostrarLibro(buscarLibro);
        } catch (Exception e) {
            System.out.println("El libro con ISBN  no fue encontrado en la base de datos.");
            crearLibro();
        }
    }

    public Libros crearLibro() {

        System.out.println("coloca el titulo del libro");
        String titulo = leer.next();

        System.out.println("ingrese la cantidad de ejemplares;");
        Integer ejemplares = leer.nextInt();

        System.out.println("ingrese la cantidad de ejemplares Prestados");
        Integer ejemplaresPrestados = leer.nextInt();

        System.out.println("ingrese la cantidad de ejemplares Restantes");
        Integer ejemplaresRestantes = leer.nextInt();

        System.out.println("ingresar nombre de autor");
        String nombreAutor = leer.next();
        Autor autor = autorDAO.buscarnombreAutor(nombreAutor);
        if (autor == null) {
            System.out.println("tienes que crear el autor");
            autor = serviciosAutor.ingresarAutor();
        }

        System.out.println("coloca el nombre de la editorial");
        String nombreEditorial = leer.next();
        Editorial editorial = editorialDAO.buscarnombreEditorial(nombreEditorial);

        if (editorial == null) {
            System.out.println("tienes que crear la editorial");
            editorial = serviciosEditorial.ingresarEditorial();
        }

        Libros libro = new Libros(titulo, ejemplares, ejemplares, ejemplaresPrestados, ejemplaresRestantes, Boolean.TRUE, autor, editorial);
        librosDAO.guardar(libro);

        return libro;

    }

    private void mostrarLibro(Libros libro) {
        System.out.println("LIBRO ENCONTRADO!");
        System.out.println("titulo " + libro.getTitulo());
        System.out.println("cantidad de ejemplares " + libro.getEjemplares());
        System.out.println("cantidad de ejemplares Prestados " + libro.getEjemplaresPrestados());
        System.out.println("ejemplares Restantes " + libro.getEjemplaresRestantes());
    }

    public Autor buscarporNombredeAutor() throws Exception {
        System.out.println("ingrese el nombre del autor");
        String nombre = leer.next();
        Autor autor = autorDAO.buscarnombreAutor(nombre);
        if (autor != null) {
            List<Libros> listalibros = librosDAO.buscarLibrosxnombreAutor(autor);
            for (Libros libro : listalibros) {
                mostrarLibro(libro);
            }
        }
        return autor;

    }

}
