package com.betting.dice.dto.user;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateUserDTO {
    @NotEmpty(message = "Informe o nome")
    private String name;
    @NotNull(message = "Informe seu balanço atual")
    private BigDecimal balance;
}
