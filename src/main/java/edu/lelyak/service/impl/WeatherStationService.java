package edu.lelyak.service.impl;

import edu.lelyak.model.Station;
import edu.lelyak.repository.WeatherStationRepository;
import edu.lelyak.service.IStationService;
import edu.lelyak.utills.exception.WeatherStationIdIsNotUniqueException;
import edu.lelyak.utills.exception.WeatherStationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer, which describes logic of application.
 */
@Service
public class WeatherStationService implements IStationService {

    @Autowired
    private WeatherStationRepository repository;

    @Override
    public List<Station> getAllStations() {
        List<Station> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Station getStation(String id) {
        validateStationDBPresence(id);
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void addStation(Station station) {
        validateStationId(station.getId());
        repository.save(station);
    }

    @Override
    public void updateStation(String id, Station station) {
        validateStationDBPresence(id);
        repository.save(station);
    }

    @Override
    public void deleteStation(String id) {
        validateStationDBPresence(id);
        repository.delete(id);
    }

    public void deleteAllStations() {
        repository.deleteAll();
    }

    public long count() {
        return repository.count();
    }


    private void validateStationDBPresence(String stationId) {
        repository.findById(stationId)
                .orElseThrow(() -> new WeatherStationNotFoundException(stationId));
    }

    private void validateStationId(String stationId) {
        repository.findById(stationId)
                .ifPresent(s -> {
                    throw new WeatherStationIdIsNotUniqueException(stationId);
                });
    }
}
