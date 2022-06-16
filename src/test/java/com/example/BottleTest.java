package com.example;
import org.junit.*;



import static org.junit.Assert.*;

import java.util.Stack;

public class BottleTest {

    @Test
    public void getStringBottleTest() {
        Bottle b = new Bottle();
        assertEquals("[]", b.getStringBottle());
        Bottle b2 = new Bottle();
        b2.anadirLiquido(new Liquid(1, 2));
        assertEquals("[[1,2]]" ,b2.getStringBottle());
    }
    @Test
    public void sizeTest() {
        Bottle b = new Bottle();
        assertEquals(0, b.size());
    }
    @Test
    public void deepCopyTest() {
        Bottle b = new Bottle();
        Bottle copy = b.deepCopy();
        assertNotSame(b, copy);
    }
    @Test
    public void deepCopyTest2() {
        Bottle b = new Bottle();
        b.anadirLiquido(new Liquid(1,2));
        Bottle copy = b.deepCopy();
        assertNotSame(b, copy);
    }
        
    @Test
    public void getCantidadliquidoTest() {
        Stack<Liquid> b = new Stack<Liquid>();
        //metemos liquidos aleatorios en botellas
        int contadorcantidad = 0;
        for (int i = 0; i < 10; i++) {
            b.push(new Liquid(i, i));
            contadorcantidad += i;
        }
        Bottle botella = new Bottle(b);

        assertEquals(contadorcantidad, botella.getCantidadliquido());
    }
    @Test
    public void isEmptyTest() {
        Bottle b = new Bottle();
        assertTrue(b.isEmpty());
    }
    @Test
    public void getColorDeArribaTest() {
        Liquid l = new Liquid(1, 2);
        Bottle b = new Bottle();
        b.push(l);
        assertEquals(1, b.getColorDeArriba());
    }
    @Test
    public void getCantDeArribaTest() {
        Liquid l = new Liquid(1, 2);
        Bottle b = new Bottle();
        b.push(l);
        assertEquals(2, b.getCantDeArriba());
    }
    @Test
    public void anadirLiquidoTest() {
        Bottle b = new Bottle();
        Liquid l = new Liquid(1, 2);
        b.anadirLiquido(l);
        assertEquals(1, b.getColorDeArriba());
        assertEquals(2, b.getCantDeArriba());
    }
    @Test
    public void peekTest() {
        Bottle b = new Bottle();
        Liquid l = new Liquid(1, 2);
        b.push(l);
        assertEquals(l, b.peek());
    }
    @Test
    public void popTest() {
        Bottle b = new Bottle();
        Liquid l = new Liquid(1, 2);
        b.push(l);
        assertEquals(l, b.pop());
    }
    @Test
    public void liquidoTest() {
        Stack<Liquid> b = new Stack<Liquid>();
        //metemos liquidos aleatorios en botellas
        for (int i = 0; i < 10; i++) {
            b.push(new Liquid(i, i));
        }
        Bottle botella = new Bottle(b);
        Bottle botellaAux = botella.liquido(botella.getLiquido());
        assertEquals(botella, botellaAux);
       
    }

}
