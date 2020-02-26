package g44422.diamond.model;

import java.util.List;

public interface Tile {

    void explore(List<Explorer> explorers);

    /**
     * returns the amount of rubies on the tile when it has been created.
     *
     * @return The amount of rubies that stood on the tile when it was created.
     */
    int getInitNbGems();

    /**
     * Returns the amount of rubies standing on the treasure tile.
     *
     * @return The amount of rubies on the tile.
     */
    List<Gem> getGems();

    /**
     * Returns the type of Hazard it is.
     *
     * @return The type of the Hazard.
     */
    HazardType getType();

    /**
     * Restore the original amount of rubies on the tile.
     */
    void restore();

    /**
     * Returns true if the relic can be taken by the explorer.
     *
     * @param explorers The explorers exploring the relic.
     * @return True if the explorer is alone and leaving.
     */
    boolean canBeTaken(List<Explorer> explorers);

    /**
     * Transfers the rubies left from one tile to another.
     *
     * @param o The treasure to transfer from
     */
    void transferGemsFrom(Treasure o);
}
