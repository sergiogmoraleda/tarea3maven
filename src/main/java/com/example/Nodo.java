package com.example;
 
 
import java.text.DecimalFormat;




public class Nodo implements Comparable<Nodo> {

 


    private int id;
    private double costoAcumulado;
    Estado estado;
    Nodo padre;
    Accion accion;
    private int profundidad;
    private double heuristica;
    private double valor;
    private static int contadorId = 0;

    public Nodo() {
    }

    public Nodo(double costoAcumulado, Estado estado, Nodo padre, Accion accion, int profundidad, double heuristica, double valor) {
        this.id = contadorId++;
        this.costoAcumulado = costoAcumulado;
        this.estado = estado;
        this.padre = padre;
        this.accion = accion;
        this.profundidad = profundidad;
        this.heuristica = heuristica;
        this.valor = valor;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCostoAcumulado() {
        return this.costoAcumulado;
    }

    

    public Estado getEstado() {
        return this.estado;
    }

    public Nodo getPadre() {
        return this.padre;
    }

   

    public Accion getAccion() {
        return this.accion;
    }


    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public double getHeuristica() {
        return this.heuristica;
    }

    public void setHeuristica(float heuristica) {
        this.heuristica = heuristica;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


 

  
    
    //hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }
    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        final Nodo other = (Nodo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    @Override //nos servira para la priority queue de frontera
    public int compareTo(Nodo o) {
        int result = 0;
        if(o.getValor()<getValor()){
            result +=1;
        }else if(o.getValor()>getValor()){
            result -=1;
        } else{
            if(o.getId()<getId()){
                result +=1;
            }else{
                result -=1;
            }
        }
        return result;
    }
    public double calcularValorEstrategia(String estrategia, Nodo nodo) {
        double valorr = 0;
        switch (estrategia) {
            case "BREADTH":
                valorr = nodo.getProfundidad();
                break;
            case "DEPTH":
                valorr = 1 /((double)(nodo.getProfundidad() + 1));
                break;
            case "UNIFORM":
                valorr = nodo.costoAcumulado;
                break;
            case "GREEDY":
                valorr = nodo.heuristica;
                break;
            case "A":
                valorr = nodo.costoAcumulado + nodo.heuristica;
                break;
                default:
                    valorr = nodo.getProfundidad();
        }
        return valorr;
    }
    

    @Override
    public String toString() {
        String result = "";
        DecimalFormat df = new DecimalFormat("#0.00");
        if (getPadre() == null){

        
         result = "[" +
                "" + getId() + "]" +
                "[" + getCostoAcumulado() + ", " +
                "" + getEstado().md5() + ", " +
                ""  + "None, " +
                "" + " None,  " +
                "" + getProfundidad() + ", " +
                "" + df.format(Math.abs(getHeuristica())) + ", " +
                "" + df.format(Math.abs(getValor())) + "" +
                "]"; 
        }
        else{
            result = "[" +
                "" + getId() + "]" +
                "[" + getCostoAcumulado() + ", " +
                "" + getEstado().md5() + ", " +
                "" + getPadre().getId() + ", " +
                "" + getAccion() + ", " +
                "" + getProfundidad() + ", " +
                "" +  df.format(Math.abs(getHeuristica())) + ", " +
                "" +  df.format(Math.abs(getValor())) + "" +
                "]"; 
        }
        
              
        return result;
    }
  
}