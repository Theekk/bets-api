package com.betting.dice.repositories;

import com.betting.dice.dto.user.UserDTO;
import com.betting.dice.entities.Bet;
import com.betting.dice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface BetRepository extends JpaRepository<Bet, UUID> {
    @Query(value = "select b.* from bets b where user_id = ?1", nativeQuery = true)
    List<Bet> findByUser(UUID user);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value = "delete from bets where id = :id and win is null", nativeQuery = true)
    int deleteByIdAndWinIsNull(@Param("id") UUID id);
}
