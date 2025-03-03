package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */
public class PilaCastigos extends PilaJuego {

    public PilaCastigos() {
        inicializarPila("Castigos");
        cargarCastigosIniciales();
    }

    private void cargarCastigosIniciales() {
        char[] operaciones = {'-', '=', '-', '-', '=', '=', '-', '-', '='};
        int[] numeros = {5, 1, 3, 1, 3, 4, 2, 2, 1};
        cargarDatosIniciales(operaciones, numeros);
    }
//no se utiliza del todo
    @Override // viene de clase padre por lo que se agrega esto
    public void listarPila() {
        // no se usa del todo, dejar por el momento.
        Nodo actual = obtenerTopNodo();
        if (actual == null) {
            System.out.println("No hay castigos disponibles.");
            return;
        }

        System.out.println("Castigos en la pila:");
        System.out.println("Operacion\t Numero\tDescripcion");
        System.out.println("-----------------------------------------");

        while (actual != null) {
            Datos datos = actual.getPiDatos();
            System.out.print(datos.getOperacion() + "\t\t" + datos.getNumero() + "\t");

            // Descripcion de los castigos y premios en base a su signo 
            switch (datos.getOperacion()) {
                case '-':
                    System.out.println("Castigo, se te restara_ " + datos.getNumero() + " posiciones.");
                    break;
                case '=':
                    System.out.println("Deberas ir a la posicion " + datos.getNumero());
                    break;
                default:
                    System.out.println("Castigo desconocido");
            }

            actual = actual.getAbajo();
        }
    }
}
