package com.tallertres.biblioteca.bibliotecajwt.persistence.repositories;

import com.tallertres.biblioteca.bibliotecajwt.persistence.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

}
