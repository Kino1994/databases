package es.joaquin.planes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.planes.entities.Crew;

public interface CrewRepository extends JpaRepository<Crew, Long> {
	

}