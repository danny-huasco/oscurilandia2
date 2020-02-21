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
public class Caguano extends Carro {
    String colorConfeti;
    int alcanceTiro;
   

    /**
     * Constructor con parametros
     * @param colorConfeti 
     * @param alcanceTiro
     * @param cantOcupantes
     * @param fechaIngreso
     * @param ubicacion 
     */
    public Caguano(String colorConfeti, int alcanceTiro, int cantOcupantes, String fechaIngreso, Espacio ubicacion) {
        super(cantOcupantes, fechaIngreso, ubicacion);
        this.colorConfeti = colorConfeti;
        this.alcanceTiro = alcanceTiro;
        
    }

    /**
     * constructor vacio
     */
    public Caguano() {
        super();
        this.alcanceTiro = 0;
        this.colorConfeti = "";
    }

    /**
     * obtiene el valor del atributo colorConfeti
     * @return valor tipo string del atributo colorConfeti
     */
    public String getColorConfeti() {
        return colorConfeti;
    }

    /**
     * da valor a atributo colorConfeti
     * @param colorConfeti valor a asignar en el atributo colorConfeti
     */
    public void setColorConfeti(String colorConfeti) {
        this.colorConfeti = colorConfeti;
    }

    /**
     * obtiene el valor del atributo alcanceTiro
     * @return valor tipo entero
     */    
    public int getAlcanceTiro() {
        return alcanceTiro;
    }

    /**
     * da valor al atributo alcanceTiro
     * @param alcanceTiro 
     */
    public void setAlcanceTiro(int alcanceTiro) {
        this.alcanceTiro = alcanceTiro;
    }

  
    
}
