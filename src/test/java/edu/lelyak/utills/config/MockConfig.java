package edu.lelyak.utills.config;

import edu.lelyak.model.GeoInformation;
import edu.lelyak.model.GeoLocation;
import edu.lelyak.model.WeatherStation;
import edu.lelyak.repository.impl.WeatherStationRepositoryMock;
import edu.lelyak.service.impl.WeatherStationService;
import edu.lelyak.utills.Real;
import edu.lelyak.utills.constants.*;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@Configuration
//@ComponentScan(basePackages = "edu.lelyak.repository")
public class MockConfig {

    //**************************** MOCK BEANS ******************************

    @Bean
    @Primary
    public WeatherStationService weatherServiceMock() {
        return Mockito.mock(WeatherStationService.class);
    }

    @Bean
    @Primary
    public WeatherStationRepositoryMock weatherStationRepositoryMock() {
        List<WeatherStation> stations = new ArrayList<>();
        WeatherStationRepositoryMock stationRepository = Mockito.mock(WeatherStationRepositoryMock.class);

        GeoInformation geoInformation = GeoInformation.builder()
                .location(GeoLocation.builder()
                        .latitude(Coordinates.COORDINATE_TEST_VALUE)
                        .longevity(Coordinates.COORDINATE_TEST_VALUE)
                        .build())
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
        when(stationRepository.count()).thenReturn(stations.size());

        return stationRepository;
    }

    //**************************** REAL BEANS ******************************

    @Bean
    @Real
    public WeatherStationService weatherServiceReal() {
        return new WeatherStationService();
    }

    @Bean
    @Real
    public WeatherStationRepositoryMock weatherStationRepositoryReal() {
        return new WeatherStationRepositoryMock();
    }
}
