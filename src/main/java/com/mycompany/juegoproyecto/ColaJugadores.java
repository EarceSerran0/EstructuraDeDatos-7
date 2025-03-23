package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class ColaJugadores extends Cola {
    public void agregarJugador(Jugador jugador) {
        NodoJugador nuevoNodo = new NodoJugador(jugador);
        super.agregar(nuevoNodo);
    }

    public Jugador quitarJugador() {
        NodoJugador nodoQuitado = super.quitar();
        return nodoQuitado != null ? nodoQuitado.getJugador() : null;
    }

    public Jugador consultarSiguiente() {
        NodoJugador nodoFrente = super.consultarFrente();
        return nodoFrente != null ? nodoFrente.getJugador() : null;
    }

    public int getCantidadJugadores() {
        return super.getCantidad();
    }
}
