package com.api.testemove.repositories;

import com.api.testemove.models.Robo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoboRepository extends JpaRepository<Robo, Long> {
    Optional<List<Robo>> findAllByUsuario_Id(Long userId);
}
