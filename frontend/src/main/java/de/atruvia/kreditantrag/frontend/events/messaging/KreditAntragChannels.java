package de.atruvia.kreditantrag.frontend.events.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KreditAntragChannels {
	
	
	String SCORING_POSITIVE = "scoringPositivIn";
	String SCORING_NEGATIVE = "scoringNegativIn";
	String CITY_SCORING_POSITIVE = "cityScoringPositivIn";
	String CITY_SCORING_NEGATIVE = "cityScoringNegativIn";

	@Output
	MessageChannel kreditAntragErfasstOut();

	@Output
	MessageChannel kreditAntragPositivOut();

	@Output
	MessageChannel kreditAntragNegativOut();

	@Input
	SubscribableChannel scoringPositivIn();

	@Input
	SubscribableChannel scoringNegativIn();

	@Input
	SubscribableChannel cityScoringPositivIn();

	@Input
	SubscribableChannel cityScoringNegativIn();

}

