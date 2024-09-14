package tech.icei.dao;

import org.hibernate.Session;
import tech.icei.model.Autor;

public class AutorDAOImpl implements AutorDAO {
    @Override
    public Autor guardarAutor(Autor autor, Session session) {
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        return autor;
    }
}
