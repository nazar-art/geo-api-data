package edu.lelyak.repository;

import edu.lelyak.model.Station;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Repository class for DB interactions.
 */
public interface WeatherStationRepository extends CrudRepository<Station, String> {
    Optional<Station> findById(String id);

    Optional<Station> findByName(String id);
}
