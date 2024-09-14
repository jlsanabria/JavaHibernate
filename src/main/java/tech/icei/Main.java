package tech.icei;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tech.icei.config.HibernateConfig;
import tech.icei.dao.*;
import tech.icei.model.Autor;
import tech.icei.model.Editorial;
import tech.icei.model.Libro;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
//        // Instancia de la configuración de hibernate
//        HibernateConfig hibernate = new HibernateConfig();
//        // Creando una fábrica de sesiones
//        SessionFactory factory = hibernate.createSessionFactory();
//        // Sesion para realizar operaciones con la BD
//        Session session = factory.openSession();

        // Uso de DAO Autor
//        Autor autor = new Autor("A-2004", "George", "Orwell", "Inglaterra");
//        Autor autor2 = new Autor("A-2005", "Aldoux", "Huxley", "Inglaterra");
//        Autor autor3 = new Autor("A-2006", "Issacc", "Asimov", "Estados Unidos");
//
        AutorDAO autorDAO = new AutorDAOImpl();
//        autorDAO.guardarAutor(autor);
//        autorDAO.guardarAutor(autor2);
//        autorDAO.guardarAutor(autor3);

        // Uso de DAO Editorial
//        Editorial editorial1 = new Editorial("América");
//        Editorial editorial2 = new Editorial("McGraw - Hill");
//        Editorial editorial3 = new Editorial("Salamandra");
//
        EditorialDAO editorialDAO = new EditorialDAOImpl();
//        editorialDAO.save(editorial1);
//        editorialDAO.save(editorial2);
//        editorialDAO.save(editorial3);

        // Uso de DAO Libro
//        Autor autorDB1 = autorDAO.getAutor("A-2006");
//        Editorial editorialDB1 = editorialDAO.getEditorial(2);
//        Autor autorDB2 = autorDAO.getAutor("A-2004");
//        Editorial editorialDB2 = editorialDAO.getEditorial(3);
        Autor autorDB3 = autorDAO.getAutor("A-2003");
        Editorial editorialDB3 = editorialDAO.getEditorial(1);
//        System.out.println("Autor DB 1 --> " + autorDB1);
//        System.out.println("Editorial DB 1 --> " + editorialDB1);
//        System.out.println("Autor DB 2 --> " + autorDB2);
//        System.out.println("Editorial DB 2 --> " + editorialDB2);
        System.out.println("Autor DB 3 --> " + autorDB3);
        System.out.println("Editorial DB 3 --> " + editorialDB3);

//        Libro libro1 = new Libro("L-0001", "Yo Robot", 500, autorDB1, editorialDB1);
        Libro libro3 = new Libro("L-0003", "Soldados de Zinc", 650, autorDB3, editorialDB3);
        LibroDAO libroDAO = new LibroDAOImpl();
//        libroDAO.create(libro1);
        //libroDAO.create(libro2);
        libroDAO.create(libro3);

        // Obtener y listar libros
        List<Libro> librosBD = libroDAO.readAll();
        librosBD.forEach(System.out::println);

        // Actualizar libro
        Libro libroActualizar = librosBD.stream().findAny().orElse(null);
        System.out.println("Libro Actualizar --> " + libroActualizar);
        if(Objects.nonNull(libroActualizar)) {
            libroActualizar.setTitulo("El Mago de Oz");
            libroDAO.update(libroActualizar);
        }

        // Eliminar libro
//        Libro libroEliminar = librosBD
//                .stream()
//                .filter(l -> l.getCodLibro().equals("L-0003"))
//                .findAny().orElse(null);
//        libroDAO.delete(libroEliminar);


//        // Cerramos la sesión
//        session.close();
//        // Cerramos la fábrica de sesiones
//        factory.close();
    }
}