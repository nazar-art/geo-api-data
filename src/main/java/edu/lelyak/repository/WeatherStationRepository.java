package edu.lelyak.repository;

import edu.lelyak.model.WeatherStation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeatherStationRepository extends MongoRepository<WeatherStation, String> {

}
