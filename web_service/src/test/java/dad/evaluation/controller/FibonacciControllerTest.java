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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciControllerTest {

	@Autowired
	private MockMvc mock;

	@Test
	public void testServiceLinearOn() throws Exception {
		mock.perform(get("/linear")).andExpect(status().isBadRequest());
	}

	@Test
	public void testServiceReccusirveOn() throws Exception {
		mock.perform(get("/reccursive")).andExpect(status().isBadRequest());
	}

	@Test
	public void testServiceLinearValue1() throws Exception {
		mock.perform(get("/linear?i=1")).andExpect(status().isOk()).andExpect(content().string("1"));
	}

	@Test
	public void testServiceLinearMultipleValue() throws Exception {
		mock.perform(get("/linear?i=2")).andExpect(status().isOk()).andExpect(content().string("1"));
		mock.perform(get("/linear?i=7")).andExpect(status().isOk()).andExpect(content().string("13"));
		mock.perform(get("/linear?i=11")).andExpect(status().isOk()).andExpect(content().string("89"));
		mock.perform(get("/linear?i=25")).andExpect(status().isOk()).andExpect(content().string("75025"));
	}

	@Test
	public void testServiceReccursiveValue1() throws Exception {
		mock.perform(get("/reccursive?i=1")).andExpect(status().isOk()).andExpect(content().string("1"));
	}

	@Test
	public void testServiceReccursiveMultipleValue() throws Exception {
		mock.perform(get("/reccursive?i=2")).andExpect(status().isOk()).andExpect(content().string("1"));
		mock.perform(get("/reccursive?i=7")).andExpect(status().isOk()).andExpect(content().string("13"));
		mock.perform(get("/reccursive?i=11")).andExpect(status().isOk()).andExpect(content().string("89"));
		mock.perform(get("/reccursive?i=25")).andExpect(status().isOk()).andExpect(content().string("75025"));
	}

}
