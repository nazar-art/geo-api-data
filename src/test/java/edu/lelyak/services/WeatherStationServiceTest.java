package edu.lelyak.services;

import edu.lelyak.model.GeoInformation;
import edu.lelyak.model.WeatherStation;
import edu.lelyak.service.WeatherStationService;
import edu.lelyak.utills.MockConfig;
import edu.lelyak.utills.Real;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MockConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class WeatherStationServiceTest {

    public static final String STATION_ID = "testStationId";
    public static final double COORDINATE_VALUE = 45D;
    public static final String STATION_NAME = "Test Station Name";

    @Autowired
    @Real
    private WeatherStationService weatherService;

    private WeatherStation testStation;


    @Before
    public void setUp() throws Exception {
        GeoInformation geoInformation = GeoInformation.builder().latitude(COORDINATE_VALUE).longevity(COORDINATE_VALUE).build();
        testStation = WeatherStation.builder().id(STATION_ID).name(STATION_NAME).geoInformation(geoInformation).build();
    }

    @Test(expected = NoSuchElementException.class)
    public void testThatWeatherStationIsNotPresented() throws Exception {
        weatherService.getStation(STATION_ID);
    }

    @Test
    public void testGetAllWeatherStationS() throws Exception {
        Assert.assertNotNull("mock stations list can't be null", weatherService.getAllStations());
    }

    @Test
    public void testAddWeatherStation() throws Exception {
        weatherService.addStation(testStation);

        Assert.assertEquals(STATION_ID, weatherService.getStation(STATION_ID).getId());
        Assert.assertEquals(COORDINATE_VALUE, weatherService.getStation(STATION_ID).getGeoInformation().getLatitude(), 0.001);
    }

    @Test
    public void testUpdateWeatherStation() throws Exception {
        weatherService.addStation(testStation);
        String update_name = "UPDATE NAME";
        testStation.setName(update_name);
        weatherService.updateStation(STATION_ID, testStation);

        Assert.assertEquals(update_name, weatherService.getStation(STATION_ID).getName());
        Assert.assertEquals(COORDINATE_VALUE, weatherService.getStation(STATION_ID).getGeoInformation().getLatitude(), 0.001);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteWeatherStation() throws Exception {
        weatherService.addStation(testStation);
        Assert.assertEquals(STATION_ID, weatherService.getStation(STATION_ID).getId());

        weatherService.deleteStation(STATION_ID);
        weatherService.getStation(STATION_ID);
    }

}
