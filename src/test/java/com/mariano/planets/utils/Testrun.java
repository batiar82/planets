package com.mariano.planets.utils;

import com.mariano.planets.model.Planet;

import java.util.*;
import java.util.stream.Collectors;

public class Testrun {
    public static void main(String[] args){

        int va=1, vb =3, vc =5;
        List<Integer> diasAlineados = new ArrayList<>();
        for(int i = 0; i < 20000; i++){
            int pca = (vc-va)*i,
            pcb = (vc-vb)*i,
            pba = (vb-va)*i;
            if(pca%180 == 0 && pcb % 180 ==0 && pba % 180 == 0) {
                //System.out.println("Alineados dia:" + i);
                diasAlineados.add(i);
            }
        }
        System.out.println("Array "+diasAlineados);
        diasAlineados = new ArrayList<>();
        vc=-5;
        for(int i = 0; i < 20000; i++){
            int pca = (Math.abs(vc-va))*i,
                    pcb = (Math.abs(vc-vb))*i,
                    pba = (Math.abs(vb-va))*i;
            if(pca%180 ==0){
               // System.out.println("Iguales "+i);
            }
            if(pca%180 == 0 && pcb % 180 ==0 && pba % 180 == 0) {
                //System.out.println("Alineados dia:" + i);
                if(i%45 == 00)
                diasAlineados.add(i);
            }
        }
        System.out.println("Array "+diasAlineados);

        Planet ferengi = new Planet(1, 500, true);
        Planet betasoide = new Planet(3, 200, true);
        Planet vulcano = new Planet(5, 1000, true);
        Map<Integer, Double> areas = new HashMap<>();
        for(int i = 0; i < 20000; i++){
           /* if(Utils.areAllAligned(i, ferengi, betasoide,vulcano)){
                diasAlineados.add(i);
            }*/
            areas.put(i,Utils.perimetro(Utils.getPosition(ferengi,i),Utils.getPosition(betasoide,i),Utils.getPosition(vulcano,i)));
        }
        System.out.println("Areas "+areas.values().stream().max(Double::compareTo));
        Map<Integer, Double> maxim = areas.entrySet().stream().filter(e -> e.getValue().equals(3108.4389579424783)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));//.stream().max(Double::compareTo).get();
        System.out.println("MAXIN> "+maxim);
    }

}
