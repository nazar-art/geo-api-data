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
    private WeatherStationRepositoryMock repositoryMock;

    @Override
    public List<WeatherStation> getAllStations() {
        return repositoryMock.getStations();
    }

    @Override
    public WeatherStation getStation(String id) {
        return repositoryMock.getStation(id);
    }

    @Override
    public void addStation(WeatherStation station) {
        repositoryMock.addStation(station);
    }

    @Override
    public void updateStation(String id, WeatherStation station) {
        repositoryMock.updateStation(id, station);
    }

    @Override
    public void deleteStation(String id) {
        repositoryMock.deleteStation(id);
    }

    public void deleteAllStations() {
        repositoryMock.deleteAllStations();
    }
}
