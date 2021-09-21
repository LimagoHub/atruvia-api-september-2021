package de.atruvia.kreditantrag.scoring.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class ScoringEvent extends BaseEvent {

	private String kreditAntragID;
	
}
