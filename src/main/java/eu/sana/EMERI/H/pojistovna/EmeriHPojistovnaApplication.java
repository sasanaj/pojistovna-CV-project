package eu.sana.EMERI.H.pojistovna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class EmeriHPojistovnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmeriHPojistovnaApplication.class, args);
	}

}
