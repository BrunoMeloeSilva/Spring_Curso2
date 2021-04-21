package github.com.brunomeloesilva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByEmail(String Email);
}
