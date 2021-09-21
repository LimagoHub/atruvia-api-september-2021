package de.atruvia.kreditantrag.frontend.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.atruvia.kreditantrag.frontend.repositories.KreditAntragRepository;
import de.atruvia.kreditantrag.frontend.repositories.KreditAntragStatusRepository;
import de.atruvia.kreditantrag.frontend.services.KrediantragErfassenService;
import de.atruvia.kreditantrag.frontend.services.impl.KrediantragErfassenServiceImpl;

@Configuration
public class KrediantragErfassenServiceConfig {
	
	@Bean
	public KrediantragErfassenService createService(KreditAntragRepository kreditAntragRepository,	KreditAntragStatusRepository kreditAntragStatusRepository) {
		return new KrediantragErfassenServiceImpl(kreditAntragRepository, kreditAntragStatusRepository);
	}
	

}
