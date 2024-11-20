package com.tallertres.biblioteca.bibliotecajwt.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private String username;
    private String password;

}
