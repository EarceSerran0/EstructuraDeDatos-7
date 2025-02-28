/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Grupo#7

 */
public class ColaJugadores {
    private NodoJugador frente;
    private NodoJugador fin;

    public ColaJugadores() {
        frente = null;
        fin = null;
    }
    
    public boolean estaVacia() {
    return frente == null;
}

    public void agregarJugador(Jugador jugador) {
        NodoJugador nuevoNodo = new NodoJugador(jugador);
        if (frente == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }
    
    public Jugador quitarJugador() {
    if (frente != null) {
        Jugador jugadorQuitado = frente.getJugador();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return jugadorQuitado;
    }
    return null; // Si la cola está vacía, retorna null
}

    public void listarJugadores() {
        NodoJugador actual = frente;
        StringBuilder sb = new StringBuilder();
        while (actual != null) {
            sb.append(actual.getJugador().getNombre()).append(" - Posición: ").append(actual.getJugador().getPosicion()).append("\n");
            actual = actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}








   
    
