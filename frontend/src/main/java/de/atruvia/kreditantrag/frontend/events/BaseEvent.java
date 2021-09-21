package de.atruvia.kreditantrag.frontend.events;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseEvent {

	@Builder.Default
	private String eventId = UUID.randomUUID().toString();
	@Builder.Default
	private LocalDateTime tiemstamp = LocalDateTime.now();
}
