package com.alura.screenmatch.models;

public class Serie extends Titulo{

    private int temporadas;
    private int episodios;
    private int minutosPorEpisodios;

    public Serie(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    @Override
    public int getDuracion() {
        return temporadas * episodios * minutosPorEpisodios;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public int getMinutosPorEpisodios() {
        return minutosPorEpisodios;
    }

    public void setMinutosPorEpisodios(int minutosPorEpisodios) {
        this.minutosPorEpisodios = minutosPorEpisodios;
    }

    @Override
    public String toString() {
        return  "\n" +this.getNombre() +
                "\naño: " + this.getFechaDeLanzamiento() +
                "\ntemporadas: " + temporadas +
                "\nepisodios: " + episodios +
                "\nminutosPorEpisodios: " + minutosPorEpisodios;
    }
}
