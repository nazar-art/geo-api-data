package edu.lelyak.utills;

import edu.lelyak.model.GeoInformation;
import edu.lelyak.model.GeoLocation;
import edu.lelyak.model.GeoPoint;
import edu.lelyak.model.GeoRectangularPolygon;
import edu.lelyak.utills.datafactory.RandomDataSource;

public final class RandomGenerator {

    private static RandomDataSource dataSource = new RandomDataSource();

    public static GeoInformation getRandomGeoInformation() {
        GeoPoint geoPoint = GeoPoint.builder().build();
        GeoInformation geoInformation = GeoInformation.builder().location(GeoLocation.builder().build())
                .rectangularPolygon(GeoRectangularPolygon.builder()
                        .first(geoPoint)
                        .second(geoPoint)
                        .third(geoPoint)
                        .four(geoPoint).build()
                ).build();

        return (GeoInformation) dataSource.randomiseEntity(geoInformation);
    }
}
