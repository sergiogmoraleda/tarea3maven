package com.example;

import java.util.PriorityQueue;

public class Frontera {

	private PriorityQueue<Nodo> f;

	public Frontera() {
		this.f = new PriorityQueue<>();
	}


	// CLEAR FRONTERA
	public void clear() {
		this.f.clear();
	}

	// ADD
	public void add(Nodo nodo) {
		this.f.add(nodo);
	}

	// REMOVE a
	public Nodo remove() {
		return this.f.remove();
	}

	// IS EMPTY
	public boolean isEmpty() {
		return this.f.isEmpty();
	}

}
