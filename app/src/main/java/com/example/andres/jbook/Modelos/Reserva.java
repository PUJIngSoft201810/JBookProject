package com.example.andres.jbook.Modelos;

import java.util.Date;

/**
 * Created by andres on 22/04/18.
 */

public class Reserva {

    private String id;
    private Date fecha_ini;
    private Date fecha_fin;
    private String estado;
    private Recurso recurso;
    private Usuario usuario;

    public Reserva() {
    }

    public Reserva(String id, Date fecha_ini, Date fecha_fin, String estado, Recurso recurso, Usuario usuario) {
        this.id = id;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.recurso = recurso;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
