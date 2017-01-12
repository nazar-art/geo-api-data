package edu.lelyak.utills.random;

import edu.lelyak.model.Station;
import edu.lelyak.utills.constants.Coordinates;
import edu.lelyak.utills.constants.Temperatures;
import edu.lelyak.utills.constants.WindSpeeds;

/**
 * Defines logic for weather station random generation.
 */
public final class RandomGenerator {

    public static final int RANDOM_POINTS_LIMIT = 4;
    private static RandomDataSource dataSource = new RandomDataSource();

    /**
     * Randomly fulfils weather station object.
     *
     * @param id station identity uri.
     * @return randomly generated station object.
     */
    public static Station fillWeatherStation(String id) {
        return Station.builder()
                .id(id)
                .name(id.toUpperCase().concat(" Description"))
                .latitude(dataSource.getNumericDouble(Coordinates.MIN_COORDINATE, Coordinates.MAX_COORDINATE))
                .longevity(dataSource.getNumericDouble(Coordinates.MIN_COORDINATE, Coordinates.MAX_COORDINATE))
                .temperature(dataSource.getNumeric(Temperatures.MIN_VALUE, Temperatures.MAX_VALUE))
                .windSpeed(dataSource.getNumeric(WindSpeeds.MIN_SPEED, WindSpeeds.MAX_SPEED))
                .points(dataSource.getRandomPoints(RANDOM_POINTS_LIMIT))
                .build();
    }
}
