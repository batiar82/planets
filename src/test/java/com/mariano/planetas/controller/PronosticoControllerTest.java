package com.mariano.planetas.controller;

import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.service.PronosticoService;
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
@WebMvcTest(PronosticoController.class)
public class PronosticoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PronosticoService pronosticoService;

    @Test
    public void getPronosticoShouldReturnPronostico() throws Exception {
        when(pronosticoService.getPronostico(1)).thenReturn(new Pronostico(1, Pronostico.Condicion.LLUVIA, 5.1));
        this.mockMvc.perform(get("/clima/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(Pronostico.Condicion.LLUVIA.name())));
    }
}
