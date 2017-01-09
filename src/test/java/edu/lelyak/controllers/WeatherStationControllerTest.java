package edu.lelyak.controllers;

import edu.lelyak.repository.IStationRepository;
import edu.lelyak.service.IStationService;
import edu.lelyak.utills.config.MockConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherStationController.class)
@ContextConfiguration(classes = MockConfig.class)
public class WeatherStationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IStationRepository stationRepository;


//    @Test
    public void shouldReturnCorrectStation() throws Exception {

        mockMvc.perform(get("/stations")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
