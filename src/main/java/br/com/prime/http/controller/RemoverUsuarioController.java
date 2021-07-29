package br.com.prime.http.controller;



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prime.http.model.Usuario;
import br.com.prime.http.repository.UsuarioRepository;

@RestController
@RequestMapping("remocao")
public class RemoverUsuarioController {
	private UsuarioRepository repository;
	
	RemoverUsuarioController(UsuarioRepository usuarioRepository){
		this.repository = usuarioRepository;
	}
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<Usuario> removerUsuario(@PathVariable long id) {
		repository.findById(id);
		repository.deleteById(id);
		return ResponseEntity.ok().build(); 
		
	}
}
