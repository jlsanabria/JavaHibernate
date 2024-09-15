package tech.icei;

import org.hibernate.SessionFactory;
import tech.icei.config.HibernateConfig;
import tech.icei.dao.*;
import tech.icei.model.Autor;
import tech.icei.model.Editorial;
import tech.icei.model.Libro;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicio de la fábrica de sesiones de Hibernate
        SessionFactory sessionFactory = HibernateConfig.createSessionFactory();
        // Instanciación de las clases DAO
        AutorDAO autorDAO = new AutorDAOImpl(sessionFactory);
        EditorialDAO editorialDAO = new EditorialDAOImpl(sessionFactory);
        LibroDAO libroDAO = new LibroDAOImpl(sessionFactory);

        //======  AUTORES  ====================================================================
        // Instanciación de autores
        Autor autor11 = new Autor("A-2011", "Svetlana", "Alexiévich", "Bielorusia");
        Autor autor12 = new Autor("A-2012", "Ernest", "Hemingway ", "Estados Unidos");
        Autor autor13 = new Autor("A-2013", "Isabel", "Allende", "Chile");
        Autor autor14 = new Autor("A-2014", "Julio", "Verne", "Francia");
        Autor autor15 = new Autor("A-2015", "Fernando", "Mires", "Chile");
        Autor autor16 = new Autor("A-2016", "Dante", "Alighieri", "Italia");
        Autor autor17 = new Autor("A-2017", "Julio", "Cortazar", "Argentina");
        Autor autor18 = new Autor("A-2018", "Ramón", "Rocha Monrroy", "Bolivia");
        Autor autor19 = new Autor("A-2019", "George", "Orwell", "Reino Unido");
        Autor autor20 = new Autor("A-2020", "Gabriel", "Garcia Marquez", "Colombia");
        // Registro de autores
        autorDAO.guardarAutor(autor11);
        autorDAO.guardarAutor(autor12);
        autorDAO.guardarAutor(autor13);
        autorDAO.guardarAutor(autor14);
        autorDAO.guardarAutor(autor15);
        autorDAO.guardarAutor(autor16);
        autorDAO.guardarAutor(autor17);
        autorDAO.guardarAutor(autor18);
        autorDAO.guardarAutor(autor19);
        autorDAO.guardarAutor(autor20);
        //======================================================================================

        //======  EDITORIALES   ================================================================
        // Instanciación de editoriales
        Editorial editorial11 = new Editorial("Penguin Random House");
        Editorial editorial12 = new Editorial("Bloomsbury");
        Editorial editorial13 = new Editorial("Anagrama");
        Editorial editorial14 = new Editorial("Debate");
        Editorial editorial15 = new Editorial("Kipus");
        Editorial editorial16 = new Editorial("América");
        // Registro de editoriales
        editorialDAO.save(editorial11);
        editorialDAO.save(editorial12);
        editorialDAO.save(editorial13);
        editorialDAO.save(editorial14);
        editorialDAO.save(editorial15);
        editorialDAO.save(editorial16);
        //======================================================================================

        //======  LIBROS   =====================================================================
        // Instanciación de editoriales
        Libro libro11 = new Libro("L-0011", "Voces de Chernóbil", 406, autor11, editorial14);
        Libro libro12 = new Libro("L-0012", "Potosí 1600", 235, autor18, editorial15);
        Libro libro13 = new Libro("L-0013", "1984", 556, autor19, editorial14);
        Libro libro14 = new Libro("L-0014", "El amor en los tiempos del colera", 764, autor20, editorial16);
        Libro libro15 = new Libro("L-0015", "Cien años de soledad", 982, autor20, editorial13);
        Libro libro16 = new Libro("L-0016", "El viejo y el mar", 627, autor12, editorial14);
        Libro libro17 = new Libro("L-0017", "La casa de los espíritus", 482, autor13, editorial15);
        Libro libro18 = new Libro("L-0018", "De la tierra a la luna", 339, autor14, editorial16);
        Libro libro19 = new Libro("L-0019", "La revolución que nadie soñó", 667, autor15, editorial11);
        Libro libro20 = new Libro("L-0020", "La divina comedia", 445, autor16, editorial12);
        Libro libro21 = new Libro("L-0021", "Rayuela", 186, autor17, editorial13);
        Libro libro22 = new Libro("L-0022", "El run run de la calavera", 564, autor18, editorial14);
        Libro libro23 = new Libro("L-0023", "Rebelión en la granja", 633, autor19, editorial15);
        Libro libro24 = new Libro("L-0024", "Los muchachos de zinc", 542, autor11, editorial16);
        Libro libro25 = new Libro("L-0025", "La isla misteriosa", 387, autor14, editorial11);
        Libro libro26 = new Libro("L-0026", "El malestar en la barbarie", 675, autor15, editorial12);
        Libro libro27 = new Libro("L-0027", "La guerra no tiene rostro de mujer", 590, autor11, editorial13);
        // Registro de editoriales
        libroDAO.create(libro11);
        libroDAO.create(libro12);
        libroDAO.create(libro13);
        libroDAO.create(libro14);
        libroDAO.create(libro15);
        libroDAO.create(libro16);
        libroDAO.create(libro17);
        libroDAO.create(libro18);
        libroDAO.create(libro19);
        libroDAO.create(libro20);
        libroDAO.create(libro21);
        libroDAO.create(libro22);
        libroDAO.create(libro23);
        libroDAO.create(libro24);
        libroDAO.create(libro25);
        libroDAO.create(libro26);
        libroDAO.create(libro27);
        //======================================================================================

        //======  OPERACIONES (Listar, Actualizar y Eliminar)   =====================================================================
        Scanner teclado = new Scanner(System.in);

        // --> Listar
        System.out.println("===== LISTA DE LIBROS =====");
        List<Libro> librosBD = libroDAO.readAll();
        librosBD.forEach(System.out::println);
        System.out.println(">>> Se tiene " + librosBD.size() + " libros");

        // --> Listar por título
        System.out.println("===== LISTA DE LIBROS POR TÍTULO =====");
        System.out.print("Título a buscar: ");
        String titulo = teclado.nextLine();
        List<Libro> librosTitulo = libroDAO.searchByTitle(titulo);
        librosTitulo.forEach(System.out::println);
        System.out.println(">>> Se tiene " + librosTitulo.size() + " libros");

        // --> Actualizar libro
        System.out.println("===== ACTUALIZAR LIBRO =====");
        System.out.print("Código del libro: ");
        String codigo = teclado.nextLine();
        String codigoActualizar = codigo;
        Libro libroEncontrado = librosBD
                .stream()
                .filter(l -> l.getCodLibro().equals(codigoActualizar))
                .findAny()
                .orElse(null);
        if (Objects.nonNull(libroEncontrado)) {
            System.out.print("Nuevo título: ");
            libroEncontrado.setTitulo(teclado.nextLine());
            libroDAO.update(libroEncontrado);
            System.out.println(">>> Libro actualizado correctamente!");
        } else System.out.println("!!! Error no se encuentra el libro");

        // --> Eliminar libro
        System.out.println("===== ELIMINAR LIBRO =====");
        System.out.print("Código del libro: ");
        codigo = teclado.nextLine();
        String codigoEliminar = codigo;
        libroEncontrado = librosBD
                .stream()
                .filter(l -> l.getCodLibro().equals(codigoEliminar))
                .findAny()
                .orElse(null);
        if (Objects.nonNull(libroEncontrado)) {
            libroDAO.delete(libroEncontrado);
            System.out.println(">>> Libro eliminado correctamente!");
        }else System.out.println("!!! Error no se encuentra el libro");
    }
}