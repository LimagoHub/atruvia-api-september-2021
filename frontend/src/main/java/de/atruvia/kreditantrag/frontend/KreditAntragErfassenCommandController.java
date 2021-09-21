package de.atruvia.kreditantrag.frontend;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.atruvia.kreditantrag.frontend.application.KreditAntragErfassenHandler;
import de.atruvia.kreditantrag.frontend.events.KrediantragErfasstEvent;
import de.atruvia.kreditantrag.frontend.models.Kreditantrag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/kreditantraege")
public class KreditAntragErfassenCommandController {

	private final KreditAntragErfassenHandler handler;

	public KreditAntragErfassenCommandController(KreditAntragErfassenHandler handler) {
		this.handler = handler;
	}
	
	
	@ApiResponse(responseCode = "200", description = "Antrag gereits vorhanden")
    @ApiResponse(responseCode = "201", description = "Antrag wurde neu erfasst")
	@ApiResponse(responseCode = "400", description = "Fehler im Service")
	@PutMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> erfassen(@Valid @RequestBody Kreditantrag antrag) {
		try {
			KrediantragErfasstEvent event = KrediantragErfasstEvent.builder().kreditantrag(antrag).build();
			handler.handle(event);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().build();
		}
	}
	
}
