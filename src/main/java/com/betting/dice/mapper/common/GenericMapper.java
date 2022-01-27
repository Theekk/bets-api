package com.betting.dice.mapper.common;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<E,DTO> {

    E mapToEntity(DTO dto);

    List<E> mapToEntity(List<DTO> dtos);

    void updateEntityFromDTO(DTO dto, @MappingTarget E entity);

    DTO mapToDTO(E entity);

    List<DTO> mapToDTO(List<E> entities);
}
