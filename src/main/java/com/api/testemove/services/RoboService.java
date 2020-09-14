package com.api.testemove.services;

import com.api.testemove.dtos.RoboDto;
import com.api.testemove.models.Robo;
import com.api.testemove.models.Usuario;
import com.api.testemove.repositories.RoboRepository;
import com.api.testemove.repositories.UsuarioRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoboService {

    @Autowired
    private RoboRepository roboRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ConectorService conectorService;

    @Transactional
    public void save(Long userId, RoboDto roboDto) throws Exception {
        Usuario usuario = null;
        if (userId != null) {
            usuario = usuarioRepository.findById(userId).get();
            if (usuario == null) {
                throw new Exception("Usuario não existente");
            }
        }

        Robo robo = Robo
                .builder()
                .usuario(usuario)
                .nome(roboDto.getNome())
                .status(roboDto.getStatus())
                .build();

        robo = roboRepository.save(robo);

        if (roboDto.getConectores() != null) {
            conectorService.saveConectores(robo, roboDto.getConectores());
        }
    }

    @Transactional
    public List<Robo> findAllByUserId(Long userId) {
        return roboRepository.findAllByUsuario_Id(userId).get();
    }

    @Transactional
    public void delete(Long id) throws NotFoundException {
        Optional<Robo> robo = roboRepository.findById(id);
        if(robo.isPresent()) {
            robo.get().setUsuario(null);
            roboRepository.deleteById(id);
        } else{
            throw new NotFoundException("Não foi encontrado um robô com ID: " + id);
        }
    }

}
