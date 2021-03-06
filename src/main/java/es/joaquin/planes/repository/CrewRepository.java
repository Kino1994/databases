package es.joaquin.planes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.joaquin.planes.dtos.CrewDeparturesDTO;
import es.joaquin.planes.dtos.CrewStatsDTO;
import es.joaquin.planes.entities.Crew;

public interface CrewRepository extends JpaRepository<Crew, Long> {
		
	@Query(value = "SELECT new es.joaquin.planes.dtos.CrewStatsDTO(c.code, c.name, c.surname, COUNT(cf.flight), SUM(f.duration)) FROM Crew c JOIN CrewFlight cf ON cf.crew = c JOIN Flight f ON cf.flight = f GROUP BY c")
    List<CrewStatsDTO> findCrewStats();
	
	@Query(value = "SELECT new es.joaquin.planes.dtos.CrewDeparturesDTO(f.code, c.name, c.surname, f.departure.city, f.departure_time) FROM Crew c JOIN CrewFlight cf ON cf.crew = c JOIN Flight f ON cf.flight = f WHERE c.code = ?1")
	List<CrewDeparturesDTO> findDeparturesByCode(String code);
}