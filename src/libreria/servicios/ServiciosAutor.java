package libreria.servicios;

import java.util.Scanner;
import libreria.Persistencia.AutorDAO;
import libreria.entidades.Autor;

public class ServiciosAutor {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorDAO autorDAO = new AutorDAO();

    public Autor ingresarAutor() {
        System.out.println("coloca el nombre del autor");
        String nombre = leer.next();
        Autor autor = new Autor(nombre, Boolean.TRUE);
        autorDAO.guardarAutor(autor);
        return autor;
    }
}
