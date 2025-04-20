/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 * Lista enlazada simple para almacenar preguntas
 * 
 * @author Grupo#7
 */
public class listaPreguntas {
    private nodoPreguntasLista cabeza;
    private int cantidad;
    
    /**
     * Constructor de la lista de preguntas
     */
    public listaPreguntas() {
        this.cabeza = null;
        this.cantidad = 0;
    }
    
    /**
     * Verificar si la lista esta vacia
     * 
     * @return true si la lista esta vacia, false en caso contrario
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    /**
     * Obtener la cantidad de preguntas en la lista
     * 
     * @return El numero de preguntas
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Insertar una pregunta en la lista ordenada por codigo
     * 
     * @param pregunta La pregunta a insertar
     */
    public void insertarPregunta(preguntas pregunta) {
        nodoPreguntasLista nuevoNodo = new nodoPreguntasLista(pregunta);
        
        // Caso 1: Lista vacia o nuevo nodo va al principio
        if (cabeza == null || pregunta.getCodigo().compareTo(cabeza.getPregunta().getCodigo()) < 0) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
            cantidad++;
            return;
        }
        
        // Caso 2: Buscar la posicion correcta para insertar
        nodoPreguntasLista actual = cabeza;
        while (actual.getSiguiente() != null && 
               pregunta.getCodigo().compareTo(actual.getSiguiente().getPregunta().getCodigo()) > 0) {
            actual = actual.getSiguiente();
        }
        
        // Verificar si ya existe una pregunta con el mismo codigo
        if (actual.getSiguiente() != null && 
            actual.getSiguiente().getPregunta().getCodigo().equals(pregunta.getCodigo())) {
            // Actualizar la pregunta existente en lugar de insertar una nueva
            actual.getSiguiente().getPregunta().setNombre(pregunta.getNombre());
            actual.getSiguiente().getPregunta().setRespuesta(pregunta.getRespuesta());
            return;
        }
        
        // Insertar el nuevo nodo
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
        cantidad++;
    }
    
    /**
     * Buscar una pregunta por su codigo
     * 
     * @param codigo El codigo de la pregunta a buscar
     * @return La pregunta si existe, null en caso contrario
     */
    public preguntas buscarPregunta(String codigo) {
        if (estaVacia()) {
            return null;
        }
        
        nodoPreguntasLista actual = cabeza;
        while (actual != null) {
            if (actual.getPregunta().getCodigo().equals(codigo)) {
                return actual.getPregunta();
            }
            actual = actual.getSiguiente();
        }
        
        return null;
    }
    
    /**
     * Modificar una pregunta existente
     * 
     * @param codigo Codigo de la pregunta a modificar
     * @param nuevoNombre Nuevo nombre de la pregunta
     * @param nuevaRespuesta Nueva respuesta a la pregunta
     * @return true si se modifico la pregunta, false si no existe
     */
    public boolean modificarPregunta(String codigo, String nuevoNombre, String nuevaRespuesta) {
        preguntas pregunta = buscarPregunta(codigo);
        if (pregunta != null) {
            pregunta.setNombre(nuevoNombre);
            pregunta.setRespuesta(nuevaRespuesta);
            return true;
        }
        return false;
    }
    
    /**
     * Eliminar una pregunta de la lista
     * 
     * @param codigo Codigo de la pregunta a eliminar
     * @return true si se elimino la pregunta, false si no existe
     */
    public boolean eliminarPregunta(String codigo) {
        if (estaVacia()) {
            return false;
        }
        
        // Caso 1: La pregunta a eliminar esta en la cabeza
        if (cabeza.getPregunta().getCodigo().equals(codigo)) {
            cabeza = cabeza.getSiguiente();
            cantidad--;
            return true;
        }
        
        // Caso 2: Buscar la pregunta en el resto de la lista
        nodoPreguntasLista actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getPregunta().getCodigo().equals(codigo)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                cantidad--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        
        return false;
    }
    
    /**
     * Mostrar todas las preguntas en la lista
     */
    public void mostrarPreguntas() {
        if (estaVacia()) {
            System.out.println("No hay preguntas disponibles.");
            return;
        }
        
        nodoPreguntasLista actual = cabeza;
        int contador = 1;
        
        System.out.println("\n=== Preguntas Disponibles ===");
        while (actual != null) {
            System.out.println(contador + ". " + actual.getPregunta().getNombre());
            contador++;
            actual = actual.getSiguiente();
        }
    }
    
    /**
     * Obtener la pregunta en una posicion especifica (comenzando desde 1)
     * 
     * @param posicion La posicion de la pregunta
     * @return La pregunta en esa posicion, null si la posicion es invalida
     */
    public preguntas obtenerPreguntaPorPosicion(int posicion) {
        if (posicion < 1 || posicion > cantidad || estaVacia()) {
            return null;
        }
        
        nodoPreguntasLista actual = cabeza;
        for (int i = 1; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        
        return actual.getPregunta();
    }
}