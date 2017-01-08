package edu.lelyak.utills;

import edu.lelyak.model.GeoInformation;
import edu.lelyak.utills.datafactory.RandomDataSource;

public final class RandomGenerator {

    private static RandomDataSource dataSource = new RandomDataSource();

    public static GeoInformation getRandomGeoInformation() {
        return (GeoInformation) dataSource.fillEntity(new GeoInformation());
    }
}
