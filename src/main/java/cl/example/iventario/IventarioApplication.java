package cl.example.iventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class IventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(IventarioApplication.class, args);
	}

}
