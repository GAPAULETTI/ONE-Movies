import com.alura.screenmatch.models.Pelicula;

public class Principal {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula();

        pelicula1.setNombre("Encanto");
        pelicula1.setFechaDeLanzamiento(2021);
        pelicula1.setDuracion(120);

        System.out.println(pelicula1);
    }
}
