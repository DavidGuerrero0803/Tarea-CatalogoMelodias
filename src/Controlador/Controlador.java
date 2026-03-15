package Controlador;

import Modelo.CatalogoMelodias;
import Modelo.Melodia;
import Vista.Vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Esta clase funciona como el Controlador en un patrón de diseño MVC.
 * Es el intermediario entre el Modelo y la Vista.
 * Recibe los datos de Vista y los pasa a Modelo para trabajar con ellos.
 *
 * @author David Guerrero
 * @version 1.0
 */
public class Controlador {
    // Como el Controlador es el intermediario entre el Modelo y la Vista,
    // hace falta llamarlos para poder acceder a todos los métodos que se han creado en ambas clases.
    private Vista vista;
    private CatalogoMelodias modelo;

    //=======================================================================
    //                             CONSTRUCTOR
    //=======================================================================

    /**
     * Constructor principal. Establece el puente entre el modelo y la Vista.
     * @param modelo (lógica y datos del Modelo).
     * @param vista (interfaces y cadenas de texto de la Vista).
     */
    public Controlador(CatalogoMelodias modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    //=======================================================================
    //                              MÉTODOS
    //=======================================================================

    /**
     * iniciar() genera el ciclo principal del programa.
     * Muestra el menú de la Vista y te permite acceder a cualquiera de las 12 opciones.
     */
    public void iniciar() {
        int opcion;
        do {

            // Se le pide a la vista mostrar el menú y devuelve la opción ingresada.
            opcion = vista.mostrarMenu();

            // Dependiendo de lo que se ingresó, el usuario accederá a una opción u otra.
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
                default:
                    System.out.println("\nIngresa una opción válida [1-12].\n");
            }

            // Mientras que el usuario no ingrese la última opción, podrá seguir navegando por el menú.
        } while (opcion != 12);
    }

    /**
     * insertarNuevaMelodia() controla los métodos de adición de una nueva melodía.
     */
    public void insertarNuevaMelodia() {
        // Se le pide a la vista capturar los datos de una melodía y devuelve el objeto Melodia.
        Melodia melodia = vista.capturarMelodia();

        // El objeto Melodia pasar por agregarMelodia() para verificar que se puede añadir.
        boolean puedeAgregarse = modelo.agregarMelodia(melodia);

        // Se pide de nuevo a la vista que avise al usuario si pudo o no agregar la melodía a la colección.
        vista.insertarMelodia(puedeAgregarse);
    }

    /**
     * mostrarMelodias() se encarga de recupear y mostrar la colección con todas las melodías.
     */
    public void mostrarMelodias() {
        // Solicita al modelo una cadena para llenarla con la información.
        String cadena = modelo.mostrarColeccion();

        // La cadena se entrega a la vista para mostrarla.
        vista.mostrarTodasLasMelodias(cadena);
    }

    /**
     * eliminarMelodia() controla los métodos de borrado de una melodía existente.
     */
    public void eliminarMelodia() {
        // Pide a la vista el nombre de la canción a borrar.
        String nombre = vista.leerCadena("nombre de la canción: ");

        // Solicita al modelo que realice la eliminación de la melodía.
        boolean pudoEliminarse = modelo.eliminarUnaMelodia(nombre);

        // Si encontró la melodía por el nombre, lo va a hacer.
        // Confirmará el resultado a través de la vista.
        vista.confirmarBorradoMelodia(pudoEliminarse);
    }

    /**
     * consultarMelodia() busca y muestra los datos de una melodía en específico.
     */
    public void consultarMelodia() {
        // Pide a la vista el nombre de la canción.
        String nombre = vista.leerCadena("nombre de la canción");

        // El nombre pasa al modelo para que encuentre la melodía correspondiente.
        Melodia melodia = modelo.buscarMelodiaXNombre(nombre);

        // Si encontró la melodía por el nombre, mostrará la información de dicha melodía.
        // Llevar el objeto a la vista para mostrarlo.
        vista.mostrarDatosDeMelodia(melodia);
    }

    /**
     * corregirMelodia() controla la modificación de un atributo de una melodía existente.
     */
    public void corregirMelodia() {
        // Pide a la vista el nombre que tiene la melodía a editar.
        String nombre = vista.leerCadena("nombre de la melodía a corregir");
        Melodia melodia = modelo.buscarMelodiaXNombre(nombre);

        // En caso de no encontrar la melodía, avisará al usuario que no se encontró.
        if (melodia == null) {
            System.out.println("\nNo se encontró la melodía.\n");
        }

        // Solicita a la vista el submenú con las opciones de los datos modificables.
        int opcion = vista.modificarMelodia();
        Scanner sc = new Scanner(System.in);

        // Dependiendo de la opción ingresada del submenú, podrá modificar el atributo de la melodía.
        switch (opcion) {
            case 1:
                melodia.setNombre(vista.leerCadena("nuevo nombre: "));
                break;
            case 2:
                melodia.setCompositor(vista.leerCadena("nuevo compositor: "));
                break;
            case 3:
                System.out.println("Ingresa el nuevo año: ");
                melodia.setAnio(sc.nextInt());
                break;
            case 4:
                melodia.setGenero(vista.leerCadena("nuevo género: "));
                break;
            case 5:
                melodia.setCantante(vista.leerCadena("nuevo cantante: "));
                break;
            case 6:
                System.out.println("Ingresa el nuevo precio: ");
                melodia.setPrecio(sc.nextDouble());
                break;
            case 7:
                melodia.setFormato(vista.leerCadena("nuevo formato: "));
                break;
            default:
                System.out.println("\nCorrección cancelada.\n");
        }
    }

    /**
     * mostrarValorMonetario() controla el manejo del cálculo y muestra el total del valor monetario.
     */
    public void mostrarValorMonetario() {
        // Solicita al modelo el valor total.
        double cadenaValor = modelo.calcularValorMonetario();

        // Pide a la vista que presente el valor total.
        vista.mostrarValorElValorMonetario(cadenaValor);
    }

    /**
     * mostrarInfoCantantes() controla el listado de cantantes de la colección.
     */
    public void mostrarInfoCantantes() {
        // El HashSet permite sacar los cantantes a través del modelo.
        HashSet<String> hs = modelo.contarTodosLosCantantes();

        // Este HashSet se envía a la vista para mostrar la información.
        vista.mostrarListaDeCantantes(hs);
    }

    /**
     * mostrarMelodiasXGenero() controla el listado de melodías que hay por género
     */
    public void mostrarMelodiasXGenero() {
        // El HashMap obtiene el mapa de la cantidad de melodías por género a través del modelo.
        HashMap<String, Integer> hm = modelo.contarMelodiasXGenero();

        // Este HashMap se envía a la vista para visualizar la información.
        vista.mostrarConteoXGenero(hm);
    }

    /**
     * mostrarGenerosDeColeccion() controla el listado de géneros en la colección.
     */
    public void mostrarGenerosDeColeccion() {
        // El HashSet extrae todos los géneros que hay en la colección.
        HashSet<String> hs = modelo.contarTodosLosGeneros();

        // Este HashSet se envía a la vista y permite visualizar el listado.
        vista.mostrarListaDeGeneros(hs);
    }

    /**
     * mostrarMelodiasDeUnGenero() gestiona el filtrado de las melodías a través de un género.
     */
    public void mostrarMelodiasDeUnGenero() {
        // La vista lee la cadena "Género" y se lo pasa al modelo.
        String genero = vista.leerCadena("Género");

        // Solicita al modelo el arreglo filtrado.
        ArrayList<Melodia> melodiasFiltradas = modelo.mostrarMelodiasGenero(genero);

        // La vista ahora pide el arreglo filtrado y el género para mostrar el listado las melodías.
        vista.mostrarMelodiasDeCadaGenero(melodiasFiltradas, genero);
    }

    /**
     * mostrarMelodiasDeUnCantante() gestiona el filtrado de las melodías a través de un cantante.
     */
    public void mostrarMelodiasDeUnCantante() {
        // La vista lee la cadena "Cantante" y se lo pasa al modelo.
        String cantante = vista.leerCadena("Cantante");

        // Solicita al modelo el arreglo filtrado.
        ArrayList<Melodia> canciones = modelo.mostrarMelodiasCantante(cantante);

        // La vista ahora pide el arreglo filtrado y el cantante para mostrar el listado las melodías.
        vista.mostrarMelodicasDeCadaCantante(canciones, cantante);
    }

}
