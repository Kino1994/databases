package es.joaquin.planes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.joaquin.planes.dtos.MechanicOverhaulDTO;
import es.joaquin.planes.entities.Overhaul;

public interface OverhaulRepository extends JpaRepository<Overhaul, Long> {
	

    @Query(value = "select new es.joaquin.planes.dtos.MechanicOverhaulDTO(o.plane.tail_number, o.mechanic.name, o.mechanic.surname) from Overhaul o")
    List<MechanicOverhaulDTO> findMechanicsfromOverhaul();
	

}