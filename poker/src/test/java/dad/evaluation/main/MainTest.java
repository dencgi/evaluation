package dad.evaluation.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dad.evaluation.Carte;
import dad.evaluation.Combinaison;
import dad.evaluation.Couleur;
import dad.evaluation.Main;
import dad.evaluation.MainPleineException;
import dad.evaluation.Valeur;

/*
 * Faire passer les tests JUnit ci-dessous.
 * 
 * Une carte a une couleur (pique, cœur, carreau ou trèfle) et une valeur (2, 3, ..., roi, as)
 * 
 * Ordre des cartes : 2, 3, 4, ..., 9, 10, valet, dame, roi, as.
 * 
 * Combinaisons possibles, du plus fort au moins fort :
 * - quinte flush : cinq cartes de la même couleur et dont les valeurs se suivent.
 * - carré : quatre cartes de même valeur.
 * - full : un brelan + une paire.
 * - couleur : cinq carte de la même couleur.
 * - suite : cinq cartes dont les valeurs se suivent.
 * - brelan : 3 cartes de la même valeur.
 * - double paire : deux paires.
 * - paire : deux cartes de la même valeur.
 * - carte : aucune autre combinaison.
 * 
 */
public class MainTest {

	@Test
	public void testQuinteFlush() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.NEUF));
		main.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection de la quinte flush !", "QUINTE_FLUSH", Combinaison.getCombinaison(main));
	}

	@Test
	public void testCarre() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.CARREAU, Valeur.DEUX));
		main.add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		assertEquals("Problème lors de la détection du carré !", "CARRE", Combinaison.getCombinaison(main));
	}

	@Test
	public void testFull() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.PIQUE, Valeur.DEUX));
		main.add(new Carte(Couleur.CARREAU, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.COEUR, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		assertEquals("Problème lors de la détection du full !", "FULL", Combinaison.getCombinaison(main));
	}

	@Test
	public void testCouleur() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.TREFLE, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection de la couleur !", "COULEUR", Combinaison.getCombinaison(main));
	}

	@Test
	public void testSuite() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.COEUR, Valeur.DAME));
		main.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.NEUF));
		main.add(new Carte(Couleur.PIQUE, Valeur.HUIT));
		assertEquals("Problème lors de la détection de la suite !", "SUITE", Combinaison.getCombinaison(main));
	}

	@Test
	public void testBrelan() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.PIQUE, Valeur.VALET));
		main.add(new Carte(Couleur.COEUR, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection du brelan !", "BRELAN", Combinaison.getCombinaison(main));
	}

	@Test
	public void testDoublePaire() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.add(new Carte(Couleur.PIQUE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.CARREAU, Valeur.ROI));
		assertEquals("Problème lors de la détection de la double paire !", "DOUBLE_PAIRE", Combinaison.getCombinaison(main));
	}

	@Test
	public void testPaire() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.COEUR, Valeur.DEUX));
		main.add(new Carte(Couleur.PIQUE, Valeur.ROI));
		main.add(new Carte(Couleur.TREFLE, Valeur.CINQ));
		main.add(new Carte(Couleur.CARREAU, Valeur.VALET));
		assertEquals("Problème lors de la détection de la paire !", "PAIRE", Combinaison.getCombinaison(main));
	}

	@Test
	public void testCarte() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.TREFLE, Valeur.DEUX));
		main.add(new Carte(Couleur.COEUR, Valeur.AS));
		main.add(new Carte(Couleur.TREFLE, Valeur.ROI));
		main.add(new Carte(Couleur.PIQUE, Valeur.CINQ));
		main.add(new Carte(Couleur.TREFLE, Valeur.DAME));
		assertEquals("Problème lors de la détection de la carte !", "CARTE", Combinaison.getCombinaison(main));
	}

	@Test(expected = MainPleineException.class)
	public void testMainPleine() throws Exception {
		Main main = new Main();
		main.add(new Carte(Couleur.COEUR, Valeur.DAME));
		main.add(new Carte(Couleur.TREFLE, Valeur.DIX));
		main.add(new Carte(Couleur.TREFLE, Valeur.VALET));
		main.add(new Carte(Couleur.TREFLE, Valeur.NEUF));
		main.add(new Carte(Couleur.PIQUE, Valeur.HUIT));
		main.add(new Carte(Couleur.CARREAU, Valeur.NEUF));
	}

}
