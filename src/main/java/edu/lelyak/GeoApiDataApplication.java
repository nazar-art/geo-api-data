package edu.lelyak;

import edu.lelyak.model.WeatherStation;
import edu.lelyak.repository.WeatherStationRepository;
import edu.lelyak.utills.random.RandomGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

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
                            WeatherStation station = RandomGenerator.fillWeatherStation(s);
                            repository.save(station);
                        });
    }
}
