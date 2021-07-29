package br.com.prime.http.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prime.http.model.Usuario;
import br.com.prime.http.repository.UsuarioRepository;

@RestController
@RequestMapping("lista")
public class ListarUsuarioController {
	private UsuarioRepository repository;

	ListarUsuarioController(UsuarioRepository usuarioRepository) {
		this.repository = usuarioRepository;
	}

	@GetMapping
	public List listarUsuarios() {
		return repository.findAll();
	}

	/*
	 * @GetMapping(path = {"/{id}"}) public Optional<Usuario> findById(@PathVariable
	 * long id){ return repository.findById(id); }
	 */

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Object> buscaId(@PathVariable long id) {
		Optional<Usuario> resultadoBusca = null;
		try {
			resultadoBusca = repository.findById(id);
			if (resultadoBusca.equals(null)) {
				System.out.println("Não existesuário com essa chave");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} 
		}catch (Exception e) {
			e.getStackTrace();
		}
		return new ResponseEntity<>(resultadoBusca, HttpStatus.FOUND);
	}
}
