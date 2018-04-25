package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a cave
 *
 * @author 44422
 * @version 0.1
 */
public class CaveEntrance {

	private Treasure lastDiscoveredTreasure;

	private List<Treasure> path;

	/**
	 * Returns the path made of all discovered tiles.
	 *
	 * @return the path made of all discovered tiles.
	 */
	public List<Treasure> getPath() {
		return path;
	}

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
	public CaveEntrance() {
		path = new ArrayList<Treasure>();
		lastDiscoveredTreasure = new Treasure();
	}

	/**
	 * Tells the explorers the last treasure they just dicorvered.
	 *
	 * @param explorers The explorers who discover the treasure.
	 */
	public void discoverNewTreasure(List<Explorer> explorers) {
		lastDiscoveredTreasure = new Treasure();
		path.add(getLastDiscoveredTreasure());
		getLastDiscoveredTreasure().explore(explorers);
	}

	public void returnToCamp(List <Explorer> explorers) {
		for(Treasure treasure : getPath()) {
			treasure.explore(explorers);
		}
		for(Explorer explorer : explorers) {
			explorer.reachCamp();
		}
	}

	void addTreasureToPath(Treasure treasure) {
		path.add(treasure);
	}
}
