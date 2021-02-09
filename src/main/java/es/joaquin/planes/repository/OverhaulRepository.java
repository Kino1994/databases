package es.joaquin.planes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.planes.entities.Overhaul;

public interface OverhaulRepository extends JpaRepository<Overhaul, Long> {
	

}