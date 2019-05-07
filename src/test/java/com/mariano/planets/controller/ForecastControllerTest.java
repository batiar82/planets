package com.mariano.planets.controller;

import com.mariano.planets.model.Forecast;
import com.mariano.planets.service.ForecastService;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ForecastController.class)
public class ForecastControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ForecastService forecastService;

    @Test
    public void getForecastShouldReturnForecast() throws Exception {
        when(forecastService.getForecast(1)).thenReturn(new Forecast(1, Forecast.Condition.RAINY, 5.1));
        this.mockMvc.perform(get("/clima/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(Forecast.Condition.RAINY.name())));
    }
}
