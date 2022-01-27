package com.betting.dice.dto.bet;

import com.betting.dice.dto.common.BaseDTO;
import com.betting.dice.dto.user.UserDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BetDTO extends BaseDTO<UUID> {
    private UserDTO userDTO;
    private BigDecimal betAmount;
    private BigDecimal chance;
    private BigDecimal payout;
    private Boolean win;
}
