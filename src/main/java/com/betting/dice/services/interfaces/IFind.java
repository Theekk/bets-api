package com.betting.dice.services.interfaces;

import com.betting.dice.excpetions.DataNotFoundException;

public interface IFind<ID,DTO> {
    DTO findById(ID id) throws DataNotFoundException;
}
