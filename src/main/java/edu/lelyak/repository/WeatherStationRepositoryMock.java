package edu.lelyak.repository;

import edu.lelyak.model.WeatherStation;
import edu.lelyak.utills.RandomUtilities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class WeatherStationRepositoryMock {

    private List<WeatherStation> stations = new ArrayList<>(
            Arrays.asList(
                    new WeatherStation("huston", "Huston station", RandomUtilities.getRandomGeoPoint()),
                    new WeatherStation("washington", "Washington station", RandomUtilities.getRandomGeoPoint()),
                    new WeatherStation("dakota", "Dakota station", RandomUtilities.getRandomGeoPoint()),
                    new WeatherStation("alaska", "Alaska station", RandomUtilities.getRandomGeoPoint()),
                    new WeatherStation("montana", "Montana station", RandomUtilities.getRandomGeoPoint()),
                    new WeatherStation("oregon", "Oregon station", RandomUtilities.getRandomGeoPoint()),
                    new WeatherStation("nevada", "Nevada station", RandomUtilities.getRandomGeoPoint()),
                    new WeatherStation("colorado", "Colorado station", RandomUtilities.getRandomGeoPoint())
            )
    );

    public List<WeatherStation> getStationsMock() {
        return stations;
    }

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

}
