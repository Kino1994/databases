package es.joaquin.planes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.joaquin.planes.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	@Query("SELECT f FROM Flight f join Airport a ON f.arrival = a where a.city = ?1 and function('date_format', f.departure_time, '%Y-%m-%d') = ?2 ORDER BY f.departure_time")
	List<Flight> findByCity(String city, String date);
	
}