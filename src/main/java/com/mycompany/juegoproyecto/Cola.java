/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 *nadd
 * @author Grupo#7
 */
public abstract class Cola {
    protected NodoJugador frente;
    protected NodoJugador fin;
    protected int cantidadElementos;
//cola padre
    public Cola() {
        frente = null;
        fin = null;
        cantidadElementos = 0;
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
    //getter
    public int getCantidadElementos() {
        return cantidadElementos;
    }

    // Metodos abstractos para las clases hijas
    public abstract void encolar(Object elemento);
    public abstract Object desencolar();
    public abstract Object consultarFrente();
}