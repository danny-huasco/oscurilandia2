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
public class Carro {
    int cantOcupantes;
    String fechaIngreso;
    Espacio ubicacion;
    
    /**
     * constructor con parametros
     * @param cantOcupantes
     * @param fechaIngreso
     * @param ubicacion 
     */
    public Carro(int cantOcupantes, String fechaIngreso, Espacio ubicacion) {
        this.cantOcupantes = cantOcupantes;
        this.fechaIngreso = fechaIngreso;
        this.ubicacion = ubicacion;
    }
    
    /**
     * constructor vacio
     */
    public Carro() {
        this.cantOcupantes = 0;
        this.fechaIngreso = "";
        this.ubicacion = new Espacio();
    }

    /**
     * obtiene valor del atributo cantOcupantes
     * @return cantOcupantes cantidad de ocupantes del carro
     */
    public int getCantOcupantes() {
        return cantOcupantes;
    }

    /**
     * da valor al atributo cantOcupantes
     * @param cantOcupantes es la cantidad de ocupantes del carro
     */
    public void setCantOcupantes(int cantOcupantes) {
        this.cantOcupantes = cantOcupantes;
    }

    /**
     * obtiene valr del atributo fechaIngreso
     * @return tipo String
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * da valor al atributo fechaIngreso
     * @param fechaIngreso tipo String
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    /**
     * obtiene valor del atributo ubicacion
     * @return tipo Espacio
     */
    public Espacio getUbicacion() {
        return ubicacion;
    }
    /**
     * da valor al atributo ubicacion
     * @param ubicacion tipo Espacio
     */
    public void setUbicacion(Espacio ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    /**
     * despliega los valores de los atributos del objeto
     */
    public void desplegarDatos(){
        System.out.print("Ocupantes: " + this.cantOcupantes + "\nFecha de ingreso: " + this.fechaIngreso + "\nPosición: (" +ubicacion.getFila()+","+ubicacion.getColumna()+")");
    }
    
    

    
}
