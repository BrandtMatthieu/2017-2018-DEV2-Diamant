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
	 * Creates a new cave and sets its default variables.
	 */
	public CaveEntrance() {
		lockedOut = false;
		unsafe = false;
		path.clear();
	}

	/**
	 * Creates a new cave entrance and sets its default variables.
	 *
	 * @param caveParam A cave in parameter just so that the caveEntrance can acess the deck.
	 */
	public CaveEntrance(Cave caveParam) {
		this.cave = caveParam;
		lockedOut = false;
		unsafe = false;
		path = new ArrayList<>();
	}

	/**
	 * Returns the cavenEntrace's cave. Probably to acess it's deck.
	 *
	 * @return The caveEntrance's cave and it's containing deck.
	 */
	public Cave getCave() {
		return cave;
	}

	/**
	 * Tells if the caveEntrance is safe or not.
	 *
	 * @return True if the caveEntrance isn't safe.
	 */
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
			if (explorerHasAlreadyEncounterHazard()) {
				this.unsafe = true;
				/* TODO */
				for (Explorer explorer : explorers) {
					explorer.runAway();
				}
			}
		}
		this.path.add(lastDiscoveredTile);
		lastDiscoveredTile.explore(explorers);
	}

	/**
	 * Returns True if the explorers have already encounters a same Hazard tile in their last path.
	 *
	 * @return True if the explorers have already encounters a same Hazard tile in their last path.
	 */
	private boolean explorerHasAlreadyEncounterHazard() {
		for (Tile tile : this.getPath()) {
			if (tile instanceof Hazard && tile.getType().equals(lastDiscoveredTile.getType())) { //Si un même hazard est déjà présent
				return true;
			}
		}
		return false;
	}

	/**
	 * Makes the explorers return to the camp.
	 *
	 * @param explorers All the exploring explorers willing to go back to the camp.
	 */
	public void returnToCamp(List<Explorer> explorers) {
		this.getPath().forEach((tile) -> {
			tile.explore(explorers);
		});
		explorers.forEach((explorer) -> {
			explorer.reachCamp();
		});
	}

	/**
	 * Adds a tile in the path. Method used just in test purposes.
	 *
	 * @param tile The tile to add in the path.
	 */
	void addTileToPath(Tile tile) {
		path.add(tile);
	}

	/**
	 * Locks the CaveEntrance entry.
	 */
	public void lockOut() {
		this.lockedOut = true;
	}
}
