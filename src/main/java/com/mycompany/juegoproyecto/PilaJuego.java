package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
//padre de castigos y premios
public abstract class PilaJuego {
    private Nodo top;
    private String tipo;

    public void inicializarPila(String tipo) {
        this.top = null;
        this.tipo = tipo;
    }

    public boolean estaVacia() {
        return top == null;
    }

    public void push(Datos datos) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setPiDatos(datos);
        nuevoNodo.setAbajo(top);
        top = nuevoNodo;
    }

    public Datos pop() {
        if (estaVacia()) {
            System.out.println("La pila de " + tipo + " esta vacia.");
            return null;
        }
        
        Datos datos = top.getPiDatos();
        top = top.getAbajo();
        return datos;
    }

    public Nodo obtenerTopNodo() {
        return top;
    }
    
   
    public abstract void listarPila();
    
    // Método para cargar datos iniciales en las pilas
    public void cargarDatosIniciales(char[] operaciones, int[] numeros) {
        for (int i = 0; i < operaciones.length; i++) {
            push(new Datos(numeros[i], operaciones[i]));
        }
    }
}

