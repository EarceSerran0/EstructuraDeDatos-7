package com.mycompany.juegoproyecto;

import java.util.*;

/**
 *
 * @author Grupo#7
 */
public class JuegoProyecto {
// en caso de no poder utilizar scanner cambiar esto
    private static Scanner scanner = new Scanner(System.in);
    private static final int META = 30; // La meta que tendra el juego , en este caso agregamos como maximo un 25 para que el juego sea rapido.

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
            System.out.println("7. Ayuda");
            System.out.println("8. Salir\n");
            System.out.print("Seleccione una opcion: ");
            
            int seleccion;
            try {
                  //pasar de string a int
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
                    
                case 7: // Ayuda
                    mostrarAyuda();
                    break;

                case 8: // Salir
                    juegoActivo = false;
                    System.out.println("Gracias por jugar");
                    break;

                default:
                    System.out.println("Opción invalida, intente de nuevo.");
                    break;
            }
        }
        
        scanner.close();
    }
    
    // Método para iniciar el juego e inscribir jugadores
    private static void iniciarJuego(ColaJugadores colaJugadores) {
        try {
            System.out.print("Ingrese el numero de jugadores (maximo 4): ");
            //pasar de sstring a int
            int numJugadores = Integer.parseInt(scanner.nextLine());
            
            if (numJugadores <= 0) {
                System.out.println("Debe ingresar un numero valido de jugadores, no negativos");
                return;
            }
            
            if (numJugadores > 4) {
                System.out.println("El máximo de jugadores permitido es 4. Se registrarán solo 4 jugadores.");
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
            }
            
            System.out.println("Se inscribieron " + numJugadores + " jugadores");
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un numero valido.");
        }
    }
    
    // Método para jugar (tirar dados)
    private static void jugar(ColaJugadores colaJugadores, PilaPremios pilaPremios, PilaCastigos pilaCastigos, Random random) {
        if (colaJugadores.estaVacia()) {
            System.out.println("No hay jugadores en la cola. Debe iniciar el juego primero.");
            return;
        }
        
        // Obtener el jugador actual
        Jugador jugadorActual = colaJugadores.quitarJugador();
        
        // Tirar los dados
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        int total = dado1 + dado2;
        
        // Mostrar el resultado de los dados
        System.out.println("\n======== TURNO DE " + jugadorActual.getNombre().toUpperCase() + " ========="); // mayusc
        System.out.println("Jugador " + jugadorActual.getNombre() + " tiro los dados:");
        System.out.println("Dado 1: " + dado1);
        System.out.println("Dado 2: " + dado2);
        System.out.println("Total: " + total);
        
        // Mensaje de posición actual y avance
        int posicionActual = jugadorActual.getPosicion();
        System.out.println("Jugador " + jugadorActual.getNombre() + " estas en la posicion " + posicionActual + 
                " , puedes avanzar " + total + " posiciones!");
        
        // Actualizar la posición
        jugadorActual.avanzar(total);
        int nuevaPosicion = jugadorActual.getPosicion();
        System.out.println("Tu nueva posicion es " + nuevaPosicion + ".");
        
        // Aplicar premio o castigo según si la nueva posición es par o impar
        if (nuevaPosicion % 2 == 0) {  // Si es par, premio
            System.out.println("Obtuviste un numero par, debes tomar un premio de la pila, mucha suerte!");
            if (!pilaPremios.estaVacia()) {
                Datos premio = pilaPremios.pop();
                String descripcion ; // se inicia vacia
                
                switch (premio.getOperacion()) {
                    case '+':
                        if (premio.getNumero() == 0) {
                            descripcion = "Te quedas en la misma posicion!";
                        } else {
                            descripcion = "Avanza " + premio.getNumero() + " posiciones!";
                        }
                        break;
                    default:
                        descripcion = "Premio desconocido";
                }
                
                System.out.println("Has recibido un premio: " + premio.getOperacion() + " " + premio.getNumero());
                System.out.println(descripcion);
                
                // Aplicar el efecto del premio
                jugadorActual.aplicarEfecto(premio);
                System.out.println("Tu nueva posicion es " + jugadorActual.getPosicion());
            } else {
                System.out.println("No hay premios disponibles actualmente.");
            }
        } else {  // Si es impar, castigo
            System.out.println("Obtuviste un numero impar, debes tomar un castigo de la pila.... suerte la proxima vez!");
            if (!pilaCastigos.estaVacia()) {
                Datos castigo = pilaCastigos.pop();
                String descripcion = "";
                
                switch (castigo.getOperacion()) {
                    case '-':
                        descripcion = "Retrocedes " + castigo.getNumero() + " posiciones!";
                        break;
                    case '=':
                        descripcion = "Debes ir a la posicion " + castigo.getNumero() + "!";
                        break;
                    default:
                        descripcion = "Castigo desconocido ¿?¿?¿?";
                }
                
                System.out.println("Has recibido un castigo: " + castigo.getOperacion() + " " + castigo.getNumero());
                System.out.println(descripcion);
                
                // Aplicar el efecto del castigo
                jugadorActual.aplicarEfecto(castigo);
                System.out.println("Tu nueva posicion es " + jugadorActual.getPosicion());
            } else {
                System.out.println("No hay castigos disponibles");
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
        
        // Pequeña pausa para que el usuario pueda leer el resultado
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
            System.out.println("Debe ingresar un nombre válido.\n");
            return;
        }
        
        eliminarJugador(colaJugadores, nombre);
    }
    
    // Método para eliminar un jugador 
    private static void eliminarJugador(ColaJugadores colaJugadores, String nombre) {
        if (colaJugadores.estaVacia()) {
            System.out.println("No hay jugadores en la cola.");
            return;
        }
        
        // Cola temporal para los jugadores
        ColaJugadores tempCola = new ColaJugadores();
        boolean encontrado = false;
        int cantidadOriginal = colaJugadores.getCantidadJugadores();
        
        // Buscar y eliminar el jugador
        for (int i = 0; i < cantidadOriginal; i++) {
            Jugador jugador = colaJugadores.quitarJugador();
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                System.out.println("El jugador " + nombre + " ha abandonado el juego.");
            } else {
                tempCola.agregarJugador(jugador);
            }
        }
        
        // Devolver los jugadores a la cola original
        while (!tempCola.estaVacia()) {
            colaJugadores.agregarJugador(tempCola.quitarJugador());
        }
        
        if (!encontrado) {
            System.out.println("No se encontro al jugador " + nombre + " en la cola.");
        }
    }
    
    // Método para listar jugadores (reemplaza el método en ColaJugadores)
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
        int cantidadOriginal = colaJugadores.getCantidadJugadores();
        
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
    
    // Método para listar pila de premios (reemplaza el método en PilaPremios)
    private static void listarPilaPremios(PilaPremios pilaPremios) {
        Nodo actual = pilaPremios.obtenerTopNodo();
        if (actual == null) {
            System.out.println("No hay premios disponibles");
            return;
        }

        System.out.println("\n===== PREMIOS EN LA PILA =====");
        System.out.println("Operacion\t Numero\t Descripcion");
        System.out.println("-----------------------------------------");

        while (actual != null) {
            Datos datos = actual.getPiDatos();
            System.out.print(datos.getOperacion() + "\t\t" + datos.getNumero() + "\t");
            
            // Agregar descripción según la operación y número
            switch(datos.getOperacion()) {
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
    
    // Método para listar pila de castigos (reemplaza el método en PilaCastigos)
    private static void listarPilaCastigos(PilaCastigos pilaCastigos) {
        Nodo actual = pilaCastigos.obtenerTopNodo();
        if (actual == null) {
            System.out.println("No hay castigos disponibles.");
            return;
        }

        System.out.println("\n ===== CASTIGOS EN LA PILA =====");
        System.out.println("Operacion \t Numero\t Descripcion");
        System.out.println("-----------------------------------------");

        while (actual != null) {
            Datos datos = actual.getPiDatos();
            System.out.print(datos.getOperacion() + "\t\t" + datos.getNumero() + "\t");
            
            // castigos / tomado de clase padre
            switch(datos.getOperacion()) {
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
    
    // Método(7) para mostrar la ayuda
    private static void mostrarAyuda() {
        System.out.println("\n===== AYUDA DEL JUEGO =====");
        System.out.println("Versión:1.0 ");
        System.out.println("Desarrollado por: Esteban, Diana, Yanko y Andres\n" );
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("1. Inicie el juego registrando entre 1 y 4 jugadores.");
        System.out.println("2. Cada jugador tira los dados en su turno para avanzar.");
        System.out.println("3. Si cae en posición par, recibe un premio.");
        System.out.println("4. Si cae en posicion impar, recibe un castigo.");
        System.out.println("5. Los jugadores pueden abandonar el juego en cualquier momento.\n");
        System.out.println("\n 6. Gana quien llegue primero a la posicion " + META + "!");
    }
}
