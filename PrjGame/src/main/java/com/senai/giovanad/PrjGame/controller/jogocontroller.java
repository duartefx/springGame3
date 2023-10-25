package com.senai.giovanad.PrjGame.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.giovanad.PrjGame.entities.jogo;
import com.senai.giovanad.PrjGame.services.jogoservices;

@RestController
@RequestMapping ("/jogos")
public class jogocontroller {
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	
	private final jogoservices jogoServices;
	
	@Autowired
	public jogocontroller (jogoservices jogoService) {
		this.jogoServices = jogoService;
	}
	
	@PostMapping
	public jogo createjogo (@RequestBody jogo Jogo) {
		return jogoServices.saveJogo(Jogo);
	}
	
	
	@DeleteMapping("/{id}")
	public void deletejogo(@PathVariable Long id) {
		jogoServices.deletejogo(id);
	}
	
	@GetMapping
	public ResponseEntity<List<jogo>> getAllJogos(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<jogo> jogos = jogoServices.getAllJogos();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(jogos);
	}
	
	@PutMapping("/{id}")
	public jogo updateJogo(@PathVariable Long id, @RequestBody jogo jogo) {
	    return jogoServices.updateJogo(id, jogo);
	}

	
	
}
