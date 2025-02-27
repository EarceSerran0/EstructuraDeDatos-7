package com.mycompany.juegoproyecto;
/**
 *
 * @author Esteban
 */

public class Jugador {
    private String nombre;
    private int posicion;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posición = 0; // iniciamos en posición 0
    }

  
    public String getNombre() {
        return nombre;
    }
    
    public int getPosicion() {
        return posicion;
    }
    
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }


   public void avanzar(int cantidad) {
        this.posición += cantidad;
    }

    public void retroceder(int cantidad) {
        this.posición -= cantidad;
        if (this.posición < 0) {
            this.posición = 0; // No permitir posiciones negativas
        }
    }



  
// Pendiente, prueba
    //Funcion para controlar posicion del jugador/ 
    public void irAPosicion(int nuevaPosicion) {
        this.posicion = Math.max(nuevaPosicion, 0);
    }
    
   
}

