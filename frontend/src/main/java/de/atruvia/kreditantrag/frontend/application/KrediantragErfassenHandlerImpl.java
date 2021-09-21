package de.atruvia.kreditantrag.frontend.application;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.atruvia.kreditantrag.frontend.events.KrediantragErfasstEvent;
import de.atruvia.kreditantrag.frontend.events.messaging.KreditAntragChannels;
import de.atruvia.kreditantrag.frontend.services.KrediantragErfassenService;


@Service
@Transactional
public class KrediantragErfassenHandlerImpl implements KreditAntragErfassenHandler {
	
	private final KrediantragErfassenService krediantragErfassenService;
	private final KreditAntragChannels channels;
	

	public KrediantragErfassenHandlerImpl(KrediantragErfassenService krediantragErfassenService,
			KreditAntragChannels channels) {
		super();
		this.krediantragErfassenService = krediantragErfassenService;
		this.channels = channels;
	}

	@Override
	public void handle(KrediantragErfasstEvent event) {
		try {
			krediantragErfassenService.erfassen(event.getKreditantrag());
			fireKreditAntragErfasstEvent(event);
		} catch (RuntimeException e) {
			// event
			throw e;
		}
	}
	
	private void fireKreditAntragErfasstEvent(KrediantragErfasstEvent event) {
		
		Message<KrediantragErfasstEvent> message = MessageBuilder.withPayload(event).build();
		channels.kreditAntragErfasstOut().send(message);
	}

}
