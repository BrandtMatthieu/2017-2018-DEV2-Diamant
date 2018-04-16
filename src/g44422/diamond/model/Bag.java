package g44422.diamond.model;

import java.util.Objects;

/**
 * Represents a bag for each explorer.
 *
 * @author 44422
 * @version 0.1
 */
public class Bag {


	private int nbRubies;

	/**
	 * Creates a new empty bag for the player.
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Bag bag = (Bag) o;
		return nbRubies == bag.nbRubies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nbRubies);
	}
}
