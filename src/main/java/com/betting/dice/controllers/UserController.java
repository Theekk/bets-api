package com.betting.dice.controllers;

import com.betting.dice.dto.user.CreateUserDTO;
import com.betting.dice.dto.user.UpdateUserDTO;
import com.betting.dice.dto.user.UserDTO;
import com.betting.dice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> create(@Valid @RequestBody CreateUserDTO createUserDTO){
        return ResponseEntity.ok(userService.create(createUserDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable UUID id, @RequestBody UpdateUserDTO updateUserDTO){
        return ResponseEntity.ok(userService.update(id, updateUserDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findByUser(@PathVariable UUID id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> list(){
        return ResponseEntity.ok(userService.list());
    }

}
