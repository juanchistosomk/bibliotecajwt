package com.tallertres.biblioteca.bibliotecajwt.presentation.dto;

import lombok.Data;

import java.util.List;

@Data
public class OpenLibraryResponse {
    private int numFound;
    private List<BookDTO> docs; // Esta clase se usa para mapear la respuesta de la API
}
