package br.com.prime.http.repository;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.prime.http.exceptions.AnyExceptionHandler;
import br.com.prime.http.model.response.MensagensErro;

public class ExistenciaDeUsuario {
	@Autowired
	private UsuarioRepository repository;
	public void verificarUsuario(Long id){
		/*if(repository.findById(id) == null){
			MensagensErro mensagem = new MensagensErro("Usuário não existe");
			throw new AnyExceptionHandler(mensagem);
		}*/
	}
}
