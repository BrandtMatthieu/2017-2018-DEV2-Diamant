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
		System.out.println("CAVE ENTRANCE L30 | Cave entrance sans param");
		lockedOut = false;
		unsafe = false;
		path.clear();
	}

	public CaveEntrance(Cave caveParam) {
		System.out.println("CAVE ENTRANCE L36 | Cave entrance avec param");
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
			for (Tile tile : this.getPath()) {
				if (tile.getType().toString().equals(this.lastDiscoveredTile.getType().toString())) {
					unsafe = true;
					break;
				}
			}
		}
		this.path.add(this.getLastDiscoveredTile());
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
