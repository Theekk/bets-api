package com.betting.dice.services;


import com.betting.dice.dto.bet.BetDTO;
import com.betting.dice.dto.bet.CreateBetDTO;
import com.betting.dice.dto.user.UserDTO;
import com.betting.dice.entities.Bet;
import com.betting.dice.entities.User;
import com.betting.dice.excpetions.DataNotFoundException;
import com.betting.dice.mapper.BetMapper;
import com.betting.dice.mapper.UserMapper;
import com.betting.dice.repositories.BetRepository;
import com.betting.dice.services.interfaces.ICreate;
import com.betting.dice.services.interfaces.IFind;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
@Log4j2
public class BetService implements ICreate<BetDTO, CreateBetDTO>, IFind<UUID, BetDTO>{

    private final UserMapper userMapper;
    private final BetMapper betMapper;
    private final BetRepository betRepository;
    @Qualifier(value = "userService")
    private final IFind<UUID, UserDTO> findUserById;

    @Override
    public BetDTO create(CreateBetDTO createBetDTO) {
        UserDTO userDTO = findUserById.findById(createBetDTO.getUserId());
        Bet bet = Bet.builder()
                .user(userMapper.mapToEntity(userDTO))
                .betAmount(createBetDTO.getBetAmount())
                .chance(BigDecimal.valueOf(createBetDTO.getChance()))
                .build();
        BetDTO betDTO = betMapper.mapToDTO(betRepository.save(bet));
        return betDTO;
    }

    private Bet find(UUID uuid) throws DataNotFoundException {
        Optional<Bet> foundBet = betRepository.findById(uuid);

        if(!foundBet.isEmpty()){
            return foundBet.get();
        }
        throw new DataNotFoundException("Bet not found");
    }

    public List<BetDTO> list(){
        return betMapper.mapToDTO(betRepository.findAll());
    } //findbyuser dps

    @Override
    public BetDTO findById(UUID uuid) throws DataNotFoundException {
        return betMapper.mapToDTO(this.find(uuid));
    }
}
