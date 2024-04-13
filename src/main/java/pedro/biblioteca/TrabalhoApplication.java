package pedro.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoApplication.class, args);
	}

}
