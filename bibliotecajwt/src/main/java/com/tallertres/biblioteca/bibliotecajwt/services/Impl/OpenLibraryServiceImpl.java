package com.tallertres.biblioteca.bibliotecajwt.services.Impl;

import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.BookDTO;
import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.OpenLibraryDTO;
import com.tallertres.biblioteca.bibliotecajwt.presentation.dto.OpenLibraryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class OpenLibraryServiceImpl {


    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(OpenLibraryServiceImpl.class);


    public OpenLibraryServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<OpenLibraryDTO> searchBooks(String query) {
        String url = "https://openlibrary.org/search.json?q=" + query + "&fields=key,title,author_name,editions";
        OpenLibraryResponse response = restTemplate.getForObject(url, OpenLibraryResponse.class);
        logger.info("🟠Conectado a API OpenLibrary");

        // Verificar si la respuesta es null
        if (response == null || response.getDocs() == null) {
            throw new RuntimeException("⛔ No se pudo obtener resultados de la API de OpenLibrary.");
        }

        List<OpenLibraryDTO> result = new ArrayList<>();
        for (BookDTO book : response.getDocs()) {
            OpenLibraryDTO dto = new OpenLibraryDTO();
            dto.setAuthorName(List.of(book.getAuthor_name())); // Convertir el array a lista
            dto.setTitle(book.getTitle());
            dto.setNumFound(book.getEditions().getNumFound());
            result.add(dto);
        }
        return result;
    }


}
