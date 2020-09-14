package com.api.testemove.controllers;

import com.api.testemove.dtos.RoboDto;
import com.api.testemove.dtos.UsuarioDto;
import com.api.testemove.mappers.RoboMapper;
import com.api.testemove.models.Robo;
import com.api.testemove.services.RoboService;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/robos")
public class RoboController {

    @Autowired
    private RoboService service;

    private RoboMapper mapper = Mappers.getMapper(RoboMapper.class);

    @PostMapping("/{userId}/robo}")
    public ResponseEntity<UsuarioDto> cadastrar(@PathVariable Long userId, @RequestBody @Valid RoboDto roboDto) throws Exception {
        service.save(userId, roboDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{userId}/robo")
    public ResponseEntity<List<RoboDto>> listarRobos(@PathVariable Long userId) {
        List<Robo> robos = service.findAllByUserId(userId);
        if(robos != null){
            return ResponseEntity.ok(mapper.map(robos));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) throws NotFoundException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
