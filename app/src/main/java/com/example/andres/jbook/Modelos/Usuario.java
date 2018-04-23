package com.example.andres.jbook.Modelos;

import java.util.ArrayList;

/**
 * Created by andres on 22/04/18.
 */

public abstract class Usuario {
    private String id;
    private String nombre;
    private ArrayList<Reserva> reservas;

    public Usuario() {
        // Firebase
    }

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        reservas = new ArrayList<Reserva>();
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

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}
