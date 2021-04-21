package github.com.brunomeloesilva.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import github.com.brunomeloesilva.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date geracao = new Date();
		Date expiracao = new Date(geracao.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
			.setIssuer("PostMan")
			.setSubject(logado.getId().toString())
			.setIssuedAt(geracao)
			.setExpiration(expiracao)
			.signWith(SignatureAlgorithm.HS256, secret)
			.compact();
	}
}
