/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class NodoPreguntas {
    
    private String codigo;
    private String nombre;
    private listaPreguntas listaPreguntas;
    private NodoPreguntas izquierda;
    private NodoPreguntas derecha;
    
    /**
     * Constructor para el nodo de preguntas
     * 
     * @param codigo Identificador del nodo, sigue un patron especifico (codigo padre + consecutivo)
     * @param nombre Nombre descriptivo del nodo
     */
    public NodoPreguntas(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaPreguntas = new listaPreguntas();
        this.izquierda = null;
        this.derecha = null;
    }
    
    /**
     * Obtener el codigo identificador del nodo
     * 
     * @return El codigo del nodo
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Establecer el codigo identificador del nodo
     * 
     * @param codigo El nuevo codigo del nodo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Obtener el nombre descriptivo del nodo
     * 
     * @return El nombre del nodo
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establecer el nombre descriptivo del nodo
     * 
     * @param nombre El nuevo nombre del nodo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtener la lista de preguntas asociada al nodo
     * 
     * @return La lista de preguntas
     */
    public listaPreguntas getListaPreguntas() {
        return listaPreguntas;
    }
    
    /**
     * Establecer la lista de preguntas asociada al nodo
     * 
     * @param listaPreguntas La nueva lista de preguntas
     */
    public void setListaPreguntas(listaPreguntas listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }
    
    /**
     * Obtener el hijo izquierdo del nodo
     * 
     * @return El nodo hijo izquierdo
     */
    public NodoPreguntas getIzquierda() {
        return izquierda;
    }
    
    /**
     * Establecer el hijo izquierdo del nodo
     * 
     * @param izquierda El nuevo nodo hijo izquierdo
     */
    public void setIzquierda(NodoPreguntas izquierda) {
        this.izquierda = izquierda;
    }
    
    /**
     * Obtener el hijo derecho del nodo
     * 
     * @return El nodo hijo derecho
     */
    public NodoPreguntas getDerecha() {
        return derecha;
    }
    
    /**
     * Establecer el hijo derecho del nodo
     * 
     * @param derecha El nuevo nodo hijo derecho
     */
    public void setDerecha(NodoPreguntas derecha) {
        this.derecha = derecha;
    }
    
    /**
     * Verificar si el nodo es una hoja (no tiene hijos)
     * 
     * @return true si el nodo es una hoja, false en caso contrario
     */
    public boolean esHoja() {
        return izquierda == null && derecha == null;
    }
    
    /**
     * Agregar una pregunta a la lista de preguntas del nodo
     * 
     * @param codigo Codigo de la pregunta
     * @param nombre Nombre de la pregunta
     * @param respuesta Respuesta a la pregunta
     */
    public void agregarPregunta(String codigo, String nombre, String respuesta) {
        preguntas pregunta = new preguntas(codigo, nombre, respuesta);
        listaPreguntas.insertarPregunta(pregunta);
    }
}