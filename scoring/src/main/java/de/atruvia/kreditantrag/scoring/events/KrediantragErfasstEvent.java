package de.atruvia.kreditantrag.scoring.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.atruvia.kreditantrag.scoring.models.Kreditantrag;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KrediantragErfasstEvent extends BaseEvent {

	private Kreditantrag kreditantrag;
}
