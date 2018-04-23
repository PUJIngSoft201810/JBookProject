package com.example.andres.jbook.Modelos;

/**
 * Created by andres on 22/04/18.
 */

public class Academico extends Usuario {
    private String estado;

    public Academico(String id, String nombre, String estado) {
        super(id, nombre);
        this.estado = estado;
    }

    public Academico(){
        super();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
