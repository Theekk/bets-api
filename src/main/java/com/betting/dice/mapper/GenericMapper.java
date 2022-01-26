package com.betting.dice.mapper;

import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public interface GenericMapper<E, DTO> {

    E mapToEntity(DTO dto);

    List<E> mapToEntity(List<DTO> dtos);

    @InheritInverseConfiguration
    DTO mapToDTO(E entity);

    @InheritInverseConfiguration
    List<DTO> mapToDTO(List<E> entities);

}
