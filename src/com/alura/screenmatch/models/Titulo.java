package com.alura.screenmatch.models;

import com.alura.screenmatch.exceptions.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int fechaDeLanzamiento;
    @SerializedName("Runtime")
    private int duracion;
    private boolean incluidoEnElPlan;

    private double valorEvaluaciones;
    private int cantidadEvaluaciones;

    //Builder
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
            this.nombre = miTituloOmdb.title();
            this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
            if (miTituloOmdb.runtime().contains("N/A")){
                throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion, porque contiene un N/A");
            }
            this.duracion= Integer.valueOf(
                    miTituloOmdb.runtime().substring(0,3).replace(" ","")
            );
        }



    //Getter&Setter


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public double getValorEvaluaciones() {
        return valorEvaluaciones;
    }

    public void setValorEvaluaciones(double valorEvaluaciones) {
        this.valorEvaluaciones = valorEvaluaciones;
    }

    public int getCantidadEvaluaciones() {
        return cantidadEvaluaciones;
    }

    public void setCantidadEvaluaciones(int cantidadEvaluaciones) {
        this.cantidadEvaluaciones = cantidadEvaluaciones;
    }



    public void evaluar(double nota){
        valorEvaluaciones += nota;
        cantidadEvaluaciones++;
    }

    public double calcularMedia(){
        return valorEvaluaciones / cantidadEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "Titulo: " + nombre +
                "\nFechaDeLanzamiento: " + fechaDeLanzamiento +
                "\nDuración: " + duracion;
    }
}
