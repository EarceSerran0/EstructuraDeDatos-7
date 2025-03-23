/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

import java.util.Date;

/**
 * Nodo que almacena las posiciones historicas de un jugador
 *
 * @author Grupo#7
 */
public class NodoPosicion {

    private int posicion;
    private Date timestamp;
    private String efecto;
    private NodoPosicion siguiente;

    /**
     * Constructor
     *
     * @param posicion La posicion del jugador
     * @param efecto Descripcion del castigo o premio obtenido
     */
    public NodoPosicion(int posicion, String efecto) {
        this.posicion = posicion;
        this.timestamp = new Date(); // hora actual
        this.efecto = efecto;
        this.siguiente = null;
    }

    // Getters y setters
    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getEfecto() {
        return efecto;
    }

    public void setEfecto(String efecto) {
        this.efecto = efecto;
    }

    public NodoPosicion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPosicion siguiente) {
        this.siguiente = siguiente;
    }
}
