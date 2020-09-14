package com.api.testemove.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarUsuarioDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

}
