package Vista;

import Modelo.Melodia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Esta clase funciona como la Vista en el patrón de diseño MVC.
 * Muestra información y captura lo que el usuario ingrese.
 * Aquí simplemente recibe datos y los envía al Controlador.
 *
 * @author David Guerrero
 * @version 1.0
 */
public class Vista {

    //=======================================================================
    //                              MÉTODOS
    //=======================================================================

    /**
     * capturarMelodia() muestra y captura los datos necesarios para crear un nuevo objeto Melodia.
     * @return objeto de tipo Melodia con los datos ingresados por el usuario.
     */
    public Melodia capturarMelodia() {
        Scanner sc = new Scanner(System.in);

        // Todos los datos necesarios que se le piden al usuario para crear una melodía.
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

        // Instancia del objeto usando el constructor parametrizado.
        Melodia melodia = new Melodia(nombre, compositor, anio, genero, cantante, precio, formato);

        // Regresa la melodía creada con los datos ingresados por el usuario.
        return melodia;
    }

    /**
     * mostrarMenu() muestra las opciones del sistema y captura la decisión del usuario.
     * @return la opción escogida por el usuario en el menú.
     */
    public int mostrarMenu() {
        // Impresión del menú principal del programa.
        System.out.println("1. Ingresar melodía");
        System.out.println("2. Mostrar melodías");
        System.out.println("3. Eliminar una melodía");
        System.out.println("4. Conocer datos de melodía");
        System.out.println("5. Corregir datos de melodía");
        System.out.println("6. Mostrar valor monetario de la colección");
        System.out.println("7. Conocer cuántos y cuáles cantantes tienen melodías");
        System.out.println("8. Mostrar melodías por género");
        System.out.println("9. Mostrar los géneros que abarca la colección");
        System.out.println("10. Mostrar melodías de un género");
        System.out.println("11. Mostrar melodías de un cantante");
        System.out.println("12. Salir");

        // Captura y regresa la opción escogida por el usuario.
        int op = validarEntrada();
        return op;
    }

    /**
     * insertarMelodia() avisa al usuario si se agregó o no la melodía a la colección.
     * Se utiliza para la opción [1].
     * @param pudoAgregarse (booleano de la operación utilizada en el modelo).
     */
    public void insertarMelodia(boolean pudoAgregarse) {
        // Se mostrará una cadena con el resultado dependiendo del operador ternario.
        // ? = en caso de ser "true", mostrará un mensaje de confirmación de añadido.
        // : = en caso de ser "false", avisará el programa de que no se añadió la melodía.
        String cadenaAgregadoMelodia =
                pudoAgregarse ? "\nSe ha agregado una melodía nueva.\n" :
                        "\nLa melodía ya está en la colección.\n";
        System.out.println(cadenaAgregadoMelodia);
    }

    /**
     * mostrarTodasLasMelodias() muestra a través de una cadena todas las melodías de la colección.
     * Se utiliza para la opción [2].
     * @param cadenaMelodias (cadena de todas las melodías).
     */
    public void mostrarTodasLasMelodias(String cadenaMelodias) {
        System.out.println(cadenaMelodias);
    }

    /**
     * confirmarBorradoMelodia() avisa al usuario si se eliminó o no una melodía de la colección.
     * Se utiliza para la opción [3].
     * @param pudoEliminarse (booleano de la operación utilizada en el modelo).
     */
    public void confirmarBorradoMelodia(boolean pudoEliminarse) {
        // Se mostrará una cadena con el resultado dependiendo del operador ternario.
        // ? = en caso de ser "true", mostrará un mensaje de confirmación de borrarado.
        // : = en caso de ser "false", te avisará el programa de que no pudo borrar la melodía.
        String cadenaMelodiaEliminada =
                pudoEliminarse ? "\nSe ha borrado la melodía.\n" :
                        "\nLa melodía no existe o no está bien escrita.\n";
        System.out.println(cadenaMelodiaEliminada);
    }

    /**
     * mostrarDatosDeMelodia() muestra la información completa de una melodía.
     * Se utiliza para la opción [4].
     * @param melodia (objeto de tipo Melodia a mostrar).
     */
    public void mostrarDatosDeMelodia(Melodia melodia) {
        // Verifica si el objeto de tipo Melodia existe.
        if (melodia != null) {
            // Si es diferente de null, mostrará los datos de la melodía a la que se accedió.
            System.out.println("\nHas accedido a tu melodia a través de la canción "
                    + melodia.getNombre() + "\n");
            System.out.println(melodia);
        } else {
            // Si null, mostrará un mensaje de aviso de que no encontró la melodía.
            System.out.println("\nNo se encontró la melodía.\n");
        }
    }

    /**
     * modificarMelodia() muestra otro menú para elegir qué atributo se desea modificar.
     * Se utiliza para la opción [5].
     * @return la opción escogida por el usuario en este submenú.
     */
    public int modificarMelodia() {
        // Despliega el submenú con las opciones de todos los datos para modificar/corregir.
        System.out.println("\nEscoge el dato de la melodía que buscas corregir: ");
        System.out.println("1. Nombre");
        System.out.println("2. Compositor");
        System.out.println("3. Año");
        System.out.println("4. Género");
        System.out.println("5. Cantante");
        System.out.println("6. Precio");
        System.out.println("7. Formato");
        System.out.println("8. Salir");

        // Captura la opción elegida y la regresa.
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    /**
     * mostrarValorElValorMonetario() muestra en una cadena el valor monetario de la colección.
     * Se utiliza para la opción [6].
     * @param cadenaPrecio (cadena del total de la suma de los precios de cada melodía).
     */
    public void mostrarValorElValorMonetario(double cadenaPrecio) {
        System.out.println("\nEl precio actual de la colección es de $" + cadenaPrecio + "\n");
    }

    /**
     * mostrarListaDeCantantes() muestra quiénes y cuántos cantantes/artistas tienen melodía.
     * Se utiliza para la opción [7].
     * @param hs (HashSet con la información de los cantantes/artistas).
     */
    public void mostrarListaDeCantantes(HashSet<String> hs) {
        // Impresión que muestra el total de cantantes que tienen melodía.
        // Se utiliza .size() para conocer el tamaño del HashSet.
        System.out.println("\nEn total hay " + hs.size() + " cantantes que tienen melodía:");

        // Recorre el HashSet con los cantantes.
        for (String cantante : hs) {
            // Muestra individualmente aquellos cantantes que tienen melodía.
            System.out.println(" -" + cantante);
        }

        System.out.println(" ");
    }

    /**
     * mostrarConteoXGenero() muestra la cantidad de melodías que hay por género.
     * Se utiliza para la opción [8].
     * @param mapa (HashMap que mantiene una relación de género-cantidad).
     */
    public void mostrarConteoXGenero(HashMap<String, Integer> mapa) {
        System.out.println("\nCantidad de melodías que hay por cada género:");

        // Recorre sobre las claves del mapa para obtener los valores.
        for (String genero : mapa.keySet()) {
            // Toma la cantidad de melodías que hubo de cada género para luego mostrarlo.
            int cantidadMelodiasXGenero = mapa.get(genero);
            System.out.println("Hay " + cantidadMelodiasXGenero + " melodías del género " + genero);
        }
        System.out.println(" ");
    }

    /**
     * mostrarListaDeGeneros() permite ver el total de géneros que hay en la colección.
     * Se utiliza para la opción [9].
     * @param hs (HashSet que contiene los géneros únicos).
     */
    public void mostrarListaDeGeneros(HashSet<String> hs) {
        // Imprime un mensaje indicando la cantidad total de géneros en la colección.
        // Se utiliza .size() para conocer el tamaño del HashSet.
        System.out.println("\nEn total hay " + hs.size() + " géneros en la colección.");

        // Recorre el HashSet con los géneros.
        for(String genero : hs) {
            // Muestra individualmente cada género existente en la colección.
            System.out.println(" -" + genero);
        }

        System.out.println(" ");
    }

    /**
     * mostrarMelodiasDeCadaGenero() muestra en un arreglo todas las melodías de un tipo de género.
     * Se utiliza para la opción [10].
     * @param melodiasFiltradasGenero (ArrayList con las melodías filtradas).
     * @param genero (género consultado).
     */
    public void mostrarMelodiasDeCadaGenero(ArrayList<Melodia> melodiasFiltradasGenero,
                                            String genero) {
        System.out.println("\nEstas son todas las melodías del género " + genero + ":\n");

        // Recorre el arreglo filtrado para mostrar individualmente cada melodía de ese género.
        for (int i = 0; i < melodiasFiltradasGenero.size(); i++) {
            System.out.println(melodiasFiltradasGenero.get(i));
        }
    }

    /**
     * mostrarMelodicasDeCadaCantante() muestra en un arreglo todas las melodías de un cantante.
     * Se utiliza para la opción [11].
     * @param melodiasFiltradasCantante (ArrayList con las melodías filtradas).
     * @param cantante (cantante consultado).
     */
    public void mostrarMelodicasDeCadaCantante(ArrayList<Melodia> melodiasFiltradasCantante,
                                               String cantante) {
        System.out.println("\nEstas son todas las melodías del cantante " + cantante + ":\n");

        // Recorre el arreglo filtrado para mostrar individualmente cada melodía de ese cantante.
        for (int i = 0; i < melodiasFiltradasCantante.size(); i++) {
            System.out.println(melodiasFiltradasCantante.get(i));
        }
    }

    //=======================================================================
    //                         MÉTODOS AUXILIARES
    //=======================================================================

    /**
     * leerCadena() se usa para capturar cualquier cadena de texto solicitada por el Controlador.
     * @param cadena (cadena de texto que se solicita).
     * @return texto que se haya ingresado en conjunto al mensaje ya escrito.
     */
    public String leerCadena(String cadena) {
        Scanner sc = new Scanner(System.in);

        // Lo que ingrese el usuario, se añadirá a este mensaje.
        System.out.println("Ingresa el " + cadena);

        // Se captura la información y la regresa en otra cadena diferente.
        String nuevaCadena = sc.nextLine();
        return nuevaCadena;
    }

    /**
     * validarEntrada() asegura que la opción ingresada en el menú sea un número válido.
     * @return opción ingresada por el usuario.
     */
    private int validarEntrada() {
        Scanner sc = new Scanner(System.in);

        // Este bucle será infinito hasta que se ingrese una opción válida.
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                // Si el usuario ingresó una letra, muestra una advertencia.
                System.out.println("\nDebes ingresar un número, no letras.");
                System.out.print("Ingresa una opción [1-12]: ");
                sc.nextLine();
            }
        }
    }

    /**
     * mostrarHashMap() funciona como auxiliar para verificar la impresión correcta de un HashMap.
     * @param hm (información del HashMap).
     */
    public void mostrarHashMap(HashMap hm) {
        System.out.println(hm);
    }

    /**
     * mostrarHashSet() funciona como auxiliar para verificar la impresión correcta de un HashSet.
     * @param hs (información del HashSet).
     */
    public void mostrarHashSet(HashSet hs) {
        System.out.println(hs);
    }
}
