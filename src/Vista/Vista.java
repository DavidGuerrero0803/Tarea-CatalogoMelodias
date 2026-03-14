package Vista;

import Modelo.Melodia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Vista {
    public Melodia capturarMelodia() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el NOMBRE de la CANCIÓN: ");
        String nombre = sc.nextLine();
        System.out.println("Escribe el NOMBRE del COMPOSITOR: ");
        String compositor = sc.nextLine();
        System.out.println("Escribe el AÑO: ");
        int anio = sc.nextInt();
        sc.nextLine();
        System.out.println("Escribe el GÉNERO: ");
        String genero = sc.nextLine();
        System.out.println("Escribe el NOMBRE del CANTANTE: ");
        String cantante = sc.nextLine();
        System.out.println("Escribe el PRECIO: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Escribe el FORMATO: ");
        String formato = sc.nextLine();

        Melodia melodia = new Melodia(nombre, compositor, anio, genero, cantante, precio, formato);
        return melodia;
    }

    public int mostrarMenu() {
        int op = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Ingresar melodía");
        System.out.println("2. Mostrar melodías"); // Se muestran TODAS las melodías.
        System.out.println("3. Eliminar una melodía"); // Se pide nombre de la canción.
        System.out.println("4. Conocer datos de melodía"); // Se pide nombre de la canción.
        System.out.println("5. Corregir datos de melodía"); // Se pide nombre de la canción.
        System.out.println("6. Mostrar valor monetario (total de la colección)"); // Suma de todos los precios.
        System.out.println("7. Conocer cuántos y cuáles cantantes tienen melodías"); // Cantantes: X cantidad y lista de cantantes.
        System.out.println("8. Mostrar melodías por género"); // Pop: 1, Rock: 2...
        System.out.println("9. Mostrar los géneros que abarca la colección"); // [Pop, Rock].
        System.out.println("10. Mostrar melodías de un género"); // Se pide el género.
        System.out.println("11. Mostrar melodías de un cantante"); // Se pide nombre del cantante.
        System.out.println("12. Salir");

        op = sc.nextInt();
        return op;
    }

    public void insertarMelodia(boolean bandera) {
        String cadena = bandera ? "\nSe ha agregado una melodía nueva.\n" : "\nLa melodía ya está en la colección.\n";
        System.out.println(cadena);
    }

    public void mostrarTodasLasMelodias(String cadenaMelodias) {
        System.out.println(cadenaMelodias);
    }

    public void mostrarValorElValorMonetario(double cadenaPrecio) {
        System.out.println("\nEl precio actual de la colección es de $" + cadenaPrecio + "\n");
    }

    public void mostrarHashMap(HashMap hm) {
        System.out.println(hm);
    }

    public void mostrarHashSet(HashSet hs) {
        System.out.println(hs);
    }

    public void mostrarMelodiasDeCadaGenero(ArrayList<Melodia> canciones, String genero) {
        System.out.println("\nEstas son todas las melodías de género: " + genero + "\n");
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println(canciones.get(i));
        }
    }

    public String leeCadena(String cadena) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el " + cadena);
        String cadena2 = sc.nextLine();

        return cadena2;
    }

}
