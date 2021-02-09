package es.joaquin.planes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.planes.entities.Plane;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
	

}