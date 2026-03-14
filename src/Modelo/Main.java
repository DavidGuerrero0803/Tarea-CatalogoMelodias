package Modelo;

import Controlador.Controlador;
import Vista.Vista;

/**
 * Clase Main donde se ejecuta el programa creando una instancia de cada elemento
 * para probar el correcto funcionamiento del patrón de diseño Modelo-Vista-Controlador.
 */
public class Main {
    public static void main(String[] args) {
        CatalogoMelodias modelo = new CatalogoMelodias();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciar();
    }
}