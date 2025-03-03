package com.mycompany.juegoproyecto;
/**
 *
 * @author Grupo#7
 */

public class Jugador {
    private String nombre;
    private int posicion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 0; // iniciamos en posición 0
    }
//getters
    public String getNombre() {
        return nombre;
    }
    
    public int getPosicion() {
        return posicion;
    }
    //setters
    public void setPosicion(int posicion) {
        this.posicion = Math.max(posicion, 0); // Evitar posiciones negativas
    }

    public void avanzar(int cantidad) {
        this.posicion += cantidad;
    }

    public void retroceder(int cantidad) {
        this.posicion -= cantidad;
        // No permitir posiciones negativas
        if (this.posicion < 0) {
            this.posicion = 0; 
        }
    }

    public void irAPosicion(int nuevaPosicion) {
        this.posicion = Math.max(nuevaPosicion, 0);
    }
    
    // Aplicar premio o castigo según la operación
    public void aplicarEfecto(Datos efecto) {
        switch (efecto.getOperacion()) {
            case '+':
                this.avanzar(efecto.getNumero());
                break;
            case '-':
                this.retroceder(efecto.getNumero());
                break;
            case '=':
                this.irAPosicion(efecto.getNumero());
                break;
        }
    }
}
