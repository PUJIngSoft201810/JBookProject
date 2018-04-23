package com.example.andres.jbook.Modelos;

/**
 * Created by andres on 17/04/18.
 */

public enum ERecurso {
    RESERVADO(1),
    LIBRE(2);

    private int value;

    ERecurso(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
