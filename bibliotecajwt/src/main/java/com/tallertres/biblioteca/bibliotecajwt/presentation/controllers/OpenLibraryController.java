package com.tallertres.biblioteca.bibliotecajwt.presentation.controllers;


import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.OpenLibraryDTO;
import com.tallertres.biblioteca.bibliotecajwt.services.Impl.OpenLibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/openlibrary")
public class OpenLibraryController {

    private final OpenLibraryServiceImpl openLibraryService;

    public OpenLibraryController(OpenLibraryServiceImpl openLibraryService){
        this.openLibraryService=openLibraryService;
    }

    @GetMapping("/{query}")    // Búsqueda por: título, autor, edición o key
    public List<OpenLibraryDTO> getBooks(@PathVariable String query){
        return openLibraryService.searchBooks(query);
    }
}
