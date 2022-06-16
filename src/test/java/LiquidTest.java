import org.junit.*;

import com.example.Liquid;

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
    public void LiquidTest() {
        Liquid l1 = new Liquid(1, 2);
        assertEquals(1, l1.getColor());
        assertEquals(2, l1.getCant());
    }
}