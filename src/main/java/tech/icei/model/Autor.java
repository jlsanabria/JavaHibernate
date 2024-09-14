package tech.icei.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Jakarta 11

@Entity
@Table(name = "icei_autor")
public class Autor {
    @Id
    @Column(name = "codigo_autor")
    private String codAutor;

    @Column(name = "nombre_autor", length = 50)
    private String nombreAutor;

    @Column(name = "apellido_autor", length = 55)
    private String apellidoAutor;

    @Column(length = 75)
    private String nacionalidad;

    public Autor() {

    }

    public Autor(String codAutor, String nombreAutor, String apellidoAutor, String nacionalidad) {
        this.codAutor = codAutor;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "codAutor='" + codAutor + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", apellidoAutor='" + apellidoAutor + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
