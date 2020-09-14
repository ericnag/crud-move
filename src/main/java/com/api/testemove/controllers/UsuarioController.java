package com.api.testemove.controllers;

import com.api.testemove.dtos.AtualizarUsuarioDto;
import com.api.testemove.dtos.UsuarioDto;
import com.api.testemove.mappers.UsuarioMapper;
import com.api.testemove.models.Usuario;
import com.api.testemove.services.UsuarioService;
import javassist.NotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    private UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        List<Usuario> usuarios = userService.findAll();
        return ResponseEntity.ok(mapper.map(usuarios));
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioDto usuarioDto) throws Exception {
        userService.save(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> alterar(@PathVariable Long id, @RequestBody @Valid AtualizarUsuarioDto usuarioDto) throws NotFoundException {
        Usuario usuario = userService.alterar(id, usuarioDto);
        return ResponseEntity.ok(mapper.usuarioMapper(usuario));
    }
}
