package com.betting.dice.controllers;

import com.betting.dice.dto.bet.BetDTO;
import com.betting.dice.dto.bet.CreateBetDTO;
import com.betting.dice.services.BetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/bets")
public class BetController {

    private final BetService betService;

    @PostMapping
    public ResponseEntity<BetDTO> create(@Valid @RequestBody CreateBetDTO createBetDTO){
        return ResponseEntity.ok(betService.create(createBetDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BetDTO> findByBet(@PathVariable UUID id){
        return ResponseEntity.ok(betService.findById(id));
    }
}
