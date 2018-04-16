package g44422.diamond.model;

/**
 * Represents a bag for each explorer.
 *
 * @author 44422
 * @version 0.1
 */
public class Bag {

	private int nbRubies;

	/**
	 * Creates a new bag for the player.
	 */
	public Bag() {
		this.nbRubies = 0;
	}

	/**
	 * Adds the specifies amound of rubbies to a player's bag.
	 *
	 * @param nbRubies The amount of rubbies to add.
	 */
	public void addRubies(int nbRubies) {
		this.nbRubies = this.nbRubies + nbRubies;
	}

	/**
	 * Returns the amount of rubbies in the explorer's bag.
	 *
	 * @return The amound of rubbies the explorer have.
	 */
	public int getNbRubies() {
		return this.nbRubies;
	}

	public boolean equals(Bag bag2) {
		return bag2 != null && (this.getNbRubies() == bag2.getNbRubies());
	}
}
