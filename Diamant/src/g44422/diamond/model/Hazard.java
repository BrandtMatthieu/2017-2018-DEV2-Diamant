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
	 * Desn't do anything
	 *
	 * @param explorers
	 */
	public void explore(List<Explorer> explorers) {
	}

	public void restore() {

	}

	public int getNbRubies() {
		return 0;
	}

	public int getInitNbRubies() {
		return 0;
	}

	public int getRubies() {
		return 0;
	}

	@Override
	public String toString() {
		return "" + type;
	}
}
