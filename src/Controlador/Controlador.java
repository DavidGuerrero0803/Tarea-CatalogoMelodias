package Controlador;

import Modelo.CatalogoMelodias;
import Modelo.Melodia;
import Vista.Vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
                case 3:
                    eliminarMelodia();
                    break;
                case 4:
                    consultarMelodia();
                    break;
                case 6:
                    mostrarValorMonetario();
                    break;
                case 7:
                    mostrarInfoCantantes();
                    break;
                case 8:
                    mostrarMelodiasXGenero();
                    break;
                case 9:
                    mostrarGenerosDeColeccion();
                    break;
                case 10:
                    mostrarMelodiasDeUnGenero();
                    break;
                case 11:
                    mostrarMelodiasDeUnCantante();
                    break;
                case 12:
                    System.out.println("\nADIÓS.");

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

    public void eliminarMelodia() {
        String nombre = vista.leeCadena("nombre de la canción");
        boolean bandera = modelo.eliminarUnaMelodia(nombre);
        vista.confirmarBorradoMelodia(bandera);
    }

    public void consultarMelodia() {
        String nombre = vista.leeCadena("nombre de la canción");
        Melodia melodia = modelo.buscarMelodiaXNombre(nombre);
        vista.mostrarDatosDeMelodia(melodia);
    }

    public void mostrarValorMonetario() {
        Double cadenaValor = modelo.calcularValorMonetario();
        vista.mostrarValorElValorMonetario(cadenaValor);
    }

    public void mostrarInfoCantantes() {
        HashSet hs = modelo.contarTodosLosCantantes();
        vista.mostrarHashSet(hs);
    }

    public void mostrarMelodiasXGenero() {
        HashMap hm = modelo.contarMelodiasXGenero();
        vista.mostrarHashMap(hm);
    }

    public void mostrarGenerosDeColeccion() {
        HashSet hs = modelo.contarTodosLosGeneros();
        vista.mostrarHashSet(hs);
    }

    public void mostrarMelodiasDeUnGenero() {
        String genero = vista.leeCadena("Género");
        ArrayList<Melodia> canciones = modelo.mostrarMelodiasGenero(genero);
        vista.mostrarMelodiasDeCadaGenero(canciones, genero);
    }

    public void mostrarMelodiasDeUnCantante() {
        String cantante = vista.leeCadena("Cantante");
        ArrayList<Melodia> canciones = modelo.mostrarMelodiasCantante(cantante);
        vista.mostrarMelodicasDeCadaCantante(canciones, cantante);
    }

}
