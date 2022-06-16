package com.example;
import org.junit.*;



import static org.junit.Assert.*;


public class LiquidTest {
    @Test
    public void deepCopyTest() {
        Liquid l1 = new Liquid(1, 2);
        Liquid copy = l1.deepCopy();
        assertNotSame(l1, copy);
        
    }
    @Test 
    public void toStringTest() {
        Liquid l1 = new Liquid(1, 2);
        assertEquals("[1,2]", l1.toString());
    }
    @Test
    public void modificarCantidadTest() {
        Liquid l1 = new Liquid(1, 2);
        l1.modificarCantidad(3);
        assertEquals(5, l1.getCant());
    }
    @Test
    public void liquidTest() {
        Liquid l1 = new Liquid(1, 2);
        assertEquals(1, l1.getColor());
        assertEquals(2, l1.getCant());
    }
    @Test
    public void assertEqualsTest() {
        Liquid l1 = new Liquid(1, 2);
        Liquid l2 = new Liquid(1, 2);
        assertNotEquals(l1, l2);
    }
    @Test
    public void liquidTest2() {
        Liquid l1 = new Liquid(1,2);
        Liquid l2 = new Liquid (l1);
        assertTrue(l1.getCant() == l2.getCant() && l1.getColor() == l2.getColor());
    }
}