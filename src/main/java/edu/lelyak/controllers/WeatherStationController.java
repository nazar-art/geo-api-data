package edu.lelyak.controllers;

import edu.lelyak.model.WeatherStation;
import edu.lelyak.service.impl.WeatherStationService;
import edu.lelyak.web.WeatherStationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherStationController {

    @Autowired
    private WeatherStationService weatherService;

    @RequestMapping(value = "/stations/{id}", method = RequestMethod.GET)
    public WeatherStationResource getWeatherStation(@PathVariable String id) {
        return new WeatherStationResource(weatherService.getStation(id));
    }

    @RequestMapping(value = "/stations",method = RequestMethod.GET)
    public List<WeatherStation> getAllWeatherStations() {
        return weatherService.getAllStations();
    }

    @RequestMapping(value = "/stations", method = RequestMethod.POST)
    public void addWeatherStation(@RequestBody WeatherStation station) {
        weatherService.addStation(station);
    }

    @RequestMapping(value = "/stations/{id}", method = RequestMethod.PUT)
    public void updateWeatherStation(@PathVariable String id, @RequestBody WeatherStation station) {
        weatherService.updateStation(id, station);
    }

    @RequestMapping(value = "/stations/{id}", method = RequestMethod.DELETE)
    public void deleteWeatherStation(@PathVariable String id) {
        weatherService.deleteStation(id);
    }

    @RequestMapping(value = "/stations", method = RequestMethod.DELETE)
    public void deleteAll() {
        weatherService.deleteAllStations();
    }

}
