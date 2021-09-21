package de.atruvia.kreditantrag.scoring.events.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KreditAntragChannels {
	
	
	String KREDIT_ANTRAG_ERFASST = "kreditAntragErfasstIn";


	@Input
	SubscribableChannel kreditAntragErfasstIn();

	

	@Output
	MessageChannel scoringPositivOut();

	@Output
	MessageChannel scoringNegativOut();




}

