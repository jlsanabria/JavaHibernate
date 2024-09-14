package tech.icei.model;

import jakarta.persistence.*;

@Entity
@Table(name = "icei_editorial")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "editorial_id")
    private Integer editorialId;

    @Column(length = 80)
    private String nombre;
}
