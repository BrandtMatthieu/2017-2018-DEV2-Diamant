package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a cave entrance
 *
 * @author 44422
 * @version 0.1
 */
public class CaveEntrance extends Cave {

	private Tile lastDiscoveredTile;

	private List<Tile> path;

	private boolean lockedOut;

	private boolean unsafe;

	private Cave cave;

	/**
	 * Creates a new cave.
	 */
	public CaveEntrance() {
		lockedOut = false;
		unsafe = false;
		path.clear();
	}

	public CaveEntrance(Cave caveParam) {
		this.cave = caveParam;
		lockedOut = false;
		unsafe = false;
		path = new ArrayList<>();
	}

	public Cave getCave() {
		return cave;
	}

	public boolean isUnsafe() {
		return unsafe;
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
		return this.lastDiscoveredTile;
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
		lastDiscoveredTile = this.cave.getDeck().getTile();
		if (lastDiscoveredTile instanceof Hazard) {
			// TODO
			for (Tile tile : this.getPath()) {
				if (tile instanceof Hazard && tile.getType().equals(lastDiscoveredTile.getType())) { //Si un même hazard est déjà présent
					this.unsafe = true;
					for (Explorer explorer : explorers) {
						explorer.runAway();
					}
					break;
				}
			}
		}
		this.path.add(lastDiscoveredTile);
		lastDiscoveredTile.explore(explorers);
	}

	public void returnToCamp(List<Explorer> explorers) {
		this.getPath().forEach((tile) -> {
			tile.explore(explorers);
		});
		explorers.forEach((explorer) -> {
			explorer.reachCamp();
		});
	}

	void addTileToPath(Tile tile) {
		path.add(tile);
	}

	/**
	 * Locks the CaveEntrance.
	 */
	public void lockOut() {
		this.lockedOut = true;
	}
}
