package edu.lelyak.utills.random;

import edu.lelyak.model.GeoPoint;
import edu.lelyak.utills.constants.Coordinates;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for common randomize operations.
 */
public final class RandomDataSource {

    private final DataFactory dataFactory;
    private final Random rand;

    public RandomDataSource() {
        dataFactory = new DataFactory();
        rand = new Random();
    }

    /**
     * Randomly generates double number.
     *
     * @param min minimum limit for random number.
     * @param max maximum limit for random generation.
     * @return random double number.
     */
    public double getNumericDouble(int min, int max) {
        return rand.doubles(min, max).findFirst().getAsDouble();
    }

    /**
     * Generates random int number.
     *
     * @param min minimum from which to generate.
     * @param max maximum for random generation.
     * @return random int number.
     */
    public int getNumeric(int min, int max) {
        return dataFactory.getNumberBetween(min, max);
    }

    /**
     * Generates list of random geo points.
     *
     * @param size number till which value list should be generated.
     * @return list with random points.
     */
    public List<GeoPoint> getRandomPoints(int size) {
        List<GeoPoint> results = new ArrayList<>();
        for (int index = 1; index <= size; index++) {
            GeoPoint point = new GeoPoint();
            point.setX(getNumericDouble(Coordinates.MIN_COORDINATE, Coordinates.MAX_COORDINATE));
            point.setY(getNumericDouble(Coordinates.MIN_COORDINATE, Coordinates.MAX_COORDINATE));
            results.add(point);
        }
        return results;
    }

}
