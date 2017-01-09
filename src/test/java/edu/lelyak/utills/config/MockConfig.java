package edu.lelyak.utills.config;

import edu.lelyak.model.GeoInformation;
import edu.lelyak.model.WeatherStation;
import edu.lelyak.repository.IStationRepository;
import edu.lelyak.repository.impl.WeatherStationRepositoryMock;
import edu.lelyak.service.impl.WeatherStationService;
import edu.lelyak.utills.Real;
import edu.lelyak.utills.constants.*;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@Configuration
@ComponentScan(basePackages = "edu.lelyak.repository")
public class MockConfig {

    //**************************** MOCK BEANS ******************************

    @Bean
    @Primary
    public WeatherStationService weatherServiceMock() {
        WeatherStationService mock = Mockito.mock(WeatherStationService.class);
        // TODO: 1/8/2017 configure mock

        return mock;
    }

    @Bean
    @Primary
    public IStationRepository weatherStationRepositoryMock() {
        List<WeatherStation> stations = new ArrayList<>();
        WeatherStationRepositoryMock stationRepository = Mockito.mock(WeatherStationRepositoryMock.class);

        GeoInformation geoInformation = GeoInformation.builder()
                .latitude(Coordinates.COORDINATE_TEST_VALUE)
                .longevity(Coordinates.COORDINATE_TEST_VALUE)
                .temperature(Temperatures.TEMPERATURE_TEST_VALUE)
                .windSpeed(WindSpeeds.WIND_SPEED_TEST)
                .build();

        WeatherStation station_1 = WeatherStation.builder()
                .id(Ids.ID_1)
                .name(Names.NAME_1)
                .geoInformation(geoInformation)
                .build();

        stations.add(station_1);
        stations.add(WeatherStation.builder()
                .id(Ids.ID_2)
                .name(Names.NAME_2)
                .geoInformation(geoInformation)
                .build());
        stations.add(WeatherStation.builder()
                .id(Ids.ID_3)
                .name(Names.NAME_3)
                .geoInformation(geoInformation)
                .build());

        when(stationRepository.getStations()).thenReturn(stations);
        when(stationRepository.getStation(anyString())).thenReturn(station_1);
        when(stationRepository.count()).thenReturn(stations.size());

        return stationRepository;
    }

    //**************************** REAL BEANS ******************************

    @Bean
    @Real
    public WeatherStationService weatherServiceReal() {
        return  new WeatherStationService();
    }
}
