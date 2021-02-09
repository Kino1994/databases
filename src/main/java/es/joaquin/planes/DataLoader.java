package es.joaquin.planes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		
		Plane p1 = new Plane("00001","Airbus","A320",10000);
		Plane p2 = new Plane("00002","Airbus","A330",11000);
		Plane p3 = new Plane("00003","Airbus","A340",12000);
		Plane p4 = new Plane("00004","Airbus","A350",13000);
		Plane p5 = new Plane("00005","Airbus","A380",14000);
		
		Plane p6 = new Plane("00006","Boeing","737",210000);
		Plane p7 = new Plane("00007","Boeing","747",220000);
		Plane p8 = new Plane("00008","Boeing","757",230000);
		Plane p9 = new Plane("00009","Boeing","767",240000);
		Plane p10 = new Plane("00010","Boeing","777",25000);		
		
		Airport a1 = new Airport("MAD","Aeropuerto de Madrid-Barajas Adolfo Suárez", "Madrid", "España"); 
		Airport a2 = new Airport("BCN","Aeropuerto de Josep Tarradellas Barcelona-El Prat", "Barcelona", "España"); 
		Airport a3 = new Airport("LHR","Londres Heathrow Airport", "Londres", "Reino Unido"); 
		Airport a4 = new Airport("CDG","París Charles de Gaulle Airport", "París", "Francia");
		Airport a5 = new Airport("AMS","Ámsterdam Airport Schiphol", "Amsterdam", "Países Bajos");
		Airport a6 = new Airport("FRA","Frankfurt Airport", "Frankfurt", "Alemania");
		
		planeRepository.save(p1);
		planeRepository.save(p2);
		planeRepository.save(p3);
		planeRepository.save(p4);
		planeRepository.save(p5);
		planeRepository.save(p6);
		planeRepository.save(p7);
		planeRepository.save(p8);
		planeRepository.save(p9);
		planeRepository.save(p10);		
		
		airportRepository.save(a1);
		airportRepository.save(a2);	
		airportRepository.save(a3);
		airportRepository.save(a4);
		airportRepository.save(a5);	
		airportRepository.save(a6);
		
		Crew c1 = new Crew("00001", "Joaquin", "De Vicente", "commander", "Iberia");
		Crew c2 = new Crew("00002", "Antonio", "Vazquez", "co-pilot", "Iberia");
		Crew c3 = new Crew("00003", "Lucas", "Gonzalez", "flight attendant", "Iberia");
		
		List<Crew> iberiaCrew = new ArrayList<Crew>();
		iberiaCrew.add(c1);
		iberiaCrew.add(c2);		
		iberiaCrew.add(c3);
		
		Crew c4 = new Crew("00004", "Patricia", "Lopez", "commander", "Air Europa");
		Crew c5 = new Crew("00005", "Maria", "Perez", "co-pilot", "Air Europa");
		Crew c6 = new Crew("00006", "Ana", "Marquez", "flight attendant", "Air Europa");
		
		List<Crew> europeCrew = new ArrayList<Crew>();
		europeCrew.add(c4);
		europeCrew.add(c5);		
		europeCrew.add(c6);
		
		Crew c7 = new Crew("00007", "Santiago", "Candela", "commander", "Air France");
		Crew c8 = new Crew("00008", "Javier", "Brotons", "co-pilot", "Air France");
		Crew c9 = new Crew("00009", "Santy", "Lerma", "flight attendant", "Air France");
		
		List<Crew> franceCrew = new ArrayList<Crew>();
		franceCrew.add(c7);
		franceCrew.add(c8);		
		franceCrew.add(c9);
		
		Crew c10 = new Crew("00010", "Carlos", "Antono", "commander", "British Airways");
		Crew c11 = new Crew("00011", "Lara", "Tisner", "co-pilot", "British Airways");
		Crew c12 = new Crew("00012", "Beatriz", "Sosa", "flight attendant", "British Airways");
		
		List<Crew> britishCrew = new ArrayList<Crew>();
		britishCrew.add(c10);
		britishCrew.add(c11);		
		britishCrew.add(c12);
		
		Crew c13 = new Crew("00013", "Miguel", "Gomez", "commander", "American Airlines");
		Crew c14 = new Crew("00014", "ALvaro", "Silva", "co-pilot", "American Airlines");
		Crew c15 = new Crew("00015", "Celia", "Garvi", "flight attendant", "American Airlines");
		
		List<Crew> americanCrew = new ArrayList<Crew>();
		americanCrew.add(c13);
		americanCrew.add(c14);		
		americanCrew.add(c15);	
				
		Flight f1 = new Flight("0000001","Iberia",p1, a1, a2, new Date(System.currentTimeMillis()+10000000),1.0);
		Flight f2 = new Flight("0000002","Air Europa",p2, a1, a3, new Date(System.currentTimeMillis()+15000000),2.0);
		Flight f3 = new Flight("0000003","Air France",p3, a1, a4, new Date(System.currentTimeMillis()+20000000),3.0);
		Flight f4 = new Flight("0000004","British Airways",p4, a1, a5, new Date(System.currentTimeMillis()+25000000),4.0);
		Flight f5 = new Flight("0000005","American Airlines",p5, a1, a6, new Date(System.currentTimeMillis()+30000000),5.0);
		
		Flight f6 = new Flight("0000006","Iberia",p6, a2, a1, new Date(System.currentTimeMillis()+35000000),1.0);
		Flight f7 = new Flight("0000007","Air Europa",p7, a2, a3, new Date(System.currentTimeMillis()+40000000),2.0);
		Flight f8 = new Flight("0000008","Air France",p8, a2, a4, new Date(System.currentTimeMillis()+45000000),3.0);
		Flight f9 = new Flight("0000009","British Airways",p9, a2, a5, new Date(System.currentTimeMillis()+50000000),4.0);
		Flight f10 = new Flight("0000010","American Airlines",p10, a2, a6, new Date(System.currentTimeMillis()+55000000),5.0);
		
		Flight f11 = new Flight("0000011","Iberia",p1, a3, a1, new Date(System.currentTimeMillis()+60000000),1.0);
		Flight f12 = new Flight("0000012","Air Europa",p2, a3, a2, new Date(System.currentTimeMillis()+65000000),2.0);
		Flight f13 = new Flight("0000013","Air France",p3, a3, a4, new Date(System.currentTimeMillis()+70000000),3.0);
		Flight f14 = new Flight("0000014","British Airways",p4, a3, a5, new Date(System.currentTimeMillis()+75000000),4.0);
		Flight f15 = new Flight("0000015","American Airlines",p5, a3, a6, new Date(System.currentTimeMillis()+80000000),5.0);
		
		Flight f16 = new Flight("0000016","Iberia",p6, a4, a1, new Date(System.currentTimeMillis()+85000000),1.0);
		Flight f17 = new Flight("0000017","Air Europa",p7, a4, a2, new Date(System.currentTimeMillis()+90000000),2.0);
		Flight f18 = new Flight("0000018","Air France",p8, a4, a3, new Date(System.currentTimeMillis()+95000000),3.0);
		Flight f19 = new Flight("0000019","British Airways",p9, a4, a5, new Date(System.currentTimeMillis()+10000000),4.0);
		Flight f20 = new Flight("0000020","American Airlines",p10, a4, a6, new Date(System.currentTimeMillis()+15000000),5.0);
		
		Flight f21 = new Flight("0000021","Iberia",p1, a5, a1, new Date(System.currentTimeMillis()+20000000),1.0);
		Flight f22 = new Flight("0000022","Air Europa",p2, a5, a2, new Date(System.currentTimeMillis()+25000000),2.0);
		Flight f23 = new Flight("0000023","Air France",p3, a5, a3, new Date(System.currentTimeMillis()+30000000),3.0);
		Flight f24 = new Flight("0000024","British Airways",p4, a5, a4, new Date(System.currentTimeMillis()+30000000),4.0);
		Flight f25 = new Flight("0000025","American Airlines",p5, a5, a6, new Date(System.currentTimeMillis()+35000000),5.0);
		
		flightRepository.save(f1);
		flightRepository.save(f2);
		flightRepository.save(f3);
		flightRepository.save(f4);
		flightRepository.save(f5);
		flightRepository.save(f6);
		flightRepository.save(f7);
		flightRepository.save(f8);
		flightRepository.save(f9);
		flightRepository.save(f10);
		flightRepository.save(f11);		
		flightRepository.save(f12);
		flightRepository.save(f13);
		flightRepository.save(f14);
		flightRepository.save(f15);
		flightRepository.save(f16);
		flightRepository.save(f17);
		flightRepository.save(f18);
		flightRepository.save(f19);
		flightRepository.save(f20);
		flightRepository.save(f21);
		flightRepository.save(f22);
		flightRepository.save(f23);
		flightRepository.save(f24);
		flightRepository.save(f25);
		
		crewRepository.saveAll(iberiaCrew);
		crewRepository.saveAll(europeCrew);
		crewRepository.saveAll(franceCrew);
		crewRepository.saveAll(britishCrew);
		crewRepository.saveAll(americanCrew);
		
		List<CrewFlight> rels = new ArrayList<>();
		
		for (Crew c : iberiaCrew) {
			rels.add(new CrewFlight(c,f1));
			rels.add(new CrewFlight(c,f6));
			rels.add(new CrewFlight(c,f11));
			rels.add(new CrewFlight(c,f16));
			rels.add(new CrewFlight(c,f21));
		}
		
		for (Crew c : europeCrew) {
			rels.add(new CrewFlight(c,f2));
			rels.add(new CrewFlight(c,f7));
			rels.add(new CrewFlight(c,f12));
			rels.add(new CrewFlight(c,f17));
			rels.add(new CrewFlight(c,f22));
		}
		
		for (Crew c : franceCrew) {
			rels.add(new CrewFlight(c,f3));
			rels.add(new CrewFlight(c,f8));
			rels.add(new CrewFlight(c,f13));
			rels.add(new CrewFlight(c,f18));
			rels.add(new CrewFlight(c,f23));
		}
		
		for (Crew c : britishCrew) {
			rels.add(new CrewFlight(c,f4));
			rels.add(new CrewFlight(c,f9));
			rels.add(new CrewFlight(c,f14));
			rels.add(new CrewFlight(c,f19));
			rels.add(new CrewFlight(c,f24));
		}
		
		for (Crew c : americanCrew) {
			rels.add(new CrewFlight(c,f5));
			rels.add(new CrewFlight(c,f10));
			rels.add(new CrewFlight(c,f15));
			rels.add(new CrewFlight(c,f20));
			rels.add(new CrewFlight(c,f25));
		}
		
		crewFlightRepository.saveAll(rels);
		
		Mechanic m1 = new Mechanic("00016", "Andres", "Lopez", "Iberia", 1972, "PhD Aeronautical engineering");
		Mechanic m2 = new Mechanic("00017", "Ruben", "Blanco", "Air Europa", 1976, "Aeronautical engineering Degree");
		Mechanic m3 = new Mechanic("00018", "Gabriel", "Galindo", "Air France", 1982, "Mechanical engineering Degree");
		
		mechanicRepository.save(m1);
		mechanicRepository.save(m2);
		mechanicRepository.save(m3);
		
		Overhaul o1 = new Overhaul(f1.getPlane(), f1.getDeparture_date_time(), new Date(System.currentTimeMillis()+10000000), 2.0, m1, "periodical", "Everything is ok", f1.getArrival());
		Overhaul o2 = new Overhaul(f2.getPlane(), f1.getDeparture_date_time(), new Date(System.currentTimeMillis()+20000000), 5.0, m2, "reparation", "Wheel brakes seem loose", f2.getArrival());
		Overhaul o3 = new Overhaul(f3.getPlane(), f1.getDeparture_date_time(), new Date(System.currentTimeMillis()+30000000), 3.0, m3, "periodical", "Everything seems ok", f3.getArrival());
		Overhaul o4 = new Overhaul(f6.getPlane(), f1.getDeparture_date_time(), new Date(System.currentTimeMillis()+40000000), 7.0, m1, "reparation", "Left Wing is damaged", f6.getArrival());
		Overhaul o5 = new Overhaul(f7.getPlane(), f1.getDeparture_date_time(), new Date(System.currentTimeMillis()+50000000), 1.0, m2, "periodical", "No overhauls found", f7.getArrival());
		Overhaul o6 = new Overhaul(f8.getPlane(), f1.getDeparture_date_time(), new Date(System.currentTimeMillis()+60000000), 9.0, m2, "reparation", "Engine is damage", f8.getArrival());

		overhaulRepository.save(o1);
		overhaulRepository.save(o2);
		overhaulRepository.save(o3);
		overhaulRepository.save(o4);
		overhaulRepository.save(o5);
		overhaulRepository.save(o6);	
		
		
		System.out.println("----------------------------------------");
		System.out.println("Primera consulta: Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables de sus revisiones.");
		System.out.println("----------------------------------------");
		
		
		List<MechanicOverhaulDTO> mechanicOverhauls = overhaulRepository.findMechanicsfromOverhaul();
		
		for (MechanicOverhaulDTO mechanic : mechanicOverhauls) {
			System.out.println(mechanic.toString());
		}
		
		System.out.println("----------------------------------------");
		System.out.println("Dado el nombre de una ciudad y una fecha, listado de los vuelos que han aterrizado (destino) en los aeropuertos de esa ciudad en esa fecha, ordenados por hora.");
		System.out.println("----------------------------------------");
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateFormat = simpleDateFormat.format(new Date());
		
		List<Flight> flights = flightRepository.findByCity("Madrid", dateFormat);
		
		for (Flight flight : flights) {
			System.out.println(flight.toString());
		}
		
		
		System.out.println("----------------------------------------");
		System.out.println("Dado el código de empleado de un tripulante, mostrar su nombre y apellidos y las ciudades desde las que ha despegado junto con la fecha en que despegó.");
		System.out.println("----------------------------------------");
		
		List<CrewDeparturesDTO> crewDepartures = crewRepository.findDeparturesByCode("0000001");
		
		for (CrewDeparturesDTO crew : crewDepartures) {
			System.out.println(crew.toString());
		}
			
		System.out.println("----------------------------------------");
		System.out.println("Para cada tripulante, mostrar su nombre y apellidos junto con su número total de vuelos y la suma de horas de estos.");
		System.out.println("----------------------------------------");
		
		List<CrewStatsDTO> crewStats = crewRepository.findCrewStats();
			
		for (CrewStatsDTO crew : crewStats) {
			System.out.println(crew.toString());
		}
			
		System.out.println("----------------------------------------");		 
		
	}

}
