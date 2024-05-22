package com.alura.screenmatch.models;

import com.alura.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {


    public String director;

    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) (calcularMedia()/2);
    }
    @Override
    public String toString() {

        return "Nombre= '" + this.getNombre() + '\'' +
                "\nFecha de lanzamiento= " + this.getClasificacion() +
                "\nDuracion= " + this.getDuracion() + " minutos" +
                "\nIncluido en el plan= " + this.isIncluidoEnElPlan();
    }
}
