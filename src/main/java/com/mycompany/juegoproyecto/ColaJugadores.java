package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class ColaJugadores extends Cola {
    
    public ColaJugadores() {
      //constructor
    }
    
    // cambias realizados a la version del proyecto anterior. llamando a clase padre
    @Override
    public void encolar(Object elemento) {
        agregarJugador((Jugador) elemento);
    }
    
    @Override
    public Object desencolar() {
        return quitarJugador();
    }
    
    @Override
    public Object consultarFrente() {
        return consultarSiguiente();
    }
    
    // listar jugadores registrads
    public int getCantidadJugadores() {
        return cantidadElementos;
    }

    public void agregarJugador(Jugador jugador) {//nuevo jug
        NodoJugador nuevoNodo = new NodoJugador(jugador);
        if (frente == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
        cantidadElementos++;
    }
    
    public Jugador quitarJugador() {
        if (frente != null) {
            Jugador jugadorQuitado = frente.getJugador();
            frente = frente.getSiguiente();
            if (frente == null) {
                fin = null;
            }
            cantidadElementos--;
            return jugadorQuitado;
        }
        return null; // retorna null con la cola vacia
    }
    
    public Jugador consultarSiguiente() {
        if (frente != null) {
            return frente.getJugador();
        }//sig
        return null;
    }
}