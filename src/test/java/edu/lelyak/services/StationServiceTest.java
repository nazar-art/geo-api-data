package edu.lelyak.services;

import edu.lelyak.config.AppConfig;
import edu.lelyak.model.Station;
import edu.lelyak.service.impl.WeatherStationService;
import edu.lelyak.utills.constants.*;
import edu.lelyak.utills.exception.WeatherStationNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Class for testing StationService.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class StationServiceTest {

    @Autowired
    private WeatherStationService weatherService;

    private Station testStationSample;

    public static final double DELTA_FOR_DOUBLE_COMPARISON = 0.001;

    @Before
    public void setUp() throws Exception {
        testStationSample = Station.builder()
                .id(Ids.ID_TEST_STATION)
                .name(Names.NAME_STATION_TEST)
                .latitude(Coordinates.COORDINATE_TEST_VALUE)
                .longevity(Coordinates.COORDINATE_TEST_VALUE)
                .temperature(Temperatures.TEMPERATURE_TEST_VALUE)
                .windSpeed(WindSpeeds.WIND_SPEED_TEST_VALUE)
                .build();
    }

    @Test(expected = WeatherStationNotFoundException.class)
    public void testThatWeatherStationIsNotPresented() throws Exception {
        weatherService.getStation(Ids.ID_TEST_STATION);
    }

    @Test
    public void testGetAllWeatherStations() throws Exception {
        Assert.assertNotNull("mock stations list can't be null", weatherService.getAllStations());
    }

    @Test
    public void testAddNewWeatherStation() throws Exception {
        System.out.println(weatherService.getAllStations());
        weatherService.addStation(testStationSample);

        Assert.assertEquals(Ids.ID_TEST_STATION, weatherService.getStation(Ids.ID_TEST_STATION).getId());
        Assert.assertEquals(Names.NAME_STATION_TEST, weatherService.getStation(Ids.ID_TEST_STATION).getName());
        
        Assert.assertEquals(Coordinates.COORDINATE_TEST_VALUE,
                weatherService.getStation(Ids.ID_TEST_STATION).getLatitude(), DELTA_FOR_DOUBLE_COMPARISON);
        Assert.assertEquals(Coordinates.COORDINATE_TEST_VALUE,
                weatherService.getStation(Ids.ID_TEST_STATION).getLongevity(), DELTA_FOR_DOUBLE_COMPARISON);
        Assert.assertEquals(Temperatures.TEMPERATURE_TEST_VALUE,
                weatherService.getStation(Ids.ID_TEST_STATION).getTemperature());
        Assert.assertEquals(WindSpeeds.WIND_SPEED_TEST_VALUE,
                weatherService.getStation(Ids.ID_TEST_STATION).getWindSpeed());
    }

    @Test
    public void testUpdateWeatherStation() throws Exception {
        weatherService.addStation(testStationSample);

        testStationSample.setName(Names.NAME_STATION_UPDATED);
        weatherService.updateStation(Ids.ID_TEST_STATION, testStationSample);

        Assert.assertEquals(Names.NAME_STATION_UPDATED, weatherService.getStation(Ids.ID_TEST_STATION).getName());
        Assert.assertEquals(Coordinates.COORDINATE_TEST_VALUE,
                weatherService.getStation(Ids.ID_TEST_STATION).getLatitude(), DELTA_FOR_DOUBLE_COMPARISON);
    }

    @Test(expected = WeatherStationNotFoundException.class)
    public void testDeleteWeatherStation() throws Exception {
        weatherService.addStation(testStationSample);

        Assert.assertEquals(Ids.ID_TEST_STATION, weatherService.getStation(Ids.ID_TEST_STATION).getId());

        weatherService.deleteStation(Ids.ID_TEST_STATION);
        weatherService.getStation(Ids.ID_TEST_STATION);
    }

}
