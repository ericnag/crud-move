package com.api.testemove.mappers;

import com.api.testemove.dtos.RoboDto;
import com.api.testemove.models.Robo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoboMapper {

    List<RoboDto> map(List<Robo> roboList);

    RoboDto roboMapper(Robo robo);

    Robo roboDtoToRobo(RoboDto request, Long id);

}
