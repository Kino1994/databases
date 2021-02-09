package es.joaquin.planes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.planes.entities.Mechanic;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
	

}