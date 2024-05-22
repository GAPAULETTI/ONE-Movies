package com.alura.screenmatch.calculos;

public class FiltroRecomendacion {

    public void filtra(Clasificacion clasificacion){
        if(clasificacion.getClasificacion() >= 4){
            System.out.println("Muy buena evaluación!!!");
        }else if(clasificacion.getClasificacion() >= 2){
            System.out.println("Buena evaluación!!");
        }else{
            System.out.println("Mala Clasificación");
        }
    }
}
