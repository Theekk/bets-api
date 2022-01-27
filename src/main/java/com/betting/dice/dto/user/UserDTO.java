package com.betting.dice.dto.user;

import com.betting.dice.dto.common.BaseDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO extends BaseDTO<UUID> {
    private String name;
    private BigDecimal balance;
}
