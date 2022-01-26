package com.betting.dice.services.interfaces;

import com.betting.dice.excpetions.DataNotFoundException;

public interface ICreate<E, DTO> {

    E create(DTO dto);
}
