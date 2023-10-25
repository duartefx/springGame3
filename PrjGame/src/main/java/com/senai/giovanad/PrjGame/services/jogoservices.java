package com.senai.giovanad.PrjGame.services;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.senai.giovanad.PrjGame.entities.jogo;
import com.senai.giovanad.PrjGame.repository.jogorepository;

@Service
public class jogoservices {


	private final jogorepository jogoRepository;
	
	public jogoservices (jogorepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public jogo saveJogo (jogo Jogo) {
		return jogoRepository.save(Jogo);
	}
	
	public jogo getjogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	public List <jogo> getAllJogos(){
		return jogoRepository.findAll();
	}
	
	public void deletejogo(Long id) {
		jogoRepository.deleteById(id);
	}
	
	public jogo updateJogo(Long id, jogo novoJogo) {
        Optional<jogo> jogoOptional = jogoRepository.findById(id);
        if (jogoOptional.isPresent()) {
        	jogo jogoExistente = jogoOptional.get();
           	jogoExistente.setName(novoJogo.getName());
        	jogoExistente.setPlataform(novoJogo.getPlataform());          
            return jogoRepository.save(jogoExistente); 
        } else {
            return null; 
        }
    }
}
