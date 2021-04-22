package github.com.brunomeloesilva.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//Anotação especializada para testar a camada de controller e tudo que tem haver com a camada MVC do projeto.
//@WebMvcTest
@RunWith(SpringRunner.class)
//Como quero testar todas as nossas classes
@SpringBootTest
//Para poder injetar o MockMvc abaixo
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTest {
	
	//Classe que simula uma requisição MVC para o controller.
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveriaDevolver400CasoAutenticacaoEstejaIncorreta() throws Exception {
		URI uri = new URI("/auth");
		String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456\"}";
		
		//Para realizar a requisição
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400));
	}

}
