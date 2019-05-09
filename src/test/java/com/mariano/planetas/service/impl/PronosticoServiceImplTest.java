package com.mariano.planetas.service.impl;

import com.mariano.planetas.modelo.Pronostico;
import com.mariano.planetas.repository.PronosticoRepository;
import com.mariano.planetas.service.PronosticoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
public class PronosticoServiceImplTest {

    private PronosticoService pronosticoService;

    @MockBean
    private PronosticoRepository pronosticoRepository;


    @Before
    public void setup()
    {
        pronosticoService = new PronosticoServiceImpl(pronosticoRepository);
    }

    @Test
    public void countDryPeriods() {
        Integer expectedDryPeriods = 256;

        when(pronosticoRepository.countByCondicionAndDiaLessThan(any(), any())).thenReturn(expectedDryPeriods);
        assertEquals(expectedDryPeriods, pronosticoService.contarPeriodosSecos(22));
    }
    @Test
    public void countRainyPeriods() {
        Integer expectedRainyPeriods = 35;

        when(pronosticoRepository.countByCondicionAndDiaLessThan(any(), any())).thenReturn(expectedRainyPeriods);
        assertEquals(expectedRainyPeriods, pronosticoService.contarPeriodosDeLluvia(22));
    }
    @Test
    public void countOptimalPeriods() {
        Integer periodosOptimosEsperados = 54;

        when(pronosticoRepository.countByCondicionAndDiaLessThan(any(), any())).thenReturn(periodosOptimosEsperados);
        assertEquals(periodosOptimosEsperados, pronosticoService.contarPeriodosOptimos(900));
    }
    @Test
    public void maxRainyDay() {
        Pronostico pronosticoEsperado= new Pronostico(33,Pronostico.Condicion.LLUVIA, 44.0);
        when(pronosticoRepository.findFirstByCondicionOrderByIntensidadDesc(any())).thenReturn(pronosticoEsperado);
        assertEquals(Integer.valueOf(33), pronosticoService.diaMayorIntensidad());
    }

    @Test
    public void getPronostico() {
        Pronostico pronostico = new Pronostico(1, Pronostico.Condicion.LLUVIA, 5.1);
        when(pronosticoRepository.findById(1)).thenReturn(Optional.of(pronostico));
        assertEquals(pronostico, pronosticoService.getPronostico(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void getPronosticoNotExistent() {
        Pronostico pronostico = new Pronostico(1, Pronostico.Condicion.LLUVIA, 5.3);
        when(pronosticoRepository.findById(1)).thenReturn(Optional.of(pronostico));
        assertEquals(pronostico, pronosticoService.getPronostico(2));
    }
}
