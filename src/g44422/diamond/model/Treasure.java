package g44422.diamond.model;

import java.util.List;

/**
 * General cases of a treasure tile.
 * @author 44422
 * @version 0.1
 */
public class Treasure {

    private int rubies;

	/**
	 * Returns the amount of rubbies standing on the treasure tile.
	 * @return The amount of rubbies on the tile.
	 */
	public int getRubies() {
        return this.rubies;
    }

    private final int initNbRubies;

	/**
	 * Renvoit The amount of rubbies on the tile when it has been created.
	 * @return The amount of rubbies that stood on the tile when it was created.
	 */
    public int getInitNbRubies() {
        return this.initNbRubies;
    }

	/**
	 * Creates a new treasure tile with a defined number.
	 * @param rubies The number of rubbies on the newly-genereated tile.
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
	 * Makes the explorers explore the tile and share the rubbies.
	 * @param explorers All the explorers who wanna explore the tile.
	 */
	public void explore(List<Explorer> explorers) {
        for (Explorer explorer : explorers) {
            explorer.addToBag(this.rubies / explorers.size());
        }
        this.rubies = this.rubies % explorers.size();
    }
}
