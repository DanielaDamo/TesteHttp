package br.com.prime.http.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prime.http.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
