package dad.evaluation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/*
 * Créer deux web services qui retournent le résultat de la suite de Fibonacci pour la valeur passée en paramètre.
 * Un des services doit implémenter la suite de Fibonacci d'une façon linéaire ; l'autre doit implémenter la suite d'une façon récursive.
 *
 * Pour rappel, voici la suite de Fibonacci :
 * f(0) = 0
 * f(1) = 1
 * f(n) = f(n-1) + f(n-2)
 * 
 * Cela signifie que :
 *   f(2) = 1 + 0 = 1
 *   f(3) = 1 + 1 = 2
 *   f(4) = 2 + 1 = 3
 *   ...
 *   f(10) = 34 + 21 = 55
 *
 * Temps nécessaire : 45 minutes.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciControllerTest {

	@Autowired
	private MockMvc mock;

	@Test
	public void testServiceLinearOn() throws Exception {
		mock.perform(get("/linear"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testServiceReccusirveOn() throws Exception {
		mock.perform(get("/reccursive"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testServiceLinearValue1() throws Exception {
		mock.perform(get("/linear?i=1"))
				.andExpect(status().isOk())
				.andExpect(content().string("1"));
	}

	@Test
	public void testServiceLinearMultipleValue() throws Exception {
		mock.perform(get("/linear?i=2"))
				.andExpect(status().isOk())
				.andExpect(content().string("1"));
		mock.perform(get("/linear?i=7"))
				.andExpect(status().isOk())
				.andExpect(content().string("13"));
		mock.perform(get("/linear?i=11"))
				.andExpect(status().isOk())
				.andExpect(content().string("89"));
		mock.perform(get("/linear?i=25"))
				.andExpect(status().isOk())
				.andExpect(content().string("75025"));
	}

	@Test
	public void testServiceReccursiveValue1() throws Exception {
		mock.perform(get("/reccursive?i=1"))
				.andExpect(status().isOk())
				.andExpect(content().string("1"));
	}

	@Test
	public void testServiceReccursiveMultipleValue() throws Exception {
		mock.perform(get("/reccursive?i=2"))
				.andExpect(status().isOk())
				.andExpect(content().string("1"));
		mock.perform(get("/reccursive?i=7"))
				.andExpect(status().isOk())
				.andExpect(content().string("13"));
		mock.perform(get("/reccursive?i=11"))
				.andExpect(status().isOk())
				.andExpect(content().string("89"));
		mock.perform(get("/reccursive?i=25"))
				.andExpect(status().isOk())
				.andExpect(content().string("75025"));
	}

}
