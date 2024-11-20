package com.tallertres.biblioteca.bibliotecajwt.persistence.repositories;


import com.tallertres.biblioteca.bibliotecajwt.persistence.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {
    //Optional<Autor> findByAutor(String autor);
}
