package com.betting.dice.mapper;

import com.betting.dice.dto.user.UserDTO;
import com.betting.dice.entities.User;
import com.betting.dice.mapper.common.GenericMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User,UserDTO> {

}
