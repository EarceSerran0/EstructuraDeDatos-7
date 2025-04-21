/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 * Nodo para la lista enlazada de preguntas
 *
 * @author Grupo#7
 */
public class nodoPreguntasLista {

    private preguntas pregunta;
    private nodoPreguntasLista siguiente;

    /**
     * Constructor para el nodo de la lista de preguntas
     *
     * @param pregunta La pregunta a almacenar en el nodo
     */
    public nodoPreguntasLista(preguntas pregunta) {
        this.pregunta = pregunta;
        this.siguiente = null;
    }

    //getters
    public preguntas getPregunta() {
        return pregunta;
    }

    public nodoPreguntasLista getSiguiente() {
        return siguiente;
    }

    //setters
    public void setSiguiente(nodoPreguntasLista siguiente) {
        this.siguiente = siguiente;
    }

    public void setPregunta(preguntas pregunta) {
        this.pregunta = pregunta;
    }

}
