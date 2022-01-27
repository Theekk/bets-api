package com.betting.dice.mapper;

import com.betting.dice.dto.bet.BetDTO;
import com.betting.dice.entities.Bet;
import com.betting.dice.mapper.common.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BetMapper extends GenericMapper<Bet , BetDTO> {
    @Override
    @Mapping(source = "user", target = "userDTO")
    BetDTO mapToDTO(Bet entity);
}
