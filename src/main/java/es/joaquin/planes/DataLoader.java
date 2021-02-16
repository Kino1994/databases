package es.joaquin.planes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.joaquin.planes.dtos.AutonomousCommunity;
import es.joaquin.planes.dtos.CrewDeparturesDTO;
import es.joaquin.planes.dtos.CrewStatsDTO;
import es.joaquin.planes.dtos.MechanicOverhaulDTO;
import es.joaquin.planes.entities.Flight;
import es.joaquin.planes.entities.Provincia;
import es.joaquin.planes.repository.CrewRepository;
import es.joaquin.planes.repository.FlightRepository;
import es.joaquin.planes.repository.OverhaulRepository;
import es.joaquin.planes.repository.PlaneRepository;
import es.joaquin.planes.repository.ProvincesRepository;

@Controller
public class DataLoader implements CommandLineRunner {
	
	@Autowired
	private PlaneRepository planeRepository;
		
	@Autowired
	private CrewRepository crewRepository;
	
	@Autowired
	private FlightRepository flightRepository;	
		
	@Autowired
	private OverhaulRepository overhaulRepository;		
	
	@Autowired
	private ProvincesRepository provincesRepository;		
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("----------------------------------------");
		System.out.println("Consultas de la Practica 1:");
		System.out.println("___________________________________________________________________________________________________________________________");		
		System.out.println();
		
		System.out.println("----------------------------------------");
		System.out.println("Primera consulta: Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones.");
		System.out.println("----------------------------------------");
		
		
		List<MechanicOverhaulDTO> mechanicOverhauls = overhaulRepository.findMechanicsfromOverhaul();
		
		for (MechanicOverhaulDTO mechanic : mechanicOverhauls) {
			System.out.println(mechanic.toString());
		}
		
		System.out.println("----------------------------------------");
		System.out.println("Segunda consulta: Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado (destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora.");
		System.out.println("----------------------------------------");
		
		String dateFormat = "2021-02-16";
		
		List<Flight> flights = flightRepository.findByCity("Madrid", dateFormat);
		
		for (Flight flight : flights) {
			System.out.println(flight.toString());
		}
		
		System.out.println("----------------------------------------");
		System.out.println("Tercera consulta: Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y las ciudades desde las que ha despegado junto con la fecha en que despegó.");
		System.out.println("----------------------------------------");
		
		List<CrewDeparturesDTO> crewDepartures = crewRepository.findDeparturesByCode()
			.stream().filter(c -> c.getCode().equals("0000001")).collect(Collectors.toList());
		
		for (CrewDeparturesDTO crew : crewDepartures) {
			System.out.println(crew.toString());
		}
			
		System.out.println("----------------------------------------");
		System.out.println("Cuarta consulta: Para cada tripulante, mostrar su nombre y apellidos junto con su número total de vuelos y la suma de horas de estos.");
		System.out.println("----------------------------------------");
		
		List<CrewStatsDTO> crewStats = crewRepository.findCrewStats();
			
		for (CrewStatsDTO crew : crewStats) {
			System.out.println(crew.toString());
		}
			
		System.out.println("----------------------------------------");
		
		System.out.println("___________________________________________________________________________________________________________________________");		
		System.out.println();
		System.out.println("Practica 2: Flyway Consultas Mysql");
		System.out.println("___________________________________________________________________________________________________________________________");		
		System.out.println();		
		
		System.out.println("----------------------------------------");
		System.out.println("Primera consulta: Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones.");
		System.out.println("----------------------------------------");
			
		List<MechanicOverhaulDTO> mechanicOverhaulsDTO = planeRepository.findAllMechanicOverhauls()
				.stream().map(m -> new MechanicOverhaulDTO(m.getTail_number(),m.getName(), m.getSurname()))
					.collect(Collectors.toList());
			
		for (MechanicOverhaulDTO mechanic : mechanicOverhaulsDTO) {
			System.out.println(mechanic.toString());
		}
				
		System.out.println("----------------------------------------");
		System.out.println("Segunda consulta: Para cada tripulante, mostrar su nombre y apellidos junto con su número total de vuelos y la suma de horas de estos.");
		System.out.println("----------------------------------------");
		
		List<CrewStatsDTO> crewFlightStats = crewRepository.findCrewFlightStats()
			.stream().map(c -> new CrewStatsDTO(c.getCode(), c.getName(), c.getSurname(), c.getTotal_flights(), c.getTotal_flight_hours()))
				.collect(Collectors.toList());
		

		for (CrewStatsDTO crew : crewFlightStats) {
			System.out.println(crew.toString());
		}
			
		System.out.println("___________________________________________________________________________________________________________________________");		
		System.out.println();
		System.out.println("Practica 2: Consultas Pronvincias Mongo");
		System.out.println("___________________________________________________________________________________________________________________________");		
		System.out.println();		
		
		System.out.println("----------------------------------------");
		System.out.println("Primera consulta: Todos la provincias.");
		System.out.println("----------------------------------------");
		
		List<Provincia> provinces = provincesRepository.findAll();
		
		for (Provincia p: provinces) {
			System.out.println(p.toString());
		}
			
		System.out.println("----------------------------------------");
		System.out.println("Segunda consulta: Comunidades Autónomas y su número total de provincias.");
		System.out.println("----------------------------------------");		
		
		List<AutonomousCommunity> autonomousCommunities = provincesRepository.provinceAggregationByAutonomousCommunity();
		
		for (AutonomousCommunity a: autonomousCommunities) {
			System.out.println(a.toString());
		}
			
		System.out.println("----------------------------------------");
		
		
		
	}

}
