/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class Nodo {

    private Datos piDatos;
    private Nodo abajo;

    public Datos getPiDatos() {
        return piDatos;
    }

    public Nodo getAbajo() {
        return abajo;
    }

    public void setPiDatos(Datos piDatos) {
        this.piDatos = piDatos;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

    public Nodo(Datos piDatos) {
        this.piDatos = piDatos;

    }

}
