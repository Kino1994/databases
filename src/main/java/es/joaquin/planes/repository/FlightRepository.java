package es.joaquin.planes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.joaquin.planes.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	@Query("SELECT f FROM Flight f WHERE f.departure.city = ?1")
	List<Flight> findByCity(String city);

}