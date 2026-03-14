package Modelo;

import java.util.Objects;

/**
 * La clase Melodia define lo que vendría siendo una melodía, contiene:
 * Nombre, Compositor, Año, Género, Cantante, Precio y Formato.
 */
public class Melodia {
    // Todos los atributos que componen a una sola melodía.
    private String nombre;
    private String compositor;
    private int anio;
    private String genero;
    private String cantante;
    private double precio;
    private String formato;

    //=======================================================================
    //                           CONSTRUCTORES
    //=======================================================================

    /**
     * Constructor que genera una melodía genérica con datos preestablecidos.
     */
    public Melodia() {
        nombre = "Canción genérica";
        compositor = "Compositor desconocido";
        anio = 2026;
        genero = "Desconocido";
        cantante = "Artista desconocido";
        precio = 5.0;
        formato = "mp3";
    }

    /**
     * Constructor que permite crear una melodía con los 7 datos que la componen.
     * @param nombre (nombre de la melodía).
     * @param compositor (compositor de la melodía).
     * @param anio (año en el que se publicó).
     * @param genero (género al que pertenece).
     * @param cantante (cantante principal de la melodía).
     * @param precio (el precio por lo que se pagó la melodía).
     * @param formato (el formato en el que se encuentra, sea mp3, ogg, etcétera).
     */
    public Melodia(String nombre, String compositor, int anio, String genero, String cantante, double precio, String formato) {
        this.nombre = nombre;
        this.compositor = compositor;
        this.anio = anio;
        this.genero = genero;
        this.cantante = cantante;
        this.precio = precio;
        this.formato = formato;
    }

    //=======================================================================
    //                              GETTERS
    //=======================================================================

    /**
     * Obtiene el nombre que tiene la melodía.
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el compositor de la melodía.
     * @return compositor.
     */
    public String getCompositor() {
        return compositor;
    }

    /**
     * Obtiene el año en el que se publicó la melodía.
     * @return anio.
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Obtiene el género al que pertenece la melodía.
     * @return genero.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Obtiene el cantante principal de la melodía.
     * @return cantante.
     */
    public String getCantante() {
        return cantante;
    }

    /**
     * Obtiene el precio de lo que costó la melodía.
     * @return precio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el formato de la melodía.
     * @return formato.
     */
    public String getFormato() {
        return formato;
    }

    //=======================================================================
    //                              SETTERS
    //=======================================================================

    /**
     * Establece el nombre que tiene la melodía.
     * @param nombre (nuevo nombre de la melodía).
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el compositor que tiene la melodía.
     * @param compositor (nuevo compositor de la melodía).
     */
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    /**
     * Establece el año en el que se publicó la melodía.
     * @param anio (nuevo año para la melodía).
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Establece el género al que pertenece la melodía.
     * @param genero (nuevo género de la melodía).
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Establece al cantante principal de la melodía.
     * @param cantante (nuevo cantante de la melodía).
     */
    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    /**
     * Establece el precio por el que se pagó la melodía.
     * @param precio (nuevo precio de la melodía).
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Establece el formato que tiene la melodía.
     * @param formato (nuevo formato de la melodía).
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    //=======================================================================
    //                              MÉTODOS
    //=======================================================================

    /**
     * equals(Object obj) determina si una melodía actual es igual a otra recién ingresada.
     * Es la misma versión si tienen mismo Cantante y el mismo Año.
     * @param obj (objeto que será de tipo Melodía para hacerle comparación).
     * @return true o false (resultado de la comparación).
     */
    @Override
    public boolean equals(Object obj) {
        // Verifica si ambos objetos apuntan a la misma dirección en memoria.
        if (this == obj) {
            // Si esto es cierto, devolverá true.
            return true;
        }
        // En el caso de que el objeto no exista, devolverá un null.
        if (obj == null) {
            return false;
        }
        // Se asegura que se esté comparando el objeto de la misma clase.
        if (getClass() != obj.getClass()) {
            // Si los dos objetos son de diferentes clases, devolverá false.
            return false;
        }
        // Se cambia el objeto a uno de tipo Melodia.
        final Melodia other = (Melodia) obj;
        // Ya que ahora es de tipo Melodia, se puede determinar si dos de ellas son iguales.
        if (this.anio != other.anio) {
            // Si ambas melodías son diferentes en año, devolverá false.
            return false;
        }
        // Se usa Objects.equals() para comparar en cadenas de texto los cantantes.
        return Objects.equals(this.cantante, other.cantante);
    }

    /**
     * toString que permite mostrar todos los datos que contiene la melodía.
     * @return cadena que contiene: nombre, compositor, año, género, cantante, precio y formato.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nCompositor: " + compositor
                + "\nAño: " + anio
                + "\nGénero: " + genero
                + "\nCantante: " + cantante
                + "\nPrecio: " + precio
                + "\nFormato: " + formato + "\n";
    }
}
