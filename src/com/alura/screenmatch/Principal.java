package com.alura.screenmatch;

import com.alura.screenmatch.calculos.CalcularTiempo;
import com.alura.screenmatch.calculos.Clasificacion;
import com.alura.screenmatch.calculos.FiltroRecomendacion;
import com.alura.screenmatch.models.Episodio;
import com.alura.screenmatch.models.Pelicula;
import com.alura.screenmatch.models.Serie;
import com.alura.screenmatch.models.Titulo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Pelicula pelicula1 = new Pelicula("Encanto", 2021);
        pelicula1.setDuracion(120);
        pelicula1.setIncluidoEnElPlan(true);

        pelicula1.evaluar(10);
        pelicula1.evaluar(7.8);
        System.out.println(pelicula1.getCantidadEvaluaciones());
        System.out.println(pelicula1.calcularMedia());
        System.out.println("Média de evaluaciones de la película: " + pelicula1.calcularMedia());
        System.out.println(pelicula1);

        Serie casaDelDragon = new Serie("La casa del Dragón", 2022);
        casaDelDragon.setTemporadas(3);
        casaDelDragon.setMinutosPorEpisodios(55);
        casaDelDragon.setEpisodios(50);

        CalcularTiempo calculadora = new CalcularTiempo();
        calculadora.incluye(pelicula1);
        calculadora.incluye(casaDelDragon);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(pelicula1);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targaryen");
        episodio.setSerie(casaDelDragon);
        episodio.setTotalVisualizaciones(300);

        filtroRecomendacion.filtra(episodio);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(pelicula1);

        System.out.println(listaDePeliculas.size());
        System.out.println(listaDePeliculas.get(0).getNombre());
        System.out.println(listaDePeliculas.get(0));

    }
}
