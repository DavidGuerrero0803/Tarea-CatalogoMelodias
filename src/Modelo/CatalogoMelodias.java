package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * La clase CatalaogoMelodias funciona como el Modelo de un patrón de diseño (MVC).
 * No tiene conocimiento de menús y de lectura de teclados.
 * Aquí se realizan los cálculos y filtraciones de información.
 *
 * @author David Guerrero
 * @version 1.0
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
     * agregarMelodia() permite agregar una melodía a la colección.
     * Asegura de que no existan melodías duplicadas.
     * @param melodia (objeto de tipo Melodia).
     * @return true si la melodía se agregó, false si es que ya existe en la colección.
     */
    public boolean agregarMelodia(Melodia melodia) {
        // Boolean que funciona como bandera.
        // Se hace uso de un flujo combinado con anyMatch,
        // este devolverá true si algún elemento cumple la condición del equals.
        boolean esNuevaMelodia = melodias.stream().anyMatch(m -> m.equals(melodia));

        // Si no ha habido una melodía duplicada, se añadirá entonces a la colección.
        if (!esNuevaMelodia) {
            melodias.add(melodia);
            // La bandera será true, indicando que la melodía es nueva.
            return true;
        }
        // En caso de detectar que es una melodía duplicada, se devolverá un false.
        return false;
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
        // Se regresará el resultado de lo que pase por el flujo.
        return melodias.stream()
                // El filtro sirve para encontrar la melodía por medio del nombre
                // (ignorando de paso las mayúsculas y minúsculas).
                .filter(m -> m.getNombre().equalsIgnoreCase(nombre))
                // Si se encuentra, se posicionará como el primer elemento del stream.
                .findFirst()
                // Si no se encontró la melodía por el nombre, regresará un null.
                .orElse(null);
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
        // Se regresará el resultado de lo que pase por el flujo.
        return melodias.stream()
                // mapToDouble transforma cada elemento del flujo a un tipo double.
                .mapToDouble(Melodia::getPrecio)
                // Todos los precios se suman para formar un total.
                .sum();
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
        // Se regresará el resultado de lo que pase por el flujo.
        return melodias.stream()
                // El map convertirá los elementos del flujo en géneros.
                .map(Melodia::getGenero)
                // Todos los géneros del flujo se guardarán en una colección HashSet
                // (al tratarse de HashSet, nativamente ignorará los géneros repetidos).
                .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * mostrarMelodiasGenero() busca en la colección las melodías de un género específico.
     * @param genero (género a buscar).
     * @return arreglo con los resultados de la búsqueda.
     */
    public ArrayList<Melodia> mostrarMelodiasGenero(String genero) {
        // Se regresará el resultado de lo que pase por el flujo.
        return melodias.stream()
                // El filtro sirve para encontrar melodías por medio del género especificado
                // (ignorando de paso las mayúsculas y minúsculas).
                .filter(m -> m.getGenero().equalsIgnoreCase(genero))
                // Las melodías con los resultados de la búsqueda se guardarán en un ArrayList.
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * mostrarMelodiasCantante() busca en la colección las melodías de un cantante específico.
     * @param cantante (cantante a buscar).
     * @return arreglo con los resultados de la búsqueda.
     */
    public ArrayList<Melodia> mostrarMelodiasCantante(String cantante) {
        // Se regresará el resultado de lo que pase por el flujo.
        return melodias.stream()
                // El filtro sirve para encontrar melodías por medio del cantante especificado
                // (ignorando de paso las mayúsculas y minúsculas).
                .filter(m -> m.getCantante().equalsIgnoreCase(cantante))
                // Las melodías con los resultados de la búsqueda se guardarán en un ArrayList.
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * contarTodosLosCantantes() identifica todos los cantantes únicos en la colección.
     * @return HashSet con todos los cantantes (sin duplicados).
     */
    public HashSet<String> contarTodosLosCantantes() {
        // Se regresará el resultado de lo que pase por el flujo.
        return melodias.stream()
                // El map convertirá los elementos del flujo en cantantes.
                .map(Melodia::getCantante)
                // Todos los géneros del flujo se guardarán en una colección HashSet
                // (al tratarse de HashSet, nativamente ignorará los géneros repetidos).
                .collect(Collectors.toCollection(HashSet::new));
    }

}
