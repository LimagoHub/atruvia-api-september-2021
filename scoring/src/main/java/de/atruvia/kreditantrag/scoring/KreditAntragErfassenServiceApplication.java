package de.atruvia.kreditantrag.scoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import de.atruvia.kreditantrag.scoring.events.messaging.KreditAntragChannels;

@SpringBootApplication
@EnableBinding(KreditAntragChannels.class)
public class KreditAntragErfassenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KreditAntragErfassenServiceApplication.class, args);
	}
	

}
