package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

public class Relic implements Tile {

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

    public void explore(List <Explorer> explorers) {}

    /**
     * Renvoit The amount of rubies on the tile when it has been created.
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

}
