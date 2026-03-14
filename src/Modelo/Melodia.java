package Modelo;

import java.util.Objects;

public class Melodia {
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

    public Melodia() {
        nombre = "Canción genérica";
        compositor = "Compositor desconocido";
        anio = 2026;
        genero = "Desconocido";
        cantante = "Artista desconocido";
        precio = 5.0;
        formato = "mp3";
    }

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

    public String getNombre() {
        return nombre;
    }

    public String getCompositor() {
        return compositor;
    }

    public int getAnio() {
        return anio;
    }

    public String getGenero() {
        return genero;
    }

    public String getCantante() {
        return cantante;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFormato() {
        return formato;
    }

    //=======================================================================
    //                              SETTERS
    //=======================================================================


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    //=======================================================================
    //                              MÉTODOS
    //=======================================================================

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Melodia other = (Melodia) obj;
        if (this.anio != other.anio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.compositor, other.compositor);
    }

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
