package github.com.brunomeloesilva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String nomeCurso);

}
