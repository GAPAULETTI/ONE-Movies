package com.alura.screenmatch;

import com.alura.screenmatch.exceptions.ErrorEnConversionDeDuracionException;
import com.alura.screenmatch.models.Titulo;
import com.alura.screenmatch.models.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner((System.in));

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        List<Titulo> titulos = new ArrayList<>();

        while (true) {
            System.out.println("Escribe el nombre de la película: ");
            var busqueda = sc.nextLine();

            if(busqueda.equalsIgnoreCase("salir")){
                break;
            }

            String urlPelicula = "http://www.omdbapi.com/?t=" + busqueda + "&apikey=3558db";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(urlPelicula))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                //System.out.println(response.body());

                //Titulo miTitulo = gson.fromJson(json, Titulo.class);

                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);


                Titulo miTitulo = new Titulo(miTituloOmdb);


                titulos.add(miTitulo);

                //Escribir datos en archivo
            /*FileWriter escritura = new FileWriter(miTitulo.getNombre()+".txt");
            escritura.write(miTitulo.toString());
            escritura.close();
            */

            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }
        }
            System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

    }
}