package com.example;

import org.junit.*;



import static org.junit.Assert.*;

import java.io.IOException;

import org.json.simple.parser.ParseException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void algoritmoBusquedaTest1() throws IOException, ParseException{
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        String estrategia = "BREADTH";
        int prof = 1000000;
        //resolvemos problema
        Boolean res = App.algoritmoBusqueda(problema, estrategia, prof);
        assertTrue(res);
    } 
    @Test
    public void algoritmoBusquedaTest2() throws IOException, ParseException{
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        String estrategia = "DEPTH";
        int prof = 1000000;
        //resolvemos problema
        Boolean res = App.algoritmoBusqueda(problema, estrategia, prof);
        assertTrue(res);
    }
    @Test
    public void algoritmoBusquedaTest3() throws IOException, ParseException{
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        String estrategia = "UNIFORM";
        int prof = 1000000;
        //resolvemos problema
        Boolean res = App.algoritmoBusqueda(problema, estrategia, prof);
        assertTrue(res);
    }  
    @Test
    public void algoritmoBusquedaTest4() throws IOException, ParseException{
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        String estrategia = "GREEDY";
        int prof = 1000000;
        //resolvemos problema
        Boolean res = App.algoritmoBusqueda(problema, estrategia, prof);
        assertTrue(res);
    }  
    @Test
    public void algoritmoBusquedaTest5() throws IOException, ParseException{
        Problema problema = new Problema("src/main/java/com/example/p0.json");
        String estrategia = "A";
        int prof = 1000000;
        //resolvemos problema
        Boolean res = App.algoritmoBusqueda(problema, estrategia, prof);
        assertTrue(res);
    }  
    @Test 
    public void seleccionarEstrategiaTest() throws IOException, ParseException{
       for(int i = 1; i <=5 ; i++){
              String estrategia = App.seleccionarEstrategia(i);
                assertNotNull(estrategia);
           
       }
       assertNotNull(App.seleccionarEstrategia(6));

    }
}
