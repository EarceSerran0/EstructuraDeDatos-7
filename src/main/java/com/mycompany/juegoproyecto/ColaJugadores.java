package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class ColaJugadores {
    private NodoJugador frente;
    private NodoJugador fin;
    private int cantidadJugadores;

    public ColaJugadores() {
        frente = null;
        fin = null;
        cantidadJugadores = 0;
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
    
    public int getCantidadJugadores() {
        return cantidadJugadores;
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
        cantidadJugadores++;
    }
    
    public Jugador quitarJugador() {
        if (frente != null) {
            Jugador jugadorQuitado = frente.getJugador();
            frente = frente.getSiguiente();
            if (frente == null) {
                fin = null;
            }
            cantidadJugadores--;
            return jugadorQuitado;
        }
        return null; // Si la cola está vacía, retorna null
    }
    
    public Jugador consultarSiguiente() {
        if (frente != null) {
            return frente.getJugador();
        }
        return null;
    }
    
    
}
