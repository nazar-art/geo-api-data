package edu.lelyak.utills;

import edu.lelyak.service.WeatherStationService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MockConfig {

    //**************************** MOCK BEANS ******************************

    @Bean
    @Primary
    public WeatherStationService weatherServiceMock() {
        WeatherStationService mock = Mockito.mock(WeatherStationService.class);
        // TODO: 1/8/2017 configure mock

        return mock;
    }

    //**************************** REAL BEANS ******************************

    @Bean
    @Real
    public WeatherStationService weatherServiceReal() {
        return  new WeatherStationService();
    }
}
