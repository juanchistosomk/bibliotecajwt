package com.tallertres.biblioteca.bibliotecajwt.presentation.controllers;

import com.tallertres.biblioteca.bibliotecajwt.persistence.entities.Libro;
import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.*;
import com.tallertres.biblioteca.bibliotecajwt.services.Impl.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {


    @Autowired
    private LibroServiceImpl libroService;

    // Listar libros según una categoría.
    @GetMapping("/categoria/{idCategoria}")
    public List<LibroPorCategoriaDTO> getBooksCategory(@PathVariable int idCategoria){
        return libroService.getBooksByCategory(idCategoria);
    }

    // Listar libros según un autor.
    @GetMapping("/autor/{idAutor}")
    public List<LibroPorAutorDTO> getBooksAutor(@PathVariable int idAutor){
        return libroService.getBooksByAutor(idAutor);
    }

    // Listar libros según un préstamo realizado por un usuario.
    @GetMapping("/prestamo/{idCliente}")
    public List<LibroPorPrestamoDTO> getBooksPrestamo(@PathVariable int idCliente){
        return libroService.getBooksByPrestamo(idCliente);
    }

    /******* CRUD *******/

    @GetMapping("")
    public List<LibroDTO> getAllBooks(){
        return libroService.getAllBooks();
    }

    @PostMapping("/create")
    public ResponseEntity<Libro> createBook(@RequestBody LibroCreateDTO nuevoLibro){
        Libro saveLibro = libroService.createBook(nuevoLibro);
        return ResponseEntity.ok(saveLibro);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Libro> updateBook(@PathVariable Long id, @RequestBody LibroCreateDTO libroDetails){
        Libro updateLibro = libroService.updateBook(id, libroDetails);
        return ResponseEntity.ok(updateLibro);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        libroService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
