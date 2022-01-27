package com.betting.dice.dto.bet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateBetDTO {
    @NotNull(message = "Informe o Usuario")
    private UUID userId;
    @NotNull(message = "Informe o valor da aposta")
    @Min(1)
    private BigDecimal betAmount;
    @NotNull(message = "Informe o número apostado")
    @Min(1)
    @Max(6)
    private Integer chance;
}
