package com.betting.dice.services;

import com.betting.dice.dto.user.CreateUserDTO;
import com.betting.dice.dto.user.UpdateUserDTO;
import com.betting.dice.dto.user.UserDTO;
import com.betting.dice.entities.User;
import com.betting.dice.excpetions.DataNotFoundException;
import com.betting.dice.mapper.*;
import com.betting.dice.repositories.UserRepository;
import com.betting.dice.services.interfaces.ICreate;
import com.betting.dice.services.interfaces.IDelete;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@AllArgsConstructor
public class UserService implements ICreate<UserDTO, CreateUserDTO>, IDelete<UUID> {

    private final UserMapper userMapper;
    private final UpdateUserMapper updateUserMapper;
    private final UserRepository userRepository;

    @Override
    public UserDTO create(CreateUserDTO createUserDTO){
        User user = User.builder()
                .name(createUserDTO.getName())
                .balance(createUserDTO.getBalance())
                .build();
        UserDTO userDTO = userMapper.mapToDTO(userRepository.save(user));
        return userDTO;
    }

    public UserDTO update(UUID id, UpdateUserDTO updateUserDTO) throws DataNotFoundException {
            User user = this.find(id);
            updateUserMapper.updateEntityFromDTO(updateUserDTO, user);
            User updatedUser = userRepository.save(user);
            return userMapper.mapToDTO(updatedUser);
    }

    @Override
    public void delete (UUID id) throws DataNotFoundException {
        userRepository.delete(this.find(id));
    }

    private User find(UUID uuid) throws DataNotFoundException {
        Optional<User> foundUser = userRepository.findById(uuid);

        if (!foundUser.isEmpty()) {
            return foundUser.get();
        }
        throw new DataNotFoundException("User not found");
    }

    public UserDTO findById(UUID uuid) throws DataNotFoundException {
        return userMapper.mapToDTO(this.find(uuid));
    }

    public List<UserDTO> list(){
        return userMapper.mapToDTO(userRepository.findAll());
    }
}
