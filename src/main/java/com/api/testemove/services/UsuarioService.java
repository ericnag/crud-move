package com.api.testemove.services;

import com.api.testemove.dtos.AtualizarUsuarioDto;
import com.api.testemove.dtos.UsuarioDto;
import com.api.testemove.models.Usuario;
import com.api.testemove.repositories.UsuarioRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public void save(UsuarioDto usuarioDto) throws Exception {
        if (repository.findByEmailIgnoreCase(usuarioDto.getEmail()).isPresent()) {
            throw new Exception("Já existe um usuário registrado com este email");
        }

        Usuario usuario = Usuario
                .builder()
                .nome(usuarioDto.getNome())
                .email(usuarioDto.getEmail())
                .build();

        repository.save(usuario);

    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Usuario alterar(Long id, AtualizarUsuarioDto usuarioDto) throws NotFoundException {
        Usuario usuario = repository.findById(id).get();
        if (usuario != null) {
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setNome(usuarioDto.getNome());
            return usuario;
        } else {
            throw new NotFoundException("O usuário não existe");
        }
    }
}
