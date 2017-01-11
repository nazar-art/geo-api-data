package edu.lelyak.service.impl;

import edu.lelyak.model.WeatherStation;
import edu.lelyak.repository.impl.WeatherStationRepositoryMock;
import edu.lelyak.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherStationService implements IStationService {

    @Autowired
    private WeatherStationRepositoryMock weatherRepository;

    @Override
    public List<WeatherStation> getAllStations() {
        return weatherRepository.getStations();
    }

    @Override
    public WeatherStation getStation(String id) {
        return weatherRepository.getStation(id);
    }

    @Override
    public void addStation(WeatherStation station) {
        weatherRepository.addStation(station);
    }

    @Override
    public void updateStation(String id, WeatherStation station) {
        weatherRepository.updateStation(id, station);
    }

    @Override
    public void deleteStation(String id) {
        weatherRepository.deleteStation(id);
    }

    public void deleteAllStations() {
        weatherRepository.deleteAllStations();
    }
}
