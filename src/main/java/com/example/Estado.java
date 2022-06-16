package com.example;

import java.util.ArrayList;

import java.util.List;




public class Estado implements  JsonUtil {

    private List<Bottle> e;
    private int bottleSize;

    public Estado() {
    }

    public Estado(List<Bottle> estado, int bottleSize) {
        this.e = estado;
        this.bottleSize = bottleSize;
    }

    public Estado(Estado accion) {
        this.e = accion.getEstado();
        this.bottleSize = accion.getBottleSize();
    }

    public Estado(List<Bottle> listaBotellas) {
        this.e = listaBotellas;
    }

    public List<Bottle> getEstado() {
        return e;
    }

    public void setEstado(List<Bottle> estado) {
        this.e = estado;
    }

    public int getBottleSize() {
        return this.bottleSize;
    }

    public void setBottleSize(int bottleSize) {
        this.bottleSize = bottleSize;
    }

    public Estado estado(List<Bottle> estado) {
        setEstado(estado);
        return this;
    }

    public Estado bottleSize(int bottleSize) {
        setBottleSize(bottleSize);
        return this;
    }


    @Override
    public String toString() {
        String estadoCorrecto = null;

        estadoCorrecto = getStringEstadoCorrecto();

        return estadoCorrecto;

    }

    public int indexOfBottle(Bottle bottle) {
        return e.indexOf(bottle);

    }

    public Estado deepCopy() {
        List<Bottle> listaBotellas = new ArrayList<>();
        Bottle auxiliar = null;
        for (int i = 0; i < this.e.size(); i++) {
            auxiliar = this.e.get(i);
            listaBotellas.add(auxiliar.deepCopy());

        }
        Estado copiado = new Estado(listaBotellas);
        copiado.setBottleSize(bottleSize);
        return copiado;
    }
    // copiamos objeto sin que se cambie el original

  
    public boolean eSAccionPosible(Bottle botOrigen, Bottle botDestino, int cantidad) {
        boolean esAccionPosible = false;
        if (!botOrigen.getLiquido().isEmpty()) {
            if (!botDestino.getLiquido().isEmpty()) {
                if ((botDestino.getCantidadliquido() + cantidad) <= this.bottleSize
                        && botDestino.getLiquido().peek().getColor() == botOrigen.getLiquido().peek().getColor()) {
                    esAccionPosible = true;
                }
            } else {
                esAccionPosible = true;
            }
        }

        return esAccionPosible;
    }

    public Estado accion(Bottle botOrigen, Bottle botDestino, int cantidad) {

        int botOrigenIndex = this.indexOfBottle(botOrigen);
        int botDestinoIndex = this.indexOfBottle(botDestino);

        // creamos una copia del estado
        Estado estadoCopia = this.deepCopy();
        if (eSAccionPosible(botOrigen, botDestino, cantidad)) {
            if (estadoCopia.getEstado().get(botDestinoIndex).getLiquido().isEmpty()) {
                estadoCopia.getEstado().get(botDestinoIndex).getLiquido().push(estadoCopia.getEstado().get(botOrigenIndex).getLiquido().pop());
            } else {
                Liquid l = estadoCopia.getEstado().get(botOrigenIndex).getLiquido().pop();
                int cant = l.getCant();
                estadoCopia.getEstado().get(botDestinoIndex).getLiquido().peek().modificarCantidad(cant);
            }
        }
        return estadoCopia;
    }


    public String getStringEstadoCorrecto() {
        StringBuilder stringEstadoCorrecto =  new StringBuilder();
        stringEstadoCorrecto.append("[");


        List<Bottle> botellas = this.e;

        for (int b = 0; b < botellas.size(); b++) {
            if (b != botellas.size() - 1) {
                stringEstadoCorrecto.append(botellas.get(b).getStringBottle() + ",");
            } else {
                stringEstadoCorrecto.append(botellas.get(b).getStringBottle());
            }

        }
        stringEstadoCorrecto.append("]");
        
        
        return stringEstadoCorrecto.toString();
    }

    public String md5() {
         return  JsonUtil.getHashMD5(getStringEstadoCorrecto());
        
    }

}
