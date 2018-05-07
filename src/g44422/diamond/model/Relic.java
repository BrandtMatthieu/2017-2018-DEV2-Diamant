package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

public class Relic implements Tile {

	private int valueInDiamonds = 1;

	/**
	 * Returns the value in diamonds of the Relic.
	 *
	 * @return The value in diamonds of the relic.
	 */
	public int getValueInDiamonds() {
		return valueInDiamonds;
	}

    /**
     * Returns true if the relic can be taken by one explorer if he is alone and leaving the cave.
     *
     * @param explorers All the explorers exploring the relic.
     * @return True if the relic can be taken by the explorer.
     */
    @Override
    public boolean canBeTaken(List<Explorer> explorers) {
        return explorers.size() == 1 && explorers.get(0).getState() == State.LEAVING;
    }

    /**
     * Transfers the rubies left from one tile to another.
     *
     * @param o The treasure to transfer from
     */
    @Override
    public void transferGemsFrom(Treasure o) {

    }

	/**
	 * Doesn't do anything for the Relic class.
	 *
	 * @param explorers The exploring explorers.
	 */
	@Override
	public void explore(List<Explorer> explorers) {

	}

	/**
     * Returns the amount of rubies on the tile when it has been created.
     *
     * @return The amount of rubies that stood on the tile when it was created.
     */
    public int getInitNbGems() {
        return 0;
    }

    /**
     * Doesn't do anything on the relic.
     *
     * @return The amount of rubies on the tile.
     */
    public List<Gem> getGems() {
        return new ArrayList<Gem>();
    }

    /**
     * Doesn't do anything on the relic.
     *
     * @return The type of the Hazard.
     */
    public HazardType getType() {
        return HazardType.SNAKES;
    }

    /**
     * Doesn't do anything on the relic.
     */
    public void restore(){}

    public void convertGemValue(int nbTakenRelics) {
        if(nbTakenRelics>=3) {
            valueInDiamonds = 2;
        } else if(nbTakenRelics < 3) {
        	valueInDiamonds = 1;
		}
    }

}
