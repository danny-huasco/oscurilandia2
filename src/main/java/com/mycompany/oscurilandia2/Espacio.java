/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oscurilandia2;

/**
 *
 * @author Daniel
 */
public class Espacio {
    int fila;
    int columna;
    int numTablero;
    String contenido;
    String muestra;

    /**
     * constructor con parametros
     * @param fila
     * @param columna
     * @param numTablero 
     */
    public Espacio(int fila, int columna, int numTablero) {
        this.fila = fila;
        this.columna = columna;
        this.numTablero = numTablero;
        this.contenido = "*";
        this.muestra = "*";
    }

    /**
     * construtor vacio
     */
    public Espacio() {
        
    }

    /**
     * obtiene valor del atributo muestra
     * @return valor tipo String
     */
    public String getMuestra() {
        return muestra;
    }

    /**
     * da valor al atributo muestra
     * @param muestra valor tipo String
     */
    public void setMuestra(String muestra) {
        this.muestra = muestra;
    }

    /**
     * obtiene valor del atributo fila
     * @return valor tipo int
     */
    public int getFila() {
        return fila;
    }

    /**
     * da valor al atributo fila
     * @param fila valor tipo int
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * obtiene valor del atributo columna
     * @return valor tipo int
     */
    public int getColumna() {
        return columna;
    }

    /**
     * da valor al atributo columna
     * @param columna valor tipo int
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * obtiene valor del atributo numTablero
     * @return valor tipo int
     */
    public int getNumTablero() {
        return numTablero;
    }

    /**
     * da valor al atributo numTablero
     * @param numTablero valor tipo int
     */
    public void setNumTablero(int numTablero) {
        this.numTablero = numTablero;
    }
    /**
     * obtiene valor del atributo contenido
     * @return valor tipo String
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * da valor al atributo contenido
     * @param contenido valor tipo String
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    /**
     * muestra los datos fila y columna del objeto
     */
    public String toString() {
        return "Posición: (" + fila + "," + columna + ")";
    }
    
}
