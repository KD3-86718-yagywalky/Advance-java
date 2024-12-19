package com.cricket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.pojos.Players;

public interface PlayerDao extends JpaRepository<Players, Long>{

}
