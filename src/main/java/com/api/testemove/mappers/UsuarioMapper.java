package com.api.testemove.mappers;

import com.api.testemove.dtos.UsuarioDto;
import com.api.testemove.models.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    List<UsuarioDto> map(List<Usuario> usuarioList);

    UsuarioDto usuarioMapper(Usuario usuario);

    Usuario usuarioDtoToUsuario(UsuarioDto request, Long id);

}
