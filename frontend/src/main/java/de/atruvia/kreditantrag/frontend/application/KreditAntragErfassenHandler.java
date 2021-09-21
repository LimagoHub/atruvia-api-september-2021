package de.atruvia.kreditantrag.frontend.application;

import de.atruvia.kreditantrag.frontend.events.KrediantragErfasstEvent;

public interface KreditAntragErfassenHandler {

	void handle(KrediantragErfasstEvent event);

}