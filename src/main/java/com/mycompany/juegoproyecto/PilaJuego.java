/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class PilaJuego {
     
     private Nodo top;

    public Nodo getTop() {
        return top;
    }

     public void push(Datos datos) {
        Nodo nuevo = new Nodo(datos);
        nuevo.setAbajo(top);
        top = nuevo;
    }

     public Datos pop() {
        if (top == null) {
            return null;
        }
        Datos datos = top.getPiDatos();
        top = top.getAbajo();
        return datos;
    }

    public PilaJuego() {
        top = null; // Pila vacia
    }       
}
