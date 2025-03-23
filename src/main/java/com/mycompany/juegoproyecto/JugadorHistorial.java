/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 * Lista Doble Circular para almacenar el historial de jugadores
 *
 * @author Grupo#7
 */
public class JugadorHistorial {

    private NodoJugadorHistorial cabeza;
    private NodoJugadorHistorial ultimo;
    private int cantidadJugadores;

    /**
     * Constructor
     */
    public JugadorHistorial() {
        this.cabeza = null;
        this.ultimo = null;
        this.cantidadJugadores = 0;
    }

    /**
     * Obtener el nodo cabeza
     *
     * @return El nodo cabeza
     */
    public NodoJugadorHistorial getCabeza() {
        return cabeza;
    }

    /**
     * Establecer el nodo cabeza de la lista
     *
     * @param cabeza El nuevo nodo cabeza
     */
    public void setCabeza(NodoJugadorHistorial cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Obtener el ultimo nodo de la lista
     *
     * @return El ultimo nodo
     */
    public NodoJugadorHistorial getUltimo() {
        return ultimo;
    }

    /**
     * Establecer el ultimo nodo de la lista
     *
     * @param ultimo El nuevo ultimo nodo
     */
    public void setUltimo(NodoJugadorHistorial ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Obtener la cantidad de jugadores en el historial
     *
     * @return Cantidad de jugadores
     */
    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    /**
     * Verificar si la lista esta vacia
     *
     * @return true si la lista esta vacia y false en caso contrario
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Insertar un jugador en la lista
     *
     * @param nombre El nombre del jugador a ingresar
     * @return El nodo del jugador insertado
     */
    public NodoJugadorHistorial insertarJugador(String nombre) {
        // Caso 1: Lista vacia
        if (cabeza == null) {
            NodoJugadorHistorial nuevo = new NodoJugadorHistorial(nombre);
            cabeza = nuevo;
            ultimo = nuevo;

            // Hacer la lista circular
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);

            cantidadJugadores++;
            return nuevo;
        }

        // Verifica si el jugador ya existe
        NodoJugadorHistorial existente = buscarJugador(nombre);
        if (existente != null) {
            return existente;
        }

        // Crea nuevo nodo
        NodoJugadorHistorial nuevo = new NodoJugadorHistorial(nombre);

        // Se inserta al inicio si es menor que la cabeza
        if (nombre.compareToIgnoreCase(cabeza.getNombre()) < 0) {
            nuevo.setSiguiente(cabeza);
            nuevo.setAnterior(ultimo);
            cabeza.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            cabeza = nuevo;
            cantidadJugadores++;
            return nuevo;
        }

        // Insertar si es mayor que el ultimo
        if (nombre.compareToIgnoreCase(ultimo.getNombre()) > 0) {
            nuevo.setSiguiente(cabeza);
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            cabeza.setAnterior(nuevo);
            ultimo = nuevo;
            cantidadJugadores++;
            return nuevo;
        }

        //Insertar en el medio
        NodoJugadorHistorial actual = cabeza;
        do {
            if (nombre.compareToIgnoreCase(actual.getSiguiente().getNombre()) < 0) {
                nuevo.setSiguiente(actual.getSiguiente());
                nuevo.setAnterior(actual);
                actual.getSiguiente().setAnterior(nuevo);
                actual.setSiguiente(nuevo);
                cantidadJugadores++;
                return nuevo;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        return null;
    }

    /**
     * Buscar un jugador por su nombre
     *
     * @param nombre El nombre del jugador a buscar
     * @return El nodo del jugador si existe, null en caso contrario
     */
    public NodoJugadorHistorial buscarJugador(String nombre) {
        if (estaVacia()) {
            return null;
        }

        NodoJugadorHistorial actual = cabeza;
        do {
            if (actual.getNombre().equalsIgnoreCase(nombre)) {
                return actual;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);

        return null;
    }

    /**
     * Agregar una posicion al historial de un jugador
     *
     * @param nombreJugador El nombre del jugador
     * @param posicion La posicion a agregar
     * @param efecto Descripcion del castigo o premio recibido
     */
    public void agregarPosicionJugador(String nombreJugador, int posicion, String efecto) {
        NodoJugadorHistorial jugador = buscarJugador(nombreJugador);

        if (jugador == null) {
            jugador = insertarJugador(nombreJugador);
        }

        jugador.agregarPosicion(posicion, efecto);
    }

    /**
     * Mostrar informacion de un jugador especifico
     *
     * @param jugador El nodo del jugador a mostrar
     */
    public void mostrarJugador(NodoJugadorHistorial jugador) {
        if (jugador != null) {
            jugador.imprimirHistorial();
        } else {
            System.out.println("Este jugador no existe en el historial");
        }
    }
}
