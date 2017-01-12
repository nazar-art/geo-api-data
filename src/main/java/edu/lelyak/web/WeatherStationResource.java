package edu.lelyak.web;

import edu.lelyak.controllers.WeatherStationController;
import edu.lelyak.model.Station;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class WeatherStationResource extends ResourceSupport {

    @Getter
    private final Station station;

    public WeatherStationResource(Station station) {
        String stationId = station.getId();
        this.station = station;

        this.add(ControllerLinkBuilder.linkTo(methodOn(WeatherStationController.class)
                .getAllWeatherStations()).withRel("stations-all"));
        this.add(ControllerLinkBuilder.linkTo(methodOn(WeatherStationController.class, stationId)
                .getWeatherStation(stationId)).withSelfRel());
    }

}
