package github.com.brunomeloesilva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.brunomeloesilva.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
