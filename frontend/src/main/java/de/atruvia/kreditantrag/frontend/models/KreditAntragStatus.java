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
@Table(name  = "tbl_kredit_antraege_status")
public class KreditAntragStatus {


	@NotNull
	@Id
	@Column(length = 36)
	private String id;
	@Version
	private int version;
	@NotNull
	
	@Column(length = 30)
	@Builder.Default
	private String scoring="in progress";
	@Column(length = 30)
	@Builder.Default
	private String cityScoring="in progress";
	@Builder.Default
	@Column(length = 30)
	private String antragStatus="in progress";
	

}
