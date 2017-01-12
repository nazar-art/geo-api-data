package edu.lelyak.utills.config;

import edu.lelyak.service.impl.WeatherStationService;
import edu.lelyak.utills.Real;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "edu.lelyak")
public class MockConfig {

    //**************************** MOCK BEANS ******************************

    @Bean
    @Primary
    public WeatherStationService weatherServiceMock() {
        return Mockito.mock(WeatherStationService.class);
    }

    //**************************** REAL BEANS ******************************

    @Bean
    @Real
    public WeatherStationService weatherServiceReal() {
        return new WeatherStationService();
    }

}
