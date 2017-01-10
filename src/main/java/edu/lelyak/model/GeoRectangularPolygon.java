package edu.lelyak.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoRectangularPolygon {

    private final String TYPE = "Polygon";

    private GeoPoint first;
    private GeoPoint second;
    private GeoPoint third;
    private GeoPoint four;
}
