package com.tallertres.biblioteca.bibliotecajwt.persistence.repositories;

import com.tallertres.biblioteca.bibliotecajwt.persistence.entities.Libro;
import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.LibroDTO;
import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.LibroPorAutorDTO;
import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.LibroPorCategoriaDTO;
import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.LibroPorPrestamoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILibroRepository extends JpaRepository<Libro, Long> {
/*
- Listar libros según una categoría.
- Listar libros según un autor.
- Listar libros según un préstamo realizado por un usuario.
- Buscar, Guardar, actualizar y eliminar libros.
 */

//@Query(nativeQuery = true, value = "SELECT l.titulo, l.anioPublicacion, l.descripcion, c.nombreCategoria FROM libro l, categoria c WHERE l.id_categoria=c.id_categoria AND c.id_categoria=?1 ORDER BY c.categoria")
//List<Object[]> findByCategory(int idCategoria);

//JPQL para crear directamente instancias del DTO.
@Query(value = "SELECT new com.tallertres.biblioteca.bibliotecajwt.presentation.dto.LibroDTO(l.titulo, l.anioPublicacion, l.disponibilidad, l.descripcion)" +
        "FROM Libro l " +
        "ORDER BY l.titulo")
List<LibroDTO> allBooks();


@Query(value = "SELECT new com.tallertres.biblioteca.bibliotecajwt.presentation.dto.LibroPorCategoriaDTO(l.titulo, l.anioPublicacion, l.disponibilidad, l.descripcion, c.nombreCategoria)" +
        "FROM Libro l JOIN l.categoria c " +
        "WHERE c.id=:id_categoria ORDER BY c.nombreCategoria")
List<LibroPorCategoriaDTO> findByCategory(@Param("id_categoria") int idCategoria);


@Query(value = "SELECT new com.tallertres.biblioteca.bibliotecajwt.presentation.dto.LibroPorAutorDTO(l.titulo, l.anioPublicacion, l.disponibilidad, l.descripcion, a.nombre)" +
    "FROM Libro l JOIN l.autor a " +
    "WHERE a.id=:id_autor ORDER BY a.nombre")
List<LibroPorAutorDTO> findByAutor(@Param("id_autor") int idAutor);


@Query(value = "SELECT new com.tallertres.biblioteca.bibliotecajwt.presentation.dto.LibroPorPrestamoDTO(l.titulo, l.anioPublicacion, l.disponibilidad, l.descripcion, p.fechaInicioPrestamo, p.fechaFinPrestamo, c.nombre) " +
        "FROM Libro l JOIN l.prestamos p JOIN p.cliente c " +
        "WHERE c.id=:id_cliente ORDER BY p.fechaInicioPrestamo" )
List<LibroPorPrestamoDTO> findByPrestamo(@Param("id_cliente") int idCliente);


}
