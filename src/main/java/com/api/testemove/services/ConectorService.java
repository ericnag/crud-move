package com.api.testemove.services;

import com.api.testemove.dtos.ConectorDto;
import com.api.testemove.dtos.RoboDto;
import com.api.testemove.models.Conector;
import com.api.testemove.models.Robo;
import com.api.testemove.repositories.ConectorRepository;
import com.api.testemove.repositories.RoboRepository;
import com.api.testemove.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConectorService {

    @Autowired
    private ConectorRepository conectorRepository;

    @Transactional
    public void saveConectores(Robo robo, List<ConectorDto> conectorDtoList) {
        for (ConectorDto conectorDto : conectorDtoList) {
            Conector conector = Conector
                    .builder()
                    .robo(robo)
                    .tipo(conectorDto.getTipo())
                    .status(conectorDto.getStatus())
                    .build();
            conectorRepository.save(conector);
        }
    }
}
