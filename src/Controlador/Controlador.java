package Controlador;

import Modelo.CatalogoMelodias;
import Modelo.Melodia;
import Vista.Vista;

import java.util.HashMap;

public class Controlador {
    private Vista vista;
    private CatalogoMelodias modelo;

    public Controlador(CatalogoMelodias modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    insertarNuevaMelodia();
                    break;
                case 2:
                    mostrarMelodias();
                    break;
                case 6:
                    mostrarValorMonetario();
                    break;
                case 8:
                    mostrarMelodiasXGenero();
                    break;
                case 12:
                    System.out.println("ADIÓS.");

            }
        } while (opcion != 12);
    }

    public void insertarNuevaMelodia() {
        Melodia melodia = vista.capturarMelodia();
        boolean bandera = modelo.agregarMelodia(melodia);
        vista.insertarMelodia(bandera);
    }

    public void mostrarMelodias() {
        String cadena = modelo.mostrarColeccion();
        vista.mostrarTodasLasMelodias(cadena);
    }

    public void mostrarValorMonetario() {
        Double cadenaValor = modelo.calcularValorMonetario();
        vista.mostrarValorElValorMonetario(cadenaValor);
    }

    public void mostrarMelodiasXGenero() {
        HashMap hm = modelo.contarMelodiasXGenero();
        vista.mostrarHashMap(hm);
    }

}
