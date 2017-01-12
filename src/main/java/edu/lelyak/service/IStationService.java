package edu.lelyak.service;

import edu.lelyak.model.Station;
import edu.lelyak.model.Station;

import java.util.List;

public interface IStationService {
    List<Station> getAllStations();

    Station getStation(String id);

    void addStation(Station station);

    void updateStation(String id, Station station);

    void deleteStation(String id);
}
