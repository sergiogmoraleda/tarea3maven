package com.example;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.*;

public class SucesorTest {

    @Test
    public void toStringTest() {
        Accion accion = new Accion(1, 2, 3);
        List<Bottle> botellas = new ArrayList<Bottle>();
        Stack<Liquid> pila = new Stack<>();
        pila.push(new Liquid(1, 1));
        Bottle b = new Bottle(pila);
        botellas.add(b);
        Estado estado = new Estado(botellas, 1);
        Sucesor sucesor = new Sucesor(accion, estado, 4.0);
        assertNotNull( sucesor.toString());
    }

    
}
