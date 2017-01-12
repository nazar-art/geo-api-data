package edu.lelyak.model;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Station {

    @Id
    private String id;
    private String name;

    private double longevity;
    private double latitude;
    private int temperature;
    private int windSpeed;

    @Singular
    @ElementCollection
    private List<GeoPoint> points;

}
