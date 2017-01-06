package edu.lelyak.utills;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.Random;

public final class RandomUtilities {

    private DataFactory dataFactory = new DataFactory();

    public static final int MIN_COORDINATE = -180;
    public static final int MAX_COORDINATE = 180;

    private static double getDoubleInRange(int min, int max) {
        Random rand = new Random();
        return rand.doubles(min, max).findFirst().getAsDouble();
    }

    public static Point getRandomPoint() {
        return new Point(getDoubleInRange(MIN_COORDINATE, MAX_COORDINATE), getDoubleInRange(MIN_COORDINATE, MAX_COORDINATE));
    }
    
    public static GeoJsonPoint getRandomGeoPoint() {
        return new GeoJsonPoint(getRandomPoint());
    }

    public String getRandomCityName() {
        return dataFactory.getCity();
    }

    public String getRandomCityUri() {
        return dataFactory.getCity().toLowerCase();
    }

}
