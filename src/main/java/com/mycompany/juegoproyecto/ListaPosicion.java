/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 * Lista simple para almacenar el historico de posiciones de todos los jugadoes
 * @author Grupo#7
 */
public class ListaPosicion {
    private NodoPosicion primero;

    /**
     * Constructor para la lista de posiciones
     */
    public ListaPosicion() {
        this.primero = null;
    }

    /**
     * Obtener el primer nodo de la lista
     * @return  Nodo #1
     */
    public NodoPosicion getPrimero() {
        return primero;
    }

    /**
     * Establecer el primer nodo de la lista
     * @param primero El nuevo nodo primero
     */
    public void setPrimero(NodoPosicion primero) {
        this.primero = primero;
    }
    
    /**
     * Insertar una posicion en la lista ordenada de menor a mayor
     * Si la posicion ya existe, se reescribe con la nueva informacion
     * @param posicion Posicion del jugador
     * @param efecto Descripcion del castigo o premio recibido
     */
    public void insertarPosicion(int posicion, String efecto) {
        NodoPosicion nuevo = new NodoPosicion(posicion, efecto);
        
        // Caso 1: Lista vacia
        if (primero == null) {
            primero = nuevo;
            return;
        }
        
        // Caso 2: Reemplazar el primero si tiene la misma posicion
        if (primero.getPosicion() == posicion) {
            nuevo.setSiguiente(primero.getSiguiente());
            primero = nuevo;
            return;
        }
        
        // Caso 3: Insertar al inicio si es menor que el primero
        if (posicion < primero.getPosicion()) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
            return;
        }
        
        // Caso 4: Insertar en cualquier otra posicion
        NodoPosicion actual = primero;
        while (actual.getSiguiente() != null && actual.getSiguiente().getPosicion() < posicion) {
            actual = actual.getSiguiente();
        }
        
        // Si encontramos un nodo con la misma posicion, lo reemplazamos
        if (actual.getSiguiente() != null && actual.getSiguiente().getPosicion() == posicion) {
            nuevo.setSiguiente(actual.getSiguiente().getSiguiente());
            actual.setSiguiente(nuevo);
        } else {
            // Sino, insertamos el nuevo nodo en orden
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
    }
    
    /**
     * Recorrer e imprimir la lista
     */
    public void imprimirLista() {
        if (primero == null) {
            System.out.println("El historial esta vacio");
            return;
        }
        
        NodoPosicion actual = primero;
        System.out.println("\n----- Historial de Posicion -----");
        System.out.println("Posicion | Fecha | Efecto");
        while (actual != null) {
            System.out.println(actual.getPosicion() + " | " + 
                               actual.getTimestamp() + " | " + 
                               actual.getEfecto());
            actual = actual.getSiguiente();
        }
    }
    
    /**
     * Verifica si la lista esta vacia
     * @return true si la lista esta vacia, false en caso contrario
     */
    public boolean estaVacia() {
        return primero == null;
    }
}