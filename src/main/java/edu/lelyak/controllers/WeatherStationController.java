package edu.lelyak.controllers;

import edu.lelyak.model.WeatherStation;
import edu.lelyak.service.impl.WeatherStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "stations")
public class WeatherStationController {

    @Autowired
    private WeatherStationService weatherService;

    @RequestMapping(method = RequestMethod.GET)
    public List<WeatherStation> getAllWeatherStations() {
        return weatherService.getAllStations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public WeatherStation getWeatherStation(@PathVariable String id) {
        return weatherService.getStation(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addWeatherStation(@RequestBody WeatherStation station) {
        weatherService.addStation(station);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateWeatherStation(@PathVariable String id, @RequestBody WeatherStation station) {
        weatherService.updateStation(id, station);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteWeatherStation(@PathVariable String id) {
        weatherService.deleteStation(id);
    }

}
