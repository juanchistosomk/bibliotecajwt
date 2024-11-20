package com.tallertres.biblioteca.bibliotecajwt.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Long idAutor;
    private String nombre;
    private String paisOrigen;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)  // bidireccional
    private List<Libro> libro = new ArrayList<>();

}
