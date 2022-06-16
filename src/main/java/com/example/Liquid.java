package com.example;



public class Liquid  {
    private int color;
    private int cant;

    public Liquid() {
    }

    public Liquid(int color, int cant) {
        this.color = color;
        this.cant = cant;
    }

    public Liquid(Liquid l) {
        this.color = l.color;
        this.cant = l.cant;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getCant() {
        return this.cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    


    @Override
    public String toString() {
        return "[" + color+ "," + cant + "]" ;
    }
    
    public Liquid deepCopy() {
    	Liquid copy = new Liquid(this.color, this.cant);
        copy.setColor(copy.getColor());
        copy.setCant(copy.getCant());
        return copy;
    }

    public void modificarCantidad(int cantidad) {
    	this.cant += cantidad;
    }

}
