package edu.lelyak.service;

import edu.lelyak.model.WeatherStation;
import edu.lelyak.repository.WeatherStationRepositoryMock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherStationService {

//    @Autowired
    private WeatherStationRepositoryMock weatherRepository = new WeatherStationRepositoryMock();

    public List<WeatherStation> getAllStations() {
        return weatherRepository.getStations();
    }

    public WeatherStation getStation(String id) {
        return weatherRepository.getStation(id);
    }

    public void addStation(WeatherStation station) {
        weatherRepository.addStation(station);
    }

    public void updateStation(String id, WeatherStation station) {
        weatherRepository.updateStation(id, station);
    }

    public void deleteStation(String id) {
        weatherRepository.deleteStation(id);
    }

}
