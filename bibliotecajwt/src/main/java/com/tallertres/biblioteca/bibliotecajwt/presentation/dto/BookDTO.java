package com.tallertres.biblioteca.bibliotecajwt.presentation.dto;

import lombok.Data;

@Data
public class BookDTO {    // DTO para aplicar en API OpenLibrary
    private String title;
    private String[] author_name; // Este campo se usará para obtener los autores
    private Editions editions;

    @Data
    public static class Editions {
        private int numFound;
    }
}