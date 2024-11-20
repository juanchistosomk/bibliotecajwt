package com.tallertres.biblioteca.bibliotecajwt.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class OpenLibraryDTO {
    private List<String> authorName;
    private String title;
    private int numFound;
}
