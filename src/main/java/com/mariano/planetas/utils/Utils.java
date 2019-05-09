package com.mariano.planetas.utils;

import com.mariano.planetas.modelo.Planeta;
import com.mariano.planetas.modelo.Punto;

public class Utils {

    /**
     * Determina si llueve buscando si el triangulo formado por los 3 puntos contiene al sol.
     * La suma de las areas debe dar igual a la cuma del area de los planetas
     * @param a el primer punto
     * @param b el segundo punto
     * @param c el tercer punto
     * @return true si los puntos contienen al Sol (0,0), false sino
     */
    public static boolean periodoDeLluvia(Punto a, Punto b, Punto c){
        Punto sol = new Punto(0,0);
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
    public static boolean periodoOptimo(Punto a, Punto b, Punto c){
        Punto sol = new Punto(0,0);
        return area(a,b,c) == 0 && area(a,b,sol) !=0;
    }

    /**
     * Hay sequia si el area de los planetas es 0 y el area del sol con 2 planetas es 0 (estan todos alineados)
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean periodoSeco(Punto a, Punto b, Punto c){
        Punto sol = new Punto(0,0);
        return area(a,b,c) == 0 && area(a,b,sol) ==0;
    }

    /**
     * Calculo la posicion de un planeta
     * @param planeta
     * @param days
     * @return
     */
    public static Punto getPosicion(Planeta planeta, int days)
    {
        double x = Math.sin(Math.toRadians(planeta.getGradosParaElDia(days)));
        double y =  Math.cos(Math.toRadians(planeta.getGradosParaElDia(days)));
        return new Punto(y* planeta.getDistancia(),x* planeta.getDistancia()).redondear();
    }

    /**
     * Calculo del area de 3 puntos
     * @param a el primer punto
     * @param b el segundo punto
     * @param c el tercer punto
     * @return el area
     */
    private static double area(Punto a, Punto b, Punto c)
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
    public static double intensidad(Punto a, Punto b, Punto c)
    {
        double ladoAB = Math.sqrt(Math.pow(b.getX()-a.getX(),2)+Math.pow(b.getY()-a.getY(),2));
        double ladoCB = Math.sqrt(Math.pow(c.getX()-b.getX(),2)+Math.pow(c.getY()-b.getY(),2));
        double ladoAC = Math.sqrt(Math.pow(c.getX()-a.getX(),2)+Math.pow(c.getY()-a.getY(),2));
        return ladoAB+ladoAC+ladoCB;
        }


}


