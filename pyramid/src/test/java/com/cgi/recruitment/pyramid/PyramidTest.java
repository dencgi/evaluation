package test.java.com.cgi.recruitment.pyramid;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 
 * This is a pyramid building simulation.
 * 
 * We need 50 slaves to add a stone to a layer, so 250 slaves add 5 stones.
 * 
 * In order to have good quality stones, we need to have enough anks for all the stones, with an amount of 2 anks per stones.
 * So, if we have 5 stones, we need 10 anks to have good quality stones (X), otherwise, we'll get weak stones (V)
 * 
 * When we build a layer, we need to cover the previous stones with '_'.
 *
 */
public class PyramidTest {
	
	@Test
	public void addLayerTest() {
		Pyramid p = new Pyramid();
		p.addLayer("250 slaves, 10 anks");
		assertThat(p.print()).isEqualTo("XXXXX");
		
		p.addLayer("150 slaves, 5 anks");
		assertThat(p.print()).isEqualTo("_VVV_\nXXXXX");
		
		p.addLayer("50 slaves, 5 anks");
		assertThat(p.print()).isEqualTo(" _X_ \n_VVV_\nXXXXX");
	}
	
	
	/**
	 * Warning! If we don't respect some basic building rules, a previous layer might collapse!
	 */
	@Test
	public void collapseLayerTest() {
		Pyramid p = new Pyramid();
		p.addLayer("250 slaves, 10 anks");
		assertThat(p.print()).isEqualTo("XXXXX");
		
		p.addLayer("50 slaves, 2 anks");
		assertThat(p.print()).isEqualTo("__X__\nXXXXX");
		
		p.addLayer("150 slaves, 5 anks");
		assertThat(p.print()).isEqualTo("_VVV_\nXXXXX");
		
		p.addLayer("150 slaves, 6 anks");
		assertThat(p.print()).isEqualTo("_XXX_\nXXXXX");
		
		p.addLayer("50 slaves, 2 anks");
		assertThat(p.print()).isEqualTo(" _X_ \n_XXX_\nXXXXX");
	}

}
