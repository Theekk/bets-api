package com.betting.dice.mapper;

import com.betting.dice.dto.user.UpdateUserDTO;
import com.betting.dice.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateUserMapper extends UpdateMapper<User, UpdateUserDTO>{

}
