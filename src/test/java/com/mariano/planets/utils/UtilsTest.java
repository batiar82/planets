package com.mariano.planets.utils;

import com.mariano.planets.model.Planet;
import com.mariano.planets.model.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void testPlanetsAligned90()
    {

        Planet ferengi = new Planet(1, 500, true);
        Planet betasoide = new Planet(3, 2000, true);
        Planet vulcano = new Planet(5, 1000, false);
        assertTrue(Utils.areAlignedWithTheSun(90, ferengi, betasoide, vulcano));
    }

    @Test
    public void testPlanetsAligned1080()
    {

        Planet ferengi = new Planet(1, 500, true);
        Planet betasoide = new Planet(3, 2000, true);
        Planet vulcano = new Planet(5, 1000, false);
        assertTrue(Utils.areAlignedWithTheSun(1080, ferengi, betasoide, vulcano));
    }
    @Test
    public void testPlanetsAligned3240()
    {

        Planet ferengi = new Planet(1, 500, true);
        Planet betasoide = new Planet(3, 2000, true);
        Planet vulcano = new Planet(5, 1000, false);
        assertTrue(Utils.areAlignedWithTheSun(3240, ferengi, betasoide, vulcano));
    }

    @Test
    public void testPlanetsAligned3240b()
    {

        Planet ferengi = new Planet(1, 500, true);
        Planet betasoide = new Planet(3, 2000, true);
        Planet vulcano = new Planet(5, 1000, false);
        assertTrue(Utils.areAlignedWithTheSun(3240, ferengi, betasoide, vulcano));
    }

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
    public void testArea()
    {
        assertEquals(Utils.area(new Point(2,0), new Point(3,4), new Point(-2,5)),21/2.0,0.2222);
    }
    @Test
    public void testArea2()
    {
        assertEquals(Utils.area(new Point(0,0), new Point(-5,0), new Point(0,5)),12.5,0.2222);
    }

    @Test
    public void testPeriodoDeLluvia()
    {
        assertEquals(true, Utils.rainyPeriod(new Point(5,0), new Point(-7,3), new Point(1,-5)));
    }
    @Test
    public void testPeriodoDeSequia()
    {
        assertEquals(false, Utils.rainyPeriod(new Point(5,0), new Point(5,2.5), new Point(-1,-2)));
    }
}
