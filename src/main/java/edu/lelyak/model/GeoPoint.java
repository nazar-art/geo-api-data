package edu.lelyak.model;

import lombok.*;

import javax.persistence.Embeddable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class GeoPoint {

    @Setter(AccessLevel.NONE)
    private final String TYPE = "Point";

    private double x;
    private double y;
}
