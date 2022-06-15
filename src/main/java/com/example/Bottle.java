package com.example;

import java.util.*;



public class Bottle implements JsonUtil {
	private Stack<Liquid> liquido;

	public Bottle() {
		liquido = new Stack<>();
	}

	public Bottle(Stack<Liquid> liquido) {
		this.liquido = liquido;
	}

	public Stack<Liquid> getLiquido() {
		return this.liquido;
	}

	public void setLiquido(Stack<Liquid> liquidos) {
		this.liquido = liquidos;
	}

	public Bottle liquido(Stack<Liquid> liquido) {
		setLiquido(liquido);
		return this;
	}
	

	@Override
	public String toString() {
		return "" + getLiquido() + "";
	}

	public Bottle deepCopy() {
		Liquid auxiliar = null;
		Bottle copy = new Bottle();
		Stack<Liquid> aux = new Stack<>();
		Stack<Liquid> liquidoCopy = new Stack<>();
		while(!this.liquido.isEmpty()) {
			aux.push(this.liquido.pop());
		}
		while(!aux.isEmpty()) {
			auxiliar = aux.pop();
			this.liquido.push(auxiliar);
			liquidoCopy.push(auxiliar.deepCopy());
		}
		copy.setLiquido(liquidoCopy);
		return copy;
	}

	public int getColorDeArriba() {
		if (!liquido.isEmpty()) {
			return liquido.peek().getColor();
		} else {
			return -1;
		}
	}

	public int getCantDeArriba() {
		return liquido.peek().getCant();
	}
	public void anadirLiquido(Liquid l) {
		liquido.add(l);
	}

	public int getCantidadliquido() {
		int cantBotella = 0;
		for(int i = 0; i < liquido.size(); i++) {
			cantBotella += liquido.get(i).getCant();
		}
		return cantBotella;
	}
	//clonamos el objeto

	


	public boolean isEmpty() {
		return liquido.isEmpty();
	}

	public Liquid pop() {
		return liquido.pop();
	}
	public Liquid push(Liquid l) {
		return liquido.push(l);
	}

    public Liquid peek() {
		return liquido.peek();
        
    }
	public String getStringBottle(){
		StringBuilder s= new StringBuilder();
		s.append("[");
		
		Stack<Liquid> botella = getLiquido();
		for(int i = botella.size()-1; i >= 0; i--) {
			if(i>0) {
				s.append(botella.get(i).toString() + ",");
			}
			if(i== 0){
				s.append(botella.get(i).toString());
			}
		}
		s.append("]");
		return s.toString();
		

	}

	public int size() {
		return liquido.size();
	}
	
}
