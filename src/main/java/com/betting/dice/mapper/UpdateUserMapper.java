package com.betting.dice.mapper;

import com.betting.dice.dto.user.UpdateUserDTO;
import com.betting.dice.entities.User;
import com.betting.dice.mapper.common.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper extends GenericMapper<User,UpdateUserDTO> {

}
