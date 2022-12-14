import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testCalculadora() {
		fail("Not yet implemented");
	}

	@Test
	public void testSuma() {
		Calculadora calcu = new
		Calculadora(20,10);
		int resultado=calcu.suma();
		assertEquals(30,resultado);
	}

	@Test 
	public void testResta() { 
		Calculadora calcu = new Calculadora(20,10); 
		int resultado = calcu.resta(); 
		assertEquals(10, resultado); 
	}
	
	@Test 
	public void testMultiplica() { 
		Calculadora calcu = new Calculadora(20,10); 
		int resultado = calcu.multiplica(); 
		assertEquals(200, resultado); 
		}
	
	@Test 
		public void testDivide() { 
		Calculadora calcu = new Calculadora(20,10); 
		int resultado = calcu.divide(); 
		assertEquals(2, resultado); 
	} 

}