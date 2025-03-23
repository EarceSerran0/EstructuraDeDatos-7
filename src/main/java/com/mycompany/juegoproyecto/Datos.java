package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class Datos {

    private int numero;
    private char operacion;

    public Datos(int numero, char operacion) {
        this.numero = numero;
        this.operacion = operacion;
    }
    
    public int getNumero() {
        return numero;
    }

    public char getOperacion() {
        return operacion;
    }

    @Override
    public String toString() {
        return operacion + " " + numero;
    }
    
    private boolean permitirAgregarJugadores;
    public boolean isPermitirAgregarJugadores() {
    return permitirAgregarJugadores;
    }

    public void setPermitirAgregarJugadores(boolean permitirAgregarJugadores) {
    this.permitirAgregarJugadores = permitirAgregarJugadores;
    }
}
