/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.juegoproyecto;

import java.util.Scanner;

/**
 * Clase principal para manejar la interfaz del chatbot
 * 
 * @author Grupo#7
 */
public class chatbot {
    private arbolChatbot arbolPreguntas;
    private Scanner scanner;
    
    /**
     * Constructor del chatbot
     */
    public chatbot() {
        this.arbolPreguntas = new arbolChatbot();
        this.scanner = new Scanner(System.in);
        
        // Precargar el arbol con los datos iniciales
        arbolPreguntas.precargarArbol();
    }
    
    /**
     * Buscar el nodo padre de un nodo dado su codigo
     * 
     * @param codigoHijo El codigo del nodo hijo
     * @return El nodo padre si existe, null en caso contrario
     */
    private NodoPreguntas buscarNodoPadre(String codigoHijo) {
        // Si el codigo es la raiz o no tiene al menos 2 caracteres, no tiene padre
        if (codigoHijo.equals("1") || codigoHijo.length() < 2) {
            return null;
        }
        
        // El codigo del padre es el codigo del hijo sin el ultimo caracter
        String codigoPadre = codigoHijo.substring(0, codigoHijo.length() - 1);
        return arbolPreguntas.buscarNodo(codigoPadre);
    }
    
    /**
     * Interfaz para el mantenimiento del chatbot (administradores)
     */
    private void mantenimientoChatbot() {
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n===== MANTENIMIENTO DEL CHATBOT =====");
            System.out.println("1. Insertar/Modificar preguntas padres (Nodos del arbol)");
            System.out.println("2. Insertar/Modificar preguntas hijas (Lista de preguntas)");
            System.out.println("3. Imprimir preguntas de un nodo");
            System.out.println("4. Imprimir estructura del arbol");
            System.out.println("5. Volver al menu de chatbot");
            System.out.print("Seleccione una opcion: ");
            
            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
                continue;
            }
            
            switch (opcion) {
                case 1:
                    insertarModificarNodo();
                    break;
                case 2:
                    insertarModificarPregunta();
                    break;
                case 3:
                    imprimirPreguntas();
                    break;
                case 4:
                    System.out.println("\n=== ESTRUCTURA DEL ARBOL DE PREGUNTAS ===");
                    arbolPreguntas.recorrerPreorden();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;
            }
        }
    }
    
    /**
     * Insertar o modificar un nodo en el arbol
     */
    private void insertarModificarNodo() {
        System.out.println("\n=== INSERTAR/MODIFICAR NODO ===");
        
        // Mostrar la estructura actual del arbol
        System.out.println("Estructura actual del arbol:");
        arbolPreguntas.recorrerPreorden();
        
        // Solicitar codigo del nodo padre
        System.out.print("\nIngrese el codigo del nodo padre: ");
        String codigoPadre = scanner.nextLine();
        
        // Verificar que el nodo padre existe
        NodoPreguntas nodoPadre = arbolPreguntas.buscarNodo(codigoPadre);
        if (nodoPadre == null) {
            System.out.println("Error: El nodo padre con codigo " + codigoPadre + " no existe.");
            return;
        }
        
        // Solicitar el consecutivo (1 o 2)
        System.out.print("Ingrese el consecutivo (1 para hijo izquierdo, 2 para hijo derecho): ");
        String consecutivo = scanner.nextLine();
        
        if (!consecutivo.equals("1") && !consecutivo.equals("2")) {
            System.out.println("Error: El consecutivo debe ser 1 o 2.");
            return;
        }
        
        // Solicitar el nombre del nodo
        System.out.print("Ingrese el nombre del nodo: ");
        String nombre = scanner.nextLine();
        
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacio.");
            return;
        }
        
        // Insertar el nodo
        boolean exito = arbolPreguntas.insertarNodo(codigoPadre, consecutivo, nombre);
        
        if (exito) {
            System.out.println("Nodo insertado/modificado correctamente con codigo " + codigoPadre + consecutivo);
        } else {
            System.out.println("Error al insertar/modificar el nodo.");
        }
    }
    
    /**
     * Insertar o modificar una pregunta en un nodo hoja
     */
    private void insertarModificarPregunta() {
        System.out.println("\n=== INSERTAR/MODIFICAR PREGUNTA ===");
        
        // Mostrar la estructura actual del arbol
        System.out.println("Estructura actual del arbol:");
        arbolPreguntas.recorrerPreorden();
        
        // Solicitar codigo del nodo
        System.out.print("\nIngrese el codigo del nodo donde insertar la pregunta: ");
        String codigoNodo = scanner.nextLine();
        
        // Verificar que el nodo existe y es una hoja
        NodoPreguntas nodo = arbolPreguntas.buscarNodo(codigoNodo);
        if (nodo == null) {
            System.out.println("Error: El nodo con codigo " + codigoNodo + " no existe.");
            return;
        }
        
        if (!nodo.esHoja()) {
            System.out.println("Error: Solo se pueden insertar preguntas en nodos hoja.");
            return;
        }
        
        // Solicitar el codigo de la pregunta
        System.out.print("Ingrese el codigo de la pregunta: ");
        String codigoPregunta = scanner.nextLine();
        
        if (codigoPregunta.trim().isEmpty()) {
            System.out.println("Error: El codigo de la pregunta no puede estar vacio.");
            return;
        }
        
        // Verificar si la pregunta ya existe
        preguntas preguntaExistente = nodo.getListaPreguntas().buscarPregunta(codigoPregunta);
        boolean esModificacion = preguntaExistente != null;
        
        // Solicitar el nombre de la pregunta
        System.out.print("Ingrese el texto de la pregunta: ");
        String nombrePregunta = scanner.nextLine();
        
        if (nombrePregunta.trim().isEmpty()) {
            System.out.println("Error: El texto de la pregunta no puede estar vacio.");
            return;
        }
        
        // Solicitar la respuesta
        System.out.print("Ingrese la respuesta a la pregunta: ");
        String respuesta = scanner.nextLine();
        
        if (respuesta.trim().isEmpty()) {
            System.out.println("Error: La respuesta no puede estar vacia.");
            return;
        }
        
        // Insertar o modificar la pregunta
        boolean exito;
        if (esModificacion) {
            exito = arbolPreguntas.modificarPregunta(codigoNodo, codigoPregunta, nombrePregunta, respuesta);
            if (exito) {
                System.out.println("Pregunta modificada correctamente.");
            } else {
                System.out.println("Error al modificar la pregunta.");
            }
        } else {
            exito = arbolPreguntas.insertarPregunta(codigoNodo, codigoPregunta, nombrePregunta, respuesta);
            if (exito) {
                System.out.println("Pregunta insertada correctamente.");
            } else {
                System.out.println("Error al insertar la pregunta.");
            }
        }
    }
    
    /**
     * Imprimir las preguntas de un nodo especifico
     */
    private void imprimirPreguntas() {
        System.out.println("\n=== IMPRIMIR PREGUNTAS DE UN NODO ===");
        
        // Mostrar la estructura actual del arbol
        System.out.println("Estructura actual del arbol:");
        arbolPreguntas.recorrerPreorden();
        
        // Solicitar codigo del nodo
        System.out.print("\nIngrese el codigo del nodo para ver sus preguntas: ");
        String codigoNodo = scanner.nextLine();
        
        // Verificar que el nodo existe
        NodoPreguntas nodo = arbolPreguntas.buscarNodo(codigoNodo);
        if (nodo == null) {
            System.out.println("Error: El nodo con codigo " + codigoNodo + " no existe.");
            return;
        }
        
        // Mostrar las preguntas
        System.out.println("\n=== Preguntas del nodo [" + nodo.getCodigo() + "] " + nodo.getNombre() + " ===");
        
        if (!nodo.esHoja()) {
            System.out.println("Este nodo no es una hoja, por lo tanto no tiene preguntas.");
            return;
        }
        
        listaPreguntas listaPreguntas = nodo.getListaPreguntas();
        
        if (listaPreguntas.estaVacia()) {
            System.out.println("No hay preguntas en este nodo.");
            return;
        }
        
        // Recorrer la lista de preguntas
        for (int i = 1; i <= listaPreguntas.getCantidad(); i++) {
            preguntas pregunta = listaPreguntas.obtenerPreguntaPorPosicion(i);
            if (pregunta != null) {
                System.out.println("\nCodigo: " + pregunta.getCodigo());
                System.out.println("Pregunta: " + pregunta.getNombre());
                System.out.println("Respuesta: " + pregunta.getRespuesta());
                System.out.println("---------------------------");
            }
        }
    }
}
    
