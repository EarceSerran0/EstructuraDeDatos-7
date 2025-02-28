/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

import javax.swing.JOptionPane;
/**
 *
 * @author Grupo#7
 */
/*
public class PilaJuego {
     
    private Nodo top;
    
    public void push(char operacion, int numero) {
        Nodo nuevo = new Nodo(new Datos(numero, operacion));
        nuevo.setAbajo(top);
        top = nuevo;
    }
    
    public Datos pop() {
        if (top == null) return null;
        Datos datos = top.getPiDatos();
        top = top.getAbajo();
        return datos;
    }
    
    public Datos verTop() {
        return (top != null) ? top.getPiDatos() : null;
    }
    
    public boolean estaVacia() {
        return top == null;
    }
    
    public void inicializarPila(String tipo) {
        if (tipo.equals("Premios")) {
            push('+', 2);
            push('+', 8);
            push('+', 0);
        } else if (tipo.equals("Castigos")) {
            push('-', 3);
            push('=', 1);
            push('-', 5);
         }
    }
    
    public Nodo obtenerTopNodo() {
        return top;
    }
     
    public void listarPila() {
    if (top == null) {
        JOptionPane.showMessageDialog(null, "No hay elementos en la pila.");
        return;
    }

    Nodo actual = top;
    StringBuilder lista = new StringBuilder("Elementos en la pila:\n");
    
    while (actual != null) {
        Datos datos = actual.getPiDatos();
        lista.append(datos.getOperacion()).append(datos.getNumero()).append("\n");
        actual = actual.getAbajo();
    }

    JOptionPane.showMessageDialog(null, lista.toString());
    }
}
