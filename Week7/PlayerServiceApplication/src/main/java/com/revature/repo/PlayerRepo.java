package com.revature.repo;

import org.springframework.data.jpa.repository.*;

import com.revature.domain.Player;


public interface PlayerRepo extends JpaRepository<Player, Integer> {

}
