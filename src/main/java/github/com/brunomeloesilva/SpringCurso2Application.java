package github.com.brunomeloesilva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class SpringCurso2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCurso2Application.class, args);
	}

}
