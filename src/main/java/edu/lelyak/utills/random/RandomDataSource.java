package edu.lelyak.utills.random;

import edu.lelyak.model.GeoPoint;
import edu.lelyak.utills.constants.Coordinates;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class RandomDataSource {

    private final DataFactory dataFactory;
    private final Random rand;

    public RandomDataSource() {
        dataFactory = new DataFactory();
        rand = new Random();
    }

    public double getNumericDouble(int min, int max) {
        return rand.doubles(min, max).findFirst().getAsDouble();
    }

    public int getNumeric(int min, int max) {
        return dataFactory.getNumberBetween(min, max);
    }

    public List<GeoPoint> getRandomPoints(int limit) {
        List<GeoPoint> results = new ArrayList<>();
        for (int index = 1; index <= limit; index++) {
            GeoPoint point = new GeoPoint();
            point.setX(getNumericDouble(Coordinates.MIN_COORDINATE, Coordinates.MAX_COORDINATE));
            point.setY(getNumericDouble(Coordinates.MIN_COORDINATE, Coordinates.MAX_COORDINATE));
            results.add(point);
        }
        return results;
    }

}
