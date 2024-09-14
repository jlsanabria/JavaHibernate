package tech.icei.dao;

import org.hibernate.Session;
import tech.icei.model.Autor;

public interface AutorDAO {
    public Autor guardarAutor(Autor autor, Session session);
}
