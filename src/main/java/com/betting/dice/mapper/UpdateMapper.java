package com.betting.dice.mapper;

import org.mapstruct.MappingTarget;

public interface UpdateMapper<E, DTO> {

    void updateEntityFromDTO(DTO dto, @MappingTarget E entity);

}
