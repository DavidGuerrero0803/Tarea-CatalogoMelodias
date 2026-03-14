package Modelo;

import Controlador.Controlador;
import Vista.Vista;

public class Main {
    public static void main(String[] args) {
        CatalogoMelodias modelo = new CatalogoMelodias();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciar();
    }
}