/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.juegoproyecto;

import javax.swing.JOptionPane;
import java.util.Random;
/**
 *
 * @author Grupo#7
 */
//Ya trate de implementar las funcion de Jugar, igual se le podrian hacer mejoras, pero yo creo que ya nos la jugamos al menos con esa funcionalidad, falta la funcion 5,6,7 la 7 hay que mejorarla solo esta por encima 
public class JuegoProyecto {

    public static void main(String[] args) {
        
        ColaJugadores colaJugadores = new ColaJugadores();
        PilaPremios pilaPremios = new PilaPremios();
        PilaCastigos pilaCastigos = new PilaCastigos();

        // Bienvenida
        JOptionPane.showMessageDialog(null, "Bienvenido/a al juego de carreras!");

        // Menú
        boolean juegoActivo = true;
        while (juegoActivo) {
            String[] opciones = {"Iniciar Juego", "Listar Jugadores", "Tirar Dados", "Listar Premios", "Listar Castigos", "Ayuda", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:",
                    "Menú Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0:
                    int numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores (máximo 4):"));
                    for (int i = 0; i < numJugadores; i++) {
                        String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador " + (i + 1) + ":");
                        Jugador jugador = new Jugador(nombreJugador);
                        colaJugadores.agregarJugador(jugador);
                    }
                    break;

                case 1:
                    colaJugadores.listarJugadores();
                    break;

                case 2: // Funcionalidad de Tirar Dados
                    if (!colaJugadores.estaVacia()) {
                        Jugador jugadorActual = colaJugadores.quitarJugador();  
                        Random random = new Random();
                        int dado1 = random.nextInt(6) + 1;  
                        int dado2 = random.nextInt(6) + 1; 
                        int total = dado1 + dado2;  

                        // Mostrar el resultado de los dados y la posición actual
                        JOptionPane.showMessageDialog(null, "Jugador " + jugadorActual.getNombre() + " tiró los dados:\nDado 1: " + dado1 + "\nDado 2: " + dado2 + "\nTotal: " + total);
                        JOptionPane.showMessageDialog(null, "Jugador " + jugadorActual.getNombre() + " estás en la posición " + jugadorActual.getPosicion()
                                + ", puedes avanzar " + total + " posiciones en la carrera.");

                        // Actualizar la posición antes de aplicar premio o castigo
                        int nuevaPosicion = jugadorActual.getPosicion() + total;
                        jugadorActual.setPosicion(nuevaPosicion);  // Actualizar la posición con el avance

                        // Mostrar la nueva posición después del avance
                        JOptionPane.showMessageDialog(null, "Ahora tu nueva posición será " + nuevaPosicion + ".");

                        // Regla: Si la posición es par, premio; si es impar, castigo
                        if (nuevaPosicion % 2 == 0) {  // Si es par, premio
                            JOptionPane.showMessageDialog(null, "Obtuviste un número par, debes tomar un premio de la pila. ¡Mucha suerte!");
                            if (!pilaPremios.estaVacia()) {
                                Datos premio = pilaPremios.pop();  // Sacar un premio de la pila
                                JOptionPane.showMessageDialog(null, "Has recibido un premio: " + premio.getOperacion() + " " + premio.getNumero());
                                jugadorActual.setPosicion(jugadorActual.getPosicion() + premio.getNumero());  // Aplicar el premio
                                JOptionPane.showMessageDialog(null, "Tu nueva posición es " + jugadorActual.getPosicion());
                            } else {
                                JOptionPane.showMessageDialog(null, "No hay premios disponibles.");
                            }
                        } else {  // Si es impar, castigo
                            JOptionPane.showMessageDialog(null, "Obtuviste un número impar, debes tomar un castigo de la pila. ¡Mejor suerte la próxima vez!");
                            if (!pilaCastigos.estaVacia()) {
                                Datos castigo = pilaCastigos.pop();  // Sacar un castigo de la pila
                                JOptionPane.showMessageDialog(null, "Has recibido un castigo: " + castigo.getOperacion() + " " + castigo.getNumero());
                                jugadorActual.setPosicion(jugadorActual.getPosicion() - castigo.getNumero());  // Aplicar el castigo
                                JOptionPane.showMessageDialog(null, "Tu nueva posición es " + jugadorActual.getPosicion());
                            } else {
                                JOptionPane.showMessageDialog(null, "No hay castigos disponibles.");
                            }
                        }

                        
                        colaJugadores.agregarJugador(jugadorActual);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay jugadores en la cola.");
                    }
                    break;

                case 3: // Listar Premios
                    pilaPremios.listarPila();
                    break;

                case 4: // Listar Castigos
                    pilaCastigos.listarPila();
                    break;

                case 5:
                   String nombreSalir = JOptionPane.showInputDialog("Ingrese el nombre del jugador que quiere salir:");
                   if (nombreSalir != null && !nombreSalir.trim().isEmpty()) {
                        colaJugadores.salirDelJuego(nombreSalir);
                   } else {
                       JOptionPane.showMessageDialog(null, "❌ Nombre inválido. Intente de nuevo.");
                   }
                   break;

                case 6:
                    String mensajeAyuda = "Versión: 4.0.0\nDesarrolladores: Esteban, Diana, Yanko y Andrés";
                    JOptionPane.showMessageDialog(null, mensajeAyuda);
                    break;
                case 7:
                    juegoActivo = false;
                    break;
                default:
                    break;
            }
        }
    }
}
