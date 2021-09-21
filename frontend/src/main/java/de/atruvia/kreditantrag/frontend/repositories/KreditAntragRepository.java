package de.atruvia.kreditantrag.frontend.repositories;

import org.springframework.data.repository.CrudRepository;

import de.atruvia.kreditantrag.frontend.models.Kreditantrag;

public interface KreditAntragRepository extends CrudRepository<Kreditantrag, String> {

}
