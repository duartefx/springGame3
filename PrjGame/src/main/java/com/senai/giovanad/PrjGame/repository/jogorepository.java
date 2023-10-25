package com.senai.giovanad.PrjGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.giovanad.PrjGame.entities.jogo;

public interface jogorepository extends JpaRepository<jogo, Long> {
	

}
