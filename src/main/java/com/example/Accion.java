package com.example;

import java.util.Objects;

public class Accion {
    private int botOrigen;
    private int botDestino;
    private int cantidad;


    public Accion() {
    }

    public Accion(int botOrigen, int botDestino, int cantidad) {
        this.botOrigen = botOrigen;
        this.botDestino = botDestino;
        this.cantidad = cantidad;
    }

    public int getBotOrigen() {
        return this.botOrigen;
    }

    

    public int getBotDestino() {
        return this.botDestino;
    }

    public int getCantidad() {
        return this.cantidad;
    }



    @Override
    public String toString() {
        return "(" +
             getBotOrigen() + ", " +
             getBotDestino() + ", " +
             getCantidad() + ")";
    }

}
