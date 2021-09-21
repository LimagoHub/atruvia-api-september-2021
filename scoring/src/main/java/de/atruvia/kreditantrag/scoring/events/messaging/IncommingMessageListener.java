package de.atruvia.kreditantrag.scoring.events.messaging;

import org.springframework.messaging.Message;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.stereotype.Component;

import de.atruvia.kreditantrag.scoring.events.KrediantragErfasstEvent;
import de.atruvia.kreditantrag.scoring.events.ScoringEvent;
import de.atruvia.kreditantrag.scoring.models.Kreditantrag;

@Component
public class IncommingMessageListener {
	
	private final KreditAntragChannels channels;

	public IncommingMessageListener(KreditAntragChannels channels) {
		super();
		this.channels = channels;
	}
	
	@StreamListener(KreditAntragChannels.KREDIT_ANTRAG_ERFASST)
	
	public void receiveKreditAntrag(@Payload KrediantragErfasstEvent event) {
		System.out.println("###### Antrag detected");
		Kreditantrag antrag = event.getKreditantrag();
		ScoringEvent outgoingEvent = ScoringEvent.builder().kreditAntragID(antrag.getId()).build();
		Message <ScoringEvent> message = MessageBuilder.withPayload(outgoingEvent).build();
		if(antrag.istKreditWuerdig())
			channels.scoringPositivOut().send(message);
		else
			channels.scoringNegativOut().send(message);
		
	}

}
