/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 * Lista Circular que representa el estado actual del juego
 *
 * @author Grupo#7
 */
public class EstadoDeJuego {

    private NodoPosicionPartida primero;
    private NodoPosicionPartida ultimo;
    private int maxPosiciones;

    /**
     * Constructors 
     *
     * @param maxPosiciones El numero maximo de posiciones en el tablero
     */
    public EstadoDeJuego(int maxPosiciones) {
        this.primero = null;
        this.ultimo = null;
        this.maxPosiciones = maxPosiciones;
        inicializarPosiciones();
    }

    /**
     * Obtener el primer nodo de la lista
     *
     * @return El primer nodo
     */
    public NodoPosicionPartida getPrimero() {
        return primero;
    }

    /**
     * Establecer el primer nodo de la lista
     *
     * @param primero El nuevo primer nodo
     */
    public void setPrimero(NodoPosicionPartida primero) {
        this.primero = primero;
    }

    /**
     * Obtener el ultimo nodo de la lista
     *
     * @return El ultimo nodo
     */
    public NodoPosicionPartida getUltimo() {
        return ultimo;
    }

    /**
     * Establecer el ultimo nodo de la lista
     *
     * @param ultimo El nuevo ultimo nodo
     */
    public void setUltimo(NodoPosicionPartida ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Obtener el numero maximo de posiciones
     *
     * @return El numero maximo de posiciones
     */
    public int getMaxPosiciones() {
        return maxPosiciones;
    }

    /**
     * Inicializar las posiciones del juego
     */
    private void inicializarPosiciones() {
        for (int i = 1; i <= maxPosiciones; i++) {
            insertarPosicion(i);
        }
    }

    /**
     * Inserta una posicion en la lista circular
     *
     * @param posicion La posicion a insertar
     */
    private void insertarPosicion(int posicion) {
        NodoPosicionPartida nuevo = new NodoPosicionPartida(posicion);

        // Caso 1: Lista vacia
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(primero);
            return;
        }

        // Caso 2: Insertar al final
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
        ultimo.setSiguiente(primero);
    }

    /**
     * Actualiza la posicion de un jugador en el tablero
     *
     * @param nombreJugador El nombre del jugador
     * @param nuevaPosicion La nueva posicion del jugador
     * @param posicionAnterior La posicion anterior del jugador 
     */
    public void actualizarPosicionJugador(String nombreJugador, int nuevaPosicion, int posicionAnterior) {
        // Validar que las posiciones esten dentro del rango
        if (nuevaPosicion <= 0 || nuevaPosicion > maxPosiciones) {
            System.out.println("Error: Posicion fuera de rango");
            return;
        }

        // Si la posicion anterior es valida, limpiarla
        if (posicionAnterior > 0 && posicionAnterior <= maxPosiciones) {
            NodoPosicionPartida nodoAnterior = buscarPosicion(posicionAnterior);
            if (nodoAnterior != null && nodoAnterior.getNombreJugador().equals(nombreJugador)) {
                nodoAnterior.setNombreJugador("Vacia");
            }
        }

        // Actualizar la nueva posicion
        NodoPosicionPartida nodoNuevo = buscarPosicion(nuevaPosicion);
        if (nodoNuevo != null) {
            nodoNuevo.setNombreJugador(nombreJugador);
        }
    }

    /**
     * Buscar un nodo por su posicion
     *
     * @param posicion La posicion a buscar
     * @return El nodo correspondiente a la posicion, null si no existe
     */
    private NodoPosicionPartida buscarPosicion(int posicion) {
        if (primero == null) {
            return null;
        }

        NodoPosicionPartida actual = primero;
        do {
            if (actual.getPosicion() == posicion) {
                return actual;
            }
            actual = actual.getSiguiente();
        } while (actual != primero);

        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
// Pendiente de probar, aun no lo entiendo bien
    
    
    /**
     * Imprimir el estado actual del juego con colores
     */
    public void imprimirEstadoJuego() {
        if (primero == null) {
            System.out.println("El juego no tiene posiciones inicializadas");
            return;
        }

        // Calcular los limites para los colores
        int limite1 = (int) (maxPosiciones * 0.4);
        int limite2 = (int) (maxPosiciones * 0.8);

        System.out.println("\n====== ESTADO ACTUAL DEL JUEGO ======");
        System.out.println("Posicion | Jugador");
        System.out.println("---------------------------");

        // Codigos ANSI para colores
        String verde = "\u001B[32m";
        String amarillo = "\u001B[33m";
        String rojo = "\u001B[31m";
        String reset = "\u001B[0m";

        NodoPosicionPartida actual = primero;
        do {
            String color;

            // Asignar color segun la posicion
            if (actual.getPosicion() <= limite1) {
                color = verde;
            } else if (actual.getPosicion() <= limite2) {
                color = amarillo;
            } else {
                color = rojo;
            }

            System.out.println(color + actual.getPosicion() + " | " + actual.getNombreJugador() + reset);

            actual = actual.getSiguiente();
        } while (actual != primero);
    }
}
