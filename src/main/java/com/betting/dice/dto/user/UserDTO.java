package com.betting.dice.dto.user;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {
    private UUID id;
    private String name;
    private BigDecimal balance;
}
