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
public class GeoLocation {

    @RandomData(type = RandomType.NUMERIC_DOUBLE, min = Coordinates.MIN_COORDINATE, max = Coordinates.MAX_COORDINATE)
    private double longevity;

    @RandomData(type = RandomType.NUMERIC_DOUBLE, min = Coordinates.MIN_COORDINATE, max = Coordinates.MAX_COORDINATE)
    private double latitude;
}
