package com.alura.screenmatch;

import com.alura.screenmatch.models.Pelicula;
import com.alura.screenmatch.models.Serie;
import com.alura.screenmatch.models.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("Encanto", 2021);
        Serie casaDelDragon = new Serie("La casa del Dragón", 2022);

        ArrayList<Titulo> listaDeTitulos = new ArrayList<>();
        listaDeTitulos.add(pelicula1);
        listaDeTitulos.add(casaDelDragon);


        for(Titulo item: listaDeTitulos){
            System.out.println(item.getNombre());
            if(item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2){
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeActores = new ArrayList<>();
        listaDeActores.add("Tom Cruise");
        listaDeActores.add("Gabriel Corrado");
        listaDeActores.add("Penelope Cruz");

        Collections.sort(listaDeActores);
        System.out.println("Actores" + listaDeActores);

        Collections.sort(listaDeTitulos);
        System.out.println(listaDeTitulos);

        listaDeTitulos.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Ordenado por fecha: " + listaDeTitulos);
    }
}
