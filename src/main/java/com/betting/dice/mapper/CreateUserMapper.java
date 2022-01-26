package com.betting.dice.mapper;

import com.betting.dice.dto.user.CreateUserDTO;
import com.betting.dice.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserMapper extends GenericMapper<User, CreateUserDTO>{
}
