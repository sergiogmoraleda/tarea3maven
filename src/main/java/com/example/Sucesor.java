package com.example;





public class Sucesor {
    
    private Accion accion;
    private Estado estado;
    private double costo;



    public Sucesor() {
    }

    public Sucesor(Accion accion, Estado estado, double costo) {
        this.accion = accion;
        this.estado = estado;
        this.costo = costo;
    }

    public Accion getAccion() {
        return this.accion;
    }


    public Estado getEstado() {
        return estado;
    }


    public double getCosto() {
        return this.costo;
    }

    

   


    @Override
    public String toString() {
        return "{" +
            " accion='" + getAccion() + "'" +
            ", estado='" + getEstado().toString() + "'" +
            ", costo='" + getCosto() + "'" +
            "}";
    }


}