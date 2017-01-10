package edu.lelyak.utills;

import edu.lelyak.model.GeoInformation;
import edu.lelyak.model.GeoLocation;
import edu.lelyak.model.GeoPoint;
import edu.lelyak.model.GeoRectangularPolygon;
import edu.lelyak.utills.datafactory.RandomDataSource;

public final class RandomGenerator {

    private static RandomDataSource dataSource = new RandomDataSource();

    public static GeoInformation getRandomGeoInformation() {
        GeoPoint geoPoint = new GeoPoint();
        GeoRectangularPolygon rectangularPolygon = new GeoRectangularPolygon(geoPoint, geoPoint, geoPoint, geoPoint);

        GeoInformation geoInformation = new GeoInformation();
        geoInformation.setLocation(new GeoLocation());
        geoInformation.setRectangularPolygon(rectangularPolygon);

        return (GeoInformation) dataSource.randomiseEntity(geoInformation);
    }
}
