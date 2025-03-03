package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class NodoJugador {

    private Jugador jugador;
    private NodoJugador siguiente;

    public NodoJugador(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }
//getters

    public Jugador getJugador() {
        return jugador;
    }

    public NodoJugador getSiguiente() {
        return siguiente;
    }
//setters

    public void setSiguiente(NodoJugador siguiente) {
        this.siguiente = siguiente;
    }
}
