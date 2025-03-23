package com.mycompany.juegoproyecto;

/**
 *
 * @author Grupo#7
 */

public class Jugador {

    private String nombre;
    private int posicion;
    private int posicionAnterior;

    /**
     * Constructor para el jugador
     *
     * @param nombre El nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 0; // iniciamos en posición 0
        this.posicionAnterior = 0;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getPosicionAnterior() {
        return posicionAnterior;
    }

    /**
     * Establecer la posicion del jugador
     *
     * @param posicion La nueva posicion
     */
    public void setPosicion(int posicion) {
        this.posicionAnterior = this.posicion;
        this.posicion = Math.max(posicion, 0); // Evitar posiciones negativas
    }

    /**
     * Avanzar el jugador una cantidad de posiciones
     *
     * @param cantidad La cantidad a avanzar
     */
    public void avanzar(int cantidad) {
        this.posicionAnterior = this.posicion;
        this.posicion += cantidad;
    }

    /**
     * Retroceder el jugador una cantidad de posiciones
     *
     * @param cantidad La cantidad a retroceder
     */
    public void retroceder(int cantidad) {
        this.posicionAnterior = this.posicion;
        this.posicion -= cantidad;
        // No permitir posiciones negativas
        if (this.posicion < 0) {
            this.posicion = 0;
        }
    }

    /**
     * Mover el jugador a una posicion especifica
     *
     * @param nuevaPosicion La nueva posicion
     */
    public void irAPosicion(int nuevaPosicion) {
        this.posicionAnterior = this.posicion;
        this.posicion = Math.max(nuevaPosicion, 0);
    }

    /**
     * Aplicar un efecto al jugador (premio o castigo)
     *
     * @param efecto Los datos del efecto a aplicar
     */
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

    /**
     * Obtener la descripcion del efecto
     *
     * @param efecto El efecto a describir
     * @return String con la descripcion del efecto
     */
    public String obtenerDescripcionEfecto(Datos efecto) {
        if (efecto == null) {
            return "Posicion " + posicion + " no tiene castigos/premios";
        }

        String descripcion = "";
        switch (efecto.getOperacion()) {
            case '+':
                if (efecto.getNumero() == 0) {
                    descripcion = "Se queda en la misma posicion";
                } else {
                    descripcion = "Avanza " + efecto.getNumero() + " posiciones";
                }
                break;
            case '-':
                descripcion = "Retrocede " + efecto.getNumero() + " posiciones";
                break;
            case '=':
                descripcion = "Va a la posicion " + efecto.getNumero();
                break;
            default:
                descripcion = "Efecto desconocido";
        }

        return descripcion;
    }
}
