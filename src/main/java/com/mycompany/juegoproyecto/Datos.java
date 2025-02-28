/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

}
