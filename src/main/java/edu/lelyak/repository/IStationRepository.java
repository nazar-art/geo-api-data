package edu.lelyak.repository;

import edu.lelyak.model.WeatherStation;

import java.util.List;

public interface IStationRepository {
    List<WeatherStation> getStations();

    WeatherStation getStation(String id);

    void addStation(WeatherStation station);

    void updateStation(String id, WeatherStation station);

    void deleteStation(String id);
}
