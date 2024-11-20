package com.tallertres.biblioteca.bibliotecajwt.presentation.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibroCreateDTO {
    private String titulo;
    private String anioPublicacion;
    private String disponibilidad;
    private String descripcion;
    private Long idAutor;  // ID del autor
    private Long idCategoria;  // ID de la categoría
}
