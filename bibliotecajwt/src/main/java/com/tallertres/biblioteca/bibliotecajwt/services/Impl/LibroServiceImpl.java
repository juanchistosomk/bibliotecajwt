package com.tallertres.biblioteca.bibliotecajwt.services.Impl;


import com.tallertres.biblioteca.bibliotecajwt.persistence.entities.Autor;
import com.tallertres.biblioteca.bibliotecajwt.persistence.entities.Categoria;
import com.tallertres.biblioteca.bibliotecajwt.persistence.entities.Libro;
import com.tallertres.biblioteca.bibliotecajwt.persistence.repositories.IAutorRepository;
import com.tallertres.biblioteca.bibliotecajwt.persistence.repositories.ICategoriaRepository;
import com.tallertres.biblioteca.bibliotecajwt.persistence.repositories.ILibroRepository;
import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroServiceImpl {

    @Autowired
    private ILibroRepository libroRepository;

    @Autowired
    private IAutorRepository autorRepository;

    @Autowired
    private ICategoriaRepository categoriaRepository;

    public List<LibroDTO> getAllBooks(){
        return libroRepository.allBooks();
    }

    public List<LibroPorCategoriaDTO> getBooksByCategory(int idCategoria){
        return libroRepository.findByCategory(idCategoria);
    }

    public List<LibroPorAutorDTO> getBooksByAutor(int idAutor){
        return libroRepository.findByAutor(idAutor);
    }


    public List<LibroPorPrestamoDTO> getBooksByPrestamo(int idCliente){
        return libroRepository.findByPrestamo(idCliente);
    }


    /* CRUD */

    public Libro createBook(LibroCreateDTO libroCreateDTO){
        if (libroCreateDTO.getIdAutor() == null || libroCreateDTO.getIdCategoria() == null) {
            throw new IllegalArgumentException("Los IDs de autor y categoría no pueden ser nulos");
        }
        Libro libro = new Libro();
        libro.setTitulo(libroCreateDTO.getTitulo());
        libro.setAnioPublicacion(libroCreateDTO.getAnioPublicacion());
        libro.setDisponibilidad(libroCreateDTO.getDisponibilidad());
        libro.setDescripcion(libroCreateDTO.getDescripcion());

        // Valida si existe el autor y la categoria
        Autor autor = autorRepository.findById(libroCreateDTO.getIdAutor()).orElseThrow(() -> new RuntimeException("Autor no encontrado."));
        Categoria categoria = categoriaRepository.findById(libroCreateDTO.getIdCategoria()).orElseThrow(()-> new RuntimeException("Categoria no encontrada"));

        libro.setAutor(autor);
        libro.setCategoria(categoria);

        return libroRepository.save(libro);
    }

    public Libro updateBook(Long id, LibroCreateDTO libroDetail ){
        Libro libro = libroRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Libro no encontrado."));

        libro.setTitulo(libroDetail.getTitulo());
        libro.setAnioPublicacion(libroDetail.getAnioPublicacion());
        libro.setDisponibilidad(libroDetail.getDisponibilidad());
        libro.setDescripcion(libroDetail.getDescripcion());

        // Valida si existe el autor y la categoria
        Autor autor = autorRepository.findById(libroDetail.getIdAutor()).orElseThrow(() -> new RuntimeException("Autor no encontrado."));
        Categoria categoria = categoriaRepository.findById(libroDetail.getIdCategoria()).orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
        libro.setAutor(autor);
        libro.setCategoria(categoria);

        return libroRepository.save(libro);
    }

    public void deleteBook(Long idBook){
        // Verificar si el libro existe
        if (!libroRepository.existsById(idBook)) {
            throw new EntityNotFoundException("Libro no encontrado con ID: " + idBook);
        }

        //Libro libro = libroRepository.findById(idBook).orElseThrow(()-> new RuntimeException("Libro no encontrado."));
        libroRepository.deleteById(idBook);
    }



}
