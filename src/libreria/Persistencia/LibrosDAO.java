package libreria.Persistencia;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Libros;

public class LibrosDAO extends Dao<Libros> {

    @Override
    public void guardar(Libros libros) {
        super.guardar(libros);
    }

    /*9) Búsqueda de un libro por ISBN.*/
    public Libros buscarLibrosxISBN(Long isbm) throws Exception {
        conectar();
        Libros libros = em.find(Libros.class, isbm);//busca por clase primaria
        desconectar();
        return libros;
    }


    /*10-Búsqueda de un libro por Título.este es mejor*/
    public Libros buscarLibrosxtitulo(String titulo) throws Exception {
        conectar();
        Libros libros = (Libros) em.createQuery("SELECT l FROM libros l WHERE l.titulo = :titulo").setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libros;
    }

    public Libros buscarLibros(String x, String y) throws Exception {//nombre del atributo y el valor del atributo
        conectar();
        String query = "SELECT l FROM libros l WHERE l." + x + "=:" + y;
        Libros libros = (Libros) em.createQuery(query).getSingleResult();// al hacer asi ya no creo el setParameter
        desconectar();
        return libros;
    }
    //Búsqueda de un libro/s por nombre de Autor.

    public List<Libros> buscarLibrosxnombreAutor(Autor autor) throws Exception {
        conectar();
        List<Libros> libros = em.createQuery("SELECT l FROM Libros l WHERE l.autor = :autor").setParameter("autor", autor).getResultList();//esta parte ya no es necesaria poner el casteo pq esta marcando que es una lista en el otro metodo   <Libros> .
        desconectar();
        return libros;
    }

}
