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
    
    /**
     * Obtener la pregunta almacenada en el nodo
     * 
     * @return La pregunta
     */
    public preguntas getPregunta() {
        return pregunta;
    }
    
    /**
     * Establecer la pregunta almacenada en el nodo
     * 
     * @param pregunta La nueva pregunta
     */
    public void setPregunta(preguntas pregunta) {
        this.pregunta = pregunta;
    }
    
    /**
     * Obtener el siguiente nodo en la lista
     * 
     * @return El siguiente nodo
     */
    public nodoPreguntasLista getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establecer el siguiente nodo en la lista
     * 
     * @param siguiente El nuevo siguiente nodo
     */
    public void setSiguiente(nodoPreguntasLista siguiente) {
        this.siguiente = siguiente;
    }
}