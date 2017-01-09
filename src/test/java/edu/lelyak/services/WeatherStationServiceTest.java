package edu.lelyak.services;

import edu.lelyak.model.GeoInformation;
import edu.lelyak.model.WeatherStation;
import edu.lelyak.service.impl.WeatherStationService;
import edu.lelyak.utills.MockConfig;
import edu.lelyak.utills.Real;
import edu.lelyak.utills.exception.WeatherStationNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WeatherStationServiceTest {

    @Autowired
    @Real
    private WeatherStationService weatherService;

    private WeatherStation testStationSample;

    public static final String STATION_ID = "testStationId";
    public static final String STATION_NAME = "Test Station Name";
    public static final double COORDINATE_VALUE = 45D;
    public static final int TEMPERATURE = 15;
    public static final int WIND_SPEED = 25;


    @Before
    public void setUp() throws Exception {
        GeoInformation geoInformation = GeoInformation.builder()
                .latitude(COORDINATE_VALUE)
                .longevity(COORDINATE_VALUE)
                .temperature(TEMPERATURE)
                .windSpeed(WIND_SPEED)
                .build();
        testStationSample = WeatherStation.builder()
                .id(STATION_ID)
                .name(STATION_NAME)
                .geoInformation(geoInformation)
                .build();
    }

    @Test(expected = WeatherStationNotFoundException.class)
    public void testThatWeatherStationIsNotPresented() throws Exception {
        weatherService.getStation(STATION_ID);
    }

    @Test
    public void testGetAllWeatherStations() throws Exception {
        Assert.assertNotNull("mock stations list can't be null", weatherService.getAllStations());
    }

    @Test
    public void testAddNewWeatherStation() throws Exception {
        weatherService.addStation(testStationSample);

        Assert.assertEquals(STATION_ID, weatherService.getStation(STATION_ID).getId());
        Assert.assertEquals(STATION_NAME, weatherService.getStation(STATION_ID).getName());
        Assert.assertEquals(COORDINATE_VALUE, weatherService.getStation(STATION_ID).getGeoInformation().getLatitude(), 0.001);
        Assert.assertEquals(COORDINATE_VALUE, weatherService.getStation(STATION_ID).getGeoInformation().getLongevity(), 0.001);
        Assert.assertEquals(TEMPERATURE, weatherService.getStation(STATION_ID).getGeoInformation().getTemperature());
        Assert.assertEquals(WIND_SPEED, weatherService.getStation(STATION_ID).getGeoInformation().getWindSpeed());
    }

    @Test
    public void testUpdateWeatherStation() throws Exception {
        weatherService.addStation(testStationSample);
        String update_name = "UPDATE NAME";
        testStationSample.setName(update_name);
        weatherService.updateStation(STATION_ID, testStationSample);

        Assert.assertEquals(update_name, weatherService.getStation(STATION_ID).getName());
        Assert.assertEquals(COORDINATE_VALUE, weatherService.getStation(STATION_ID).getGeoInformation().getLatitude(), 0.001);
    }

    @Test(expected = WeatherStationNotFoundException.class)
    public void testDeleteWeatherStation() throws Exception {
        weatherService.addStation(testStationSample);
        Assert.assertEquals(STATION_ID, weatherService.getStation(STATION_ID).getId());

        weatherService.deleteStation(STATION_ID);
        weatherService.getStation(STATION_ID);
    }

}
