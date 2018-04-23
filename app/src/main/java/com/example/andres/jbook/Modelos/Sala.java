package com.example.andres.jbook.Modelos;

import java.io.Serializable;

/**
 * Created by andres on 18/04/18.
 */

public class Sala extends Recurso implements Serializable{
    private int capacidad;

    public Sala(String id,String nombre, String descripcion, String estado, String ubicacion, int capacidad) {
        super(id, nombre, descripcion, estado, ubicacion);
        this.capacidad = capacidad;
    }

    public Sala(){
        super();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
