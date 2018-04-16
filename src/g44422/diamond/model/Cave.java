package g44422.diamond.model;

import java.util.List;

/**
 * Defines a cave
 *
 * @author 44422
 * @version 0.1
 */
public class Cave {

	private Treasure lastDiscoveredTreasure;

	/**
	 * Returns the last treasure discovered by the explorers.
	 *
	 * @return the last discovered treasure.
	 */
	public Treasure getLastDiscoveredTreasure() {
		return lastDiscoveredTreasure;
	}

	/**
	 * Creates a new cave.
	 */
	public Cave() {
		/* TODO */
		lastDiscoveredTreasure = new Treasure();
	}

	/**
	 * Tells the explorers the last treasure they just dicorvered.
	 *
	 * @param explorers The explorers who discover the treasure.
	 */
	public void discoverNewTreasure(List<Explorer> explorers) {
		lastDiscoveredTreasure = new Treasure();
		getLastDiscoveredTreasure().explore(explorers);
	}
}
