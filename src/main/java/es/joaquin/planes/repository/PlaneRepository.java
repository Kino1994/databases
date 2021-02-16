package es.joaquin.planes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.joaquin.planes.dtos.MechanicOverhaul;
import es.joaquin.planes.entities.Plane;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
	
	@Query(value = "SELECT p.tail_number, m.name, m.surname FROM plane p JOIN mechanic m ON JSON_CONTAINS(p.overhauls, CAST(m.id as JSON), '$.mechanic_id') ORDER BY p.tail_number", nativeQuery = true)
    List<MechanicOverhaul> findAllMechanicOverhauls();
	

}