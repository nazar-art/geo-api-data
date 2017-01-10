package edu.lelyak.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoRectangularPolygon {

    @Setter(AccessLevel.NONE)
    private final String TYPE = "Polygon";

    private GeoPoint first;
    private GeoPoint second;
    private GeoPoint third;
    private GeoPoint four;
}
