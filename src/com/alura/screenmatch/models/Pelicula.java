package com.alura.screenmatch.models;

public class Pelicula {
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracion;
    private boolean incluidoEnElPlan;

    private double valorEvaluaciones;
    private int cantidadEvaluaciones;

    //Builder

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

    @Override
    public String toString() {

        return "Nombre= '" + nombre + '\'' +
                "\nFecha de lanzamiento= " + fechaDeLanzamiento +
                "\nDuracion= " + duracion + "minutos" +
                "\nIncluido en el plan= " + incluidoEnElPlan;
    }

    public void evaluar(double nota){
        valorEvaluaciones += nota;
        cantidadEvaluaciones++;
    }

    public double calcularMedia(){
        return valorEvaluaciones / cantidadEvaluaciones;
    }
}
