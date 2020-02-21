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
public class Kromi extends Carro{
    int anioFabricacion;
    String marca;    
 
    /**
     * constructor con parametros
     * @param anioFabricacion tipo int
     * @param marca tipo String 
     * @param cantOcupantes tipo int
     * @param fechaIngreso tipo String
     * @param ubicacion  tipo Espacio
     */
    public Kromi(int anioFabricacion, String marca, int cantOcupantes, String fechaIngreso, Espacio ubicacion) {
        super(cantOcupantes, fechaIngreso, ubicacion);
        this.anioFabricacion = anioFabricacion;
        this.marca = marca;
        
    }

    /**
     * constructor vacio
     */
    public Kromi() {
        super();
        this.anioFabricacion = 0;
        this.marca = "";
    }

    /**
     * obtiene valor del atributo anioFabricacion
     * @return valor tipo int
     */
    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * da valor al atributo anioFabricacion
     * @param anioFabricacion tipo int
     */
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    /**
     * obtiene valor del atributo marca
     * @return tipo String
     */
    public String getMarca() {
        return marca;
    }

    /**
     * da valor al atributo marca
     * @param marca tipo String
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
       
}
