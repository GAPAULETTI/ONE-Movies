package com.alura.screenmatch.calculos;

import com.alura.screenmatch.models.Pelicula;
import com.alura.screenmatch.models.Titulo;

public class CalcularTiempo {

    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo){
        this.tiempoTotal += titulo.getDuracion();
    }
}
