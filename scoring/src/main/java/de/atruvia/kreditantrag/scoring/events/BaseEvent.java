package de.atruvia.kreditantrag.scoring.events;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEvent {

	@Builder.Default
	private String eventId = UUID.randomUUID().toString();
	@Builder.Default
	private LocalDateTime tiemstamp = LocalDateTime.now();
}
