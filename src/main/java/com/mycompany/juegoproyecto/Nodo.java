package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class Nodo {

    private Datos piDatos;
    private Nodo abajo;
//getters

    public Datos getPiDatos() {
        return piDatos;
    }

    public Nodo getAbajo() {
        return abajo;
    }
//setters

    public void setPiDatos(Datos piDatos) {
        this.piDatos = piDatos;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

}
