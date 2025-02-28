/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.juegoproyecto;

import javax.swing.JOptionPane;
/**
 *
 * @author Grupo#7
 */
public class JuegoProyecto {

    public static void main(String[] args) {
        
        ColaJugadores colaJugadores = new ColaJugadores(); 
        PilaPremios pilaPremios = new PilaPremios(); 
        PilaCastigos pilaCastigos = new PilaCastigos(); 
        

        // Bienvenida
        JOptionPane.showMessageDialog(null, "Bienvenid@ al juego de carreras!");

        // Menú
        boolean juegoActivo = true;
        while (juegoActivo) {
            String[] opciones = {"Iniciar Juego", "Listar Jugadores","Aplicar Premio", "Aplicar Castigo", "Ayuda", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", 
                "Menú Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            
            switch (seleccion) {
                case 0 -> {
                    int numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores (máximo 4):"));
                    for (int i = 0; i < numJugadores; i++) {
                        String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador " + (i + 1) + ":");
                        Jugador jugador = new Jugador(nombreJugador);
                        colaJugadores.agregarJugador(jugador); 
                    }
                }

                case 1 -> { 
                    colaJugadores.listarJugadores();
                    break;
                }

                case 2 -> { 
                   Datos premio = pilaPremios.pop();
                    if (premio != null) {
                        JOptionPane.showMessageDialog(null, "Premio aplicado: " + premio.getOperacion() + premio.getNumero());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay premios disponibles.");
                    }
                }

                case 3 -> { 
                    Datos castigo = pilaCastigos.pop();
                    if (castigo != null) {
                        JOptionPane.showMessageDialog(null, "Castigo aplicado: " + castigo.getOperacion() + castigo.getNumero());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay castigos disponibles.");
                    }
                }
                    
                case 4 -> { //Ayuda
                    String mensajeAyuda = "Versión: 4.0.0\nDesarrolladores: Esteban, Diana, Yanko y Andrés";
                    JOptionPane.showMessageDialog(null, mensajeAyuda);
                }  
                    
                case 5 -> { 
                    juegoActivo = false;
                    break;
                }
            }
        }
    }
}
