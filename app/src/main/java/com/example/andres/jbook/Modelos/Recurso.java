package com.example.andres.jbook.Modelos;

import java.io.Serializable;

/**
 * Created by andres on 17/04/18.
 */

public abstract class Recurso implements Serializable{
    private String id;
    private String nombre;
    private String descripcion;
    private String estado;
    private String ubicacion;

    public  Recurso() {

    }

    public Recurso(String id,String nombre, String descripcion, String estado, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
