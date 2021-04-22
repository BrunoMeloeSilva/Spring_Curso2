package github.com.brunomeloesilva.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import github.com.brunomeloesilva.modelo.Curso;

@DataJpaTest
//Para não substituir o DB configurado na minha aplicação, pelo DB H2 de Testes padrão.
//Isso seria necessário se eu não estivesse usando um banco em memória.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Para determinar qual o profile a ser usado no teste.
@ActiveProfiles("test")
public class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository cursoRepository;
	//Esse é um TestEntityManager especifico para testes, que tem mais recursos para testes.
	@Autowired
	TestEntityManager testEntityManager;

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		
		Curso novoCurso = new Curso();
		novoCurso.setNome(nomeCurso);
		novoCurso.setCategoria("Programacao");
		testEntityManager.persist(novoCurso);
		
		Curso curso = cursoRepository.findByNome(nomeCurso);
		assertNotNull(curso);
		assertEquals(nomeCurso, curso.getNome());
	}

}
