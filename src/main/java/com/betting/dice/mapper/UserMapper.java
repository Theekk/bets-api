package com.betting.dice.mapper;

import com.betting.dice.dto.user.UserDTO;
import com.betting.dice.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User ,UserDTO>{
}
