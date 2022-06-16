package com.example;
import org.junit.*;



import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.json.simple.parser.ParseException;

public class ProblemaTest {
    @Test
    public void esObjetivoTest() throws IOException, ParseException {
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        Estado e = new Estado(problema.getInitState().getEstado(), problema.getBottleSize());
        assertFalse(problema.esObjetivo(e));
    }
    @Test
    public void esObjetivoTest2() throws IOException, ParseException {
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        
        Estado e = new Estado();
        List<Bottle> bottles = new LinkedList<>();
        Stack<Liquid> stack = new Stack<>();
        stack.push(new Liquid(1, 4));
        Bottle b = new Bottle(stack);
        Stack<Liquid> stack2 = new Stack<>();
        stack2.push(new Liquid(2, 4));
        Bottle b2 = new Bottle(stack2);

        bottles.add(b);
        bottles.add(b2);
        e.estado(bottles);
      
        e.setBottleSize(4);
        assertTrue(problema.esObjetivo(e));
    }
    @Test 
    public void getSucesoresTest() throws IOException, ParseException {
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        Estado e = new Estado(problema.getInitState().getEstado(), problema.getBottleSize());
        List<Sucesor> sucesores = problema.getSucesores(e);
        
        assertTrue(sucesores.size() > 0);
    }
    @Test
    public void equalsTest() throws IOException, ParseException {
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        Estado e = problema.getInitState();
        Estado e2 = problema.getInitState();
        assertTrue(e.equals(e2));
    }
    @Test
    public void initStateTest() throws IOException, ParseException {
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        assertNotNull(problema.initState(problema.getInitState()));
    }
    @Test 
    public void toStringTest() throws IOException, ParseException{
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        ;
        assertNotNull(problema.toString());
    }
    @Test
    public void problemaTest() throws IOException, ParseException{
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        Problema problemaNuevo  = new Problema(problema.getId(), problema.getBottleSize(), problema.getInitState());
        assertNotNull(problemaNuevo);
    }
}
