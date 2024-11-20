package com.tallertres.biblioteca.bibliotecajwt.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LibroPorPrestamoDTO {

    private String titulo;
    private String anioPublicacion;
    private String disponibilidad;
    private String descripcion;
    private LocalDateTime fechaInicioPrestamo;
    private LocalDateTime fechaFinPrestamo;
    private String nombreCliente;

}
