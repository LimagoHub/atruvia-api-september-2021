package de.atruvia.kreditantrag.frontend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name  = "tbl_kredit_antraege")
public class Kreditantrag {

	@Size(min = 36, max=36)
	@NotNull
	@Id
	@Column(length = 36)
	private String id;
	@Version
	private int version;
	@NotNull
	@Size(min = 2, max=30)
	@Column(length = 30)
	private String vorname;
	@Size(min = 2, max=30)
	@NotNull
	@Column(length = 30, nullable = false)
	private String nachname;
	@Size(min = 2, max=30)
	@NotNull
	@Column(length = 30, nullable = false)
	private String ort;
	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private double einkommen;
	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private double ausgaben;
	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private double kreditWunsch;
}
