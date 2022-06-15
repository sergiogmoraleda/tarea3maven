package com.example;

import java.util.PriorityQueue;

public class Frontera {

	private PriorityQueue<Nodo> f;

	public Frontera() {
		this.f = new PriorityQueue<>();
	}

	public Frontera(PriorityQueue<Nodo> frontera) {
		this.f = frontera;
	}

	public PriorityQueue<Nodo> getFrontera() {
		return this.f;
	}

	public void setFrontera(PriorityQueue<Nodo> frontera) {
		this.f = frontera;
	}

	public Frontera frontera(PriorityQueue<Nodo> frontera) {
		setFrontera(frontera);
		return this;
	}

	// CLEAR FRONTERA
	public void clear() {
		this.f.clear();
	}

	// ADD
	public void add(Nodo nodo) {
		this.f.add(nodo);
	}

	// REMOVE
	public Nodo remove() {
		return this.f.remove();
	}

	// IS EMPTY
	public boolean isEmpty() {
		return this.f.isEmpty();
	}

}
