package edu.lelyak;

import edu.lelyak.model.Station;
import edu.lelyak.repository.WeatherStationRepository;
import edu.lelyak.utills.random.RandomGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * This application uses RESTful API
 * which returns in geojson format list of weather stations.
 *
 * @author Nazar_Lelyak.
 * @version 0.5 12-01-2017
 */
@SpringBootApplication
public class GeoApiDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoApiDataApplication.class, args);
    }

    @Bean
    CommandLineRunner init(WeatherStationRepository repository) {
        return (evt) -> Arrays.asList("huston,alaska,washington,oklahoma,dakota,montana,nevada,colorado".split(","))
                .forEach(
                        s -> {
                            Station station = RandomGenerator.fillWeatherStation(s);
                            repository.save(station);
                        });
    }
}
