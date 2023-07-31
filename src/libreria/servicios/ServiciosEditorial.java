package libreria.servicios;

import java.util.Scanner;
import libreria.Persistencia.EditorialDAO;
import libreria.entidades.Editorial;

public class ServiciosEditorial {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    EditorialDAO editorialDAO = new EditorialDAO();

    public Editorial ingresarEditorial() {

        System.out.println("ingrese nombre de editorial");
        String nombre = leer.next();
        Editorial editorial = new Editorial(nombre, Boolean.TRUE);
        editorialDAO.guardarEditorial(editorial);
        return editorial;
    }
}
