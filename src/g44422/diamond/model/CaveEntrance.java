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

	private boolean treasureFound;

	private Treasure firstTreasureTile;

	/**
	 * Creates a new cave and sets its default variables.
	 */
	public CaveEntrance() {
		lockedOut = false;
		unsafe = false;
		path.clear();
		treasureFound = false;
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
	 * Returns the cavenEntrace's cave. Probably to acess it's deck.
	 *
	 * @return The caveEntrance's cave and it's containing deck.
	 */
	public Cave getCave() {
		return cave;
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
	 * Returns the state of the CaveEntrance, locked or not.
	 *
	 * @return The state of the cave netrance, locked or not.
	 */
	public boolean isLockedOut() {
		return lockedOut;
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
	 * Adds a tile in the path. Method used just in test purposes.
	 *
	 * @param tile The tile to add in the path.
	 */
	void addTileToPath(Tile tile) {
		path.add(tile);
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
				((Hazard) lastDiscoveredTile).escape();
				for (Explorer explorer : explorers) {
					explorer.runAway();
				}
			}
		} else if (lastDiscoveredTile instanceof Treasure) {
			for (Tile tile : path) {
				if (tile instanceof Treasure) {
					treasureFound = true;
					break;
				}
			}
			if (!treasureFound) {
				firstTreasureTile = (Treasure) lastDiscoveredTile;
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
	 * Locks the CaveEntrance entry.
	 */
	public void lockOut() {
		this.lockedOut = true;
	}

	public void makeLastTileExplored() {
		if (path.get(path.size() - 1) instanceof Treasure) {
			firstTreasureTile.transferGemsFrom((Treasure) this.getPath().get(path.size() - 1));
		}
	}

	/**
	 * Makes the explorers return to the camp.
	 *
	 * @param explorers All the exploring explorers willing to go back to the camp.
	 */
	public void returnToCamp(List<Explorer> explorers) {
		for (int i = 0; i < this.getPath().size() - 1; i++) {
			if (this.getPath().get(i) instanceof Treasure) {
				this.getPath().get(i).explore(explorers);
			} else if (this.getPath().get(i) instanceof Relic) {
				if (this.getPath().get(i).canBeTaken(explorers)) {
					((Relic) this.getPath().get(i)).convertGemValue(getNbTakenRelics());
					for (int j = 0; j < ((Relic)this.getPath().get(i)).getValueInDiamonds() ; j++) {
						explorers.get(0).addToBag(Gem.DIAMOND);
					}
					this.getPath().remove(i);
					this.getCave().incrementNbTakenRelics();
				}
			}
		}
		explorers.forEach((explorer) -> {
			explorer.reachCamp();
		});
	}
}
