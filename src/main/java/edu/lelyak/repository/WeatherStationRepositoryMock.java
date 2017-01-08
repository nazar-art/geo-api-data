package edu.lelyak.repository;

import edu.lelyak.model.WeatherStation;
import edu.lelyak.utills.RandomGenerator;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class WeatherStationRepositoryMock {

    @Getter
    private List<WeatherStation> stations = new ArrayList<>(
            Arrays.asList(
                    new WeatherStation("huston", "Huston station", RandomGenerator.getRandomGeoInformation()),
                    new WeatherStation("washington", "Washington station", RandomGenerator.getRandomGeoInformation()),
                    new WeatherStation("dakota", "Dakota station", RandomGenerator.getRandomGeoInformation()),
                    new WeatherStation("alaska", "Alaska station", RandomGenerator.getRandomGeoInformation()),
                    new WeatherStation("montana", "Montana station", RandomGenerator.getRandomGeoInformation()),
                    new WeatherStation("oregon", "Oregon station", RandomGenerator.getRandomGeoInformation()),
                    new WeatherStation("nevada", "Nevada station", RandomGenerator.getRandomGeoInformation()),
                    new WeatherStation("colorado", "Colorado station", RandomGenerator.getRandomGeoInformation())
            )
    );

    public WeatherStation getStation(String id) {
        return stations.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .get();
    }

    public void addStation(WeatherStation station) {
        stations.add(station);
    }

    public void updateStation(String id, WeatherStation station) {
        for (int index = 0; index < stations.size(); index++) {
            WeatherStation current = stations.get(index);
            if (current.getId().equalsIgnoreCase(id)) {
                stations.set(index, station);
                return;
            }
        }
    }

    public void deleteStation(String id) {
        stations.removeIf(s -> s.getId().equals(id));
    }

    public static void main(String[] args) {
        WeatherStationRepositoryMock mock = new WeatherStationRepositoryMock();
        System.out.println(mock.getStations());
    }

}
