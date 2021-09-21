package de.atruvia.kreditantrag.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import de.atruvia.kreditantrag.frontend.events.messaging.KreditAntragChannels;

@SpringBootApplication
@EnableBinding(KreditAntragChannels.class)
public class KreditAntragErfassenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KreditAntragErfassenServiceApplication.class, args);
	}

}
