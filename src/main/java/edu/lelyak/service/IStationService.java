package edu.lelyak.service;

import edu.lelyak.model.WeatherStation;

import java.util.List;

public interface IStationService {
    List<WeatherStation> getAllStations();

    WeatherStation getStation(String id);

    void addStation(WeatherStation station);

    void updateStation(String id, WeatherStation station);

    void deleteStation(String id);
}
