package de.atruvia.kreditantrag.frontend.repositories;

import org.springframework.data.repository.CrudRepository;

import de.atruvia.kreditantrag.frontend.models.KreditAntragStatus;

public interface KreditAntragStatusRepository extends CrudRepository<KreditAntragStatus, String> {

}
