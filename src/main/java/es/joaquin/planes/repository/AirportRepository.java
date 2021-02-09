package es.joaquin.planes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.planes.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
	

}