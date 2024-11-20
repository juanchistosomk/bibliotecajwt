package com.tallertres.biblioteca.bibliotecajwt.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long idLibro;
    private String titulo;
    private String anioPublicacion;
    private String disponibilidad;
    private String descripcion;

    // @OneToMany, @ManyToOne, @ManyToMany, y @OneToOne

    @ManyToOne   // Aquí va la llave foránea
    @JoinColumn(name = "id_autor", referencedColumnName = "id_autor", nullable = false)
    private Autor autor;  // campo que representa la relación en la otra entidad

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    private Categoria categoria;  // campo que representa la relación en la otra entidad


    @ManyToMany
    @JoinTable(
            name="prestamo_libro",
            joinColumns = @JoinColumn(name="id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_prestamo")
    )
    List<Prestamo> prestamos = new ArrayList<>();

}
