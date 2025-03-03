package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class PilaPremios extends PilaJuego {

    public PilaPremios() {
        inicializarPila("Premios");
        cargarPremiosIniciales();
    }

    private void cargarPremiosIniciales() {
        char[] operaciones = {'+', '+', '+', '+', '+', '+', '+', '+', '+'};
        int[] numeros = {0, 8, 2, 0, 0, 5, 3, 4, 3};
        cargarDatosIniciales(operaciones, numeros);
    }

    @Override
    public void listarPila() {
        // lo mismo que castigos, viene de clase padre
        Nodo actual = obtenerTopNodo();
        if (actual == null) {
            System.out.println("No hay premios disponibles.");
            return;
        }

        System.out.println("Premios en la pila:");
        System.out.println("Operacion\t Nuumero\t Descripcion");
        System.out.println("-----------------------------------------");

        while (actual != null) {
            Datos datos = actual.getPiDatos();
            System.out.print(datos.getOperacion() + "\t\t" + datos.getNumero() + "\t");

            // no se usa del todo pero dejar (similar a castigos, se usa parte por herencia del padre)
            switch (datos.getOperacion()) {
                case '+':
                    if (datos.getNumero() == 0) {
                        System.out.println("Te quedaras en la posicion actual.");
                    } else {
                        System.out.println("Se te sumaran " + datos.getNumero() + " posiciones.");
                    }
                    break;
                default:
                    System.out.println("Premio desconocido");
            }

            actual = actual.getAbajo();
        }
    }
}
