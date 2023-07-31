package libreria.Persistencia;

import java.util.List;
import libreria.entidades.Autor;

public class AutorDAO extends Dao<Autor> {
//Búsqueda de un Autor por nombre.

    public Autor buscarnombreAutor(String nombreAutor) {
        conectar();
        List<Autor> resultados = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre")
                .setParameter("nombre", nombreAutor)
                .getResultList();
        desconectar();

        if (resultados.isEmpty()) {
            return null; // No se encontró ningún autor con el nombre especificado
        } else {
            return resultados.get(0); // Devuelve el primer autor de la lista de resultados
        }
    }

    public void guardarAutor(Autor autor) {
        super.guardar(autor);
    }

}
