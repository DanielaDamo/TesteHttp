package br.com.prime.http.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prime.http.repository.UsuarioRepository;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
	private UsuarioRepository repository;
	UsuarioController(UsuarioRepository usuarioRepository){
		this.repository = usuarioRepository;
	}
	
}
