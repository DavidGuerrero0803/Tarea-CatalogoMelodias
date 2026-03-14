package Controlador;

import Modelo.CatalogoMelodias;
import Modelo.Melodia;
import Vista.Vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

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
                case 5:
                    corregirMelodia();
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

    public void corregirMelodia() {
        String nombre = vista.leeCadena("nombre de la melodía a corregir");
        Melodia melodia = modelo.buscarMelodiaXNombre(nombre);

        if (melodia == null) {
            System.out.println("\nNo se encontró la melodía.\n");
        }

        int opcion = vista.modificarMelodia();
        Scanner sc = new Scanner(System.in);

        switch (opcion) {
            case 1:
                melodia.setNombre(vista.leeCadena("nuevo nombre: "));
                break;
            case 2:
                melodia.setCompositor(vista.leeCadena("nuevo compositor: "));
                break;
            case 3:
                System.out.println("Ingresa el nuevo año: ");
                melodia.setAnio(sc.nextInt());
                break;
            case 4:
                melodia.setGenero(vista.leeCadena("nuevo género: "));
                break;
            case 5:
                melodia.setCantante(vista.leeCadena("nuevo cantante: "));
                break;
            case 6:
                System.out.println("Ingresa el nuevo precio: ");
                melodia.setPrecio(sc.nextDouble());
                break;
            case 7:
                melodia.setFormato(vista.leeCadena("nuevo formato: "));
                break;
            default:
                System.out.println("\nCorrección cancelada.\n");
        }
    }

    public void mostrarValorMonetario() {
        Double cadenaValor = modelo.calcularValorMonetario();
        vista.mostrarValorElValorMonetario(cadenaValor);
    }

    public void mostrarInfoCantantes() {
        HashSet<String> hs = modelo.contarTodosLosCantantes();
        vista.mostrarListaDeCantantes(hs);
    }

    public void mostrarMelodiasXGenero() {
        HashMap<String, Integer> hm = modelo.contarMelodiasXGenero();
        vista.mostrarConteoXGenero(hm);
    }

    public void mostrarGenerosDeColeccion() {
        HashSet<String> hs = modelo.contarTodosLosGeneros();
        vista.mostrarListaDeGeneros(hs);
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
