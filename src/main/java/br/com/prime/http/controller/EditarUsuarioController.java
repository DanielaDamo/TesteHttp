package br.com.prime.http.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prime.http.model.Usuario;
import br.com.prime.http.repository.UsuarioRepository;

@RestController
@RequestMapping("update")
public class EditarUsuarioController {
	private UsuarioRepository repository;
	
	public EditarUsuarioController(UsuarioRepository usuarioRepository) {
		this.repository = usuarioRepository;
	}
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarDadosUsuario(@PathVariable long id, @RequestBody Usuario usuario ){
		Optional<Usuario> usuarioExiste = repository.findById(id);
		
		try {
			if (usuarioExiste == null) {
				System.out.println("Não existe usuário com essa chave");
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}else{
				Usuario usuarioAtual = usuarioExiste.get();
				usuarioAtual.setNome(usuario.getNome());
				usuarioAtual.setSenha(usuario.getSenha());
				usuarioAtual.setEmail(usuario.getEmail());
				repository.save(usuarioAtual);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
