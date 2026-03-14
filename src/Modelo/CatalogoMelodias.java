package Modelo;

import java.util.ArrayList;

public class CatalogoMelodias {
    private ArrayList<Melodia> melodias;

    public CatalogoMelodias() {
        melodias = new ArrayList<>();
    }

    public boolean agregarMelodia(Melodia melodia) {
        boolean bandera = true;

        for (Melodia melodia1 : melodias) {
            if (melodia1.equals(melodias)) {
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

}
