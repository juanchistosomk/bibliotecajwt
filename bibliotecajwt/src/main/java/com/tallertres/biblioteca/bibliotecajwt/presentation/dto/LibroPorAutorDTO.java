package com.tallertres.biblioteca.bibliotecajwt.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibroPorAutorDTO {

    private String titulo;
    private String anioPublicacion;
    private String disponibilidad;
    private String descripcion;
    private String nombreAutor;

}
