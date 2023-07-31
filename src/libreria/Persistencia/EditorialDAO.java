package libreria.Persistencia;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import libreria.entidades.Editorial;

public class EditorialDAO extends Dao<Editorial> {

    public void guardarEditorial(Editorial editorial) {
        super.guardar(editorial);
    }

    public Editorial buscarnombreEditorial(String nombreEditorial) {
        conectar();
        Query query = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre");
        query.setParameter("nombre", nombreEditorial);
        Editorial editorial = null;

        try {
            editorial = (Editorial) query.getSingleResult();
        } catch (NoResultException e) {
            // Manejar el caso en el que no se encontró ninguna editorial
        } finally {
            desconectar();
        }

        return editorial;
    }

}
