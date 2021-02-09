package es.joaquin.planes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.planes.entities.CrewFlight;

public interface CrewFlightRepository extends JpaRepository<CrewFlight, Long> {

	
}