/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 * Nodo para la lista doble circular de historial de jugadores
 * @author Grupo#7
 */
public class NodoJugadorHistorial {
    private String nombre;
    private ListaPosicion historialPosiciones;
    private NodoJugadorHistorial siguiente;
    private NodoJugadorHistorial anterior;

    /**
     * Constructor para el nodo de jugador en el historial
     * @param nombre El nombre del jugador
     */
    public NodoJugadorHistorial(String nombre) {
        this.nombre = nombre;
        this.historialPosiciones = new ListaPosicion();
        this.siguiente = null;
        this.anterior = null;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPosicion getHistorialPosiciones() {
        return historialPosiciones;
    }

    public void setHistorialPosiciones(ListaPosicion historialPosiciones) {
        this.historialPosiciones = historialPosiciones;
    }

    public NodoJugadorHistorial getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoJugadorHistorial siguiente) {
        this.siguiente = siguiente;
    }

    public NodoJugadorHistorial getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoJugadorHistorial anterior) {
        this.anterior = anterior;
    }
    
    /**
     * Agregar una posicion al historial del jugador
     * @param posicion La posicion a agregar
     * @param efecto Descripcion del castigo o premio recibido
     */
    public void agregarPosicion(int posicion, String efecto) {
        historialPosiciones.insertarPosicion(posicion, efecto);
    }
    
    /**
     * Imprimir el historial de posiciones del jugador
     */
    public void imprimirHistorial() {
        System.out.println("\n=== Historial del jugador: " + nombre + " ===");
        historialPosiciones.imprimirLista();
    }
}