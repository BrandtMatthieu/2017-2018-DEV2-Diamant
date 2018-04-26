package g44422.diamond.model;

import java.util.List;

/**
 * General cases of a treasure tile.
 *
 * @author 44422
 * @version 0.1
 */
public class Treasure implements Tile {

	private int rubies;

	/**
	 * Returns the amount of rubies standing on the treasure tile.
	 *
	 * @return The amount of rubies on the tile.
	 */
	public int getRubies() {
		return this.rubies;
	}

	private final int initNbRubies;

	/**
	 * Renvoit The amount of rubies on the tile when it has been created.
	 *
	 * @return The amount of rubies that stood on the tile when it was created.
	 */
	public int getInitNbRubies() {
		return this.initNbRubies;
	}

	/**
	 * Creates a new treasure tile with a defined number.
	 *
	 * @param rubies The number of rubies on the newly-genereated tile.
	 */
	public Treasure(int rubies) {
		this.rubies = rubies;
		this.initNbRubies = rubies;
	}

	/**
	 * Creates a treasure tile with a random amount of rubies, between 1 and 15.
	 */
	public Treasure() {
		int random = (int) Math.round((Math.random() * 14) + 1);
		this.rubies = random;
		this.initNbRubies = random;
	}

	/**
	 * Makes the explorers explore the tile and share the rubies.
	 *
	 * @param explorers All the explorers who wanna explore the tile.
	 */
	@Override
	public void explore(List<Explorer> explorers) {
		if (!explorers.isEmpty()) {
			int rubiesToShare = this.rubies / explorers.size();
			for (Explorer explorer : explorers) {
				explorer.addToBag(rubiesToShare);
			}
			this.rubies = this.rubies % explorers.size();
		}
	}

	/**
	 * Restore the original amount of rubies on the tile.
	 */
	public void restore() {
		this.rubies = this.initNbRubies;
	}

	@Override
	public HazardType getType() {
		return null;
	}
}
