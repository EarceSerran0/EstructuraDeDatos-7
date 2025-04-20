/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegoproyecto;


public class preguntas {
    
    private String codigo;
    private String nombre;
    private String respuesta;
    
    /**
     * Constructor para una pregunta
     * 
     * @param codigo Codigo identificador de la pregunta
     * @param nombre Texto de la pregunta
     * @param respuesta Respuesta a la pregunta
     */
    public preguntas(String codigo, String nombre, String respuesta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.respuesta = respuesta;
    }
    
    /**
     * Obtener el codigo de la pregunta
     * 
     * @return El codigo de la pregunta
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Establecer el codigo de la pregunta
     * 
     * @param codigo El nuevo codigo de la pregunta
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Obtener el nombre (texto) de la pregunta
     * 
     * @return El nombre de la pregunta
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establecer el nombre (texto) de la pregunta
     * 
     * @param nombre El nuevo nombre de la pregunta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtener la respuesta a la pregunta
     * 
     * @return La respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }
    
    /**
     * Establecer la respuesta a la pregunta
     * 
     * @param respuesta La nueva respuesta
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    /**
     * Representacion en forma de texto de la pregunta
     * 
     * @return String con la informacion de la pregunta
     */
    @Override
    public String toString() {
        return nombre;
    }
}