package github.com.brunomeloesilva.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		
		System.out.println(token);
		
		filterChain.doFilter(request, response);
	}

	private String recuperarToken(HttpServletRequest request) {
		String authorizationValue = request.getHeader("Authorization");
		if(authorizationValue == null || authorizationValue.isEmpty() || !authorizationValue.startsWith("Bearer ")) {
			return null;
		}
		return authorizationValue.substring(7, authorizationValue.length());
	}

}
