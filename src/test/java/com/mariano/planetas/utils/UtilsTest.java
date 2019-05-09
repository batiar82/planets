package com.mariano.planetas.utils;

import com.mariano.planetas.modelo.Planeta;
import com.mariano.planetas.modelo.Punto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UtilsTest {


   @Test
    public void testPointAtZero()
   {
       Planeta ferengi = new Planeta(1, 1, true);
       assertEquals(new Punto(1,0), Utils.getPosicion(ferengi, 0).redondear());
   }
    @Test
    public void testPointAt365()
    {
        Planeta ferengi = new Planeta(1, 1, true);
        assertEquals(new Punto(1,0),Utils.getPosicion(ferengi, 360).redondear());
    }

    @Test
    public void testPointAt180()
    {
        Planeta ferengi = new Planeta(1, 1, true);
        assertEquals(new Punto(-1,0),Utils.getPosicion(ferengi, 180).redondear());
    }

    @Test
    public void testPointAt45()
    {
        Planeta ferengi = new Planeta(1, 1, true);
        assertEquals(new Punto(0.70711,-0.70711),Utils.getPosicion(ferengi, 45).redondear());
    }

    @Test
    public void testPointAt90()
    {
        Planeta ferengi = new Planeta(1, 1, true);
        assertEquals(new Punto(-0.70711,-0.70711),Utils.getPosicion(ferengi, 135).redondear());
    }


    @Test
    public void testPeriodoDeLluvia()
    {
        assertTrue(Utils.periodoDeLluvia(new Punto(5, 0), new Punto(-7, 3), new Punto(1, -5)));
    }
    @Test
    public void testPeriodoDeSequia()
    {
        assertEquals(false, Utils.periodoDeLluvia(new Punto(5,0), new Punto(5,2.5), new Punto(-1,-2)));
    }
}
