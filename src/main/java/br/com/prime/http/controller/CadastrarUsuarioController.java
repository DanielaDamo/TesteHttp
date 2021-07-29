package br.com.prime.http.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prime.http.model.Usuario;
import br.com.prime.http.repository.UsuarioRepository;

@RestController
@RequestMapping("cadastro")
public class CadastrarUsuarioController {
	private UsuarioRepository repository;

	CadastrarUsuarioController(UsuarioRepository usuarioRepository){
		this.repository=usuarioRepository;
	}
	
	@PostMapping
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
	   return repository.save(usuario);
	}
}
