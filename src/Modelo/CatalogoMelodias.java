package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * La clase CatalaogoMelodias funciona como el Modelo de un patrón de diseño (MVC).
 * No tiene conocimiento de menús y de lectura de teclados.
 * Aquí se realizan los cálculos y filtraciones de información.
 */
public class CatalogoMelodias {
    // Todos los atributos de Melodia, se guardan en un ArrayList de melodías.
    private ArrayList<Melodia> melodias;

    //=======================================================================
    //                            CONSTRUCTORES
    //=======================================================================

    /**
     * Constructor que crea una ArrayList de melodías "vacía" para llenar con información.
     */
    public CatalogoMelodias() {
        melodias = new ArrayList<>();
    }

    /**
     * Constructor el cual tiene una ArrayList y que llena con información genérica de una melodía.
     * @param melodias ArrayList de melodías previas para llenar en la colección.
     */
    public CatalogoMelodias(ArrayList<Melodia> melodias) {
        this.melodias = melodias;
    }

    //=======================================================================
    //                              MÉTODOS
    //=======================================================================

    /**
     * agregarMelodia() permite agregar una melodía a la colección (validando de que no existan duplicados).
     * @param melodia (objeto de tipo Melodia).
     * @return true si la melodía se agregó, false si es que ya existe en la colección.
     */
    public boolean agregarMelodia(Melodia melodia) {
        // Boolean que funciona como bandera y que por default es true.
        boolean esNuevaMelodia = true;

        // Recorre la colección buscando una melodía que sea igual.
        for (Melodia melodia1 : melodias) {
            // Mediante el equals, determina si la nueva melodía es igual a otra.
            if (melodia1.equals(melodia)) {
                // En caso de ser cierto, la melodía no es nueva, por lo que devuelve false.
                esNuevaMelodia = false;
                // Ya que se sabe el resultado de la búsqueda, esta se detiene.
                break;
            } else {
                // Si ambas melodías son diferentes, entonces SÍ es una nueva melodía.
                esNuevaMelodia = true;
            }
        }
        // Cuando la condición sea true, la nueva melodía se añadirá a la ArrayList/colección.
        if (esNuevaMelodia) {
            melodias.add(melodia);
        }

        // Al final devuelve el resultado de las comparaciones.
        return esNuevaMelodia;
    }

    /**
     * mostrarColeccion() genera una cadena con la información de la colección y la muestra.
     * @return cadena de texto con los datos de cada una de las melodías.
     */
    public String mostrarColeccion() {
        String cadenaDeColeccion = "";

        // Recorre toda la colección de melodías.
        for (Melodia melodia : melodias) {
            // La cadena utiliza el toString() de Melodia para mostrar la colección.
            cadenaDeColeccion += melodia;
        }

        // Regresa la cadena de texto creada con toda la información de las melodías.
        return cadenaDeColeccion;
    }

    /**
     * buscarMelodiaXNombre() se encarga de buscar una melodía a través de su nombre.
     * @param nombre (nombre de la melodía a buscar).
     * @return la melodía (en caso de que exista), null si es que no se encuentra.
     */
    public Melodia buscarMelodiaXNombre(String nombre) {
        // Recorre toda la colección de melodías.
        for (Melodia melodia : melodias) {
            // Busca el nombre de la melodía comparando nombres de la colección.
            // equalsIgnoreCase() se encarga de ignorar mayúsculas y minúsculas.
            if (melodia.getNombre().equalsIgnoreCase(nombre)) {
                // Regresa la melodía (si es que se encontró).
                return melodia;
            }
        }

        // Si no se encontró la melodía por el nombre, regresará un null.
        return null;
    }

    /**
     * eliminarUnaMelodia() elimina una melodía del catálogo a través del nombre.
     * @param nombre (nombre de la melodía a eliminar).
     * @return true si el borrado fue realizado, false en caso de que no se pueda.
     */
    public boolean eliminarUnaMelodia(String nombre) {
        // Se crea un objeto de tipo Melodia para utilizar el buscarMelodiaXNombre().
        Melodia melodia = buscarMelodiaXNombre(nombre);

        // Condición que se cumple si la melodía es diferente de null (que exista).
        if (melodia != null) {
            // Si la melodía se encontró, entonces se remueve del arreglo.
            return melodias.remove(melodia);
        }

        // En caso de que no se haya encontrado la melodía por el nombre, devolverá false.
        return false;
    }

    /**
     * calcularValorMonetario() suma todos los precios de las melodías en la colección.
     * @return total de la suma acumulada del valor monetario.
     */
    public double calcularValorMonetario() {
        // Contador que inicia en 0.
        double sumaTotal = 0;

        // Recorre toda la colección de melodías.
        for (Melodia melodia : melodias) {
            // En cada iteración se suma el precio de una melodía con la otra.
            sumaTotal = sumaTotal + melodia.getPrecio();
        }

        // Regresa la suma total de todos los precios.
        return sumaTotal;
    }

    /**
     * contarMelodiasXGenero() cuenta cuántas melodías existen por cada género.
     * @return HashMap donde la clave es el género y el Valor la cantidad de melodías.
     */
    public HashMap<String, Integer> contarMelodiasXGenero() {
        // HashMap con clave: Género, valor: Cantidad de melodías.
        HashMap<String, Integer> mapa = new HashMap<>();

        // Recorre toda la colección de melodías.
        for (Melodia melodia : melodias) {
            // Si el género no existe en el mapa, inicia el conteo en 1.
            if (!mapa.containsKey(melodia.getGenero())) {
                mapa.put(melodia.getGenero(), 1);
            } else {
                // Si es que el mapa existe, incrementa el valor actual.
                int valor = mapa.get(melodia.getGenero());
                valor++;
                mapa.put(melodia.getGenero(), valor);
            }
        }

        // Regresa el HashMap con el género y la cantidad de veces que sale.
        return mapa;
    }

    /**
     * contarTodosLosGeneros() identifica todos los géneros únicos en la colección.
     * @return HashSet con todos los géneros (sin duplicados).
     */
    public HashSet<String> contarTodosLosGeneros() {
        // HashMap que alojará a todos los géneros identificados.
        HashSet<String> hs = new HashSet<>();

        // Recorre toda la colección de melodías.
        for (Melodia melodia : melodias) {
            // Se añade el género al HashSet (nativamente ignorará los repetidos).
            hs.add(melodia.getGenero());
        }

        // Regresa el HashSet con todos los géneros identificados.
        return hs;
    }

    /**
     * mostrarMelodiasGenero() busca en la colección las melodías de un género específico.
     * @param genero (género a buscar).
     * @return arreglo con los resultados de la búsqueda.
     */
    public ArrayList<Melodia> mostrarMelodiasGenero(String genero) {
        // ArrayList donde se alojarán las melodías del género a buscar.
        ArrayList<Melodia> listaMelodiasDeUnGenero = new ArrayList<>();

        // Recorre toda la colección de melodías.
        for (Melodia melodia : melodias) {
            // Busca el género de la melodía comparando géneros de la colección.
            // equalsIgnoreCase() se encarga de ignorar mayúsculas y minúsculas.
            if (genero.equalsIgnoreCase(melodia.getGenero())) {
                // Aquellas melodías de un género en particular se guardan en el arreglo.
                listaMelodiasDeUnGenero.add(melodia);
            }
        }

        // Regresa el ArrayList de todas las melodías de un género en específico.
        return listaMelodiasDeUnGenero;
    }

    /**
     * mostrarMelodiasCantante() busca en la colección las melodías de un cantante específico.
     * @param cantante (cantante a buscar).
     * @return arreglo con los resultados de la búsqueda.
     */
    public ArrayList<Melodia> mostrarMelodiasCantante(String cantante) {
        // ArrayList donde se alojarán las melodías del género a buscar.
        ArrayList<Melodia> listaMelodiasDeUnCantante = new ArrayList<>();

        // Recorre toda la colección de melodías.
        for (Melodia melodia : melodias) {
            // Busca el cantante de la melodía comparando cantantes de la colección.
            // equalsIgnoreCase() se encarga de ignorar mayúsculas y minúsculas.
            if (cantante.equalsIgnoreCase(melodia.getCantante())) {
                // Aquellas melodías de un cantante en particular se guardan en el arreglo.
                listaMelodiasDeUnCantante.add(melodia);
            }
        }

        // Regresa el ArrayList de todas las melodías de un cantante en específico.
        return listaMelodiasDeUnCantante;
    }

    /**
     * contarTodosLosCantantes() identifica todos los cantantes únicos en la colección.
     * @return HashSet con todos los cantantes (sin duplicados).
     */
    public HashSet contarTodosLosCantantes() {
        // HashMap que alojará a todos los cantantes identificados.
        HashSet<String> hs = new HashSet<>();

        // Recorre toda la colección de melodías.
        for (Melodia melodia : melodias) {
            // Se añade el cantante al HashSet (nativamente ignorará los repetidos).
            hs.add(melodia.getCantante());
        }

        // Regresa el HashSet con todos los cantantes identificados.
        return hs;
    }

}
