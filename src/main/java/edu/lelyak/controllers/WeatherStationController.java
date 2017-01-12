package edu.lelyak.controllers;

import edu.lelyak.model.Station;
import edu.lelyak.service.impl.WeatherStationService;
import edu.lelyak.web.WeatherStationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling user request.
 */
@RestController
public class WeatherStationController {

    @Autowired
    private WeatherStationService stationService;


    @RequestMapping(value = "/stations/{id}", method = RequestMethod.GET)
    public WeatherStationResource getWeatherStation(@PathVariable String id) {
        return new WeatherStationResource(stationService.getStation(id));
    }

    @RequestMapping(value = "/stations",method = RequestMethod.GET)
    public List<Station> getAllWeatherStations() {
        return stationService.getAllStations();
    }

    @RequestMapping(value = "/stations", method = RequestMethod.POST)
    public void addWeatherStation(@RequestBody Station station) {
        stationService.addStation(station);
    }

    @RequestMapping(value = "/stations/{id}", method = RequestMethod.PUT)
    public void updateWeatherStation(@PathVariable String id, @RequestBody Station station) {
        stationService.updateStation(id, station);
    }

    @RequestMapping(value = "/stations/{id}", method = RequestMethod.DELETE)
    public void deleteWeatherStation(@PathVariable String id) {
        stationService.deleteStation(id);
    }

    @RequestMapping(value = "/stations", method = RequestMethod.DELETE)
    public void deleteAll() {
        stationService.deleteAllStations();
    }

}
