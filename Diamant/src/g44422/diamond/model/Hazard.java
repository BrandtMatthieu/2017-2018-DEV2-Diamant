package g44422.diamond.model;

import java.util.List;

/**
 * General cases of a hazard tile.
 *
 * @author 44422
 * @version 0.1
 */
public class Hazard implements Tile {

	private HazardType type;

	private boolean exlorersEscapeReason;

	public Hazard(HazardType type) {
		this.type = type;
	}

	/**
	 * Returns the type of danger of the tile.
	 *
	 * @return the type of danger of the tile.
	 */
	@Override
	public HazardType getType() {
		return type;
	}

	/**
	 * Returns the reason why the explorers escaped.
	 *
	 * @return The reason why the explorers escaped.
	 */
	public boolean isExlorersEscapeReason() {
		return exlorersEscapeReason;
	}

	/**
	 * Gives a true value to the Hazard tiles.
	 */
	public void escape() {
		this.exlorersEscapeReason = true;
	}

	/**
	 * Doesn't do anything
	 *
	 * @param explorers
	 */
	public void explore(List<Explorer> explorers) {
	}

	/**
	 * Doesn't do anyhting on Hazard tiles.
	 */
	@Override
	public void restore() {

	}

	/**
	 * Doesn't do anyhting on Hazard tiles.
	 *
	 * @return Doesn't return anything on Hazard tiles (0).
	 */
	public int getNbRubies() {
		return 0;
	}

	/**
	 * Doesn't do anyhting on Hazard tiles.
	 *
	 * @return Doesn't return anything on Hazard tiles (0).
	 */
	@Override
	public int getInitNbRubies() {
		return 0;
	}

	/**
	 * Doesn't do anyhting on Hazard tiles.
	 *
	 * @return Doesn't return anything on Hazard tiles (0).
	 */
	@Override
	public int getRubies() {
		return 0;
	}

	/**
	 * Return s the type of the tile.
	 *
	 * @return Returns the type of the Hazard tile.
	 */
	@Override
	public String toString() {
		return "" + type;
	}
}
