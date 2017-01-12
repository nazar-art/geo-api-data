package edu.lelyak.repository;

import edu.lelyak.model.WeatherStation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WeatherStationRepository extends CrudRepository<WeatherStation, String> {
    Optional<WeatherStation> findById(String id);

    Optional<WeatherStation> findByName(String id);
}
