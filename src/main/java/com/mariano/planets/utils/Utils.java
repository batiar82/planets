package com.mariano.planets.utils;

import com.mariano.planets.model.Planet;
import com.mariano.planets.model.Point;

public class Utils {

    /**
     * Determina si llueve buscando si el triangulo formado por los 3 puntos contiene al sol.
     * La suma de las areas debe dar igual a la cuma del area de los planetas
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
        return t0!= 0 && (t1+t2+t3) == t0;
    }

    /**
     * Es periodo optimo cuando el area de los 3 puntos es cero pero el area del sol con 2 planetas no es cero
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean optimalPeriod(Point a, Point b, Point c){
        Point sol = new Point(0,0);
        return area(a,b,c) == 0 && area(a,b,sol) !=0;
    }

    /**
     * Hay sequia si el area de los planetas es 0 y el area del sol con 2 planetas es 0 (estan todos alineados)
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean dryPeriod(Point a, Point b, Point c){
        Point sol = new Point(0,0);
        return area(a,b,c) == 0 && area(a,b,sol) ==0;
    }

    /**
     * Calculo la posicion de un planeta
     * @param planet
     * @param days
     * @return
     */
    public static Point getPosition(Planet planet, int days)
    {
        double x = Math.sin(Math.toRadians(planet.getDegresAtDays(days)));
        double y =  Math.cos(Math.toRadians(planet.getDegresAtDays(days)));
        return new Point(y*planet.getDistance(),x*planet.getDistance()).round();
    }

    /**
     * Calculo del area de 3 puntos
     * @param a el primer punto
     * @param b el segundo punto
     * @param c el tercer punto
     * @return el area
     */
    private static double area(Point a, Point b, Point c)
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
    public static double intensity(Point a, Point b, Point c)
    {
        double one = Math.sqrt(Math.pow(b.getX()-a.getX(),2)+Math.pow(b.getY()-a.getY(),2));
        double two = Math.sqrt(Math.pow(c.getX()-b.getX(),2)+Math.pow(c.getY()-b.getY(),2));
        double three = Math.sqrt(Math.pow(c.getX()-a.getX(),2)+Math.pow(c.getY()-a.getY(),2));
        return one+two+three;
        }


}


