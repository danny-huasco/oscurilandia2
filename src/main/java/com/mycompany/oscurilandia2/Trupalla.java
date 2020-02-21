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
public class Trupalla extends Carro{
    int armadura;//validar ingreso entre 1 y 5
    String nombreChofer;

    /**
     * constructor con parametros
     * @param armadura
     * @param nombreChofer
     * @param cantOcupantes
     * @param fechaIngreso
     * @param ubicacion 
     */
    public Trupalla(int armadura, String nombreChofer, int cantOcupantes, String fechaIngreso, Espacio ubicacion) {
        super(cantOcupantes, fechaIngreso, ubicacion);
        this.armadura = armadura;
        this.nombreChofer = nombreChofer;
    }

    /**
     * constructor vacío
     */
    public Trupalla() {
        super();
        this.armadura = 0;
        this.nombreChofer = "";
    }

    /**
     * obtiene valor del atributo armadura
     * @return tipo int
     */
    public int getArmadura() {
        return armadura;
    }
    
    /**
     * da valor al atributo armadura
     * @param armadura tipo int
     */
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    /**
     * obtiene valor del atributo nombreChofer 
     * @return tipo String
     */
    public String getNombreChofer() {
        return nombreChofer;
    }

    /**
     * da valor al atributo nombreChofer
     * @param nombreChofer tipo String
     */    
    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }
       
}
