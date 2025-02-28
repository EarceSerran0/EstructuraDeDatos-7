/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */



// Esta  pila la tendremos como una referencia sin embargo es posible que no sea utilizada, por ahora centremonos en hacer las estructuras de premios y castigos.
/*
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
     public Datos verTop() {
        if (top != null) {
            return top.getPiDatos(); // Retorna el objeto de datos del nodo superior.
        }
        return null; // Si la pila está vacía, retornamos null.
    }
}
