package de.atruvia.kreditantrag.frontend.services.impl;

import de.atruvia.kreditantrag.frontend.models.KreditAntragStatus;
import de.atruvia.kreditantrag.frontend.models.Kreditantrag;
import de.atruvia.kreditantrag.frontend.repositories.KreditAntragRepository;
import de.atruvia.kreditantrag.frontend.repositories.KreditAntragStatusRepository;
import de.atruvia.kreditantrag.frontend.services.KrediantragErfassenService;

public class KrediantragErfassenServiceImpl implements KrediantragErfassenService {
	
	private final KreditAntragRepository kreditAntragRepository;
	private final KreditAntragStatusRepository kreditAntragStatusRepository;
	
	

	public KrediantragErfassenServiceImpl(KreditAntragRepository kreditAntragRepository,KreditAntragStatusRepository kreditAntragStatusRepository) {
		
		this.kreditAntragRepository = kreditAntragRepository;
		this.kreditAntragStatusRepository = kreditAntragStatusRepository;
	}



	@Override
	public void erfassen(Kreditantrag antrag) {
		
		if(kreditAntragRepository.existsById(antrag.getId()))
			throw new RuntimeException("upps");
		
		kreditAntragRepository.save(antrag);
		KreditAntragStatus status = KreditAntragStatus.builder().id(antrag.getId()).build();
		kreditAntragStatusRepository.save(status);

	}

}
