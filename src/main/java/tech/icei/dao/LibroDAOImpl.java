package tech.icei.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tech.icei.config.HibernateConfig;
import tech.icei.model.Libro;

import java.util.List;
import java.util.Objects;

public class LibroDAOImpl implements LibroDAO {
    // Instancia de la configuración de hibernate
    SessionFactory factory = HibernateConfig.createSessionFactory();

    private Session session;

    public LibroDAOImpl() {
        //this.session = session;
        // Sesion para realizar operaciones con la BD
    }

    @Override
    public Libro findByCode(String codLibro) {
        // HQL -->  Hibernate Query Language
        session = factory.openSession();
        session.beginTransaction();
        Query<Libro> query = session.createQuery("from Libro where codLibro = :codLibro", Libro.class);
        query.setParameter("codLibro", codLibro);
        session.close();
        return query.uniqueResult();
    }

    @Override
    public Libro create(Libro libro) {
        session = factory.openSession();
        session.beginTransaction();
        session.persist(libro);
        session.getTransaction().commit();
        session.close();
        return libro;
    }

    @Override
    public List<Libro> readAll() {
        session = factory.openSession();
        session.beginTransaction();
        Query<Libro> query = session.createQuery("from Libro", Libro.class);
        session = factory.openSession();
        return query.list();
    }

    @Override
    public Libro update(Libro libro) {
        session = factory.openSession();
        session.beginTransaction();
        session.merge(libro);
        session.getTransaction().commit();
        session = factory.openSession();
        return libro;
    }

    @Override
    public void delete(Libro libro) {
        session = factory.openSession();
        session.beginTransaction();
        session.remove(libro);
        session.getTransaction().commit();
        session = factory.openSession();
    }

    @Override
    public List<Libro> searchByTitle(String titulo) {
        return List.of();
    }
}
