package es.joaquin.planes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.joaquin.planes.dtos.CrewStatsDTO;
import es.joaquin.planes.entities.Crew;

public interface CrewRepository extends JpaRepository<Crew, Long> {
		
	@Query(value = "select new es.joaquin.planes.dtos.CrewStatsDTO(c.code, c.name, c.surname, count(cf.flight), sum(f.duration)) from Crew c join CrewFlight cf on cf.crew = c join Flight f on cf.flight = f group by c")
    List<CrewStatsDTO> findCrewStats();
	
}