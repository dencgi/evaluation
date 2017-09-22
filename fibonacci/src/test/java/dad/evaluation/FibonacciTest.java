package dad.evaluation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dad.evaluation.Fibonacci;
import dad.evaluation.LinearFibonacci;
import dad.evaluation.RecursiveFibonacci;

/*
 * Faire passer les tests JUnit ci-dessous.
 * 
 * La suite de Fibonacci est définie comme suit :
 * - F(0) = 0
 * - F(1) = 1
 * - ...
 * - F(n) = F(n-1) + F(n-2)
 * 
 * Ce qui donne la suite suivante : 0, 1, 1, 2, 3, 5, 8, 13, ...
 * 
 * Temps nécessaire : 30 minutes.
 * 
 */
public class FibonacciTest {

	private Fibonacci recursiveFib = new RecursiveFibonacci();
	private Fibonacci linearFib = new LinearFibonacci();

	@Test
	public void testRecursiveZero() {
		assertEquals("La valeur initiale n'est pas correcte.", 0, recursiveFib.get(0));
	}

	@Test
	public void testRecursiveUn() {
		assertEquals("La valeur initiale n'est pas correcte.", 1, recursiveFib.get(1));
	}

	@Test
	public void testRecursiveMultiples() {
		assertEquals("La valeur pour n = 2 n'est pas correcte.", 1, recursiveFib.get(2));
		assertEquals("La valeur pour n = 7 n'est pas correcte.", 13, recursiveFib.get(7));
		assertEquals("La valeur pour n = 11 n'est pas correcte.", 89, recursiveFib.get(11));
		assertEquals("La valeur pour n = 25 n'est pas correcte.", 75025, recursiveFib.get(25));
	}
	
	@Test
	public void testLinearZero() {
		assertEquals("La valeur initiale n'est pas correcte.", 0, linearFib.get(0));
	}

	@Test
	public void testLinearUn() {
		assertEquals("La valeur initiale n'est pas correcte.", 1, linearFib.get(1));
	}

	@Test
	public void testLinearMultiples() {
		assertEquals("La valeur pour n = 2 n'est pas correcte.", 1, linearFib.get(2));
		assertEquals("La valeur pour n = 7 n'est pas correcte.", 13, linearFib.get(7));
		assertEquals("La valeur pour n = 11 n'est pas correcte.", 89, linearFib.get(11));
		assertEquals("La valeur pour n = 25 n'est pas correcte.", 75025, linearFib.get(25));
	}

}
