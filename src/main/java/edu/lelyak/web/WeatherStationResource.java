package edu.lelyak.web;

import edu.lelyak.controllers.WeatherStationController;
import edu.lelyak.model.WeatherStation;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class WeatherStationResource extends ResourceSupport {

    @Getter
    private final WeatherStation weatherStation;

    public WeatherStationResource(WeatherStation station) {
        String stationId = station.getId();
        weatherStation = station;

        this.add(ControllerLinkBuilder.linkTo(methodOn(WeatherStationController.class)
                .getAllWeatherStations()).withRel("messages"));
        this.add(ControllerLinkBuilder.linkTo(methodOn(WeatherStationController.class, stationId)
                .getWeatherStation(stationId)).withSelfRel());
    }

}
