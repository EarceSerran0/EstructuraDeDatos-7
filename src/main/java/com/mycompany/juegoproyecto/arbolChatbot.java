/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.juegoproyecto;

/**
 * Arbol binario para el chatbot de preguntas frecuentes
 * 
 * @author Grupo#7
 */
public class arbolChatbot {
    private NodoPreguntas raiz;
    
    /**
     * Constructor del arbol de chatbot
     */
    public arbolChatbot() {
        // Inicializar con la raiz predefinida (codigo 1, nombre "Preguntas Frecuentes (FAQ)")
        this.raiz = new NodoPreguntas("1", "Preguntas Frecuentes (FAQ)");
    }
    
    /**
     * Obtener el nodo raiz del arbol
     * 
     * @return El nodo raiz
     */
    public NodoPreguntas getRaiz() {
        return raiz;
    }
    
    /**
     * Buscar un nodo por su codigo
     * 
     * @param codigo El codigo del nodo a buscar
     * @return El nodo encontrado, null si no existe
     */
    public NodoPreguntas buscarNodo(String codigo) {
        return buscarNodoRecursivo(raiz, codigo);
    }
    
    /**
     * Metodo recursivo para buscar un nodo por su codigo
     * 
     * @param nodoActual Nodo actual en la recursion
     * @param codigo Codigo del nodo a buscar
     * @return El nodo encontrado, null si no existe
     */
    private NodoPreguntas buscarNodoRecursivo(NodoPreguntas nodoActual, String codigo) {
        if (nodoActual == null) {
            return null;
        }
        
        if (nodoActual.getCodigo().equals(codigo)) {
            return nodoActual;
        }
        
        // Comparar los codigos para determinar en que subárbol buscar
        if (codigo.compareTo(nodoActual.getCodigo()) < 0) {
            return buscarNodoRecursivo(nodoActual.getIzquierda(), codigo);
        } else {
            return buscarNodoRecursivo(nodoActual.getDerecha(), codigo);
        }
    }
    
    /**
     * Insertar un nuevo nodo en el arbol
     * 
     * @param codigoPadre Codigo del nodo padre
     * @param consecutivo Consecutivo para formar el codigo completo
     * @param nombre Nombre del nuevo nodo
     * @return true si se inserto correctamente, false si no se pudo insertar
     */
    public boolean insertarNodo(String codigoPadre, String consecutivo, String nombre) {
        // Formar el codigo completo del nuevo nodo
        String codigoCompleto = codigoPadre + consecutivo;
        
        // Buscar el nodo padre
        NodoPreguntas nodoPadre = buscarNodo(codigoPadre);
        if (nodoPadre == null) {
            return false; // No se encontro el nodo padre
        }
        
        // Crear el nuevo nodo
        NodoPreguntas nuevoNodo = new NodoPreguntas(codigoCompleto, nombre);
        
        // Determinar si va como hijo izquierdo o derecho
        if (consecutivo.equals("1")) { // Si el consecutivo es 1, va como hijo izquierdo
            if (nodoPadre.getIzquierda() != null) {
                // Ya existe un hijo izquierdo, actualizar sus datos
                nodoPadre.getIzquierda().setNombre(nombre);
                return true;
            } else {
                // No existe un hijo izquierdo, crear uno nuevo
                nodoPadre.setIzquierda(nuevoNodo);
                return true;
            }
        } else if (consecutivo.equals("2")) { // Si el consecutivo es 2, va como hijo derecho
            if (nodoPadre.getDerecha() != null) {
                // Ya existe un hijo derecho, actualizar sus datos
                nodoPadre.getDerecha().setNombre(nombre);
                return true;
            } else {
                // No existe un hijo derecho, crear uno nuevo
                nodoPadre.setDerecha(nuevoNodo);
                return true;
            }
        }
        
        return false; // Consecutivo invalido
    }
    
    /**
     * Modificar un nodo existente
     * 
     * @param codigo Codigo del nodo a modificar
     * @param nuevoNombre Nuevo nombre para el nodo
     * @return true si se modifico correctamente, false si no existe el nodo
     */
    public boolean modificarNodo(String codigo, String nuevoNombre) {
        NodoPreguntas nodo = buscarNodo(codigo);
        if (nodo != null) {
            nodo.setNombre(nuevoNombre);
            return true;
        }
        return false;
    }
    
    /**
     * Insertar una pregunta en un nodo hoja
     * 
     * @param codigoNodo Codigo del nodo donde insertar la pregunta
     * @param codigoPregunta Codigo de la pregunta
     * @param nombrePregunta Nombre (texto) de la pregunta
     * @param respuesta Respuesta a la pregunta
     * @return true si se inserto correctamente, false si no es un nodo hoja o no existe
     */
    public boolean insertarPregunta(String codigoNodo, String codigoPregunta, String nombrePregunta, String respuesta) {
        NodoPreguntas nodo = buscarNodo(codigoNodo);
        if (nodo != null && nodo.esHoja()) {
            nodo.agregarPregunta(codigoPregunta, nombrePregunta, respuesta);
            return true;
        }
        return false;
    }
    
    /**
     * Modificar una pregunta existente
     * 
     * @param codigoNodo Codigo del nodo que contiene la pregunta
     * @param codigoPregunta Codigo de la pregunta a modificar
     * @param nuevoNombre Nuevo nombre para la pregunta
     * @param nuevaRespuesta Nueva respuesta para la pregunta
     * @return true si se modifico correctamente, false si no existe el nodo o la pregunta
     */
    public boolean modificarPregunta(String codigoNodo, String codigoPregunta, String nuevoNombre, String nuevaRespuesta) {
        NodoPreguntas nodo = buscarNodo(codigoNodo);
        if (nodo != null) {
            return nodo.getListaPreguntas().modificarPregunta(codigoPregunta, nuevoNombre, nuevaRespuesta);
        }
        return false;
    }
    
    /**
     * Precargar el arbol con la estructura y preguntas iniciales
     */
    public void precargarArbol() {
        // Nivel 2: Hijos de la raiz (codigo 1)
        insertarNodo("1", "1", "Preguntas para jugadores");
        insertarNodo("1", "2", "Preguntas para Administradores");
        
        // Nivel 3: Hijos de "11" (Preguntas para jugadores)
        insertarNodo("11", "1", "Primera vez que juego");
        insertarNodo("11", "2", "Jugador Experimentado");
        
        // Nivel 4: Hijos de "111" (Primera vez que juego)
        insertarNodo("111", "1", "Soy nuevo en videojuegos");
        insertarNodo("111", "2", "Ya he jugado otros juegos similares");
        
        // Nivel 3: Hijos de "12" (Preguntas para Administradores)
        insertarNodo("12", "1", "Funcionalidades");
        
        // Nivel 4: Hijos de "121" (Funcionalidades)
        insertarNodo("121", "1", "Administrador preguntas");
        insertarNodo("121", "2", "Mejorar Juego");
        
        // Preguntas para el nodo "1111" (Soy nuevo en videojuegos)
        insertarPregunta("1111", "1", "¿Cuantos Jugadores pueden participar simultáneamente?", 
                        "Se tiene un maximo de 4 jugadores.");
        insertarPregunta("1111", "2", "¿Hay un tiempo maximo por partida?", 
                        "No, el juego termina cuando un jugador alcance la posicion maxima.");
        
        // Preguntas para el nodo "1112" (Ya he jugado otros juegos similares)
        insertarPregunta("1112", "1", "¿Puedo jugar en linea?", 
                        "No, en la version liberada no se permite jugar en linea.");
        insertarPregunta("1112", "2", "¿Si hay un ganador, los demas jugadores pueden continuar?", 
                        "Si, no hay restriccion que les impida continuar.");
        
        // Preguntas para el nodo "112" (Jugador Experimentado)
        insertarPregunta("112", "1", "Hay una comunidad de jugadores para enriquecer el juego.", 
                        "No, pero es una excelente idea. Te invito a fundarla.");
        insertarPregunta("112", "2", "En que lenguaje fue implementado", 
                        "El juego fue implementado en JAVA.");
        insertarPregunta("112", "3", "¿Cuando liberan una nueva version?", 
                        "Esperamos liberar una nueva version en noviembre de 2024.");
    }
    
    /**
     * Recorrer el arbol en preorden e imprimir los nodos
     */
    public void recorrerPreorden() {
        recorrerPreordenRec(raiz, 0);
    }
    
    /**
     * Metodo recursivo para recorrer el arbol en preorden
     * 
     * @param nodoActual Nodo actual en la recursion
     * @param nivel Nivel actual en el arbol
     */
    private void recorrerPreordenRec(NodoPreguntas nodoActual, int nivel) {
        if (nodoActual != null) {
            // Imprimir indentacion segun el nivel
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            
            // Imprimir informacion del nodo
            System.out.println("[" + nodoActual.getCodigo() + "] " + nodoActual.getNombre() + 
                          (nodoActual.esHoja() ? " (Hoja)" : ""));
            
            // Si es una hoja, imprimir sus preguntas
            if (nodoActual.esHoja() && nodoActual.getListaPreguntas().getCantidad() > 0) {
                for (int i = 0; i < nivel + 1; i++) {
                    System.out.print("    ");
                }
                System.out.println("Preguntas: " + nodoActual.getListaPreguntas().getCantidad());
            }
            
            // Recorrer los hijos
            recorrerPreordenRec(nodoActual.getIzquierda(), nivel + 1);
            recorrerPreordenRec(nodoActual.getDerecha(), nivel + 1);
        }
    }
}