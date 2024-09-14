package tech.icei.dao;

import org.hibernate.Session;
import tech.icei.model.Autor;

public interface AutorDAO {

    //public void setSession(Session session);

    public Autor getAutor(String codigo);

    public Autor guardarAutor(Autor autor);
}
