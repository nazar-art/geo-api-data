package edu.lelyak.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherStation {

    private String id;
    private String name;
    private GeoJsonPoint location;
}
