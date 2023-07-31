package libreria.Persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public abstract class Dao<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("libreriaPU");
    protected EntityManager em = EMF.createEntityManager();

    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void guardar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected void editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected void eliminar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
//
//    protected List<T> consulta(Class<T> entityClass, String atributo, String valor) throws Exception {
//        conectar();
//        List<T> entities = null;
//        try {
//            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + atributo + " = " + valor;
//            TypedQuery<T> query = em.createQuery(jpql, entityClass);
//            entities = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("EXCEPCION AL CONSULTAR ATRIBUTO");
//        }
//        return entities;
//    }

}
