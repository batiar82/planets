package com.mariano.planets.utils;

import com.mariano.planets.model.Planet;
import com.mariano.planets.model.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {


   @Test
    public void testPointAtZero()
   {
       Planet ferengi = new Planet(1, 1, true);
       assertEquals(new Point(1,0), Utils.getPosition(ferengi, 0).round());
   }
    @Test
    public void testPointAt365()
    {
        Planet ferengi = new Planet(1, 1, true);
        assertEquals(new Point(1,0),Utils.getPosition(ferengi, 360).round());
    }

    @Test
    public void testPointAt180()
    {
        Planet ferengi = new Planet(1, 1, true);
        assertEquals(new Point(-1,0),Utils.getPosition(ferengi, 180).round());
    }

    @Test
    public void testPointAt45()
    {
        Planet ferengi = new Planet(1, 1, true);
        assertEquals(new Point(0.70711,-0.70711),Utils.getPosition(ferengi, 45).round());
    }

    @Test
    public void testPointAt90()
    {
        Planet ferengi = new Planet(1, 1, true);
        assertEquals(new Point(-0.70711,-0.70711),Utils.getPosition(ferengi, 135).round());
    }


    @Test
    public void testPeriodoDeLluvia()
    {
        assertTrue(Utils.rainyPeriod(new Point(5, 0), new Point(-7, 3), new Point(1, -5)));
    }
    @Test
    public void testPeriodoDeSequia()
    {
        assertEquals(false, Utils.rainyPeriod(new Point(5,0), new Point(5,2.5), new Point(-1,-2)));
    }
}
