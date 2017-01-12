package edu.lelyak.service.impl;

import edu.lelyak.model.Station;
import edu.lelyak.model.Station;
import edu.lelyak.repository.WeatherStationRepository;
import edu.lelyak.service.IStationService;
import edu.lelyak.utills.exception.WeatherStationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        validateStation(id);
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void addStation(Station station) {
        repository.save(station);
    }

    @Override
    public void updateStation(String id, Station station) {
        validateStation(id);
        repository.save(station);
    }

    @Override
    public void deleteStation(String id) {
        validateStation(id);
        repository.delete(id);
    }

    public void deleteAllStations() {
        repository.deleteAll();
    }

    public long count() {
        return repository.count();
    }

    public void validateStation(String stationId) {
        repository.findById(stationId)
                .orElseThrow(() -> new WeatherStationNotFoundException(stationId));
    }
}
