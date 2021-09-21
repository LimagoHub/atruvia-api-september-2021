package de.atruvia.kreditantrag.frontend.events;

import de.atruvia.kreditantrag.frontend.models.Kreditantrag;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=true)
public class KrediantragErfasstEvent extends BaseEvent {

	private Kreditantrag kreditantrag;
}
