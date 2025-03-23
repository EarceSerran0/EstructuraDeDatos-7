/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 * Nodo para la lista circular del estado actual del juego
 * @author Grupo#7
 */
public class NodoPosicionPartida {
    private int posicion;
    private String nombreJugador; // Vacio si no hay jugador
    private NodoPosicionPartida siguiente;

    /**
     * Constructor para el nodo de posicion en el juego
     * @param posicion La posicion en el tablero
     */
    public NodoPosicionPartida(int posicion) {
        this.posicion = posicion;
        this.nombreJugador = "VACIA";
        this.siguiente = null;
    }

    // Getters y setters
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public NodoPosicionPartida getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPosicionPartida siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Verificar si la posicion esta vacia (sin jugador)
     * @return true si la posicion esta vacia, false en caso contrario
     */
    public boolean estaVacia() {
        return "VACIA".equals(nombreJugador);
    }
}