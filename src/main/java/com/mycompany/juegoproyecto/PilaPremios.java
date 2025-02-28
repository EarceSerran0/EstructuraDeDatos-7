/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;

import javax.swing.JOptionPane;
/**
 *
 * @author Esteban
 */
public class PilaPremios extends PilaJuego {
    public PilaPremios() {
        inicializarPila("Premios");
    }

    @Override
    public void listarPila() {
        Nodo actual = obtenerTopNodo();
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "No hay premios disponibles.");
            return;
        }

        StringBuilder lista = new StringBuilder("Premios en la pila:\n");

        while (actual != null) {
            Datos datos = actual.getPiDatos();
            lista.append(datos.getOperacion()).append(datos.getNumero()).append("\n");
            actual = actual.getAbajo();
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
}
