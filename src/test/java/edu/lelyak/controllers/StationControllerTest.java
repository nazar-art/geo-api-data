package edu.lelyak.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.lelyak.model.Station;
import edu.lelyak.model.Station;
import edu.lelyak.repository.WeatherStationRepository;
import edu.lelyak.service.impl.WeatherStationService;
import edu.lelyak.utills.config.AppConfig;
import edu.lelyak.utills.constants.Ids;
import edu.lelyak.utills.constants.Names;
import edu.lelyak.utills.exception.WeatherStationNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StationControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WeatherStationRepository repository;
    @Autowired
    private WeatherStationService stationService;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new WeatherStationController()).build();

    }

    @Test(expected = WeatherStationNotFoundException.class)
    public void testStationNotFound() throws Exception {
        mockMvc.perform(get("/stations/buhaha"));
    }

    @Test(expected = WeatherStationNotFoundException.class)
    public void readSingleStation() throws Exception {
        mockMvc.perform(get("/stations/" + Ids.ID_1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(Ids.ID_1)))
                .andExpect(jsonPath("$.name", is(Names.NAME_1)));
    }

    @Test(expected = WeatherStationNotFoundException.class)
    public void readStations() throws Exception {
        mockMvc.perform(get("/stations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize((int) repository.count())))
                .andExpect(jsonPath("$[0].id", is(Ids.ID_1)))
                .andExpect(jsonPath("$[0].name", is(Names.NAME_1)))
                .andExpect(jsonPath("$[1].id", is(Ids.ID_2)))
                .andExpect(jsonPath("$[1].name", is(Names.NAME_2)))
                .andExpect(jsonPath("$[2].id", is(Ids.ID_3)))
                .andExpect(jsonPath("$[2].name", is(Names.NAME_3)));
    }

    @Test
    public void createStation() throws Exception {
        String bookmarkJson = convertToJson(Station.builder().id("newOne").name("New name").build());

        this.mockMvc.perform(post("/stations")
                .contentType(contentType)
                .content(bookmarkJson))
                .andExpect(status().isCreated());
    }


    protected String convertToJson(Station station) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(station);
    }
}
