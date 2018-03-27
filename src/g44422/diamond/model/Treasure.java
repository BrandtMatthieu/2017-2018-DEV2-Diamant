package g44422.diamond.model;

import java.util.List;

/**
 * Cas généraux d'une carte trésor
 * @author 44422
 * @version 0.1
 */
public class Treasure {

    private int rubies;

	/**
	 * Renvoit le nombre de rubis présents sur la tuile trésor.
	 * @return le nombre de rubis de la tuile trésor
	 */
	public int getRubies() {
        return this.rubies;
    }

    private final int initNbRubies;

	/**
	 * Renvoit le nombre originel de rubis présents sur la tuile trésor.
	 * @return le nombre de rubis restant sur la tuile
	 */
    public int getInitNbRubies() {
        return this.initNbRubies;
    }

	/**
	 * Crée une nouvelle tuile trésor avec un nombre de rubis définis.
	 * @param rubies le nombre de rubis défini
	 */
	public Treasure(int rubies) {
        this.rubies = rubies;
        this.initNbRubies = rubies;
    }

	/**
	 * Crée une tuile trésor avec un nombre de rubis aléatoir entre 1 et 15.
	 */
	public Treasure() {
        int random = (int) Math.round((Math.random() * 14) + 1);
        this.rubies = random;
        this.initNbRubies = random;
    }

	/**
	 * Fais explorer les explorateurs donnés la tuile.
	 * @param explorers les explorateurs devant explorer la tuile
	 */
	public void explore(List<Explorer> explorers) {
        for (Explorer explorer : explorers) {
            explorer.addToBag(this.rubies / explorers.size());
        }
        this.rubies = this.rubies % explorers.size();
    }
}
