import static org.junit.Assert.*;
import org.junit.Test;

public class JeuDeLaVieTest {
	@Test
	public void uneCelluleTouteSeuleMeurt() {
		boolean[][] plateau = nouveauPlateau();
		rendreVivante(plateau, 1, 1);

		etapeSuivante(plateau);

		assertEquals(false, plateau[1][1]);
	}

	@Test
	public void uneCelluleEntoureeEnHautAGaucheEtEnDessousSurvit() {
		boolean[][] plateau = nouveauPlateau();
		rendreVivante(plateau, 1, 1);
		rendreVivante(plateau, 1, 2);
		rendreVivante(plateau, 0, 1);
		rendreVivante(plateau, 1, 0);

		etapeSuivante(plateau);

		assertEquals(true, plateau[1][1]);
	}

	@Test
	public void uneCelluleEntoureeADroiteAGaucheEtEnDessousSurvit() {
		boolean[][] plateau = nouveauPlateau();
		rendreVivante(plateau, 1, 1);
		rendreVivante(plateau, 2, 1);
		rendreVivante(plateau, 0, 1);
		rendreVivante(plateau, 1, 2);

		etapeSuivante(plateau);

		assertEquals(true, plateau[1][1]);
	}

	private boolean[][] nouveauPlateau() {
		return new boolean[5][5];
	}

	private void rendreVivante(boolean[][] plateau, int x, int y) {
		plateau[x][y] = true;
	}

	private void etapeSuivante(boolean[][] plateau) {
		if (!plateau[1][0] && !plateau[1][2]) {
			plateau[1][1] = false;
		}
	}

}
