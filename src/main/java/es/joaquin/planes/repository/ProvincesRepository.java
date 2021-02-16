package es.joaquin.planes.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import es.joaquin.planes.dtos.AutonomousCommunity;
import es.joaquin.planes.entities.Provincia;

public interface ProvincesRepository extends MongoRepository<Provincia, String> {

	@Aggregation(pipeline = {
		"{$project: {AutonomousCommunity: {$ifNull: [\"$CA\", \"sin comunidad\"]}}}",
        	"{$group: {\"_id\":\"$AutonomousCommunity\", \"totalProvinces\": {$sum:1}}}",
        		"{$project: {autonomousCommunity:\"$_id\", totalProvinces: 1}}"
    })
    List<AutonomousCommunity> provinceAggregationByAutonomousCommunity();
}