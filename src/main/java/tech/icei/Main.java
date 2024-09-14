package tech.icei;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tech.icei.config.HibernateConfig;
import tech.icei.dao.AutorDAO;
import tech.icei.dao.AutorDAOImpl;
import tech.icei.model.Autor;

public class Main {
    public static void main(String[] args) {
        // Instancia de la configuración de hibernate
        HibernateConfig hibernate = new HibernateConfig();
        // Creando una fábrica de sesiones
        SessionFactory factory = hibernate.createSessionFactory();
        // Sesion para realizar operaciones con la BD
        Session session = factory.openSession();

        // Uso de DAO Autor
        Autor autor = new Autor("A-2003", "Svetlana", "Alexiévich", "Bielorusia");
        AutorDAO autorDAO = new AutorDAOImpl();
        autorDAO.guardarAutor(autor, session);

        // Cerramos la sesión
        session.close();
        // Cerramos la fábrica de sesiones
        factory.close();
    }
}