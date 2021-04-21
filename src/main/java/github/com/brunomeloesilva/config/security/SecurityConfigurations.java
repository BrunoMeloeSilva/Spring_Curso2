package github.com.brunomeloesilva.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	//Configuracoes de autenticacao, controle de acesso, login, etc..
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configuracoes de autorizacao, acesso a urls, perfil de acesso, etc..
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/topicos").permitAll()
		.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
		.anyRequest().authenticated() //Para os demais recursos, tem de autenticar
		.and().formLogin(); //O spring tem um formulário padrão, com um controller interno para receber requests de autenticação
	}
	
	//Configuracoes de recursos estaticos, js, css, imagens, etc..
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
	
	
	/*Só para gerar minha senha de testes com BCrypt
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
	Saída: $2a$10$rmBpkF74yCt9p1vNULdpgeudzRtakVAatfB/Fhann2ZZkcjQXFYwW
	*/
}
