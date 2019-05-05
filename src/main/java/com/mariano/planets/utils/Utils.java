package com.mariano.planets.utils;

import com.mariano.planets.model.Planet;
import com.mariano.planets.model.Point;

public class Utils {
/*
    public static boolean areAllAligned(int days, Planet... planets){
        List<Point> positions = Arrays.asList(planets).stream().map(planet -> getPosition(planet,days)).collect(Collectors.toList());
        return areAligned(positions.get(0), positions.get(1), positions.get(2));
    }
*/
    public static boolean areAlignedWithTheSun(int days, Planet a, Planet b, Planet c){
        int posA = a.getDegresAtDays(days);
        int posB = b.getDegresAtDays(days);
        int posC = c.getDegresAtDays(days);

        if(posA == posB || Math.abs(posA - posB) % 180 == 0  && (posA == posC || Math.abs(posA - posC) % 180 == 0 ) && (posB == posC || Math.abs(posB -posC) % 180 == 0))
        {
            return true;
        }
       return false;
    }

    public static Point getPosition(Planet planet, int days)
    {
        double x = Math.sin(Math.toRadians(planet.getDegresAtDays(days)));
        double y =  Math.cos(Math.toRadians(planet.getDegresAtDays(days)));
        return new Point(y*planet.getDistance(),x*planet.getDistance()).round();
    }
/*
    public static boolean areAligned(Point a, Point b, Point c)
    {
        if(a.getX() == b.getX() && a.getX() == c.getX() || a.getY() == b.getY() && a.getY() == c.getY())
        {
            return true;
        }
        else {
            double one = (b.getX() - a.getX()) / (c.getX() - b.getX());
            double two = (b.getY() - a.getY()) / (c.getY() - b.getY());

            return one == two;
        }

    }
*/
    /**
     * Calculo del area de 3 puntos
     * @param a el primer punto
     * @param b el segundo punto
     * @param c el tercer punto
     * @return el area
     */
    public static double area(Point a, Point b, Point c)
    {
        return Math.abs((a.getX()*b.getY()*1)+(a.getY()*1*c.getX())+(1*b.getX()*c.getY())-(1*b.getY()*c.getX())-(a.getY()*b.getX()*1)-(a.getX()*1*c.getY()))/2;

    }

    /**
     * Calculo el perimetro para averiguar el momento de mayor intensidad
     * @param a el primer punto
     * @param b el segundo punto
     * @param c el tercer punto
     * @return El perimetro
     */
    public static double perimetro(Point a, Point b, Point c)
    {
        double one = Math.sqrt(Math.pow(b.getX()-a.getX(),2)+Math.pow(b.getY()-a.getY(),2));
        double two = Math.sqrt(Math.pow(c.getX()-b.getX(),2)+Math.pow(c.getY()-b.getY(),2));
        double three = Math.sqrt(Math.pow(c.getX()-a.getX(),2)+Math.pow(c.getY()-a.getY(),2));
        return one+two+three;
        }

    /**
     * Determina si llueve buscando si el triangulo formado por los 3 puntos contiene al sol
     * @param a el primer punto
     * @param b el segundo punto
     * @param c el tercer punto
     * @return true si los puntos contienen al Sol (0,0), false sino
     */
    public static boolean rainyPeriod(Point a, Point b, Point c){
        Point sol = new Point(0,0);
        double t0 = area(a,b,c);
        double t1 = area(a,b,sol);
        double t2 = area(b,c,sol);
        double t3 = area(c,a,sol);
        return (t1+t2+t3) == t0;
    }

    public static boolean optimalPeriod(Point a, Point b, Point c){
        return area(a,b,c) == 0 && !rainyPeriod(a,b,c);
    }
}


