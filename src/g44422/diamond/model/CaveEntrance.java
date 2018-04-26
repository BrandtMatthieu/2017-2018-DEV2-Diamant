package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a cave entrance
 *
 * @author 44422
 * @version 0.1
 */
public class CaveEntrance {

	private Tile lastDiscoveredTile;

	private List<Tile> path;

	private boolean lockedOut;

	private Cave cave;

	/**
	 * Creates a new cave.
	 */
	public CaveEntrance() {
		path = new ArrayList<Tile>();
		lastDiscoveredTile = new Treasure();
		lockedOut = false;
		cave = new Cave();
	}

	/**
	 * Returns the path made of all discovered tiles.
	 *
	 * @return the path made of all discovered tiles.
	 */
	public List<Tile> getPath() {
		return path;
	}

	/**
	 * Returns the last treasure discovered by the explorers.
	 *
	 * @return the last discovered treasure.
	 */
	public Tile getLastDiscoveredTile() {
		return lastDiscoveredTile;
	}

	/**
	 * Returns the state of the CaveEntrance, locked or not.
	 *
	 * @return The state of the cave netrance, locked or not.
	 */
	public boolean isLockedOut() {
		return lockedOut;
	}

	/**
	 * Tells the explorers the last treasure they just dicorvered.
	 *
	 * @param explorers The explorers who discover the treasure.
	 */
	public void discoverNewTile(List<Explorer> explorers) {
		lastDiscoveredTile = cave.getDeck().getTile();
		path.add(getLastDiscoveredTile());
		getLastDiscoveredTile().explore(explorers);
	}

	public void returnToCamp(List<Explorer> explorers) {
		for (Tile tile : getPath()) {
			tile.explore(explorers);
		}
		for (Explorer explorer : explorers) {
			explorer.reachCamp();
		}
	}

	void addTileToPath(Treasure treasure) {
		path.add(treasure);
	}

	/**
	 * Locks the CaveEntrance.
	 */
	public void lockOut() {
		this.lockedOut = true;
	}
}
