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
	 * Returns the amount of rubbies in the explorer's bag.
	 *
	 * @return The amound of rubbies the explorer have.
	 */
	public int getNbRubies() {
		return this.nbRubies;
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
	 * Resets the player's bag when he falls into a trap.
	 */
	public void loseContent() {
		this.nbRubies = 0;
	}

	/**
	 * Checks if a bag is a bag.
	 *
	 * @param o An object.
	 * @return True if the bag isn't empty, is an object and if is equals to itself.
	 */
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

	/**
	 * Returns the hashCode of the amount of rubies.
	 *
	 * @return the hashCode of the amount of rubies.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nbRubies);
	}

}
