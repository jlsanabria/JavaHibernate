package tech.icei.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tech.icei.config.HibernateConfig;
import tech.icei.model.Libro;

import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private final SessionFactory factory;
    private Session session;

    public LibroDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Buscar un libro por código de libro
     * @param codLibro
     * @return
     */
    @Override
    public Libro findByCode(String codLibro) {
        // HQL -->  Hibernate Query Language
        session = factory.openSession();
        Query<Libro> query = session.createQuery("from Libro where codLibro = :codLibro", Libro.class);
        query.setParameter("codLibro", codLibro);
        return query.uniqueResult();
    }

    /**
     * Registrar un libro
     * @param libro
     * @return
     */
    @Override
    public Libro create(Libro libro) {
        session = factory.openSession();
        session.beginTransaction();
        session.persist(libro);
        session.getTransaction().commit();
        session.close();
        return libro;
    }

    /**
     * Listar todos los libros
     * @return
     */
    @Override
    public List<Libro> readAll() {
        session = factory.openSession();
        Query<Libro> query = session.createQuery("from Libro", Libro.class);
        return query.list();
    }

    /**
     * Actualizar un libro
     * @param libro
     * @return
     */
    @Override
    public Libro update(Libro libro) {
        session = factory.openSession();
        session.beginTransaction();
        session.merge(libro);
        session.getTransaction().commit();
        session.close();
        return libro;
    }

    /**
     * Eliminar un libro
     * @param libro
     */
    @Override
    public void delete(Libro libro) {
        session = factory.openSession();
        session.beginTransaction();
        session.remove(libro);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Buscar un libro por títutlo
     * @param titulo
     * @return
     */
    @Override
    public List<Libro> searchByTitle(String titulo) {
        session = factory.openSession();
        Query<Libro> query = session
                .createQuery("from Libro where lower(titulo) like lower(:titulo)", Libro.class)
                .setParameter("titulo", "%" + titulo + "%");
        return query.list();
    }
}
