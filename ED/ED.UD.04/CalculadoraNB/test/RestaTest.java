import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jmore
 */
public class RestaTest {

    @Test
    public void testGetResta() {
        System.out.println("getResta");
        double a = 3.0;
        double b = 2.0;
        Resta instance = new Resta();
        double expResult = 1.0;
        double result = instance.getResta(a, b);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testDecrementa() {
        System.out.println("decrementa");
        double a = 3.0;
        Resta instance = new Resta();
        double expResult = 2.0;
        double result = instance.decrementa(a);
        assertEquals(expResult, result, 0);
    }    
}