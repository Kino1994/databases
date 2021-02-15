package es.joaquin.planes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.joaquin.planes.dtos.CrewDeparturesDTO;
import es.joaquin.planes.dtos.CrewStatsDTO;
import es.joaquin.planes.dtos.MechanicOverhaulDTO;
import es.joaquin.planes.entities.Airport;
import es.joaquin.planes.entities.Crew;
import es.joaquin.planes.entities.CrewFlight;
import es.joaquin.planes.entities.Flight;
import es.joaquin.planes.entities.Mechanic;
import es.joaquin.planes.entities.Overhaul;
import es.joaquin.planes.entities.Plane;
import es.joaquin.planes.repository.AirportRepository;
import es.joaquin.planes.repository.CrewFlightRepository;
import es.joaquin.planes.repository.CrewRepository;
import es.joaquin.planes.repository.FlightRepository;
import es.joaquin.planes.repository.MechanicRepository;
import es.joaquin.planes.repository.OverhaulRepository;
import es.joaquin.planes.repository.PlaneRepository;

@Controller
public class DataLoader implements CommandLineRunner {
	
	@Autowired
	private PlaneRepository planeRepository;
	
	@Autowired
	private AirportRepository airportRepository;
	
	@Autowired
	private CrewRepository crewRepository;
	
	@Autowired
	private FlightRepository flightRepository;	
	
	@Autowired
	private CrewFlightRepository crewFlightRepository;
	
	@Autowired
	private MechanicRepository mechanicRepository;
	
	@Autowired
	private OverhaulRepository overhaulRepository;		
		
	
	@Override
	public void run(String... args) throws Exception {
		
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
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateFormat = simpleDateFormat.format(new Date());
		
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
		
	}

}
