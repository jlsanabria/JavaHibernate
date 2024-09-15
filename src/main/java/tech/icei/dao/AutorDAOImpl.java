package tech.icei.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tech.icei.config.HibernateConfig;
import tech.icei.model.Autor;

public class AutorDAOImpl implements AutorDAO {
    private final SessionFactory factory;
    private Session session;

    public AutorDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Autor getAutor(String codigo) {
        session = factory.openSession();
        session.beginTransaction();
        Query<Autor> query = session
                .createQuery("from Autor a where a.codAutor = :codigoA", Autor.class)
                .setParameter("codigoA", codigo);
        return query.getSingleResult();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        session = factory.openSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
        return autor;
    }
}
