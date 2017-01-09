package edu.lelyak.repository.impl;

import edu.lelyak.model.WeatherStation;
import edu.lelyak.repository.IStationRepository;
import edu.lelyak.utills.RandomGenerator;
import edu.lelyak.utills.exception.WeatherStationNotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class WeatherStationRepositoryMock implements IStationRepository {

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

    @Override
    public WeatherStation getStation(String id) {
        if (notExistsIntoDB(id)) {
            throw new WeatherStationNotFoundException(id);
        }

        return stations.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void addStation(WeatherStation station) {
        stations.add(station);
    }

    @Override
    public void updateStation(String id, WeatherStation station) {
        for (int index = 0; index < stations.size(); index++) {
            WeatherStation current = stations.get(index);
            if (current.getId().equalsIgnoreCase(id)) {
                stations.set(index, station);
                return;
            }
        }
        throw new WeatherStationNotFoundException(id);
    }

    @Override
    public void deleteStation(String id) {
        if (notExistsIntoDB(id)) {
            throw new WeatherStationNotFoundException(id);
        }

        stations.removeIf(s -> s.getId().equals(id));
    }


    public int count() {
        return stations.size();
    }

    private boolean notExistsIntoDB(String id) {
        return stations.stream()
                .noneMatch(s -> s.getId().equals(id));
    }

}
