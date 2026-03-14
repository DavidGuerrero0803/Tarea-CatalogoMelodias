package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CatalogoMelodias {
    private ArrayList<Melodia> melodias;

    public CatalogoMelodias() {
        melodias = new ArrayList<>();
    }

    public boolean agregarMelodia(Melodia melodia) {
        boolean bandera = true;

        for (Melodia melodia1 : melodias) {
            if (melodia1.equals(melodia)) {
                bandera = false;
                break;
            } else {
                bandera = true;
            }
        }
        if (bandera) {
            melodias.add(melodia);
        }

        return bandera;
    }

    public String mostrarColeccion() {
        String cadena = null;

        for (Melodia melodia : melodias) {
            cadena += melodia + "\n";
        }

        return cadena;
    }

    public double calcularValorMonetario() {
        double sumaTotal = 0;

        for (Melodia melodia : melodias) {
            sumaTotal = sumaTotal + melodia.getPrecio();
        }

        return sumaTotal;
    }

    public HashMap contarMelodiasXGenero() {
        HashMap<String, Integer> mapa = new HashMap<>();

        for (Melodia melodia : melodias) {
            if(!mapa.containsKey(melodia.getGenero())) {
                mapa.put(melodia.getGenero(), 1);
            } else {
                int valor = mapa.get(melodia.getGenero());
                valor++;
                mapa.put(melodia.getGenero(), valor);
            }
        }

        return mapa;
    }

    public HashSet contarTodosLosGeneros() {
        HashSet<String> hs = new HashSet<>();

        for (Melodia melodia : melodias) {
            hs.add(melodia.getGenero());
        }

        return hs;
    }

    public ArrayList<Melodia> mostrarMelodiasGenero(String genero) {
        ArrayList<Melodia> canciones = new ArrayList<>();
        for (Melodia melodia : melodias) {
            if (genero.equalsIgnoreCase(melodia.getGenero())) {
                canciones.add(melodia);
            }
        }

        return canciones;
    }

    public ArrayList<Melodia> mostrarMelodiasCantante(String cantante) {
        ArrayList<Melodia> canciones = new ArrayList<>();
        for (Melodia melodia : melodias) {
            if (cantante.equalsIgnoreCase(melodia.getCantante())) {
                canciones.add(melodia);
            }
        }
        return canciones;
    }

    public HashSet contarTodosLosCantantes() {
        HashSet<String> hs = new HashSet<>();

        for (Melodia melodia : melodias) {
            hs.add(melodia.getCantante());
        }

        return hs;
    }

}
