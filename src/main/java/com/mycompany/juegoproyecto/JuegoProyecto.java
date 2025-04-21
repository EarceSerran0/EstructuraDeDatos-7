package com.mycompany.juegoproyecto;

import java.util.*;

/**
 *
 * @author Grupo#7
 */
public class JuegoProyecto {

    private static Scanner scanner = new Scanner(System.in);
    private static int META = 30; // Valor por defecto
    private static boolean permitirNuevosJugadores = true; // Valor por defecto
    private static JugadorHistorial historialJugadores = new JugadorHistorial();
    private static EstadoDeJuego estadoJuego = null;
    private static chatbot chatbot = new chatbot(); // Instancia del chatbot

    public static void main(String[] args) {

        ColaJugadores colaJugadores = new ColaJugadores();
        PilaPremios pilaPremios = new PilaPremios();
        PilaCastigos pilaCastigos = new PilaCastigos();
        Random random = new Random();

        // Mensaje de inicio
        System.out.println("Bienvenido a nuestro jugo de carreras\n");
        System.out.println("La meta sera la posicion " + META);

        // Menu
        boolean juegoActivo = true;
        while (juegoActivo) {
            System.out.println("\n****** MENU  ******");
            System.out.println("1. Iniciar Juego(ingresar nombres)");
            System.out.println("2. Jugar (Tirar dados)");
            System.out.println("3. Listar pila de premios");
            System.out.println("4. Listar pila de castigos");
            System.out.println("5. Abandonar el Juego");
            System.out.println("6. Listar Jugadores");
            System.out.println("7. Adicionar Jugador");
            System.out.println("8. Estado Actual del Juego");
            System.out.println("9. Bitacora-Historial");
            System.out.println("10. Ayuda");
            System.out.println("11. Chatbot de Preguntas Frecuentes");
            System.out.println("12. Salir\n");
            System.out.print("Seleccione una opcion: ");

            int seleccion;
            try {
                seleccion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
                continue;
            }

            switch (seleccion) {
                case 1: // Iniciar Juego
                    iniciarJuego(colaJugadores);
                    break;

                case 2: // Jugar (Tirar Dados)
                    jugar(colaJugadores, pilaPremios, pilaCastigos, random);
                    break;

                case 3: // Listar premios
                    listarPilaPremios(pilaPremios);
                    break;

                case 4: // Listarcastigos
                    listarPilaCastigos(pilaCastigos);
                    break;

                case 5: // Abandonar el juego
                    abandonarJuego(colaJugadores);
                    break;

                case 6: // Listar jugadores
                    listarJugadores(colaJugadores);
                    break;

                case 7: // Adicionar Jugador
                    adicionarJugador(colaJugadores);
                    break;

                case 8: // Estado Actual del Juego
                    mostrarEstadoJuego();
                    break;

                case 9: // Bitacora-Historial
                    mostrarBitacoraHistorial();
                    break;

                case 10: // Ayuda
                    mostrarAyuda();
                    break;

                case 11: // Chatbot de Preguntas Frecuentes 
                    chatbot.iniciar();
                    break;

                case 12: // Salir 
                    juegoActivo = false;
                    System.out.println("Gracias por jugar");
                    break;

                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    // Metodo para iniciar el juego e inscribir jugadores
    private static void iniciarJuego(ColaJugadores colaJugadores) {
        try {
            // Solicitar posicion maxima del laberinto
            System.out.print("Ingrese la posicion maxima del laberinto: ");
            META = Integer.parseInt(scanner.nextLine());

            if (META <= 0) {
                System.out.println("La posicion maxima debe ser un numero positivo. Se usara 30 por defecto.");
                META = 30;
            }

            // Crear estado del juego con las posiciones necesarias
            estadoJuego = new EstadoDeJuego(META);

            // Solicitar si se permite ingresar mas jugadores luego de iniciado el juego
            System.out.print("Permitir ingresar mas jugadores despues de iniciado el juego? (S/N): ");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            permitirNuevosJugadores = respuesta.equals("S");

            System.out.print("Ingrese el numero de jugadores (maximo 4): ");
            int numJugadores = Integer.parseInt(scanner.nextLine());

            if (numJugadores <= 0) {
                System.out.println("Debe ingresar un numero valido de jugadores, no negativos");
                return;
            }

            if (numJugadores > 4) {
                System.out.println("El maximo de jugadores permitido es 4. Se registraran solo 4 jugadores.");
                numJugadores = 4;
            }

            for (int i = 0; i < numJugadores; i++) {
                System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
                String nombreJugador = scanner.nextLine();
                if (nombreJugador.trim().isEmpty()) {
                    nombreJugador = "Jugador " + (i + 1);
                }
                Jugador jugador = new Jugador(nombreJugador);
                colaJugadores.agregarJugador(jugador);

                // Agregar jugador al historial
                historialJugadores.insertarJugador(nombreJugador);

                // Agregar la posicion inicial (0) al historial
                historialJugadores.agregarPosicionJugador(
                        nombreJugador, 0, "Posicion Inicial"
                );
            }

            System.out.println("Se inscribieron " + numJugadores + " jugadores");
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un numero valido.");
        }
    }

    // Metodo para adicionar un jugador luego de iniciado el juego
    private static void adicionarJugador(ColaJugadores colaJugadores) {
        if (estadoJuego == null) {
            System.out.println("Debe iniciar el juego primero.");
            return;
        }

        if (!permitirNuevosJugadores) {
            System.out.println("ERROR!!! La configuracion de este juego no permite ingresar mas jugadores, debera esperar a que inicie uno nuevo.");
            return;
        }

        System.out.print("Ingrese el nombre del nuevo jugador: ");
        String nombreJugador = scanner.nextLine();
        if (nombreJugador.trim().isEmpty()) {
            nombreJugador = "Jugador " + (colaJugadores.getCantidadElementos() + 1);
        }

        Jugador jugador = new Jugador(nombreJugador);
        colaJugadores.agregarJugador(jugador);

        // Agregar jugador al historial
        historialJugadores.insertarJugador(nombreJugador);

        // Agregar la posicion inicial (0) al historial
        historialJugadores.agregarPosicionJugador(
                nombreJugador, 0, "Posicion Inicial"
        );

        System.out.println("El jugador " + nombreJugador + " ha sido agregado a la cola de jugadores.");
    }

    // Metodo para jugar (tirar dados)
    private static void jugar(ColaJugadores colaJugadores, PilaPremios pilaPremios, PilaCastigos pilaCastigos, Random random) {
        if (colaJugadores.estaVacia()) {
            System.out.println("No hay jugadores en la cola. Debe iniciar el juego primero.");
            return;
        }

        if (estadoJuego == null) {
            System.out.println("Debe iniciar el juego primero.");
            return;
        }

        // Obtener el jugador actual
        Jugador jugadorActual = colaJugadores.quitarJugador();

        // Tirar los dados
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        int total = dado1 + dado2;

        // Mostrar el resultado de los dados
        System.out.println("\n======== TURNO DE " + jugadorActual.getNombre().toUpperCase() + " =========");
        System.out.println("Jugador " + jugadorActual.getNombre() + " tiro los dados:");
        System.out.println("Dado 1: " + dado1);
        System.out.println("Dado 2: " + dado2);
        System.out.println("Total: " + total);

        // Mensaje de posicion actual y avance
        int posicionActual = jugadorActual.getPosicion();
        System.out.println("Jugador " + jugadorActual.getNombre() + " estas en la posicion " + posicionActual
                + " , puedes avanzar " + total + " posiciones!");

        // Actualizar la posicion considerando la meta
        int nuevaPosicion = posicionActual + total;

        // Validar si se pasa de la meta
        if (nuevaPosicion > META) {
            int exceso = nuevaPosicion - META;
            nuevaPosicion = META - exceso;
            System.out.println("Te pasaste de la meta! Debes retroceder " + exceso + " posiciones desde la meta.");
        }

        jugadorActual.setPosicion(nuevaPosicion);
        System.out.println("Tu nueva posicion es " + nuevaPosicion + ".");

        // Actualizar el estado del juego
        estadoJuego.actualizarPosicionJugador(
                jugadorActual.getNombre(),
                jugadorActual.getPosicion(),
                jugadorActual.getPosicionAnterior()
        );

        // Variable para almacenar el efecto aplicado
        Datos premio = null;
        Datos castigo = null;
        String descripcionEfecto = "";

        // Aplicar premio o castigo según si la nueva posicion es par o impar
        if (nuevaPosicion % 2 == 0) {  // Si es par, premio
            System.out.println("Obtuviste un numero par, debes tomar un premio de la pila, mucha suerte!");
            if (!pilaPremios.estaVacia()) {
                premio = pilaPremios.pop();

                switch (premio.getOperacion()) {
                    case '+':
                        if (premio.getNumero() == 0) {
                            descripcionEfecto = "Te quedas en la misma posicion!";
                        } else {
                            descripcionEfecto = "Avanza " + premio.getNumero() + " posiciones!";
                        }
                        break;
                    default:
                        descripcionEfecto = "Premio desconocido";
                }

                System.out.println("Has recibido un premio: " + premio.getOperacion() + " " + premio.getNumero());
                System.out.println(descripcionEfecto);

                // Aplicar el efecto del premio
                int posicionAnterior = jugadorActual.getPosicion();
                jugadorActual.aplicarEfecto(premio);

                // Validar si se pasa de la meta al aplicar el premio
                if (jugadorActual.getPosicion() > META) {
                    int exceso = jugadorActual.getPosicion() - META;
                    jugadorActual.setPosicion(META - exceso);
                    System.out.println("Te pasaste de la meta! Debes retroceder " + exceso + " posiciones desde la meta.");
                }

                System.out.println("Tu nueva posicion es " + jugadorActual.getPosicion());

                // Actualizar el estado del juego
                estadoJuego.actualizarPosicionJugador(
                        jugadorActual.getNombre(),
                        jugadorActual.getPosicion(),
                        posicionAnterior
                );

                // Agregar al historial
                historialJugadores.agregarPosicionJugador(
                        jugadorActual.getNombre(),
                        jugadorActual.getPosicion(),
                        descripcionEfecto
                );
            } else {
                System.out.println("No hay premios disponibles actualmente.");

                // Agregar al historial sin efecto
                historialJugadores.agregarPosicionJugador(
                        jugadorActual.getNombre(),
                        jugadorActual.getPosicion(),
                        "Posicion " + jugadorActual.getPosicion() + " no tiene castigos/premios"
                );
            }
        } else {  // Si es impar, castigo
            System.out.println("Obtuviste un numero impar, debes tomar un castigo de la pila.... suerte la proxima vez!");
            if (!pilaCastigos.estaVacia()) {
                castigo = pilaCastigos.pop();

                switch (castigo.getOperacion()) {
                    case '-':
                        descripcionEfecto = "Retrocedes " + castigo.getNumero() + " posiciones!";
                        break;
                    case '=':
                        descripcionEfecto = "Debes ir a la posicion " + castigo.getNumero() + "!";
                        break;
                    default:
                        descripcionEfecto = "Castigo desconocido";
                }

                System.out.println("Has recibido un castigo: " + castigo.getOperacion() + " " + castigo.getNumero());
                System.out.println(descripcionEfecto);

                // Aplicar el efecto del castigo
                int posicionAnterior = jugadorActual.getPosicion();
                jugadorActual.aplicarEfecto(castigo);
                System.out.println("Tu nueva posicion es " + jugadorActual.getPosicion());

                // Actualizar el estado del juego
                estadoJuego.actualizarPosicionJugador(
                        jugadorActual.getNombre(),
                        jugadorActual.getPosicion(),
                        posicionAnterior
                );

                // Agregar al historial
                historialJugadores.agregarPosicionJugador(
                        jugadorActual.getNombre(),
                        jugadorActual.getPosicion(),
                        descripcionEfecto
                );
            } else {
                System.out.println("No hay castigos disponibles");

                // Agregar al historial sin efecto
                historialJugadores.agregarPosicionJugador(
                        jugadorActual.getNombre(),
                        jugadorActual.getPosicion(),
                        "Posicion " + jugadorActual.getPosicion() + " no tiene castigos/premios"
                );
            }
        }

        // Verificar si ha llegado a la meta
        if (jugadorActual.getPosicion() >= META) {
            System.out.println("FELICIDADES " + jugadorActual.getNombre().toUpperCase());
            System.out.println("Has ganado el juego ^^");
            return;
        }

        // Volver a poner al jugador en la cola
        colaJugadores.agregarJugador(jugadorActual);
        System.out.println("El jugador " + jugadorActual.getNombre() + " ha vuelto a la cola.");

        // Pequena pausa para que el usuario pueda leer el resultado
        System.out.println("\n\n\n Presione ENTER para continuar...");
        scanner.nextLine();
    }

    // Abadonar el juego
    private static void abandonarJuego(ColaJugadores colaJugadores) {
        if (colaJugadores.estaVacia()) {
            System.out.println("\n No hay jugadores en la cola.");
            return;
        }

        System.out.print("\n Ingrese el nombre del jugador que desea abandonar: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Debe ingresar un nombre valido.\n");
            return;
        }

        eliminarJugador(colaJugadores, nombre);
    }

    // Metodo para eliminar un jugador 
    private static void eliminarJugador(ColaJugadores colaJugadores, String nombre) {
        if (colaJugadores.estaVacia()) {
            System.out.println("No hay jugadores en la cola.");
            return;
        }

        // Cola temporal para los jugadores
        ColaJugadores tempCola = new ColaJugadores();
        boolean encontrado = false;
        int cantidadOriginal = colaJugadores.getCantidadElementos();
        Jugador jugadorEliminado = null;

        // Buscar y eliminar el jugador
        for (int i = 0; i < cantidadOriginal; i++) {
            Jugador jugador = colaJugadores.quitarJugador();
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                jugadorEliminado = jugador;
                System.out.println("El jugador " + nombre + " ha abandonado el juego.");
            } else {
                tempCola.agregarJugador(jugador);
            }
        }

        // Devolver los jugadores a la cola original
        while (!tempCola.estaVacia()) {
            colaJugadores.agregarJugador(tempCola.quitarJugador());
        }

        if (encontrado && jugadorEliminado != null && estadoJuego != null) {
            // Limpiar la posicion del jugador en el estado del juego
            estadoJuego.actualizarPosicionJugador(jugadorEliminado.getNombre(), 0, jugadorEliminado.getPosicion());

            // Agregar al historial
            historialJugadores.agregarPosicionJugador(
                    jugadorEliminado.getNombre(), -1, "Abandono el juego");
        }

        if (!encontrado) {
            System.out.println("No se encontro al jugador " + nombre + " en la cola.");
        }
    }

    // Metodo para listar jugadores
    private static void listarJugadores(ColaJugadores colaJugadores) {
        if (colaJugadores.estaVacia()) {
            System.out.println("No hay jugadores en la cola.");
            return;
        }

        System.out.println("\n===== LISTA DE JUGADORES =====");
        System.out.println("Nombre\t\tPosicion");
        System.out.println("---------------------------");

        // Crear una cola temporal
        ColaJugadores tempCola = new ColaJugadores();
        int cantidadOriginal = colaJugadores.getCantidadElementos();

        // Mostrar cada jugador y guardarlos en la cola temporal
        for (int i = 0; i < cantidadOriginal; i++) {
            Jugador jugador = colaJugadores.quitarJugador();
            System.out.println(jugador.getNombre() + "\t\t" + jugador.getPosicion());
            tempCola.agregarJugador(jugador);
        }

        // Devolver los jugadores a la cola original
        while (!tempCola.estaVacia()) {
            colaJugadores.agregarJugador(tempCola.quitarJugador());
        }
    }

    // Metodo para listar pila de premios
    private static void listarPilaPremios(PilaPremios pilaPremios) {
        Nodo actual = pilaPremios.obtenerTopNodo();
        if (actual == null) {
            System.out.println("No hay premios disponibles");
            return;
        }

        System.out.println("\n***** PREMIOS EN LA PILA *****");
        System.out.println("Operacion\t Numero\t Descripcion");
        System.out.println("-----------------------------------------");

        while (actual != null) {
            Datos datos = actual.getPiDatos();
            System.out.print(datos.getOperacion() + "\t\t" + datos.getNumero() + "\t");

            // Agregar descripcion segun la operacion y numero
            switch (datos.getOperacion()) {
                case '+':
                    if (datos.getNumero() == 0) {
                        System.out.println("Significa que se queda en la posicion actual.");
                    } else {
                        System.out.println("Significa que suma " + datos.getNumero() + " posiciones.");
                    }
                    break;
                default:
                    System.out.println("Premio desconocido");
            }

            actual = actual.getAbajo();
        }
    }

    // Metodo para listar pila de castigos
    private static void listarPilaCastigos(PilaCastigos pilaCastigos) {
        Nodo actual = pilaCastigos.obtenerTopNodo();
        if (actual == null) {
            System.out.println("No hay castigos disponibles.");
            return;
        }

        System.out.println("\n ***** CASTIGOS EN LA PILA *****");
        System.out.println("Operacion \t Numero\t Descripcion");
        System.out.println("-----------------------------------------");

        while (actual != null) {
            Datos datos = actual.getPiDatos();
            System.out.print(datos.getOperacion() + "\t\t" + datos.getNumero() + "\t");

            // castigos / tomado de clase padre
            switch (datos.getOperacion()) {
                case '-':
                    System.out.println("Se te restaran " + datos.getNumero() + " posiciones.");
                    break;
                case '=':
                    System.out.println("Deberas ir a la posicion " + datos.getNumero() + ".");
                    break;
                default:
                    System.out.println("Castigo desconocido");
            }

            actual = actual.getAbajo();
        }
    }

    // Metodo para mostrar el estado actual del juego
    private static void mostrarEstadoJuego() {
        if (estadoJuego == null) {
            System.out.println("Debe iniciar el juego primero.");
            return;
        }

        estadoJuego.imprimirEstadoJuego();
    }

    // Metodo para mostrar la bitacora-historial
    private static void mostrarBitacoraHistorial() {
        if (historialJugadores.estaVacia()) {
            System.out.println("No hay jugadores en el historial.");
            return;
        }

        // Navegacion por los jugadores
        NodoJugadorHistorial actual = historialJugadores.getCabeza();
        boolean salir = false;

        while (!salir) {
            // Mostrar jugador actual
            actual.imprimirHistorial();

            // Opciones de navegacion
            System.out.println("\n Opciones:");
            System.out.println("1. Siguiente jugador");
            System.out.println("2. Jugador anterior");
            System.out.println("3. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    actual = actual.getSiguiente();
                    break;
                case 2:
                    actual = actual.getAnterior();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
                    break;
            }
        }
    }

    // Metodo para mostrar la ayuda
    private static void mostrarAyuda() {
        System.out.println("\n ***** AYUDA DEL JUEGO *****");
        System.out.println("Version:1.3 "); // Actualizado a versión 1.3
        System.out.println("Desarrollado por: Esteban, Diana y Andres\n");
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("1. Inicie el juego registrando entre 1 y 4 jugadores.");
        System.out.println("2. Cada jugador tira los dados en su turno para avanzar.");
        System.out.println("3. Si cae en posicion par, recibe un premio.");
        System.out.println("4. Si cae en posicion impar, recibe un castigo.");
        System.out.println("5. Los jugadores pueden abandonar el juego en cualquier momento.");
        System.out.println("6. Gana quien llegue primero a la posicion " + META + "!");
        System.out.println("7. Puede adicionar nuevos jugadores durante el juego si esta habilitado.");
        System.out.println("8. Consulte el estado actual del juego para ver todas las posiciones.");
        System.out.println("9. Revise la bitacora-historial para ver el recorrido de cada jugador.");
        System.out.println("10. Use el chatbot para responder preguntas frecuentes sobre el juego.");
        System.out.println("\nNOVEDADES EN ESTA VERSION:");
        System.out.println("- Posibilidad de configurar la posicion maxima del juego");
        System.out.println("- Control de jugadores que se pasan de la meta");
        System.out.println("- Visualizacion del estado del tablero");
        System.out.println("- Bitacora completa del recorrido de cada jugador");
        System.out.println("- Chatbot de preguntas frecuentes");

    }
}
