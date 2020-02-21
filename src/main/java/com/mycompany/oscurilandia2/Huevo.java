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
public class Huevo {
    Espacio pos;
    int puntaje;

    /**
     * constructor con parametros
     * @param pos posicion en el tablero
     * @param puntaje puntaje asignado al impactar el tablero
     */
    public Huevo(Espacio pos, int puntaje) {
        this.pos = pos;
        this.puntaje = puntaje;
    }

    /**
     * constructor vacío
     */
    public Huevo() {
        this.pos = new Espacio();
        this.puntaje = 0;
    }

    /**
     * obtiene la posicion donde impactó, del tipo Espacio
     * @return atributo de tipo Espacio
     */
    public Espacio getPos() {
        return pos;
    }

    /**
     * da valor al atributo Pos(posicion)
     * @param pos del tipo Espacio, corresponde a la ubicacion donde impactó
     */
    public void setPos(Espacio pos) {
        this.pos = pos;
    }

    /**
     * obtiene el valor del atributo puntaje
     * @return puntaje almacenado del tipo entero
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * da valor al atributo puntaje
     * @param puntaje entero correspondiente al puntaje asignado
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    /**
     * metodo de muestra del contenido de cada objeto
     */
    public String toString() {
        return "Huevo{" + "posicion: " + pos.toString() + ", puntaje: " + puntaje + '}';
    }
   
    
    
    
}
