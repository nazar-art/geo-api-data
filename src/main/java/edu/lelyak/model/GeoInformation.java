package edu.lelyak.model;

import edu.lelyak.utills.constants.Coordinates;
import edu.lelyak.utills.datafactory.RandomData;
import edu.lelyak.utills.datafactory.RandomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoInformation {

    @RandomData(type = RandomType.NUMERIC_DOUBLE, min = Coordinates.MIN_COORDINATE, max = Coordinates.MAX_COORDINATE)
    private double longevity;

    @RandomData(type = RandomType.NUMERIC_DOUBLE, min = Coordinates.MIN_COORDINATE, max = Coordinates.MAX_COORDINATE)
    private double latitude;

    @RandomData(type = RandomType.NUMERIC, min = -10, max = 20)
    private int temperature;

    @RandomData(type = RandomType.NUMERIC, min = 5, max = 35)
    private int windSpeed;
}